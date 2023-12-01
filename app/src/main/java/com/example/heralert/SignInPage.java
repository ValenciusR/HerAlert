package com.example.heralert;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class SignInPage extends AppCompatActivity {

    TextView signUpLink;
    Button signInBtn;
    FirebaseAuth mAuth;
    EditText emailField, passwordField;
    FirebaseApp firebaseApp;

    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        emailField = findViewById(R.id.et_email_signin);
        passwordField = findViewById(R.id.et_password_signin);
        signInBtn = findViewById(R.id.btn_signin);
        signUpLink = findViewById(R.id.tv_signUp);

        firebaseApp = FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        signUpLink.setOnClickListener(view -> {
            Intent signUpIntent = new Intent(this, SignUpPage.class);
            startActivity(signUpIntent);
            finish();
        });

        signInBtn.setOnClickListener(view -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(SignInPage.this, task -> {
                if(!task.isSuccessful()){
                    Toast.makeText(this, "Login Failed, Email doesn't exist", Toast.LENGTH_SHORT).show();
                    Log.e("Signup Error", "onCancelled", task.getException());
                }else{
                    startActivity(new Intent(SignInPage.this, HomePage.class));
                    finish();
                }
            });

        });
    }
}