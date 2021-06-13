package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class scheiben extends AppCompatActivity {

    Button scheibenbutton20;
    RatingBar scheibenbar1;
    RatingBar scheibenbar2;
    RatingBar scheibenbar3;
    RatingBar scheibenbar4;
    RatingBar scheibenbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheiben);

        scheibenbar1 = findViewById(R.id.scheibenratingBar1);
        scheibenbar1.setVisibility(View.INVISIBLE);
        scheibenbar2 = findViewById(R.id.scheibenratingBar3);
        scheibenbar2.setVisibility(View.INVISIBLE);
        scheibenbar3 = findViewById(R.id.scheibenratingBar5);
        scheibenbar3.setVisibility(View.INVISIBLE);
        scheibenbar4 = findViewById(R.id.scheibenratingBar7);
        scheibenbar4.setVisibility(View.INVISIBLE);
        scheibenbar5 = findViewById(R.id.scheibenratingBar9);
        scheibenbar5.setVisibility(View.INVISIBLE);

        scheibenbutton20 = findViewById(R.id.scheibenbutton6);
        scheibenbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    scheibenbar1.setVisibility(View.VISIBLE);
                    scheibenbar2.setVisibility(View.VISIBLE);
                    scheibenbar3.setVisibility(View.VISIBLE);
                    scheibenbar4.setVisibility(View.VISIBLE);
                    scheibenbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}