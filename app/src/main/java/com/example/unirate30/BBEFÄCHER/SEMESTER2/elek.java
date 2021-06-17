package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.PROFESSOR.Sauer;
import com.example.unirate30.PROFESSOR.Votzi;
import com.example.unirate30.PROFESSOR.Windisch;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class elek extends AppCompatActivity implements View.OnClickListener {

    Button elekbutton;
    RatingBar elekbar, elekbar1;
    RatingBar elekbar2, elekbar4;
    RatingBar elekbar3, elekbar5;
    FachBewertDBHelper db;
    String db_name = "elek";

    TextInputLayout til_Prof16;
    AutoCompleteTextView act_Prof16;

    ArrayList<String> ArrayList_Prof16;
    ArrayAdapter<String> ArrayAdapter_Prof16;

    ImageButton eleknextButton;
    String selected_Profelek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elek);

        db = new FachBewertDBHelper(elek.this, db_name);

        elekbar = findViewById(R.id.elekratingBar1);
        elekbar.setIsIndicator(true);
        elekbar1 =findViewById(R.id.elekratingBar2);
        elekbar1.setVisibility(View.INVISIBLE);
        elekbar2 = findViewById(R.id.elekratingBar3);
        elekbar2.setIsIndicator(true);
        elekbar3 = findViewById(R.id.elekratingBar4);
        elekbar3.setVisibility(View.INVISIBLE);
        elekbar4 =findViewById(R.id.elekratingBar5);
        elekbar4.setIsIndicator(true);
        elekbar5 =findViewById(R.id.elekratingBar6);
        elekbar5.setVisibility(View.INVISIBLE);

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
        eleknextButton = findViewById(R.id.eleknextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        eleknextButton.setOnClickListener((View.OnClickListener) this);
        elekbutton.setOnClickListener((View.OnClickListener) this);
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

    public void update ()
    {


        db = new FachBewertDBHelper(elek.this, db_name);


        boolean wahr = db.updateData("elek",
                Username.getUsername(),
                Math.round(elekbar1.getRating()),
                Math.round(elekbar3.getRating()),
                Math.round(elekbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(elek.this, db_name);
        boolean wahr = db.insertData("elek",
                Username.getUsername(),
                (int) elekbar1.getRating(),
                (int) elekbar3.getRating(),
                (int) elekbar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("elek", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("elek", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("elek", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(elek.this, db_name);
        List<Integer> list = db.getData("elek");
        elekbar.setRating((float)list.get(0));
        elekbar2.setRating((float)list.get(1));
        elekbar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.elekbutton:
                if(elekbutton.getText().toString().equals("Bewerten")){
                    elekbar1.setVisibility(View.VISIBLE);
                    elekbar3.setVisibility(View.VISIBLE);
                    elekbar5.setVisibility(View.VISIBLE);
                    elekbutton.setText("Speichern");
                } else if(elekbutton.getText().toString().equals("Speichern"))
                {
                    elekbar1.setVisibility(View.INVISIBLE);
                    elekbar3.setVisibility(View.INVISIBLE);
                    elekbar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    elekbutton.setText("Bewerten");
                }
                break;
            case R.id.eleknextButton:
                selected_Profelek = act_Prof16.getText().toString();
                if (selected_Profelek.equals("Stefan Sauermann")){
                    openSauer();
                }if (selected_Profelek.equals("Helmut Votzi")){
                openVotzi();
            }if (selected_Profelek.equals("Michael Windisch")){
                openWindisch();
            }
                break;
        }
    }
}
