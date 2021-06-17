package com.example.unirate30.BBEFÄCHER.SEMESTER2;

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

public class mathe2 extends AppCompatActivity implements View.OnClickListener {

    Button mathe2button;
    RatingBar mathe2bar, mathe2bar1;
    RatingBar mathe2bar2, mathe2bar4;
    RatingBar mathe2bar3, mathe2bar5;
    FachBewertDBHelper db;
    String db_name="mathe2";

    TextInputLayout til_Prof9mathe2;
    AutoCompleteTextView act_Prof9mathe2;

    ArrayList<String> ArrayList_Prof9mathe2;
    ArrayAdapter<String> ArrayAdapter_Prof9mathe2;

    ImageButton mathe2nextButton;
    String selected_Profmathe2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe2);

        db = new FachBewertDBHelper(mathe2.this,db_name);
        mathe2bar = findViewById(R.id.mathe2ratingBar1);
        mathe2bar.setIsIndicator(true);
        mathe2bar1 =findViewById(R.id.mathe2ratingBar2);
        mathe2bar1.setVisibility(View.INVISIBLE);
        mathe2bar2 = findViewById(R.id.mathe2ratingBar3);
        mathe2bar2.setIsIndicator(true);
        mathe2bar3 = findViewById(R.id.mathe2ratingBar4);
        mathe2bar3.setVisibility(View.INVISIBLE);
        mathe2bar4 =findViewById(R.id.mathe2ratingBar5);
        mathe2bar4.setIsIndicator(true);
        mathe2bar5 =findViewById(R.id.mathe2ratingBar6);
        mathe2bar5.setVisibility(View.INVISIBLE);

        til_Prof9mathe2 = (TextInputLayout) findViewById(R.id.til_Prof9mathe2);
        act_Prof9mathe2 = (AutoCompleteTextView) findViewById(R.id.act_Prof9mathe2);

        ArrayList_Prof9mathe2 = new ArrayList<>();
        ArrayList_Prof9mathe2.add("Simon Reif");



        ArrayAdapter_Prof9mathe2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof9mathe2);
        act_Prof9mathe2.setAdapter(ArrayAdapter_Prof9mathe2);

        act_Prof9mathe2.setThreshold(1);

        mathe2button = findViewById(R.id.mathe2button6);
        mathe2nextButton = findViewById(R.id.mathe2nextButton12);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        mathe2nextButton.setOnClickListener((View.OnClickListener) this);
        mathe2button.setOnClickListener((View.OnClickListener) this);
    }

    public void openReif2(){
        Intent reif = new Intent(this, com.example.unirate30.PROFESSOR.reif.class);
        startActivity(reif);
    }


    public void update ()
    {


        db = new FachBewertDBHelper(mathe2.this,db_name);


        boolean wahr = db.updateData("Mathemathik für Engineering Science 2",
                Username.getUsername(),
                Math.round(mathe2bar1.getRating()),
                Math.round(mathe2bar3.getRating()),
                Math.round(mathe2bar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(mathe2.this,db_name);
        boolean wahr = db.insertData("Mathemathik für Engineering Science 2",
                Username.getUsername(),
                (int) mathe2bar1.getRating(),
                (int) mathe2bar3.getRating(),
                (int) mathe2bar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("Mathemathik für Engineering Science 2", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Mathemathik für Engineering Science 2", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("mMathemathik für Engineering Science 2", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(mathe2.this,db_name);
        List<Integer> list = db.getData("Mathemathik für Engineering Science 2");
        mathe2bar.setRating((float)list.get(0));
        mathe2bar2.setRating((float)list.get(1));
        mathe2bar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mathe2button6:
                if(mathe2button.getText().toString().equals("Bewerten")){
                    mathe2bar1.setVisibility(View.VISIBLE);
                    mathe2bar3.setVisibility(View.VISIBLE);
                    mathe2bar5.setVisibility(View.VISIBLE);
                    mathe2button.setText("Speichern");
                } else if(mathe2button.getText().toString().equals("Speichern"))
                {
                    mathe2bar1.setVisibility(View.INVISIBLE);
                    mathe2bar3.setVisibility(View.INVISIBLE);
                    mathe2bar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    mathe2button.setText("Bewerten");
                }
                break;
            case R.id.mathe2nextButton12:
                selected_Profmathe2 = act_Prof9mathe2.getText().toString();
                if (selected_Profmathe2.equals("Simon Reif")){
                    openReif2();
                }
                break;
        }
    }
}
