package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Sauer extends AppCompatActivity {

    Button sauerbutton20;
    RatingBar sauerbar1;
    RatingBar sauerbar2;
    RatingBar sauerbar3;
    RatingBar sauerbar4;
    RatingBar sauerbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauer);

        sauerbar1 = findViewById(R.id.sauerratingBar1);
        sauerbar1.setVisibility(View.INVISIBLE);
        sauerbar2 = findViewById(R.id.sauerratingBar3);
        sauerbar2.setVisibility(View.INVISIBLE);
        sauerbar3 = findViewById(R.id.sauerratingBar5);
        sauerbar3.setVisibility(View.INVISIBLE);
        sauerbar4 = findViewById(R.id.sauerratingBar7);
        sauerbar4.setVisibility(View.INVISIBLE);
        sauerbar5 = findViewById(R.id.sauerratingBar9);
        sauerbar5.setVisibility(View.INVISIBLE);

        sauerbutton20 = findViewById(R.id.sauerbutton6);
        sauerbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    sauerbar1.setVisibility(View.VISIBLE);
                    sauerbar2.setVisibility(View.VISIBLE);
                    sauerbar3.setVisibility(View.VISIBLE);
                    sauerbar4.setVisibility(View.VISIBLE);
                    sauerbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
