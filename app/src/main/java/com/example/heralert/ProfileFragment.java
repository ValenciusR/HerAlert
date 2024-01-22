package com.example.heralert;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    AppCompatButton backBtn;
    EditText nameText, phoneNumberText;
    Button updateBtn;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference usersReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        backBtn = v.findViewById(R.id.backBtn);
        nameText = v.findViewById(R.id.et_name);
        phoneNumberText = v.findViewById(R.id.et_phonenumber);
        updateBtn = v.findViewById(R.id.btn_update_profile);

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance("https://heralert-default-rtdb.asia-southeast1.firebasedatabase.app/");

        FirebaseUser currentUser = mAuth.getCurrentUser();
        usersReference = firebaseDatabase.getReference().child("users");
        DatabaseReference userReference = usersReference.child(currentUser.getUid());

        ProgressDialog progressDialog = new ProgressDialog(v.getContext());
        progressDialog.setTitle("Please Wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("name").getValue().toString();
                String phone = snapshot.child("phoneNumber").getValue().toString();

                nameText.setText(name);
                phoneNumberText.setText(phone);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(v.getContext(), "Failed to Load Data", Toast.LENGTH_SHORT).show();
            }


        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new SettingsFragment());
            }
        });
        // Inflate the layout for this fragment

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameText.getText().toString();
                String phoneNumber = phoneNumberText.getText().toString();


                if(name.isEmpty() || phoneNumber.isEmpty()){
                    Toast.makeText(v.getContext(), "Name and Phone Number Cannot be Empty", Toast.LENGTH_SHORT).show();
                }else{
                    userReference.child("name").setValue(name);
                    userReference.child("phoneNumber").setValue(phoneNumber);

                    Toast.makeText(v.getContext(), "Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return v;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}