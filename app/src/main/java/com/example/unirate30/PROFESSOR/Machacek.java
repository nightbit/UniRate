package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Machacek extends AppCompatActivity {

    Button machacekbutton20;
    RatingBar machacekbar1;
    RatingBar machacekbar2;
    RatingBar machacekbar3;
    RatingBar machacekbar4;
    RatingBar machacekbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_machacek);
        machacekbar1 = findViewById(R.id.machacekratingBar1);
        machacekbar1.setVisibility(View.INVISIBLE);
        machacekbar2 = findViewById(R.id.machacekratingBar3);
        machacekbar2.setVisibility(View.INVISIBLE);
        machacekbar3 = findViewById(R.id.machacekratingBar5);
        machacekbar3.setVisibility(View.INVISIBLE);
        machacekbar4 = findViewById(R.id.machacekratingBar7);
        machacekbar4.setVisibility(View.INVISIBLE);
        machacekbar5 = findViewById(R.id.machacekratingBar9);
        machacekbar5.setVisibility(View.INVISIBLE);

        machacekbutton20 = findViewById(R.id.machacekbutton6);
        machacekbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    machacekbar1.setVisibility(View.VISIBLE);
                    machacekbar2.setVisibility(View.VISIBLE);
                    machacekbar3.setVisibility(View.VISIBLE);
                    machacekbar4.setVisibility(View.VISIBLE);
                    machacekbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}