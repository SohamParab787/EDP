package com.example.edp20;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

import io.github.muddz.styleabletoast.StyleableToast;

public class Login2 extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button loginButton;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalyearproject-e5638-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginUsername = findViewById(R.id.username);
        loginPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateUsername() | !validatePassword()) {

                } else {
                    checkUser();
                }
            }
        });

    }

    public Boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if (val.isEmpty()) {
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }


    public void checkUser(){
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();


        Query checkUserDatabase = databaseReference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){

                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)) {
                        loginUsername.setError(null);

                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);


                        Intent intent = getIntent();
                        String course = intent.getStringExtra("course");
                        String Time = intent.getStringExtra("Time");
                        SemiClass semiClass = new SemiClass(nameFromDB, emailFromDB, course, usernameFromDB, passwordFromDB);
                        databaseReference.child(userUsername).setValue(semiClass);

                        String courseFromDB = snapshot.child(userUsername).child("course").getValue(String.class);
                        Intent intent1 = new Intent(Login2.this, MainActivity2.class);

                        intent1.putExtra("name", nameFromDB);
                        intent1.putExtra("email", emailFromDB);
                        intent1.putExtra("username", usernameFromDB);
                        intent1.putExtra("password", passwordFromDB);
                        intent1.putExtra("course", course);
                        intent1.putExtra("Time",Time);

                        StyleableToast.makeText(Login2.this," Successfully Booked",R.style.exampleToast).show();
                        startActivity(intent1);

                       // Toast.makeText(Login2.this, "Booked", Toast.LENGTH_SHORT).show();

                    } else {
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}