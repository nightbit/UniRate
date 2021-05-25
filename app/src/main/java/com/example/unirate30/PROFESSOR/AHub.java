package com.example.unirate30.PROFESSOR;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.R;

public class AHub extends AppCompatActivity {

    Button button20;
    ConstraintLayout bewerten1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_hub);

        bewerten1 = findViewById(R.id.bewerten);
        bewerten1.setVisibility(View.INVISIBLE);

        button20 = findViewById(R.id.button6);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    bewerten1.setVisibility(View.VISIBLE);
                }


            }
        });

    }
}