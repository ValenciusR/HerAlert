package com.example.heralert;

import android.os.Bundle;

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

public class MessageFragment extends Fragment {

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
        safeMessageInputText = v.findViewById(R.id.helpMessageInputText);
        sosSoundSwitch = v.findViewById(R.id.sosSoundSwitch);
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
                // isi code update button disini
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