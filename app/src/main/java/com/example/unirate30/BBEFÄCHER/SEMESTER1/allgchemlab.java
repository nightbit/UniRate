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

public class allgchemlab extends AppCompatActivity implements View.OnClickListener {

    Button allglabbutton;
    RatingBar allglabbar1;
    RatingBar allglabbar2;
    RatingBar allglabbar3;
    RatingBar allglabbar4;
    RatingBar allglabbar5;
    RatingBar allglabbar6;
    FachBewertDBHelper db;

    TextInputLayout til_Prof2;
    AutoCompleteTextView act_Prof2;

    ArrayList<String> ArrayList_Prof2;
    ArrayAdapter<String> ArrayAdapter_Prof2;

    ImageButton allglabnextButton;
    String selected_Profallglab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgchemlab);
        db = new FachBewertDBHelper(allgchemlab.this);

        allglabbar1 = findViewById(R.id.allglabratingBar2);
        allglabbar1.setVisibility(View.INVISIBLE);
        allglabbar2 = findViewById(R.id.allglabratingBar4);
        allglabbar2.setVisibility(View.INVISIBLE);
        allglabbar3 = findViewById(R.id.allglabratingBar6);
        allglabbar3.setVisibility(View.INVISIBLE);
        allglabbar4 = findViewById(R.id.allglabratingBar1);
        allglabbar4.setIsIndicator(true);
        allglabbar5 = findViewById(R.id.allglabratingBar3);
        allglabbar5.setIsIndicator(true);
        allglabbar6 = findViewById(R.id.allglabratingBar5);
        allglabbar6.setIsIndicator(true);

        til_Prof2 = (TextInputLayout) findViewById(R.id.til_Profallglab);
        act_Prof2 = (AutoCompleteTextView) findViewById(R.id.act_Profallglab);

        ArrayList_Prof2 = new ArrayList<>();
        ArrayList_Prof2.add("Barbara Gepp");
        ArrayList_Prof2.add("Katharina Wiessner");
        ArrayList_Prof2.add("Thomas Machacek");
        ArrayList_Prof2.add("Elisabeth Simboeck");
        ArrayList_Prof2.add("Ursula Knaack");

        ArrayAdapter_Prof2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof2);
        act_Prof2.setAdapter(ArrayAdapter_Prof2);

        act_Prof2.setThreshold(1);

        allglabbutton = findViewById(R.id.allglabbutton);



        allglabnextButton = findViewById(R.id.allglabnextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        allglabnextButton.setOnClickListener((View.OnClickListener) this);
        allglabbutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openWiessner() {
        Intent Wiessner = new Intent(this, com.example.unirate30.PROFESSOR.Wiessner.class);
        startActivity(Wiessner);
    }
    public void openMachacek() {
        Intent Machacek = new Intent(this, com.example.unirate30.PROFESSOR.Machacek.class);
        startActivity(Machacek);
    }
    public void openKnaack() {
        Intent Knaack = new Intent(this, com.example.unirate30.PROFESSOR.Knaack.class);
        startActivity(Knaack);
    }
    public void openSimboeck() {
        Intent Simboeck = new Intent(this, com.example.unirate30.PROFESSOR.Simboeck.class);
        startActivity(Simboeck);
    }

    public void update ()
    {
        db = new FachBewertDBHelper(allgchemlab.this);

        boolean wahr = db.updateData("allgchemlab",
                Username.getUsername(),
                Math.round(allglabbar1.getRating()),
                Math.round(allglabbar2.getRating()),
                Math.round(allglabbar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(allgchemlab.this);
        boolean wahr = db.insertData("allgchemlab",
                Username.getUsername(),
                (int) allglabbar1.getRating(),
                (int) allglabbar2.getRating(),
                (int) allglabbar3.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("allgchemlab", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("allgchemlab", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("allgchemlab", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(allgchemlab.this);
        List<Integer> list = db.getData("allgchemlab");
        allglabbar4.setRating((float)list.get(0));
        allglabbar5.setRating((float)list.get(1));
        allglabbar6.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.allglabbutton:
            if(allglabbutton.getText().toString().equals("Bewerten")){
                allglabbar1.setVisibility(View.VISIBLE);
                allglabbar2.setVisibility(View.VISIBLE);
                allglabbar3.setVisibility(View.VISIBLE);
                allglabbutton.setText("Speichern");
            } else if(allglabbutton.getText().toString().equals("Speichern"))
            {
                allglabbar1.setVisibility(View.INVISIBLE);
                allglabbar2.setVisibility(View.INVISIBLE);
                allglabbar3.setVisibility(View.INVISIBLE);

                update();
                AddData();

                ergebnisse();
                allglabbutton.setText("Bewerten");
            }
                break;
            case R.id.allglabnextButton:
                selected_Profallglab = act_Prof2.getText().toString();
                if (selected_Profallglab.equals("Katharina Wiessner")){
                    openWiessner();
                } if (selected_Profallglab.equals("Barbara Gepp")){
                openGepp();
            }  if (selected_Profallglab.equals("Thomas Machacek")){
                openMachacek();
            } if (selected_Profallglab.equals("Ursula Knaack")){
                openKnaack();
            }if (selected_Profallglab.equals("Elisabeth Simboeck")){
                openSimboeck();
            }
                break;
        }
    }

}
