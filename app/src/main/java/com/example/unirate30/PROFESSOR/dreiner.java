package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class dreiner extends AppCompatActivity {

    Button dreinerbutton20;
    RatingBar dreinerbar1;
    RatingBar dreinerbar2;
    RatingBar dreinerbar3;
    RatingBar dreinerbar4;
    RatingBar dreinerbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreiner);


        dreinerbar1 = findViewById(R.id.dreinerratingBar1);
        dreinerbar1.setVisibility(View.INVISIBLE);
        dreinerbar2 = findViewById(R.id.dreinerratingBar3);
        dreinerbar2.setVisibility(View.INVISIBLE);
        dreinerbar3 = findViewById(R.id.dreinerratingBar5);
        dreinerbar3.setVisibility(View.INVISIBLE);
        dreinerbar4 = findViewById(R.id.dreinerratingBar7);
        dreinerbar4.setVisibility(View.INVISIBLE);
        dreinerbar5 = findViewById(R.id.dreinerratingBar9);
        dreinerbar5.setVisibility(View.INVISIBLE);

        dreinerbutton20 = findViewById(R.id.dreinerbutton6);
        dreinerbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    dreinerbar1.setVisibility(View.VISIBLE);
                    dreinerbar2.setVisibility(View.VISIBLE);
                    dreinerbar1.setVisibility(View.VISIBLE);
                    dreinerbar4.setVisibility(View.VISIBLE);
                    dreinerbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
