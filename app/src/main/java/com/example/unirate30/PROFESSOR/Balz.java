package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Balz extends AppCompatActivity {

    Button balzbutton20;
    RatingBar balzbar1;
    RatingBar balzbar2;
    RatingBar balzbar3;
    RatingBar balzbar4;
    RatingBar balzbar5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balz);

        balzbar1 = findViewById(R.id.balzratingBar1);
        balzbar1.setVisibility(View.INVISIBLE);
        balzbar2 = findViewById(R.id.balzratingBar3);
        balzbar2.setVisibility(View.INVISIBLE);
        balzbar3 = findViewById(R.id.balzratingBar5);
        balzbar3.setVisibility(View.INVISIBLE);
        balzbar4 = findViewById(R.id.balzratingBar7);
        balzbar4.setVisibility(View.INVISIBLE);
        balzbar5 = findViewById(R.id.balzratingBar9);
        balzbar5.setVisibility(View.INVISIBLE);

        balzbutton20 = findViewById(R.id.balzbutton6);
        balzbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    balzbar1.setVisibility(View.VISIBLE);
                    balzbar2.setVisibility(View.VISIBLE);
                    balzbar3.setVisibility(View.VISIBLE);
                    balzbar4.setVisibility(View.VISIBLE);
                    balzbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
