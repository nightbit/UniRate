package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Schenk extends AppCompatActivity {

    Button schenkbutton20;
    RatingBar schenkbar1;
    RatingBar schenkbar2;
    RatingBar schenkbar3;
    RatingBar schenkbar4;
    RatingBar schenkbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schenk);

        schenkbar1 = findViewById(R.id.schenkratingBar1);
        schenkbar1.setVisibility(View.INVISIBLE);
        schenkbar2 = findViewById(R.id.schenkratingBar3);
        schenkbar2.setVisibility(View.INVISIBLE);
        schenkbar3 = findViewById(R.id.schenkratingBar5);
        schenkbar3.setVisibility(View.INVISIBLE);
        schenkbar4 = findViewById(R.id.schenkratingBar7);
        schenkbar4.setVisibility(View.INVISIBLE);
        schenkbar5 = findViewById(R.id.schenkratingBar9);
        schenkbar5.setVisibility(View.INVISIBLE);

        schenkbutton20 = findViewById(R.id.schenkbutton6);
        schenkbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    schenkbar1.setVisibility(View.VISIBLE);
                    schenkbar2.setVisibility(View.VISIBLE);
                    schenkbar3.setVisibility(View.VISIBLE);
                    schenkbar4.setVisibility(View.VISIBLE);
                    schenkbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}