package com.example.edp20;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    TextView profileName, profileEmail, profileUsername,profileCourse,detail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profileCourse = findViewById(R.id.profileCourse);
        detail = findViewById(R.id.detail);

        showAllUserData();



    }

    public void showAllUserData(){
        Intent intent1 = getIntent();
        String nameUser = intent1.getStringExtra("name");
        String emailUser = intent1.getStringExtra("email");
        String usernameUser = intent1.getStringExtra("username");
        String courseUser = intent1.getStringExtra("course");
        String timeUser = intent1.getStringExtra("Time");

        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profileUsername.setText(usernameUser);
        profileCourse.setText(courseUser);
        detail.setText(timeUser);

    }
}