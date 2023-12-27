package com.example.heralert;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    FusedLocationProviderClient fusedLocationProviderClient;
    TextView addressTxt;
    private final static int REQUEST_CODE=106;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference usersReference;

    AppCompatTextView helloUserTxt, helloTxt2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        ProgressDialog progressDialog = new ProgressDialog(v.getContext());
        progressDialog.setTitle("Please Wait..");
        progressDialog.setCancelable(false);
        progressDialog.show();

        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance("https://heralert-default-rtdb.asia-southeast1.firebasedatabase.app/");

        FirebaseUser currentUser = mAuth.getCurrentUser();

        usersReference = firebaseDatabase.getReference().child("users");
        DatabaseReference userReference = usersReference.child(currentUser.getUid());

        // Hello user
        helloUserTxt = v.findViewById(R.id.helloUserTxt);
        helloTxt2 = v.findViewById(R.id.helloTxt2);

        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username = snapshot.child("name").getValue().toString();
                helloUserTxt.setText(username);
                helloTxt2.append(username);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(v.getContext(), "Failed to Load Data", Toast.LENGTH_SHORT).show();
            }
        });

        // Address
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(v.getContext());
        addressTxt = v.findViewById(R.id.addressTxt);
        getLastLocation(v);
        return v;
    }

    private void getLastLocation(View v){
        if(ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation()
                    .addOnSuccessListener(new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if(location!=null){
                                Geocoder geocoder = new Geocoder(v.getContext(), Locale.getDefault());
                                try {
                                    List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                    addressTxt.setText(addresses.get(0).getAddressLine(0));
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    });
        } else {
            askPermission();
        }
    }

    private void askPermission(){
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
    }
}