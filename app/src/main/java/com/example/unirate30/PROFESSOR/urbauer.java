package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class urbauer extends AppCompatActivity {

    Button urbbutton20;
    RatingBar urbbar1;
    RatingBar urbbar2;
    RatingBar urbbar3;
    RatingBar urbbar4;
    RatingBar urbbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urbauer);

        urbbar1 = findViewById(R.id.urbratingBar1);
        urbbar1.setVisibility(View.INVISIBLE);
        urbbar2 = findViewById(R.id.urbratingBar3);
        urbbar2.setVisibility(View.INVISIBLE);
        urbbar3 = findViewById(R.id.urbratingBar5);
        urbbar3.setVisibility(View.INVISIBLE);
        urbbar4 = findViewById(R.id.urbratingBar7);
        urbbar4.setVisibility(View.INVISIBLE);
        urbbar5 = findViewById(R.id.urbratingBar9);
        urbbar5.setVisibility(View.INVISIBLE);

        urbbutton20 = findViewById(R.id.urbbutton6);
        urbbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    urbbar1.setVisibility(View.VISIBLE);
                    urbbar2.setVisibility(View.VISIBLE);
                    urbbar3.setVisibility(View.VISIBLE);
                    urbbar4.setVisibility(View.VISIBLE);
                    urbbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}