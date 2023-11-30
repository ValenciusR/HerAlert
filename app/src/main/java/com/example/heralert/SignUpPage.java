package com.example.heralert;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignUpPage extends AppCompatActivity {

    TextView signInLink;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        signInLink = findViewById(R.id.tv_signIn);

        signInLink.setOnClickListener(view -> {
            Intent signUpIntent = new Intent(this, SignInPage.class);
            startActivity(signUpIntent);
            finish();
        });
    }
}