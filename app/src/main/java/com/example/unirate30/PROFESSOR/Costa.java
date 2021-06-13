package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Costa extends AppCompatActivity {

    Button costabutton20;
    RatingBar costabar1;
    RatingBar costabar2;
    RatingBar costabar3;
    RatingBar costabar4;
    RatingBar costabar5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costa);
        costabar1 = findViewById(R.id.brabratingBar1);
        costabar1.setVisibility(View.INVISIBLE);
        costabar2 = findViewById(R.id.brabratingBar3);
        costabar2.setVisibility(View.INVISIBLE);
        costabar3 = findViewById(R.id.brabratingBar5);
        costabar3.setVisibility(View.INVISIBLE);
        costabar4 = findViewById(R.id.brabratingBar7);
        costabar4.setVisibility(View.INVISIBLE);
        costabar5 = findViewById(R.id.brabratingBar9);
        costabar5.setVisibility(View.INVISIBLE);

        costabutton20 = findViewById(R.id.brabbutton6);
        costabutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    costabar1.setVisibility(View.VISIBLE);
                    costabar2.setVisibility(View.VISIBLE);
                    costabar3.setVisibility(View.VISIBLE);
                    costabar4.setVisibility(View.VISIBLE);
                    costabar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}