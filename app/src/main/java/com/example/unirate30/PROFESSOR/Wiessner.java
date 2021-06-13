package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class Wiessner extends AppCompatActivity {

    Button wiessbutton20;
    RatingBar wiessbar1;
    RatingBar wiessbar2;
    RatingBar wiessbar3;
    RatingBar wiessbar4;
    RatingBar wiessbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiessner);

        wiessbar1 = findViewById(R.id.wiessratingBar1);
        wiessbar1.setVisibility(View.INVISIBLE);
        wiessbar2 = findViewById(R.id.wiessratingBar3);
        wiessbar2.setVisibility(View.INVISIBLE);
        wiessbar3 = findViewById(R.id.wiessratingBar5);
        wiessbar3.setVisibility(View.INVISIBLE);
        wiessbar4 = findViewById(R.id.wiessratingBar7);
        wiessbar4.setVisibility(View.INVISIBLE);
        wiessbar5 = findViewById(R.id.wiessratingBar9);
        wiessbar5.setVisibility(View.INVISIBLE);

        wiessbutton20 = findViewById(R.id.wiessbutton6);
        wiessbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    wiessbar1.setVisibility(View.VISIBLE);
                    wiessbar2.setVisibility(View.VISIBLE);
                    wiessbar3.setVisibility(View.VISIBLE);
                    wiessbar4.setVisibility(View.VISIBLE);
                    wiessbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}