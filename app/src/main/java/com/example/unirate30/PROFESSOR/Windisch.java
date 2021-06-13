package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class Windisch extends AppCompatActivity {

    Button windbutton20;
    RatingBar windbar1;
    RatingBar windbar2;
    RatingBar windbar3;
    RatingBar windbar4;
    RatingBar windbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windisch);

        windbar1 = findViewById(R.id.windratingBar1);
        windbar1.setVisibility(View.INVISIBLE);
        windbar2 = findViewById(R.id.windratingBar3);
        windbar2.setVisibility(View.INVISIBLE);
        windbar3 = findViewById(R.id.windratingBar5);
        windbar3.setVisibility(View.INVISIBLE);
        windbar4 = findViewById(R.id.windratingBar7);
        windbar4.setVisibility(View.INVISIBLE);
        windbar5 = findViewById(R.id.windratingBar9);
        windbar5.setVisibility(View.INVISIBLE);

        windbutton20 = findViewById(R.id.windbutton6);
        windbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    windbar1.setVisibility(View.VISIBLE);
                    windbar2.setVisibility(View.VISIBLE);
                    windbar3.setVisibility(View.VISIBLE);
                    windbar4.setVisibility(View.VISIBLE);
                    windbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}