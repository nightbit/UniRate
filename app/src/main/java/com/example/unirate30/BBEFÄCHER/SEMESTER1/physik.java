package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.PROFESSOR.maierhofer;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class physik extends AppCompatActivity implements View.OnClickListener {

    Button phbutton;
    RatingBar phbar1,phbar4,phbar5,phbar6;
    RatingBar phbar2;
    RatingBar phbar3;

    String fachname= "physik";
    FachBewertDBHelper db;

    TextInputLayout til_Prof10;
    AutoCompleteTextView act_Prof10;

    ArrayList<String> ArrayList_Prof10;
    ArrayAdapter<String> ArrayAdapter_Prof10;

    ImageButton phnextButton;
    String selected_Profphysik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physik);

        phbar1 = findViewById(R.id.phratingBar2);
        phbar1.setVisibility(View.INVISIBLE);
        phbar2 = findViewById(R.id.phratingBar4);
        phbar2.setVisibility(View.INVISIBLE);
        phbar3 = findViewById(R.id.phratingBar6);
        phbar3.setVisibility(View.INVISIBLE);
        phbar4 = findViewById(R.id.phratingBar1);
        phbar4.setIsIndicator(true);
        phbar5 = findViewById(R.id.phratingBar3);
        phbar5.setIsIndicator(true);
        phbar6 = findViewById(R.id.phratingBar5);
        phbar6.setIsIndicator(true);

        til_Prof10 = (TextInputLayout) findViewById(R.id.til_Profph);
        act_Prof10 = (AutoCompleteTextView) findViewById(R.id.act_Profph);

        ArrayList_Prof10 = new ArrayList<>();
        ArrayList_Prof10.add("Lukas Mairhofer");

        ArrayAdapter_Prof10 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof10);
        act_Prof10.setAdapter(ArrayAdapter_Prof10);

        act_Prof10.setThreshold(1);

        phbutton = findViewById(R.id.phbutton);
        phbutton.setOnClickListener(this);

        phnextButton = findViewById(R.id.phnextButton);
        phnextButton.setOnClickListener(this);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
    }


    public void openMaierhofer(){
        Intent maierhofer = new Intent(this, com.example.unirate30.PROFESSOR.maierhofer.class);
        startActivity(maierhofer);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(physik.this);


        boolean wahr = db.updateData(fachname,
                Username.getUsername(),
                Math.round(phbar1.getRating()),
                Math.round(phbar2.getRating()),
                Math.round(phbar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db = new FachBewertDBHelper(physik.this);
        boolean wahr = db.insertData(fachname,
                Username.getUsername(),
                (int) phbar1.getRating(),
                (int) phbar2.getRating(),
                (int) phbar3.getRating()

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
        db =  new FachBewertDBHelper(physik.this);
        List<Integer> list = db.getData(fachname);
        phbar4.setRating((float)list.get(0));
        phbar5.setRating((float)list.get(1));
        phbar6.setRating((float)list.get(2));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phbutton:
                if(phbutton.getText().toString().equals("Bewerten")){
                    phbar1.setVisibility(View.VISIBLE);
                    phbar2.setVisibility(View.VISIBLE);
                    phbar3.setVisibility(View.VISIBLE);
                    phbutton.setText("Speichern");
                } else if(phbutton.getText().toString().equals("Speichern"))
                {
                    phbar1.setVisibility(View.INVISIBLE);
                    phbar2.setVisibility(View.INVISIBLE);
                    phbar3.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    phbutton.setText("Bewerten");
                }
                break;
            case R.id.phnextButton:
                selected_Profphysik = act_Prof10.getText().toString();
                if (selected_Profphysik.equals("Lukas Mairhofer")){
                    openMaierhofer();
                }
                break;
        }
    }
}