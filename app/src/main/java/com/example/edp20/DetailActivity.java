package com.example.edp20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DetailActivity extends AppCompatActivity {

    TextView detailDesc, detailTitle,detailTime;
    ImageView detailImage;
    Button booknow;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://finalyearproject-e5638-default-rtdb.firebaseio.com");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailDesc = findViewById(R.id.detailDesc);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        detailTime = findViewById(R.id.detailTime);
        booknow = findViewById(R.id.booknow);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getInt("Desc"));
            detailImage.setImageResource(bundle.getInt("Image"));
            detailTitle.setText(bundle.getString("Title"));
            detailTime.setText(bundle.getInt("Time"));
        }
        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String course = detailTitle.getText().toString();
                    String Time = detailTime.getText().toString();
                           Intent intent = new Intent(DetailActivity.this, Login2.class);
                            intent.putExtra("course", course);
                            intent.putExtra("Time",Time);
                            startActivity(intent);
            }
        });
    }
}