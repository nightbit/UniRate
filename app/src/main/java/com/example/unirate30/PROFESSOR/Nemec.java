package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Nemec extends AppCompatActivity {

    Button nemecbutton20;
    RatingBar nemecbar1;
    RatingBar nemecbar2;
    RatingBar nemecbar3;
    RatingBar nemecbar4;
    RatingBar nemecbar5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nemec);

        nemecbar1 = findViewById(R.id.nemecratingBar1);
        nemecbar1.setVisibility(View.INVISIBLE);
        nemecbar2 = findViewById(R.id.nemecratingBar3);
        nemecbar2.setVisibility(View.INVISIBLE);
        nemecbar3 = findViewById(R.id.nemecratingBar5);
        nemecbar3.setVisibility(View.INVISIBLE);
        nemecbar4 = findViewById(R.id.nemecratingBar7);
        nemecbar4.setVisibility(View.INVISIBLE);
        nemecbar5 = findViewById(R.id.nemecratingBar9);
        nemecbar5.setVisibility(View.INVISIBLE);

        nemecbutton20 = findViewById(R.id.nemecbutton6);
        nemecbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    nemecbar1.setVisibility(View.VISIBLE);
                    nemecbar2.setVisibility(View.VISIBLE);
                    nemecbar3.setVisibility(View.VISIBLE);
                    nemecbar4.setVisibility(View.VISIBLE);
                    nemecbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
