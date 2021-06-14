package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class physik extends AppCompatActivity {

    Button phbutton;
    RatingBar phbar1;
    RatingBar phbar2;
    RatingBar phbar3;

    TextInputLayout til_Prof10;
    AutoCompleteTextView act_Prof10;

    ArrayList<String> ArrayList_Prof10;
    ArrayAdapter<String> ArrayAdapter_Prof10;

    ImageButton phnextButton;
    String selected_Profph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physik);

        phbar1 = findViewById(R.id.phratingBar2);
        phbar1.setVisibility(View.INVISIBLE);
        phbar2 = findViewById(R.id.phratingBar4);
        phbar2.setVisibility(View.INVISIBLE);
        phbar3 = findViewById(R.id.phratingBar6);
        phbar3.setVisibility(View.INVISIBLE);

        til_Prof10 = (TextInputLayout) findViewById(R.id.til_Profph);
        act_Prof10 = (AutoCompleteTextView) findViewById(R.id.act_Profph);

        ArrayList_Prof10 = new ArrayList<>();
        ArrayList_Prof10.add("Lukas Mairhofer");

        ArrayAdapter_Prof10 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof10);
        act_Prof10.setAdapter(ArrayAdapter_Prof10);

        act_Prof10.setThreshold(1);

        phbutton = findViewById(R.id.phbutton);
        phbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    phbar1.setVisibility(View.VISIBLE);
                    phbar2.setVisibility(View.VISIBLE);
                    phbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        phnextButton = findViewById(R.id.phnextButton);
        phnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaierhofer();
            }
        });
    }

    public void openMaierhofer(){
        Intent maierhofer = new Intent(this, com.example.unirate30.PROFESSOR.maierhofer.class);
        startActivity(maierhofer);
    }
}