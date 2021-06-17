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

public class etbio extends AppCompatActivity implements View.OnClickListener {

    Button etbiobutton;
    RatingBar etbiobar, etbiobar1;
    RatingBar etbiobar2, etbiobar4;
    RatingBar etbiobar3, etbiobar5;
    FachBewertDBHelper db;
    TextInputLayout til_Prof19;
    AutoCompleteTextView act_Prof19;
    String db_name="etbio";

    ArrayList<String> ArrayList_Prof19;
    ArrayAdapter<String> ArrayAdapter_Prof19;

    ImageButton etbionextButton;
    String selected_Profetbio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etbio);

        db = new FachBewertDBHelper(etbio.this,db_name);
        etbiobar = findViewById(R.id.etbioratingBar1);
        etbiobar.setIsIndicator(true);
        etbiobar1 =findViewById(R.id.etbioratingBar2);
        etbiobar1.setVisibility(View.INVISIBLE);
        etbiobar2 = findViewById(R.id.etbioratingBar3);
        etbiobar2.setIsIndicator(true);
        etbiobar3 = findViewById(R.id.etbioratingBar4);
        etbiobar3.setVisibility(View.INVISIBLE);
        etbiobar4 =findViewById(R.id.etbioratingBar5);
        etbiobar4.setIsIndicator(true);
        etbiobar5 =findViewById(R.id.etbioratingBar6);
        etbiobar5.setVisibility(View.INVISIBLE);

        til_Prof19 = (TextInputLayout) findViewById(R.id.til_Profetbio);
        act_Prof19 = (AutoCompleteTextView) findViewById(R.id.act_Profetbio);

        ArrayList_Prof19 = new ArrayList<>();
        ArrayList_Prof19.add("Andreas Drauschke");
        ArrayList_Prof19.add("Floarian Enghuber");
        ArrayList_Prof19.add("Karl Knoebl");
        ArrayList_Prof19.add("Joao Pedro Santos da Costa");

        ArrayAdapter_Prof19 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof19);
        act_Prof19.setAdapter(ArrayAdapter_Prof19);

        act_Prof19.setThreshold(1);

        etbiobutton = findViewById(R.id.etbiobutton);
        etbionextButton = findViewById(R.id.etbionextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        etbionextButton.setOnClickListener((View.OnClickListener) this);
        etbiobutton.setOnClickListener((View.OnClickListener) this);
    }
        public void openDrausch(){
            Intent Drausch = new Intent(this, com.example.unirate30.PROFESSOR.Drausch.class);
            startActivity(Drausch);
        }
        public void openEnghuber(){
            Intent Enghuber = new Intent(this, com.example.unirate30.PROFESSOR.Enghuber.class);
            startActivity(Enghuber);
        }
        public void openKnoebl(){
            Intent Knoebl = new Intent(this, com.example.unirate30.PROFESSOR.Knoebl.class);
            startActivity(Knoebl);
        }
        public void openCosta(){
            Intent Costa = new Intent(this, com.example.unirate30.PROFESSOR.Costa.class);
            startActivity(Costa);
        }

    public void update ()
    {


        db = new FachBewertDBHelper(etbio.this,db_name);


        boolean wahr = db.updateData("Elektronik in der biomedizinischen Technik",
                Username.getUsername(),
                Math.round(etbiobar1.getRating()),
                Math.round(etbiobar3.getRating()),
                Math.round(etbiobar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(etbio.this,db_name);
        boolean wahr = db.insertData("Elektronik in der biomedizinischen Technik",
                Username.getUsername(),
                (int) etbiobar1.getRating(),
                (int) etbiobar3.getRating(),
                (int) etbiobar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("etbio", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("etbio", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("etbio", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(etbio.this,db_name);
        List<Integer> list = db.getData("Elektronik in der biomedizinischen Technik");
        etbiobar.setRating((float)list.get(0));
        etbiobar2.setRating((float)list.get(1));
        etbiobar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.etbiobutton:
                if(etbiobutton.getText().toString().equals("Bewerten")){
                    etbiobar1.setVisibility(View.VISIBLE);
                    etbiobar3.setVisibility(View.VISIBLE);
                    etbiobar5.setVisibility(View.VISIBLE);
                    etbiobutton.setText("Speichern");
                } else if(etbiobutton.getText().toString().equals("Speichern"))
                {
                    etbiobar1.setVisibility(View.INVISIBLE);
                    etbiobar3.setVisibility(View.INVISIBLE);
                    etbiobar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    etbiobutton.setText("Bewerten");
                }
                break;
            case R.id.etbionextButton:
                selected_Profetbio = act_Prof19.getText().toString();
                if (selected_Profetbio.equals("Andreas Drauschke")){
                    openDrausch();
                }if (selected_Profetbio.equals("Floarian Enghuber")){
                openEnghuber();
                } if (selected_Profetbio.equals("Karl Knoebl")) {
                openKnoebl();
                }if (selected_Profetbio.equals("Joao Pedro Santos da Costa")) {
                openCosta();
            }
                break;
        }
    }
}
