package com.example.heralert;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SignUpPage extends AppCompatActivity {

    EditText nameField, emailField, phoneField, passwordField;
    Button signUpBtn;
    TextView signInLink;


    FirebaseApp firebaseApp;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference userReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        nameField = findViewById(R.id.et_name);
        emailField = findViewById(R.id.et_email);
        phoneField = findViewById(R.id.et_phonenumber);
        passwordField = findViewById(R.id.et_password);
        signInLink = findViewById(R.id.tv_signIn);
        signUpBtn = findViewById(R.id.btn_signup);

        firebaseApp = FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://heralert-default-rtdb.asia-southeast1.firebasedatabase.app/");

        signInLink.setOnClickListener(view -> {
            Intent signUpIntent = new Intent(this, SignInPage.class);
            startActivity(signUpIntent);
            finish();
        });

        signUpBtn.setOnClickListener(view -> {
            String email = emailField.getText().toString();
            String name = nameField.getText().toString();
            String password = passwordField.getText().toString();
            ArrayList<String> phone = new ArrayList<>();
            phone.add(phoneField.getText().toString());

            if(!email.contains("@") || !email.endsWith(".com")){
                Toast.makeText(this, "Email must contain '@' and ends with '.com'", Toast.LENGTH_SHORT).show();
            }else if(name.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()){
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
            }else if(password.length() < 6){
                Toast.makeText(this, "Password length must be more than 5 characters", Toast.LENGTH_SHORT).show();
            }else if(name.length() < 5){
                Toast.makeText(this, "Name must be more than 5 characters", Toast.LENGTH_SHORT).show();
            }else{
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpPage.this, task -> {
                    if(!task.isSuccessful()){
                        Toast.makeText(this, "Register Failed, email already exits", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Register Success, go Back to Login", Toast.LENGTH_SHORT).show();
                        userReference = firebaseDatabase.getReference().child("users").child(mAuth.getCurrentUser().getUid());
                        userReference.setValue(new User(name,email,password,phone));
                    }
                });
            }

        });

    }
}