package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class Votzi extends AppCompatActivity {

    Button votzibutton20;
    RatingBar votzibar1;
    RatingBar votzibar2;
    RatingBar votzibar3;
    RatingBar votzibar4;
    RatingBar votzibar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votzi);

        votzibar1 = findViewById(R.id.votziratingBar1);
        votzibar1.setVisibility(View.INVISIBLE);
        votzibar2 = findViewById(R.id.votziratingBar3);
        votzibar2.setVisibility(View.INVISIBLE);
        votzibar3 = findViewById(R.id.votziratingBar5);
        votzibar3.setVisibility(View.INVISIBLE);
        votzibar4 = findViewById(R.id.votziratingBar7);
        votzibar4.setVisibility(View.INVISIBLE);
        votzibar5 = findViewById(R.id.votziratingBar9);
        votzibar5.setVisibility(View.INVISIBLE);

        votzibutton20 = findViewById(R.id.votzibutton6);
        votzibutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    votzibar1.setVisibility(View.VISIBLE);
                    votzibar2.setVisibility(View.VISIBLE);
                    votzibar3.setVisibility(View.VISIBLE);
                    votzibar4.setVisibility(View.VISIBLE);
                    votzibar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}