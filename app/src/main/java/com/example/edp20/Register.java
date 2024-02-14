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

import io.github.muddz.styleabletoast.StyleableToast;

public class Register extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword,conPassword;
    Button signupButton;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalyearproject-e5638-default-rtdb.firebaseio.com");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupName = findViewById(R.id.fullname);
        signupEmail = findViewById(R.id.email);
        signupUsername = findViewById(R.id.uname);
        signupPassword = findViewById(R.id.password);
        conPassword = findViewById(R.id.conPassword);
        signupButton = findViewById(R.id.registerBtn);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String conPasswordTxt = conPassword.getText().toString();


                if (name.isEmpty()||email.isEmpty()||username.isEmpty()||password.isEmpty()){
                    StyleableToast.makeText(Register.this,"Please fill all fields!",R.style.exampleToast1).show();
                } else if (!password.equals(conPasswordTxt)) {
                    StyleableToast.makeText(Register.this,"Password are not matching!",R.style.exampleToast1).show();
                }
                else {

                    HelperClass helperClass = new HelperClass(name, email, username, password);
                    databaseReference.child(username).setValue(helperClass);
                    StyleableToast.makeText(Register.this,"You have signup successfully!",R.style.exampleToast).show();
                    //Toast.makeText(Register.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }

            }
        });
    }
}