package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Eitel extends AppCompatActivity {

    Button eitelbutton20;
    RatingBar eitelbar1;
    RatingBar eitelbar2;
    RatingBar eitelbar3;
    RatingBar eitelbar4;
    RatingBar eitelbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eitel);
        eitelbar1 = findViewById(R.id.eitelratingBar1);
        eitelbar1.setVisibility(View.INVISIBLE);
        eitelbar2 = findViewById(R.id.eitelratingBar3);
        eitelbar2.setVisibility(View.INVISIBLE);
        eitelbar3 = findViewById(R.id.eitelratingBar5);
        eitelbar3.setVisibility(View.INVISIBLE);
        eitelbar4 = findViewById(R.id.eitelratingBar7);
        eitelbar4.setVisibility(View.INVISIBLE);
        eitelbar5 = findViewById(R.id.eitelratingBar9);
        eitelbar5.setVisibility(View.INVISIBLE);

        eitelbutton20 = findViewById(R.id.eitelbutton6);
        eitelbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    eitelbar1.setVisibility(View.VISIBLE);
                    eitelbar2.setVisibility(View.VISIBLE);
                    eitelbar1.setVisibility(View.VISIBLE);
                    eitelbar4.setVisibility(View.VISIBLE);
                    eitelbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
