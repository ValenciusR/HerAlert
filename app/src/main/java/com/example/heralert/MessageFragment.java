package com.example.heralert;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MessageFragment extends Fragment {

    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference usersReference;
    AppCompatButton backBtn, updateBtn;
    SwitchCompat sosSoundSwitch;
    TextInputEditText helpMessageInputText, safeMessageInputText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        backBtn = v.findViewById(R.id.backBtn);
        updateBtn = v.findViewById(R.id.updateBtn);
        helpMessageInputText = v.findViewById(R.id.helpMessageInputText);
        safeMessageInputText = v.findViewById(R.id.safeMessageInputText);
        sosSoundSwitch = v.findViewById(R.id.sosSoundSwitch);

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
                String helpMessage = snapshot.child("helpMessage").getValue().toString();
                String safeMessage = snapshot.child("safeMessage").getValue().toString();
                String checkSound = snapshot.child("sound").getValue().toString();
                if(checkSound.equals("true")){
                    sosSoundSwitch.setChecked(true);
                }else{
                    sosSoundSwitch.setChecked(false);
                }
                helpMessageInputText.setText(helpMessage);
                safeMessageInputText.setText(safeMessage);
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

        sosSoundSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSosSwitchClick(v);
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String help = helpMessageInputText.getText().toString();
                String safe = safeMessageInputText.getText().toString();
                Boolean soundTrue = sosSoundSwitch.isChecked();

                if(help.isEmpty() || safe.isEmpty()){
                    Toast.makeText(v.getContext(), "Help Message and Safe Message Cannot be Empty", Toast.LENGTH_SHORT).show();
                }else{
                    userReference.child("safeMessage").setValue(safe);
                    userReference.child("helpMessage").setValue(help);
                    if(soundTrue){
                        userReference.child("sound").setValue(true);
                    }else{
                        userReference.child("sound").setValue(false);
                    }
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

    public void onSosSwitchClick(View view){
        if(sosSoundSwitch.isChecked()){

        }
        else{

        }
    }
}