package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Huber extends AppCompatActivity {

    Button huberbutton20;
    RatingBar huberbar1;
    RatingBar huberbar2;
    RatingBar huberbar3;
    RatingBar huberbar4;
    RatingBar huberbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huber);
        huberbar1 = findViewById(R.id.huberratingBar1);
        huberbar1.setVisibility(View.INVISIBLE);
        huberbar2 = findViewById(R.id.huberratingBar3);
        huberbar2.setVisibility(View.INVISIBLE);
        huberbar3 = findViewById(R.id.huberratingBar5);
        huberbar3.setVisibility(View.INVISIBLE);
        huberbar4 = findViewById(R.id.huberratingBar7);
        huberbar4.setVisibility(View.INVISIBLE);
        huberbar5 = findViewById(R.id.huberratingBar9);
        huberbar5.setVisibility(View.INVISIBLE);

        huberbutton20 = findViewById(R.id.huberbutton6);
        huberbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    huberbar1.setVisibility(View.VISIBLE);
                    huberbar2.setVisibility(View.VISIBLE);
                    huberbar1.setVisibility(View.VISIBLE);
                    huberbar4.setVisibility(View.VISIBLE);
                    huberbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}