package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class mathe2 extends AppCompatActivity {

    Button mathe2button20;
    RatingBar mathe2bar1;
    RatingBar mathe2bar2;
    RatingBar mathe2bar3;

    TextInputLayout til_Prof9mathe2;
    AutoCompleteTextView act_Prof9mathe2;

    ArrayList<String> ArrayList_Prof9mathe2;
    ArrayAdapter<String> ArrayAdapter_Prof9mathe2;

    ImageButton mathe2nextButton12;
    String selected_Prof9mathe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe2);

        mathe2bar1 = findViewById(R.id.mathe2ratingBar2);
        mathe2bar1.setVisibility(View.INVISIBLE);
        mathe2bar2 = findViewById(R.id.mathe2ratingBar4);
        mathe2bar2.setVisibility(View.INVISIBLE);
        mathe2bar3 = findViewById(R.id.mathe2ratingBar6);
        mathe2bar3.setVisibility(View.INVISIBLE);

        til_Prof9mathe2 = (TextInputLayout) findViewById(R.id.til_Prof9mathe2);
        act_Prof9mathe2 = (AutoCompleteTextView) findViewById(R.id.act_Prof9mathe2);

        ArrayList_Prof9mathe2 = new ArrayList<>();
        ArrayList_Prof9mathe2.add("Simon Reif");



        ArrayAdapter_Prof9mathe2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof9mathe2);
        act_Prof9mathe2.setAdapter(ArrayAdapter_Prof9mathe2);

        act_Prof9mathe2.setThreshold(1);

        mathe2button20 = findViewById(R.id.mathe2button6);
        mathe2button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    mathe2bar1.setVisibility(View.VISIBLE);
                    mathe2bar2.setVisibility(View.VISIBLE);
                    mathe2bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        mathe2nextButton12 = findViewById(R.id.mathe2nextButton12);
        mathe2nextButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof9mathe2 = act_Prof9mathe2.getText().toString();
                if (selected_Prof9mathe2.equals("Simon Reif")){
                    openReif2();
                }
            }
        });

    }

    public void openReif2(){
        Intent reif = new Intent(this, com.example.unirate30.PROFESSOR.reif.class);
        startActivity(reif);
    }

}