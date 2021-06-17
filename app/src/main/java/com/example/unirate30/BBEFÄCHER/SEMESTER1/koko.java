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

public class koko extends AppCompatActivity implements View.OnClickListener {

    Button kokobutton;
    RatingBar kokobar1;
    RatingBar kokobar2;
    RatingBar kokobar3;
    RatingBar kokobar4;
    RatingBar kokobar5;
    RatingBar kokobar6;
    FachBewertDBHelper db;
    String db_name="koko";

    TextInputLayout til_Prof9;
    AutoCompleteTextView act_Prof9;

    ArrayList<String> ArrayList_Prof9;
    ArrayAdapter<String> ArrayAdapter_Prof9;

    ImageButton kokonextButton;
    String kokoselected_Prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koko);
        db = new FachBewertDBHelper(koko.this,db_name);

        kokobar1 = findViewById(R.id.kokoratingBar2);
        kokobar1.setVisibility(View.INVISIBLE);
        kokobar2 = findViewById(R.id.kokoratingBar4);
        kokobar2.setVisibility(View.INVISIBLE);
        kokobar3 = findViewById(R.id.kokoratingBar6);
        kokobar3.setVisibility(View.INVISIBLE);
        kokobar4 = findViewById(R.id.kokoratingBar1);
        kokobar4.setIsIndicator(true);
        kokobar5 = findViewById(R.id.kokoratingBar3);
        kokobar5.setIsIndicator(true);
        kokobar6 = findViewById(R.id.kokoratingBar5);
        kokobar6.setIsIndicator(true);

        til_Prof9 = (TextInputLayout) findViewById(R.id.til_Prof9);
        act_Prof9 = (AutoCompleteTextView) findViewById(R.id.act_Prof9);

        ArrayList_Prof9 = new ArrayList<>();
        ArrayList_Prof9.add("Christian Brabetz");

        ArrayAdapter_Prof9 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof9);
        act_Prof9.setAdapter(ArrayAdapter_Prof9);

        act_Prof9.setThreshold(1);

        kokobutton = findViewById(R.id.kokobutton6);

        kokonextButton = findViewById(R.id.nextButton12);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        kokonextButton.setOnClickListener((View.OnClickListener) this);
        kokobutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openBrabetz(){
        Intent brabetz = new Intent(this, com.example.unirate30.PROFESSOR.brabetz.class);
        startActivity(brabetz);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(koko.this,db_name);


        boolean wahr = db.updateData("koko",
                Username.getUsername(),
                Math.round(kokobar1.getRating()),
                Math.round(kokobar2.getRating()),
                Math.round(kokobar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(koko.this,db_name);
        boolean wahr = db.insertData("koko",
                Username.getUsername(),
                (int) kokobar1.getRating(),
                (int) kokobar2.getRating(),
                (int) kokobar3.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("koko", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("koko", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("koko", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(koko.this,db_name);
        List<Integer> list = db.getData("koko");
        kokobar4.setRating((float)list.get(0));
        kokobar5.setRating((float)list.get(1));
        kokobar6.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.kokobutton6:ton:
            if(kokobutton.getText().toString().equals("Bewerten")){
                kokobar1.setVisibility(View.VISIBLE);
                kokobar2.setVisibility(View.VISIBLE);
                kokobar3.setVisibility(View.VISIBLE);
                kokobutton.setText("Speichern");
            } else if(kokobutton.getText().toString().equals("Speichern"))
            {
                kokobar1.setVisibility(View.INVISIBLE);
                kokobar2.setVisibility(View.INVISIBLE);
                kokobar3.setVisibility(View.INVISIBLE);

                update();
                AddData();

                ergebnisse();
                kokobutton.setText("Bewerten");
            }
                break;
            case R.id.nextButton12:
                kokoselected_Prof = act_Prof9.getText().toString();
                if (kokoselected_Prof.equals("Christian Brabetz")){
                    openBrabetz();
                }
                break;
        }
    }
}
