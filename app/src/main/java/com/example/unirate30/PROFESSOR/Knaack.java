package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Knaack extends AppCompatActivity {

    Button knaackbutton20;
    RatingBar knaackbar1;
    RatingBar knaackbar2;
    RatingBar knaackbar3;
    RatingBar knaackbar4;
    RatingBar knaackbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knaack);

        knaackbar1 = findViewById(R.id.knaackratingBar1);
        knaackbar1.setVisibility(View.INVISIBLE);
        knaackbar2 = findViewById(R.id.knaackratingBar3);
        knaackbar2.setVisibility(View.INVISIBLE);
        knaackbar3 = findViewById(R.id.knaackratingBar5);
        knaackbar3.setVisibility(View.INVISIBLE);
        knaackbar4 = findViewById(R.id.knaackratingBar7);
        knaackbar4.setVisibility(View.INVISIBLE);
        knaackbar5 = findViewById(R.id.knaackratingBar9);
        knaackbar5.setVisibility(View.INVISIBLE);

        knaackbutton20 = findViewById(R.id.knaackbutton6);
        knaackbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    knaackbar1.setVisibility(View.VISIBLE);
                    knaackbar2.setVisibility(View.VISIBLE);
                    knaackbar3.setVisibility(View.VISIBLE);
                    knaackbar4.setVisibility(View.VISIBLE);
                    knaackbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}