package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class maierhofer extends AppCompatActivity {

    Button maierhoferbutton20;
    RatingBar maierhoferbar1;
    RatingBar maierhoferbar2;
    RatingBar maierhoferbar3;
    RatingBar maierhoferbar4;
    RatingBar maierhoferbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maierhofer);
        maierhoferbar1 = findViewById(R.id.maierhoferratingBar1);
        maierhoferbar1.setVisibility(View.INVISIBLE);
        maierhoferbar2 = findViewById(R.id.maierhoferratingBar3);
        maierhoferbar2.setVisibility(View.INVISIBLE);
        maierhoferbar3 = findViewById(R.id.maierhoferratingBar5);
        maierhoferbar3.setVisibility(View.INVISIBLE);
        maierhoferbar4 = findViewById(R.id.maierhoferratingBar7);
        maierhoferbar4.setVisibility(View.INVISIBLE);
        maierhoferbar5 = findViewById(R.id.maierhoferratingBar9);
        maierhoferbar5.setVisibility(View.INVISIBLE);

        maierhoferbutton20 = findViewById(R.id.maierhoferbutton6);
        maierhoferbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    maierhoferbar1.setVisibility(View.VISIBLE);
                    maierhoferbar2.setVisibility(View.VISIBLE);
                    maierhoferbar3.setVisibility(View.VISIBLE);
                    maierhoferbar4.setVisibility(View.VISIBLE);
                    maierhoferbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}