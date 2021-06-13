package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Filler extends AppCompatActivity {

    Button fillerbutton20;
    RatingBar fillerbar1;
    RatingBar fillerbar2;
    RatingBar fillerbar3;
    RatingBar fillerbar4;
    RatingBar fillerbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filler);


        fillerbar1 = findViewById(R.id.fillerratingBar1);
        fillerbar1.setVisibility(View.INVISIBLE);
        fillerbar2 = findViewById(R.id.fillerratingBar3);
        fillerbar2.setVisibility(View.INVISIBLE);
        fillerbar3 = findViewById(R.id.fillerratingBar5);
        fillerbar3.setVisibility(View.INVISIBLE);
        fillerbar4 = findViewById(R.id.fillerratingBar7);
        fillerbar4.setVisibility(View.INVISIBLE);
        fillerbar5 = findViewById(R.id.fillerratingBar9);
        fillerbar5.setVisibility(View.INVISIBLE);

        fillerbutton20 = findViewById(R.id.fillerbutton6);
        fillerbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    fillerbar1.setVisibility(View.VISIBLE);
                    fillerbar2.setVisibility(View.VISIBLE);
                    fillerbar1.setVisibility(View.VISIBLE);
                    fillerbar4.setVisibility(View.VISIBLE);
                    fillerbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
