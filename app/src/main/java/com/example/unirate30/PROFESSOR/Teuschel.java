package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class Teuschel extends AppCompatActivity {

    Button teuschbutton20;
    RatingBar teuschbar1;
    RatingBar teuschbar2;
    RatingBar teuschbar3;
    RatingBar teuschbar4;
    RatingBar teuschbar5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teuschel);

        teuschbar1 = findViewById(R.id.teuschratingBar1);
        teuschbar1.setVisibility(View.INVISIBLE);
        teuschbar2 = findViewById(R.id.teuschratingBar3);
        teuschbar2.setVisibility(View.INVISIBLE);
        teuschbar3 = findViewById(R.id.teuschratingBar5);
        teuschbar3.setVisibility(View.INVISIBLE);
        teuschbar4 = findViewById(R.id.teuschratingBar7);
        teuschbar4.setVisibility(View.INVISIBLE);
        teuschbar5 = findViewById(R.id.teuschratingBar9);
        teuschbar5.setVisibility(View.INVISIBLE);

        teuschbutton20 = findViewById(R.id.teuschbutton6);
        teuschbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    teuschbar1.setVisibility(View.VISIBLE);
                    teuschbar2.setVisibility(View.VISIBLE);
                    teuschbar3.setVisibility(View.VISIBLE);
                    teuschbar4.setVisibility(View.VISIBLE);
                    teuschbar5.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}