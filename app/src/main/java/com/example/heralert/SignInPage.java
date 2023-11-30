package com.example.heralert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SignInPage extends AppCompatActivity {

    TextView signUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        signUpLink = findViewById(R.id.tv_signUp);

        signUpLink.setOnClickListener(view -> {
            Intent signUpIntent = new Intent(this, SignUpPage.class);
            startActivity(signUpIntent);
            finish();
        });
    }
}