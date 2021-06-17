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

public class MedPR extends AppCompatActivity implements View.OnClickListener{

    Button medprbutton;
    RatingBar medprbar, medprbar1;
    RatingBar medprbar2, medprbar4;
    RatingBar medprbar3, medprbar5;
    FachBewertDBHelper db;

    TextInputLayout til_Profmed;
    AutoCompleteTextView act_Profmed;

    ArrayList<String> ArrayList_Profmed;
    ArrayAdapter<String> ArrayAdapter_Profmed;

    ImageButton medprnextButton;
    String selected_Profmedpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_p_r);

        db = new FachBewertDBHelper(MedPR.this);

        medprbar = findViewById(R.id.medratingBar1);
        medprbar.setIsIndicator(true);
        medprbar1 =findViewById(R.id.medratingBar2);
        medprbar1.setVisibility(View.INVISIBLE);
        medprbar2 = findViewById(R.id.medratingBar3);
        medprbar2.setIsIndicator(true);
        medprbar3 = findViewById(R.id.medratingBar4);
        medprbar3.setVisibility(View.INVISIBLE);
        medprbar4 =findViewById(R.id.medratingBar5);
        medprbar4.setIsIndicator(true);
        medprbar5 =findViewById(R.id.medratingBar6);
        medprbar5.setVisibility(View.INVISIBLE);

        til_Profmed = (TextInputLayout) findViewById(R.id.til_Profmed);
        act_Profmed = (AutoCompleteTextView) findViewById(R.id.act_Profmed);

        ArrayList_Profmed = new ArrayList<>();
        ArrayList_Profmed.add("Johannes Martinek");
        ArrayList_Profmed.add("Matthias Scherer");
        ArrayList_Profmed.add("Philipp Urbauer");

        ArrayAdapter_Profmed = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Profmed);
        act_Profmed.setAdapter(ArrayAdapter_Profmed);

        act_Profmed.setThreshold(1);

        medprbutton = findViewById(R.id.medbutton);
        medprnextButton = findViewById(R.id.mednextButton);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        medprnextButton.setOnClickListener((View.OnClickListener) this);
        medprbutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openScherer(){
        Intent scherer = new Intent(this, com.example.unirate30.PROFESSOR.Scherer.class);
        startActivity(scherer);
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


        db = new FachBewertDBHelper(MedPR.this);


        boolean wahr = db.updateData("Medizininformatisched Projekt",
                Username.getUsername(),
                Math.round(medprbar1.getRating()),
                Math.round(medprbar3.getRating()),
                Math.round(medprbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(MedPR.this);
        boolean wahr = db.insertData("Medizininformatisched Projekt",
                Username.getUsername(),
                (int) medprbar1.getRating(),
                (int) medprbar3.getRating(),
                (int) medprbar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("Medizininformatisched Projekt", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Medizininformatisched Projekt", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Medizininformatisched Projekt", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(MedPR.this);
        List<Integer> list = db.getData("Medizininformatisched Projekt");
        medprbar.setRating((float)list.get(0));
        medprbar2.setRating((float)list.get(1));
        medprbar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.medbutton:
                if(medprbutton.getText().toString().equals("Bewerten")){
                    medprbar1.setVisibility(View.VISIBLE);
                    medprbar3.setVisibility(View.VISIBLE);
                    medprbar5.setVisibility(View.VISIBLE);
                    medprbutton.setText("Speichern");
                } else if(medprbutton.getText().toString().equals("Speichern"))
                {
                    medprbar1.setVisibility(View.INVISIBLE);
                    medprbar3.setVisibility(View.INVISIBLE);
                    medprbar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    medprbutton.setText("Bewerten");
                }
                break;
            case R.id.mednextButton:
                selected_Profmedpr = act_Profmed.getText().toString();
                if (selected_Profmedpr.equals("Johannes Martinek")){
                    openScherer();
                }if (selected_Profmedpr.equals("Matthias Scherer")){
                    openMartinek();
                } if (selected_Profmedpr.equals("Philipp Urbauer")) {
                    openUrbauer();
            }
                break;
        }
    }
}
