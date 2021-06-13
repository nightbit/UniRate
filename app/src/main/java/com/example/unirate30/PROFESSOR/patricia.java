package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class patricia extends AppCompatActivity {

    Button patriciabutton20;
    RatingBar patriciabar1;
    RatingBar patriciabar2;
    RatingBar patriciabar3;
    RatingBar patriciabar4;
    RatingBar patriciabar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patricia);

        patriciabar1 = findViewById(R.id.patriciaratingBar1);
        patriciabar1.setVisibility(View.INVISIBLE);
        patriciabar2 = findViewById(R.id.patriciaratingBar3);
        patriciabar2.setVisibility(View.INVISIBLE);
        patriciabar3 = findViewById(R.id.patriciaratingBar5);
        patriciabar3.setVisibility(View.INVISIBLE);
        patriciabar4 = findViewById(R.id.patriciaratingBar7);
        patriciabar4.setVisibility(View.INVISIBLE);
        patriciabar5 = findViewById(R.id.patriciaratingBar9);
        patriciabar5.setVisibility(View.INVISIBLE);

        patriciabutton20 = findViewById(R.id.patriciabutton6);
        patriciabutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    patriciabar1.setVisibility(View.VISIBLE);
                    patriciabar2.setVisibility(View.VISIBLE);
                    patriciabar3.setVisibility(View.VISIBLE);
                    patriciabar4.setVisibility(View.VISIBLE);
                    patriciabar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}