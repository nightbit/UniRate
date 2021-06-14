package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class eng1 extends AppCompatActivity {

    Button eng1button;
    RatingBar eng1bar1;
    RatingBar eng1bar2;
    RatingBar eng1bar3;

    TextInputLayout til_Prof8;
    AutoCompleteTextView act_Prof8;

    ArrayList<String> ArrayList_Prof8;
    ArrayAdapter<String> ArrayAdapter_Prof8;

    ImageButton eng1nextButton;
    String selected_Profeng1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng1);

        eng1bar1 = findViewById(R.id.eng1ratingBar2);
        eng1bar1.setVisibility(View.INVISIBLE);
        eng1bar2 = findViewById(R.id.eng1ratingBar4);
        eng1bar2.setVisibility(View.INVISIBLE);
        eng1bar3 = findViewById(R.id.eng1ratingBar6);
        eng1bar3.setVisibility(View.INVISIBLE);

        til_Prof8 = (TextInputLayout) findViewById(R.id.til_Profeng1);
        act_Prof8 = (AutoCompleteTextView) findViewById(R.id.act_Profeng1);

        ArrayList_Prof8 = new ArrayList<>();
        ArrayList_Prof8.add("Patricia Chan Stephenson");


        ArrayAdapter_Prof8 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof8);
        act_Prof8.setAdapter(ArrayAdapter_Prof8);

        act_Prof8.setThreshold(1);

        eng1button = findViewById(R.id.eng1button);
        eng1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    eng1bar1.setVisibility(View.VISIBLE);
                    eng1bar2.setVisibility(View.VISIBLE);
                    eng1bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        eng1nextButton = findViewById(R.id.eng1nextButton);
        eng1nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profeng1 = act_Prof8.getText().toString();
                if (selected_Profeng1.equals("Patricia Chan Stephenson")){
                    openPatricia();
                }
            }
        });
    }

    public void openPatricia(){
        Intent patricia = new Intent(this, com.example.unirate30.PROFESSOR.patricia.class);
        startActivity(patricia);
    }

}