package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Scherer extends AppCompatActivity {

    Button schererbutton20;
    RatingBar schererbar1;
    RatingBar schererbar2;
    RatingBar schererbar3;
    RatingBar schererbar4;
    RatingBar schererbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scherer);

        schererbar1 = findViewById(R.id.schererratingBar1);
        schererbar1.setVisibility(View.INVISIBLE);
        schererbar2 = findViewById(R.id.schererratingBar3);
        schererbar2.setVisibility(View.INVISIBLE);
        schererbar3 = findViewById(R.id.schererratingBar5);
        schererbar3.setVisibility(View.INVISIBLE);
        schererbar4 = findViewById(R.id.schererratingBar7);
        schererbar4.setVisibility(View.INVISIBLE);
        schererbar5 = findViewById(R.id.schererratingBar9);
        schererbar5.setVisibility(View.INVISIBLE);

        schererbutton20 = findViewById(R.id.schererbutton6);
        schererbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    schererbar1.setVisibility(View.VISIBLE);
                    schererbar2.setVisibility(View.VISIBLE);
                    schererbar3.setVisibility(View.VISIBLE);
                    schererbar4.setVisibility(View.VISIBLE);
                    schererbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}