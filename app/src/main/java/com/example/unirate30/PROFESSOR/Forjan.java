package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Forjan extends AppCompatActivity {

    Button forjanbutton20;
    RatingBar forjanbar1;
    RatingBar forjanbar2;
    RatingBar forjanbar3;
    RatingBar forjanbar4;
    RatingBar forjanbar5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forjan);

        forjanbar1 = findViewById(R.id.forjanratingBar1);
        forjanbar1.setVisibility(View.INVISIBLE);
        forjanbar2 = findViewById(R.id.forjanratingBar3);
        forjanbar2.setVisibility(View.INVISIBLE);
        forjanbar3 = findViewById(R.id.forjanratingBar5);
        forjanbar3.setVisibility(View.INVISIBLE);
        forjanbar4 = findViewById(R.id.forjanratingBar7);
        forjanbar4.setVisibility(View.INVISIBLE);
        forjanbar5 = findViewById(R.id.forjanratingBar9);
        forjanbar5.setVisibility(View.INVISIBLE);

        forjanbutton20 = findViewById(R.id.forjanbutton6);
        forjanbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    forjanbar1.setVisibility(View.VISIBLE);
                    forjanbar2.setVisibility(View.VISIBLE);
                    forjanbar3.setVisibility(View.VISIBLE);
                    forjanbar4.setVisibility(View.VISIBLE);
                    forjanbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
