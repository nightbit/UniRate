package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class AHub extends AppCompatActivity {

    Button button20;
    RatingBar bar1;
    RatingBar bar2;
    RatingBar bar3;
    RatingBar bar4;
    RatingBar bar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_hub);

        bar1 = findViewById(R.id.ratingBar1);
        bar1.setVisibility(View.INVISIBLE);
        bar2 = findViewById(R.id.ratingBar3);
        bar2.setVisibility(View.INVISIBLE);
        bar3 = findViewById(R.id.ratingBar5);
        bar3.setVisibility(View.INVISIBLE);
        bar4 = findViewById(R.id.ratingBar7);
        bar4.setVisibility(View.INVISIBLE);
        bar5 = findViewById(R.id.ratingBar9);
        bar5.setVisibility(View.INVISIBLE);

        button20 = findViewById(R.id.button6);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    bar1.setVisibility(View.VISIBLE);
                    bar2.setVisibility(View.VISIBLE);
                    bar3.setVisibility(View.VISIBLE);
                    bar4.setVisibility(View.VISIBLE);
                    bar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}