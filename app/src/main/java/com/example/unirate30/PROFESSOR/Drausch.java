package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;

public class Drausch extends AppCompatActivity {

    Button drauschbutton20;
    RatingBar drauschbar1;
    RatingBar drauschbar2;
    RatingBar drauschbar3;
    RatingBar drauschbar4;
    RatingBar drauschbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drausch);

        drauschbar1 = findViewById(R.id.drauschratingBar1);
        drauschbar1.setVisibility(View.INVISIBLE);
        drauschbar2 = findViewById(R.id.drauschratingBar3);
        drauschbar2.setVisibility(View.INVISIBLE);
        drauschbar3 = findViewById(R.id.drauschratingBar5);
        drauschbar3.setVisibility(View.INVISIBLE);
        drauschbar4 = findViewById(R.id.drauschratingBar7);
        drauschbar4.setVisibility(View.INVISIBLE);
        drauschbar5 = findViewById(R.id.drauschratingBar9);
        drauschbar5.setVisibility(View.INVISIBLE);

        drauschbutton20 = findViewById(R.id.drauschbutton6);
        drauschbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    drauschbar1.setVisibility(View.VISIBLE);
                    drauschbar2.setVisibility(View.VISIBLE);
                    drauschbar1.setVisibility(View.VISIBLE);
                    drauschbar4.setVisibility(View.VISIBLE);
                    drauschbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
