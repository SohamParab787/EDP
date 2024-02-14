package com.example.edp20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),Register.class);
                StyleableToast.makeText(MainActivity.this,"Open Successfully",R.style.exampleToast).show();
                startActivity(intent);

  //              Toast.makeText(MainActivity.this,"Sign-up page Successfully Open",Toast.LENGTH_LONG).show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),Login.class);
                StyleableToast.makeText(MainActivity.this,"Open Successfully",R.style.exampleToast).show();
                startActivity(intent);

 //               Toast.makeText(MainActivity.this,"Sign-in page Successfully Open",Toast.LENGTH_LONG).show();

            }
        });
    }
}