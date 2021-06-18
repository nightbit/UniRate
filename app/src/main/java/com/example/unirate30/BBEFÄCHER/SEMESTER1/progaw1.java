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

public class progaw1 extends AppCompatActivity implements View.OnClickListener{

    Button progaw1button;
    RatingBar progaw1bar1,progaw1bar,progaw1bar4,progaw1bar5;
    RatingBar progaw1bar2;
    RatingBar progaw1bar3;
    String fachname= "progaw1";
    FachBewertDBHelper db;

    TextInputLayout til_Prof7;
    AutoCompleteTextView act_Prof7;

    ArrayList<String> ArrayList_Prof7;
    ArrayAdapter<String> ArrayAdapter_Prof7;

    ImageButton progaw1nextButton;
    String selected_Profprogaw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progaw1);



        progaw1bar = findViewById(R.id.progaw1ratingBar1);
        progaw1bar.setIsIndicator(true);
        progaw1bar1=findViewById(R.id.progaw1ratingBar2);
        progaw1bar1.setVisibility(View.INVISIBLE);
        progaw1bar2 = findViewById(R.id.progaw1ratingBar3);
        progaw1bar2.setIsIndicator(true);
        progaw1bar3 = findViewById(R.id.progaw1ratingBar4);
        progaw1bar3.setVisibility(View.INVISIBLE);
        progaw1bar4=findViewById(R.id.progaw1ratingBar5);
        progaw1bar4.setIsIndicator(true);
        progaw1bar5=findViewById(R.id.progaw1ratingBar6);
        progaw1bar5.setVisibility(View.INVISIBLE);

        til_Prof7 = (TextInputLayout) findViewById(R.id.til_Profprogaw1);
        act_Prof7 = (AutoCompleteTextView) findViewById(R.id.act_Profprogaw1);

        ArrayList_Prof7 = new ArrayList<>();
        ArrayList_Prof7.add("Phillipp Urbauer");
        ArrayList_Prof7.add("Matthias Frohner");
        ArrayList_Prof7.add("Johannes Martinek");

        ArrayAdapter_Prof7 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof7);
        act_Prof7.setAdapter(ArrayAdapter_Prof7);

        act_Prof7.setThreshold(1);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        progaw1button = findViewById(R.id.progaw1button);
        progaw1button.setOnClickListener(this);


        progaw1nextButton = findViewById(R.id.progaw1nextButton);
        progaw1nextButton.setOnClickListener(this);
    }

    public void openFrohner(){
        Intent frohner = new Intent(this, com.example.unirate30.PROFESSOR.frohner.class);
        startActivity(frohner);
    }
    public void openMartinek(){
        Intent martinek = new Intent(this, com.example.unirate30.PROFESSOR.martinek.class);
        startActivity(martinek);
    }
    public void openUrbauer(){
        Intent urbauer = new Intent(this, com.example.unirate30.PROFESSOR.urbauer.class);
        startActivity(urbauer);
    }



    public void update ()
    {


        db = new FachBewertDBHelper(progaw1.this,fachname);


        boolean wahr = db.updateData(fachname,
                Username.getUsername(),
                Math.round(progaw1bar1.getRating()),
                Math.round(progaw1bar3.getRating()),
                Math.round(progaw1bar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db = new FachBewertDBHelper(progaw1.this,fachname);
        boolean wahr = db.insertData(fachname,
                Username.getUsername(),
                (int) progaw1bar1.getRating(),
                (int) progaw1bar3.getRating(),
                (int) progaw1bar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences(fachname, MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean(fachname  , false)) {
            first = true;
            sharedPreferencesEditor.putBoolean(fachname, true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(progaw1.this,fachname);
        List<Integer> list = db.getData(fachname);
        progaw1bar.setRating((float)list.get(0));
        progaw1bar2.setRating((float)list.get(1));
        progaw1bar4.setRating((float)list.get(2));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.progaw1button:
                if(progaw1button.getText().toString().equals("Bewerten")){
                    progaw1bar1.setVisibility(View.VISIBLE);
                    progaw1bar3.setVisibility(View.VISIBLE);
                    progaw1bar5.setVisibility(View.VISIBLE);
                    progaw1button.setText("Speichern");
                } else if(progaw1button.getText().toString().equals("Speichern"))
                {
                    progaw1bar1.setVisibility(View.INVISIBLE);
                    progaw1bar3.setVisibility(View.INVISIBLE);
                    progaw1bar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    progaw1button.setText("Bewerten");
                }
                break;
            case R.id.progaw1nextButton:
                selected_Profprogaw1 = act_Prof7.getText().toString();
                if (selected_Profprogaw1.equals("Matthias Frohner")){
                    openFrohner();
                }if (selected_Profprogaw1.equals("Johannes Martinek")){
                openMartinek();
                }if (selected_Profprogaw1.equals("Phillipp Urbauer")) {
                  openUrbauer();
                }
                break;
        }
    }
}