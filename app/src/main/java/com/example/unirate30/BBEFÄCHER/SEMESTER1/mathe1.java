package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class mathe1 extends AppCompatActivity implements View.OnClickListener {

    Button mathe1button;
    RatingBar mathe1bar1;
    RatingBar mathe1bar2;
    RatingBar mathe1bar3;
    RatingBar mathe1bar4;
    RatingBar mathe1bar5;
    RatingBar mathe1bar6;
    FachBewertDBHelper db;
    String db_name="allgchem";

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
        db = new FachBewertDBHelper(mathe1.this,db_name);

        mathe1bar1 = findViewById(R.id.mathe1ratingBar2);
        mathe1bar1.setVisibility(View.INVISIBLE);
        mathe1bar2 = findViewById(R.id.mathe1ratingBar4);
        mathe1bar2.setVisibility(View.INVISIBLE);
        mathe1bar3 = findViewById(R.id.mathe1ratingBar6);
        mathe1bar3.setVisibility(View.INVISIBLE);
        mathe1bar4 = findViewById(R.id.mathe1ratingBar1);
        mathe1bar4.setIsIndicator(true);
        mathe1bar5 = findViewById(R.id.mathe1ratingBar3);
        mathe1bar5.setIsIndicator(true);
        mathe1bar6 = findViewById(R.id.mathe1ratingBar5);
        mathe1bar6.setIsIndicator(true);

        til_Prof5 = (TextInputLayout) findViewById(R.id.til_Profmathe1);
        act_Prof5 = (AutoCompleteTextView) findViewById(R.id.act_Profmathe1);

        ArrayList_Prof5 = new ArrayList<>();
        ArrayList_Prof5.add("Simon Reif");

        ArrayAdapter_Prof5 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof5);
        act_Prof5.setAdapter(ArrayAdapter_Prof5);

        act_Prof5.setThreshold(1);

        mathe1button = findViewById(R.id.mathe1button);

        mathe1nextButton = findViewById(R.id.mathe1nextButton);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        mathe1nextButton.setOnClickListener((View.OnClickListener) this);
        mathe1button.setOnClickListener((View.OnClickListener) this);
    }

    public void openReif(){
        Intent reif = new Intent(this, com.example.unirate30.PROFESSOR.reif.class);
        startActivity(reif);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(mathe1.this,db_name);


        boolean wahr = db.updateData("mathe1",
                Username.getUsername(),
                Math.round(mathe1bar1.getRating()),
                Math.round(mathe1bar2.getRating()),
                Math.round(mathe1bar3.getRating())
        );

        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }
    }
    public void AddData () {
        db = new FachBewertDBHelper(mathe1.this,db_name);
        boolean wahr = db.insertData("mathe1",
                Username.getUsername(),
                (int) mathe1bar1.getRating(),
                (int) mathe1bar2.getRating(),
                (int) mathe1bar3.getRating()
        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("mathe1", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("mathe1", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("mathe1", true);
            sharedPreferencesEditor.apply();
        }
        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(mathe1.this,db_name);
        List<Integer> list = db.getData("mathe1");
        mathe1bar4.setRating((float)list.get(0));
        mathe1bar5.setRating((float)list.get(1));
        mathe1bar6.setRating((float)list.get(2));
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mathe1button:ton:
            if(mathe1button.getText().toString().equals("Bewerten")){
                mathe1bar1.setVisibility(View.VISIBLE);
                mathe1bar2.setVisibility(View.VISIBLE);
                mathe1bar3.setVisibility(View.VISIBLE);
                mathe1button.setText("Speichern");
            } else if(mathe1button.getText().toString().equals("Speichern"))
            {
                mathe1bar1.setVisibility(View.INVISIBLE);
                mathe1bar2.setVisibility(View.INVISIBLE);
                mathe1bar3.setVisibility(View.INVISIBLE);

                update();
                AddData();

                ergebnisse();
                mathe1button.setText("Bewerten");
            }
                break;
            case R.id.mathe1nextButton:
                selected_Profmathe1 = act_Prof5.getText().toString();
                if (selected_Profmathe1.equals("Simon Reif")){
                    openReif();
                }
                break;
        }
    }
}