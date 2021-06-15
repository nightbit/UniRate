package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Sauer;
import com.example.unirate30.PROFESSOR.Votzi;
import com.example.unirate30.PROFESSOR.Windisch;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class elek extends AppCompatActivity {

    Button elekbutton;
    RatingBar elekbar1;
    RatingBar elekbar2;
    RatingBar elekbar3;

    TextInputLayout til_Prof16;
    AutoCompleteTextView act_Prof16;

    ArrayList<String> ArrayList_Prof16;
    ArrayAdapter<String> ArrayAdapter_Prof16;

    ImageButton eleknextButton;
    String elekselected_Prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elek);

        elekbar1 = findViewById(R.id.elekratingBar2);
        elekbar1.setVisibility(View.INVISIBLE);
        elekbar2 = findViewById(R.id.elekratingBar4);
        elekbar2.setVisibility(View.INVISIBLE);
        elekbar3 = findViewById(R.id.elekratingBar6);
        elekbar3.setVisibility(View.INVISIBLE);

        til_Prof16 = (TextInputLayout) findViewById(R.id.til_Profelek);
        act_Prof16 = (AutoCompleteTextView) findViewById(R.id.act_Profelek);

        ArrayList_Prof16 = new ArrayList<>();
        ArrayList_Prof16.add("Stefan Sauermann");
        ArrayList_Prof16.add("Helmut Votzi");
        ArrayList_Prof16.add("Michael Windisch");


        ArrayAdapter_Prof16 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof16);
        act_Prof16.setAdapter(ArrayAdapter_Prof16);

        act_Prof16.setThreshold(1);

        elekbutton = findViewById(R.id.elekbutton);
        elekbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    elekbar1.setVisibility(View.VISIBLE);
                    elekbar2.setVisibility(View.VISIBLE);
                    elekbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        eleknextButton = findViewById(R.id.eleknextButton);
        eleknextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elekselected_Prof = act_Prof16.getText().toString();
                if (elekselected_Prof.equals("Stefan Sauermann")){
                    openSauer();
                }if (elekselected_Prof.equals("Helmut Votzi")){
                    openVotzi();
                }if (elekselected_Prof.equals("Michael Windisch")){
                    openWindisch();
                }
            }
        });
    }

    public void openSauer(){
        Intent sauer = new Intent(this, Sauer.class);
        startActivity(sauer);
    }
    public void openVotzi(){
        Intent votzi = new Intent(this, Votzi.class);
        startActivity(votzi);
    }
    public void openWindisch(){
        Intent windisch = new Intent(this, Windisch.class);
        startActivity(windisch);
    }

}