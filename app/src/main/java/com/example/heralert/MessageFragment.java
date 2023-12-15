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

public class MessageFragment extends Fragment {

    AppCompatButton backBtn;
    SwitchCompat autoSendSwitch, sosSoundSwitch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_message, container, false);
        backBtn = v.findViewById(R.id.backBtn);
        autoSendSwitch = v.findViewById(R.id.autoSendSwitch);
        sosSoundSwitch = v.findViewById(R.id.sosSoundSwitch);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new HomeFragment());
            }
        });

        autoSendSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAutoSendClick(v);
            }
        });

        sosSoundSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSosSwitchClick(v);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    public void onAutoSendClick(View view){
        if(autoSendSwitch.isChecked()){

        }
        else{

        }
    }

    public void onSosSwitchClick(View view){
        if(sosSoundSwitch.isChecked()){

        }
        else{

        }
    }
}