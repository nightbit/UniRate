package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Gepp extends AppCompatActivity {

    Button geppbutton20;
    RatingBar geppbar1;
    RatingBar geppbar2;
    RatingBar geppbar3;
    RatingBar geppbar4;
    RatingBar geppbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gepp);
        geppbar1 = findViewById(R.id.geppratingBar1);
        geppbar1.setVisibility(View.INVISIBLE);
        geppbar2 = findViewById(R.id.geppratingBar3);
        geppbar2.setVisibility(View.INVISIBLE);
        geppbar3 = findViewById(R.id.geppratingBar5);
        geppbar3.setVisibility(View.INVISIBLE);
        geppbar4 = findViewById(R.id.geppratingBar7);
        geppbar4.setVisibility(View.INVISIBLE);
        geppbar5 = findViewById(R.id.geppratingBar9);
        geppbar5.setVisibility(View.INVISIBLE);

        geppbutton20 = findViewById(R.id.geppbutton6);
        geppbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    geppbar1.setVisibility(View.VISIBLE);
                    geppbar2.setVisibility(View.VISIBLE);
                    geppbar1.setVisibility(View.VISIBLE);
                    geppbar4.setVisibility(View.VISIBLE);
                    geppbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}