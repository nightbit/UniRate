package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Knoebl extends AppCompatActivity {

    Button knoeblbutton20;
    RatingBar knoeblbar1;
    RatingBar knoeblbar2;
    RatingBar knoeblbar3;
    RatingBar knoeblbar4;
    RatingBar knoeblbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knoebl);

        knoeblbar1 = findViewById(R.id.knoeblratingBar1);
        knoeblbar1.setVisibility(View.INVISIBLE);
        knoeblbar2 = findViewById(R.id.knoeblratingBar3);
        knoeblbar2.setVisibility(View.INVISIBLE);
        knoeblbar3 = findViewById(R.id.knoeblratingBar5);
        knoeblbar3.setVisibility(View.INVISIBLE);
        knoeblbar4 = findViewById(R.id.knoeblratingBar7);
        knoeblbar4.setVisibility(View.INVISIBLE);
        knoeblbar5 = findViewById(R.id.knoeblratingBar9);
        knoeblbar5.setVisibility(View.INVISIBLE);

        knoeblbutton20 = findViewById(R.id.knoeblbutton6);
        knoeblbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    knoeblbar1.setVisibility(View.VISIBLE);
                    knoeblbar2.setVisibility(View.VISIBLE);
                    knoeblbar3.setVisibility(View.VISIBLE);
                    knoeblbar4.setVisibility(View.VISIBLE);
                    knoeblbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}