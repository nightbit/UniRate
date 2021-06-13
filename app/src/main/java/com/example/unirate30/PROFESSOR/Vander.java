package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class Vander extends AppCompatActivity {

    Button chanbutton20;
    RatingBar chanbar1;
    RatingBar chanbar2;
    RatingBar chanbar3;
    RatingBar chanbar4;
    RatingBar chanbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vander);

        chanbar1 = findViewById(R.id.chanratingBar1);
        chanbar1.setVisibility(View.INVISIBLE);
        chanbar2 = findViewById(R.id.chanratingBar3);
        chanbar2.setVisibility(View.INVISIBLE);
        chanbar3 = findViewById(R.id.chanratingBar5);
        chanbar3.setVisibility(View.INVISIBLE);
        chanbar4 = findViewById(R.id.chanratingBar7);
        chanbar4.setVisibility(View.INVISIBLE);
        chanbar5 = findViewById(R.id.chanratingBar9);
        chanbar5.setVisibility(View.INVISIBLE);

        chanbutton20 = findViewById(R.id.chanbutton6);
        chanbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    chanbar1.setVisibility(View.VISIBLE);
                    chanbar2.setVisibility(View.VISIBLE);
                    chanbar3.setVisibility(View.VISIBLE);
                    chanbar4.setVisibility(View.VISIBLE);
                    chanbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}