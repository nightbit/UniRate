package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class reif extends AppCompatActivity {

    Button reifbutton20;
    RatingBar reifbar1;
    RatingBar reifbar2;
    RatingBar reifbar3;
    RatingBar reifbar4;
    RatingBar reifbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reif);

        reifbar1 = findViewById(R.id.reifratingBar1);
        reifbar1.setVisibility(View.INVISIBLE);
        reifbar2 = findViewById(R.id.reifratingBar3);
        reifbar2.setVisibility(View.INVISIBLE);
        reifbar3 = findViewById(R.id.reifratingBar5);
        reifbar3.setVisibility(View.INVISIBLE);
        reifbar4 = findViewById(R.id.reifratingBar7);
        reifbar4.setVisibility(View.INVISIBLE);
        reifbar5 = findViewById(R.id.reifratingBar9);
        reifbar5.setVisibility(View.INVISIBLE);

        reifbutton20 = findViewById(R.id.reifbutton6);
        reifbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    reifbar1.setVisibility(View.VISIBLE);
                    reifbar2.setVisibility(View.VISIBLE);
                    reifbar3.setVisibility(View.VISIBLE);
                    reifbar4.setVisibility(View.VISIBLE);
                    reifbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}