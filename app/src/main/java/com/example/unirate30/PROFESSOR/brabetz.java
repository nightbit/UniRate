package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class brabetz extends AppCompatActivity {

    Button brabbutton20;
    RatingBar brabbar1;
    RatingBar brabbar2;
    RatingBar brabbar3;
    RatingBar brabbar4;
    RatingBar brabbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brabetz);

        brabbar1 = findViewById(R.id.brabratingBar1);
        brabbar1.setVisibility(View.INVISIBLE);
        brabbar2 = findViewById(R.id.brabratingBar3);
        brabbar2.setVisibility(View.INVISIBLE);
        brabbar3 = findViewById(R.id.brabratingBar5);
        brabbar3.setVisibility(View.INVISIBLE);
        brabbar4 = findViewById(R.id.brabratingBar7);
        brabbar4.setVisibility(View.INVISIBLE);
        brabbar5 = findViewById(R.id.brabratingBar9);
        brabbar5.setVisibility(View.INVISIBLE);

        brabbutton20 = findViewById(R.id.brabbutton6);
        brabbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    brabbar1.setVisibility(View.VISIBLE);
                    brabbar2.setVisibility(View.VISIBLE);
                    brabbar3.setVisibility(View.VISIBLE);
                    brabbar4.setVisibility(View.VISIBLE);
                    brabbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}