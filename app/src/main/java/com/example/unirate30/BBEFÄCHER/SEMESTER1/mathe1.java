package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class mathe1 extends AppCompatActivity {

    Button mathe1button;
    RatingBar mathe1bar1;
    RatingBar mathe1bar2;
    RatingBar mathe1bar3;

    TextInputLayout til_Prof5;
    AutoCompleteTextView act_Prof5;

    ArrayList<String> ArrayList_Prof5;
    ArrayAdapter<String> ArrayAdapter_Prof5;

    ImageButton mathe1nextButton;
    String selected_Profmathe1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe1);

        mathe1bar1 = findViewById(R.id.mathe1ratingBar2);
        mathe1bar1.setVisibility(View.INVISIBLE);
        mathe1bar2 = findViewById(R.id.mathe1ratingBar4);
        mathe1bar2.setVisibility(View.INVISIBLE);
        mathe1bar3 = findViewById(R.id.mathe1ratingBar6);
        mathe1bar3.setVisibility(View.INVISIBLE);

        til_Prof5 = (TextInputLayout) findViewById(R.id.til_Profmathe1);
        act_Prof5 = (AutoCompleteTextView) findViewById(R.id.act_Profmathe1);

        ArrayList_Prof5 = new ArrayList<>();
        ArrayList_Prof5.add("Simon Reif");


        ArrayAdapter_Prof5 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof5);
        act_Prof5.setAdapter(ArrayAdapter_Prof5);

        act_Prof5.setThreshold(1);

        mathe1button = findViewById(R.id.mathe1button);
        mathe1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    mathe1bar1.setVisibility(View.VISIBLE);
                    mathe1bar2.setVisibility(View.VISIBLE);
                    mathe1bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        mathe1nextButton = findViewById(R.id.mathe1nextButton);
        mathe1nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profmathe1 = act_Prof5.getText().toString();
                if (selected_Profmathe1.equals("Simon Reif")){
                    openReif();
                }
            }
        });
    }

    public void openReif(){
        Intent reif = new Intent(this, com.example.unirate30.PROFESSOR.reif.class);
        startActivity(reif);
    }

}