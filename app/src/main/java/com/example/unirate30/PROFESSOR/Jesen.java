package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Jesen extends AppCompatActivity {

    Button jesenbutton20;
    RatingBar jesenbar1;
    RatingBar jesenbar2;
    RatingBar jesenbar3;
    RatingBar jesenbar4;
    RatingBar jesenbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jesen);
        jesenbar1 = findViewById(R.id.jesenratingBar1);
        jesenbar1.setVisibility(View.INVISIBLE);
        jesenbar2 = findViewById(R.id.jesenratingBar3);
        jesenbar2.setVisibility(View.INVISIBLE);
        jesenbar3 = findViewById(R.id.jesenratingBar5);
        jesenbar3.setVisibility(View.INVISIBLE);
        jesenbar4 = findViewById(R.id.jesenratingBar7);
        jesenbar4.setVisibility(View.INVISIBLE);
        jesenbar5 = findViewById(R.id.jesenratingBar9);
        jesenbar5.setVisibility(View.INVISIBLE);

        jesenbutton20 = findViewById(R.id.jesenbutton6);
        jesenbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    jesenbar1.setVisibility(View.VISIBLE);
                    jesenbar2.setVisibility(View.VISIBLE);
                    jesenbar3.setVisibility(View.VISIBLE);
                    jesenbar4.setVisibility(View.VISIBLE);
                    jesenbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}