package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class pasteka extends AppCompatActivity {

    Button pastekabutton20;
    RatingBar pastekabar1;
    RatingBar pastekabar2;
    RatingBar pastekabar3;
    RatingBar pastekabar4;
    RatingBar pastekabar5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasteka);

        pastekabar1 = findViewById(R.id.pastekaratingBar1);
        pastekabar1.setVisibility(View.INVISIBLE);
        pastekabar2 = findViewById(R.id.pastekaratingBar3);
        pastekabar2.setVisibility(View.INVISIBLE);
        pastekabar3 = findViewById(R.id.pastekaratingBar5);
        pastekabar3.setVisibility(View.INVISIBLE);
        pastekabar4 = findViewById(R.id.pastekaratingBar7);
        pastekabar4.setVisibility(View.INVISIBLE);
        pastekabar5 = findViewById(R.id.pastekaratingBar9);
        pastekabar5.setVisibility(View.INVISIBLE);

        pastekabutton20 = findViewById(R.id.pastekabutton6);
        pastekabutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    pastekabar1.setVisibility(View.VISIBLE);
                    pastekabar2.setVisibility(View.VISIBLE);
                    pastekabar3.setVisibility(View.VISIBLE);
                    pastekabar4.setVisibility(View.VISIBLE);
                    pastekabar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}