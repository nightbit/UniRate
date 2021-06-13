package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Simboeck extends AppCompatActivity {

    Button simboeckbutton20;
    RatingBar simboeckbar1;
    RatingBar simboeckbar2;
    RatingBar simboeckbar3;
    RatingBar simboeckbar4;
    RatingBar simboeckbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simboeck);

        simboeckbar1 = findViewById(R.id.simboeckratingBar1);
        simboeckbar1.setVisibility(View.INVISIBLE);
        simboeckbar2 = findViewById(R.id.simboeckratingBar3);
        simboeckbar2.setVisibility(View.INVISIBLE);
        simboeckbar3 = findViewById(R.id.simboeckratingBar5);
        simboeckbar3.setVisibility(View.INVISIBLE);
        simboeckbar4 = findViewById(R.id.simboeckratingBar7);
        simboeckbar4.setVisibility(View.INVISIBLE);
        simboeckbar5 = findViewById(R.id.simboeckratingBar9);
        simboeckbar5.setVisibility(View.INVISIBLE);

        simboeckbutton20 = findViewById(R.id.simboeckbutton6);
        simboeckbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    simboeckbar1.setVisibility(View.VISIBLE);
                    simboeckbar2.setVisibility(View.VISIBLE);
                    simboeckbar3.setVisibility(View.VISIBLE);
                    simboeckbar4.setVisibility(View.VISIBLE);
                    simboeckbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}