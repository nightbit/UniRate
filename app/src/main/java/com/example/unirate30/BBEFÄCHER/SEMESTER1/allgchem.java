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

public class allgchem extends AppCompatActivity implements View.OnClickListener {

    Button allgbutton20;
    RatingBar allgbar1;
    RatingBar allgbar2;
    RatingBar allgbar3;
    RatingBar allgbar4;
    RatingBar allgbar5;
    RatingBar allgbar6;
    FachBewertDBHelper db;
    String db_name="allgchem";

    TextInputLayout til_Prof1;
    AutoCompleteTextView act_Prof1;

    ArrayList<String> ArrayList_Prof1;
    ArrayAdapter<String> ArrayAdapter_Prof1;

    ImageButton allgnextButton12;
    String selected_Profallg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgchem);
        db = new FachBewertDBHelper(allgchem.this,db_name);

        allgbar1 = findViewById(R.id.allgchemratingBar2);
        allgbar1.setVisibility(View.INVISIBLE);
        allgbar2 = findViewById(R.id.allgchemratingBar4);
        allgbar2.setVisibility(View.INVISIBLE);
        allgbar3 = findViewById(R.id.allgchemratingBar6);
        allgbar3.setVisibility(View.INVISIBLE);
        allgbar4 = findViewById(R.id.allgchemratingBar1);
        allgbar4.setIsIndicator(true);
        allgbar5 = findViewById(R.id.allgchemratingBar3);
        allgbar5.setIsIndicator(true);
        allgbar6 = findViewById(R.id.allgchemratingBar5);
        allgbar6.setIsIndicator(true);

        til_Prof1 = (TextInputLayout) findViewById(R.id.til_Prof9allg);
        act_Prof1 = (AutoCompleteTextView) findViewById(R.id.act_Prof9allg);

        ArrayList_Prof1 = new ArrayList<>();
        ArrayList_Prof1.add("Barbara Gepp");
        ArrayList_Prof1.add("Katharina Wiessner");

        ArrayAdapter_Prof1 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof1);
        act_Prof1.setAdapter(ArrayAdapter_Prof1);

        act_Prof1.setThreshold(1);

        allgbutton20 = findViewById(R.id.allgbutton6);



        allgnextButton12 = findViewById(R.id.allgnextButton12);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        allgnextButton12.setOnClickListener((View.OnClickListener) this);
        allgbutton20.setOnClickListener((View.OnClickListener) this);
    }

    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openWiessner() {
        Intent Wiessner = new Intent(this, com.example.unirate30.PROFESSOR.Wiessner.class);
        startActivity(Wiessner);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(allgchem.this,db_name);


        boolean wahr = db.updateData("allgchem",
                Username.getUsername(),
                Math.round(allgbar1.getRating()),
                Math.round(allgbar2.getRating()),
                Math.round(allgbar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(allgchem.this,db_name);
        boolean wahr = db.insertData("allgchem",
                Username.getUsername(),
                (int) allgbar1.getRating(),
                (int) allgbar2.getRating(),
                (int) allgbar3.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("allgchem", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("allgchem", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("allgchem", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(allgchem.this,db_name);
        List<Integer> list = db.getData("allgchem");
        allgbar4.setRating((float)list.get(0));
        allgbar5.setRating((float)list.get(1));
        allgbar6.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.allgbutton6:ton:
                if(allgbutton20.getText().toString().equals("Bewerten")){
                    allgbar1.setVisibility(View.VISIBLE);
                    allgbar2.setVisibility(View.VISIBLE);
                    allgbar3.setVisibility(View.VISIBLE);
                    allgbutton20.setText("Speichern");
                } else if(allgbutton20.getText().toString().equals("Speichern"))
                {
                    allgbar1.setVisibility(View.INVISIBLE);
                    allgbar2.setVisibility(View.INVISIBLE);
                    allgbar3.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    allgbutton20.setText("Bewerten");
                }
                break;
            case R.id.allgnextButton12:
                selected_Profallg = act_Prof1.getText().toString();
                if (selected_Profallg.equals("Katharina Wiessner")){
                    openWiessner();
                } if (selected_Profallg.equals("Barbara Gepp")){
                openGepp();
            }
                break;
        }
    }

}