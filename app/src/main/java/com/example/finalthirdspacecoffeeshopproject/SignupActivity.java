package com.example.finalthirdspacecoffeeshopproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;

public class SignupActivity extends AppCompatActivity {

    EditText FirstName, LastName, Email, PhoneNumber, Password, ConfirmPassword;
    Button Create;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        Email = findViewById(Email);
        PhoneNumber = findViewById(PhoneNumber);
        Password = findViewById(Password);
        ConfirmPassword = findViewById(ConfirmPassword)

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {

        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if (v==Create) {

            makeNewUsers(email,password);
        } else if (v==Create) {


            mAuth.signInWithEmailandPassword(email, password)
                    .addOnCompleteListener(this,
                            if (task.isSuccessful()) {

                                Toast.makeText(SignupActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                                Intent logoutIntent = new Intent (SignupActivity.this, AccountActivity.class);
                                startActivity(logoutIntent);}

                                else {

                                    Toast.makeText(SignupActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();


                }
            });
        }







    }
}


    public void makeNewUsers (String email, String password) {

        mAuth.createUserwithEmailandPassword(email, password)
            .addOnCompleteListener(this,
                    if (task.isSuccessful()) {


                        Toast.makeText(SignupActivity.this "User Registration Successful", Toast.LENGTH_SHORT).show();
        }
                    else {

                        Toast.makeText(SignupActivity.this "User Registration Failed", Toast.LENGTH_SHORT).show();

        }

                        );



        }