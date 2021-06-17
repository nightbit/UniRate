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

public class eng2 extends AppCompatActivity implements View.OnClickListener {

    Button eng2button;
    RatingBar eng2bar, eng2bar1;
    RatingBar eng2bar2, eng2bar4;
    RatingBar eng2bar3, eng2bar5;
    FachBewertDBHelper db;
    String db_name = "eng2";

    TextInputLayout til_Prof17;
    AutoCompleteTextView act_Prof17;

    ArrayList<String> ArrayList_Prof17;
    ArrayAdapter<String> ArrayAdapter_Prof17;

    ImageButton eng2nextButton;
    String selected_Profeng2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng2);


        db = new FachBewertDBHelper(eng2.this, db_name);
        eng2bar = findViewById(R.id.eng2ratingBar1);
        eng2bar.setIsIndicator(true);
        eng2bar1 =findViewById(R.id.eng2ratingBar2);
        eng2bar1.setVisibility(View.INVISIBLE);
        eng2bar2 = findViewById(R.id.eng2ratingBar3);
        eng2bar2.setIsIndicator(true);
        eng2bar3 = findViewById(R.id.eng2ratingBar4);
        eng2bar3.setVisibility(View.INVISIBLE);
        eng2bar4 =findViewById(R.id.eng2ratingBar5);
        eng2bar4.setIsIndicator(true);
        eng2bar5 =findViewById(R.id.eng2ratingBar6);
        eng2bar5.setVisibility(View.INVISIBLE);

        til_Prof17 = (TextInputLayout) findViewById(R.id.til_Profeng2);
        act_Prof17 = (AutoCompleteTextView) findViewById(R.id.act_Profeng2);

        ArrayList_Prof17 = new ArrayList<>();
        ArrayList_Prof17.add("Ruth Schenk");
        ArrayList_Prof17.add("Chanda Vanderhart");



        ArrayAdapter_Prof17 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof17);
        act_Prof17.setAdapter(ArrayAdapter_Prof17);

        act_Prof17.setThreshold(1);

        eng2button = findViewById(R.id.eng2button);
        eng2nextButton = findViewById(R.id.eng2nextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        eng2nextButton.setOnClickListener((View.OnClickListener) this);
        eng2button.setOnClickListener((View.OnClickListener) this);
    }
    public void openSchenk(){
        Intent Schenk = new Intent(this, com.example.unirate30.PROFESSOR.Schenk.class);
        startActivity(Schenk);
    }

    public void openVander(){
        Intent Vander = new Intent(this, com.example.unirate30.PROFESSOR.Vander.class);
        startActivity(Vander);
    }


    public void update ()
    {


        db = new FachBewertDBHelper(eng2.this, db_name);


        boolean wahr = db.updateData("Englisch 2",
                Username.getUsername(),
                Math.round(eng2bar1.getRating()),
                Math.round(eng2bar3.getRating()),
                Math.round(eng2bar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(eng2.this, db_name);
        boolean wahr = db.insertData("Englisch 2",
                Username.getUsername(),
                (int) eng2bar1.getRating(),
                (int) eng2bar3.getRating(),
                (int) eng2bar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("Englisch 2", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Englisch 2", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Englisch 2", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(eng2.this, db_name);
        List<Integer> list = db.getData("Englisch 2");
        eng2bar.setRating((float)list.get(0));
        eng2bar2.setRating((float)list.get(1));
        eng2bar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eng2button:
                if(eng2button.getText().toString().equals("Bewerten")){
                    eng2bar1.setVisibility(View.VISIBLE);
                    eng2bar3.setVisibility(View.VISIBLE);
                    eng2bar5.setVisibility(View.VISIBLE);
                    eng2button.setText("Speichern");
                } else if(eng2button.getText().toString().equals("Speichern"))
                {
                    eng2bar1.setVisibility(View.INVISIBLE);
                    eng2bar3.setVisibility(View.INVISIBLE);
                    eng2bar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    eng2button.setText("Bewerten");
                }
                break;
            case R.id.eng2nextButton:
                selected_Profeng2 = act_Prof17.getText().toString();
                if (selected_Profeng2.equals("Ruth Schenk")){
                    openSchenk();
                }if (selected_Profeng2.equals("Chanda Vanderhart")){
                    openVander();
            }
                break;
        }
    }
}


