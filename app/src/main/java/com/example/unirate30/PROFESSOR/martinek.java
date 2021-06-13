package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class martinek extends AppCompatActivity {

    Button martinekbutton20;
    RatingBar martinekbar1;
    RatingBar martinekbar2;
    RatingBar martinekbar3;
    RatingBar martinekbar4;
    RatingBar martinekbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_martinek);

        martinekbar1 = findViewById(R.id.martinekratingBar1);
        martinekbar1.setVisibility(View.INVISIBLE);
        martinekbar2 = findViewById(R.id.martinekratingBar3);
        martinekbar2.setVisibility(View.INVISIBLE);
        martinekbar3 = findViewById(R.id.martinekratingBar5);
        martinekbar3.setVisibility(View.INVISIBLE);
        martinekbar4 = findViewById(R.id.martinekratingBar7);
        martinekbar4.setVisibility(View.INVISIBLE);
        martinekbar5 = findViewById(R.id.martinekratingBar9);
        martinekbar5.setVisibility(View.INVISIBLE);

        martinekbutton20 = findViewById(R.id.martinekbutton6);
        martinekbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    martinekbar1.setVisibility(View.VISIBLE);
                    martinekbar2.setVisibility(View.VISIBLE);
                    martinekbar3.setVisibility(View.VISIBLE);
                    martinekbar4.setVisibility(View.VISIBLE);
                    martinekbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}