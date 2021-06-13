package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Enghuber extends AppCompatActivity {

    Button enghuberbutton20;
    RatingBar enghuberbar1;
    RatingBar enghuberbar2;
    RatingBar enghuberbar3;
    RatingBar enghuberbar4;
    RatingBar enghuberbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enghuber);

        enghuberbar1 = findViewById(R.id.enghuberratingBar1);
        enghuberbar1.setVisibility(View.INVISIBLE);
        enghuberbar2 = findViewById(R.id.enghuberratingBar3);
        enghuberbar2.setVisibility(View.INVISIBLE);
        enghuberbar3 = findViewById(R.id.enghuberratingBar5);
        enghuberbar3.setVisibility(View.INVISIBLE);
        enghuberbar4 = findViewById(R.id.enghuberratingBar7);
        enghuberbar4.setVisibility(View.INVISIBLE);
        enghuberbar5 = findViewById(R.id.enghuberratingBar9);
        enghuberbar5.setVisibility(View.INVISIBLE);

        enghuberbutton20 = findViewById(R.id.enghuberbutton6);
        enghuberbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    enghuberbar1.setVisibility(View.VISIBLE);
                    enghuberbar2.setVisibility(View.VISIBLE);
                    enghuberbar1.setVisibility(View.VISIBLE);
                    enghuberbar4.setVisibility(View.VISIBLE);
                    enghuberbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
