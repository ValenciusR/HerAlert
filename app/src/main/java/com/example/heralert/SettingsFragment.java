package com.example.heralert;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heralert.databinding.FragmentSettingsBinding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsFragment extends Fragment {
    FragmentSettingsBinding binding;
    AppCompatButton backBtn;
    LinearLayoutCompat profileSelect, messageSelect, logoutSelect;
    FirebaseAuth mAuth;
    FirebaseApp firebaseApp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        backBtn = v.findViewById(R.id.backBtn);
        profileSelect = v.findViewById(R.id.profileSelect);
        messageSelect = v.findViewById(R.id.messageSelect);
        logoutSelect = v.findViewById(R.id.logoutSelect);
        firebaseApp = FirebaseApp.initializeApp(v.getContext());
        mAuth = FirebaseAuth.getInstance();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HomeFragment());
            }
        });

        profileSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new ProfileFragment());
            }
        });

        messageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MessageFragment());
            }
        });

        logoutSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(getActivity(), SignInPage.class));
                getActivity().finish();
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