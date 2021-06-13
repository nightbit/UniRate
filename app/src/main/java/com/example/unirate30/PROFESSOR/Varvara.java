package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class Varvara extends AppCompatActivity {

    Button varvbutton20;
    RatingBar varvbar1;
    RatingBar varvbar2;
    RatingBar varvbar3;
    RatingBar varvbar4;
    RatingBar varvbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varvara);

        varvbar1 = findViewById(R.id.varvratingBar1);
        varvbar1.setVisibility(View.INVISIBLE);
        varvbar2 = findViewById(R.id.varvratingBar3);
        varvbar2.setVisibility(View.INVISIBLE);
        varvbar3 = findViewById(R.id.varvratingBar5);
        varvbar3.setVisibility(View.INVISIBLE);
        varvbar4 = findViewById(R.id.varvratingBar7);
        varvbar4.setVisibility(View.INVISIBLE);
        varvbar5 = findViewById(R.id.varvratingBar9);
        varvbar5.setVisibility(View.INVISIBLE);

        varvbutton20 = findViewById(R.id.varvbutton6);
        varvbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    varvbar1.setVisibility(View.VISIBLE);
                    varvbar2.setVisibility(View.VISIBLE);
                    varvbar3.setVisibility(View.VISIBLE);
                    varvbar4.setVisibility(View.VISIBLE);
                    varvbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}