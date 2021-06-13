package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Praher extends AppCompatActivity {

    Button praherbutton20;
    RatingBar praherbar1;
    RatingBar praherbar2;
    RatingBar praherbar3;
    RatingBar praherbar4;
    RatingBar praherbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praher);

        praherbar1 = findViewById(R.id.praherratingBar1);
        praherbar1.setVisibility(View.INVISIBLE);
        praherbar2 = findViewById(R.id.praherratingBar3);
        praherbar2.setVisibility(View.INVISIBLE);
        praherbar3 = findViewById(R.id.praherratingBar5);
        praherbar3.setVisibility(View.INVISIBLE);
        praherbar4 = findViewById(R.id.praherratingBar7);
        praherbar4.setVisibility(View.INVISIBLE);
        praherbar5 = findViewById(R.id.praherratingBar9);
        praherbar5.setVisibility(View.INVISIBLE);

        praherbutton20 = findViewById(R.id.praherbutton6);
        praherbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    praherbar1.setVisibility(View.VISIBLE);
                    praherbar2.setVisibility(View.VISIBLE);
                    praherbar3.setVisibility(View.VISIBLE);
                    praherbar4.setVisibility(View.VISIBLE);
                    praherbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}