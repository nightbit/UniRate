package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class mohl extends AppCompatActivity {

    Button mohlbutton20;
    RatingBar mohlbar1;
    RatingBar mohlbar2;
    RatingBar mohlbar3;
    RatingBar mohlbar4;
    RatingBar mohlbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mohl);

        mohlbar1 = findViewById(R.id.mohlratingBar1);
        mohlbar1.setVisibility(View.INVISIBLE);
        mohlbar2 = findViewById(R.id.mohlratingBar3);
        mohlbar2.setVisibility(View.INVISIBLE);
        mohlbar3 = findViewById(R.id.mohlratingBar5);
        mohlbar3.setVisibility(View.INVISIBLE);
        mohlbar4 = findViewById(R.id.mohlratingBar7);
        mohlbar4.setVisibility(View.INVISIBLE);
        mohlbar5 = findViewById(R.id.mohlratingBar9);
        mohlbar5.setVisibility(View.INVISIBLE);

        mohlbutton20 = findViewById(R.id.mohlbutton6);
        mohlbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    mohlbar1.setVisibility(View.VISIBLE);
                    mohlbar2.setVisibility(View.VISIBLE);
                    mohlbar3.setVisibility(View.VISIBLE);
                    mohlbar4.setVisibility(View.VISIBLE);
                    mohlbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}

