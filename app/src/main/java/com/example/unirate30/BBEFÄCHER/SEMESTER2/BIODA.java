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

public class BIODA extends AppCompatActivity implements View.OnClickListener {

    Button biodabutton;
    RatingBar biodabar, biodabar1;
    RatingBar biodabar2, biodabar4;
    RatingBar biodabar3, biodabar5;
    FachBewertDBHelper db;
    String db_name = "bioda";

    TextInputLayout til_Prof15;
    AutoCompleteTextView act_Prof15;

    ArrayList<String> ArrayList_Prof15;
    ArrayAdapter<String> ArrayAdapter_Prof15;

    ImageButton biodanextButton;
    String selected_Profbioda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_i_o_d);

        db = new FachBewertDBHelper(BIODA.this, db_name);

        biodabar = findViewById(R.id.bioratingBar1);
        biodabar.setIsIndicator(true);
        biodabar1 =findViewById(R.id.bioratingBar2);
        biodabar1.setVisibility(View.INVISIBLE);
        biodabar2 = findViewById(R.id.bioratingBar3);
        biodabar2.setIsIndicator(true);
        biodabar3 = findViewById(R.id.bioratingBar4);
        biodabar3.setVisibility(View.INVISIBLE);
        biodabar4 =findViewById(R.id.bioratingBar5);
        biodabar4.setIsIndicator(true);
        biodabar5 =findViewById(R.id.bioratingBar6);
        biodabar5.setVisibility(View.INVISIBLE);

        til_Prof15 = (TextInputLayout) findViewById(R.id.til_Profbio);
        act_Prof15 = (AutoCompleteTextView) findViewById(R.id.act_Profbio);

        ArrayList_Prof15 = new ArrayList<>();
        ArrayList_Prof15.add("Johannes Martinek");
        ArrayList_Prof15.add("Richard Pasteka");
        ArrayList_Prof15.add("Agnes Scheibenreif");


        ArrayAdapter_Prof15 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof15);
        act_Prof15.setAdapter(ArrayAdapter_Prof15);

        act_Prof15.setThreshold(1);

        biodabutton = findViewById(R.id.biobutton);
        biodanextButton = findViewById(R.id.bionextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        biodanextButton.setOnClickListener((View.OnClickListener) this);
        biodabutton.setOnClickListener((View.OnClickListener) this);
    }
    public void openMartinek(){
        Intent martinek = new Intent(this, com.example.unirate30.PROFESSOR.martinek.class);
        startActivity(martinek);
    }
    public void openPasteka(){
        Intent pasteka = new Intent(this, com.example.unirate30.PROFESSOR.pasteka.class);
        startActivity(pasteka);
    }
    public void openScheiben(){
        Intent scheiben = new Intent(this, com.example.unirate30.PROFESSOR.scheiben.class);
        startActivity(scheiben);
    }


    public void update ()
    {


        db = new FachBewertDBHelper(BIODA.this, db_name);


        boolean wahr = db.updateData("BIODA",
                Username.getUsername(),
                Math.round(biodabar1.getRating()),
                Math.round(biodabar3.getRating()),
                Math.round(biodabar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(BIODA.this, db_name);
        boolean wahr = db.insertData("BIODA",
                Username.getUsername(),
                (int) biodabar1.getRating(),
                (int) biodabar3.getRating(),
                (int) biodabar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("BIODA", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("BIODA", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("BIODA", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(BIODA.this, db_name);
        List<Integer> list = db.getData("BIODA");
        biodabar.setRating((float)list.get(0));
        biodabar2.setRating((float)list.get(1));
        biodabar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.biobutton:
                if(biodabutton.getText().toString().equals("Bewerten")){
                    biodabar1.setVisibility(View.VISIBLE);
                    biodabar3.setVisibility(View.VISIBLE);
                    biodabar5.setVisibility(View.VISIBLE);
                    biodabutton.setText("Speichern");
                } else if(biodabutton.getText().toString().equals("Speichern"))
                {
                    biodabar1.setVisibility(View.INVISIBLE);
                    biodabar3.setVisibility(View.INVISIBLE);
                    biodabar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    biodabutton.setText("Bewerten");
                }
                break;
            case R.id.bionextButton:
                selected_Profbioda = act_Prof15.getText().toString();
                if (selected_Profbioda.equals("Johannes Martinek")){
                    openMartinek();
                }if (selected_Profbioda.equals("Richard Pasteka")){
                openPasteka();

                }if (selected_Profbioda.equals("Agnes Scheibenreif")){
                openScheiben();

                }
                break;
        }
    }
}

