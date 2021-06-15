package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class eng2 extends AppCompatActivity {

    Button eng2button;
    RatingBar eng2bar1;
    RatingBar eng2bar2;
    RatingBar eng2bar3;

    TextInputLayout til_Prof17;
    AutoCompleteTextView act_Prof17;

    ArrayList<String> ArrayList_Prof17;
    ArrayAdapter<String> ArrayAdapter_Prof17;

    ImageButton eng2nextButton;
    String eng2selected_Prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng2);

        eng2bar1 = findViewById(R.id.eng2ratingBar2);
        eng2bar1.setVisibility(View.INVISIBLE);
        eng2bar2 = findViewById(R.id.eng2ratingBar4);
        eng2bar2.setVisibility(View.INVISIBLE);
        eng2bar3 = findViewById(R.id.eng2ratingBar6);
        eng2bar3.setVisibility(View.INVISIBLE);

        til_Prof17 = (TextInputLayout) findViewById(R.id.til_Profeng2);
        act_Prof17 = (AutoCompleteTextView) findViewById(R.id.act_Profeng2);

        ArrayList_Prof17 = new ArrayList<>();
        ArrayList_Prof17.add("Ruth Schenk");
        ArrayList_Prof17.add("Chanda Vanderhart");



        ArrayAdapter_Prof17 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof17);
        act_Prof17.setAdapter(ArrayAdapter_Prof17);

        act_Prof17.setThreshold(1);

        eng2button = findViewById(R.id.eng2button);
        eng2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    eng2bar1.setVisibility(View.VISIBLE);
                    eng2bar2.setVisibility(View.VISIBLE);
                    eng2bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        eng2nextButton = findViewById(R.id.eng2nextButton);
        eng2nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eng2selected_Prof = act_Prof17.getText().toString();
                if (eng2selected_Prof.equals("Ruth Schenk")) {
                    openSchenk();
                }
                    if (eng2selected_Prof.equals("Chanda Vanderhart")){
                        openVander();
                    }
                }

        });
    }
    public void openSchenk(){
        Intent Schenk = new Intent(this, com.example.unirate30.PROFESSOR.Schenk.class);
        startActivity(Schenk);
    }

    public void openVander(){
        Intent Vander = new Intent(this, com.example.unirate30.PROFESSOR.Vander.class);
        startActivity(Vander);
    }

}

