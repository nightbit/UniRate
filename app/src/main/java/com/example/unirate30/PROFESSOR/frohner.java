package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class frohner extends AppCompatActivity {

    Button frohnerbutton20;
    RatingBar frohnerbar1;
    RatingBar frohnerbar2;
    RatingBar frohnerbar3;
    RatingBar frohnerbar4;
    RatingBar frohnerbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frohner);

        frohnerbar1 = findViewById(R.id.frohnerratingBar1);
        frohnerbar1.setVisibility(View.INVISIBLE);
        frohnerbar2 = findViewById(R.id.frohnerratingBar3);
        frohnerbar2.setVisibility(View.INVISIBLE);
        frohnerbar3 = findViewById(R.id.frohnerratingBar5);
        frohnerbar3.setVisibility(View.INVISIBLE);
        frohnerbar4 = findViewById(R.id.frohnerratingBar7);
        frohnerbar4.setVisibility(View.INVISIBLE);
        frohnerbar5 = findViewById(R.id.frohnerratingBar9);
        frohnerbar5.setVisibility(View.INVISIBLE);

        frohnerbutton20 = findViewById(R.id.frohnerbutton6);
        frohnerbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    frohnerbar1.setVisibility(View.VISIBLE);
                    frohnerbar2.setVisibility(View.VISIBLE);
                    frohnerbar1.setVisibility(View.VISIBLE);
                    frohnerbar4.setVisibility(View.VISIBLE);
                    frohnerbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
