package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.annotation.SuppressLint;
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

public class kreko extends AppCompatActivity implements View.OnClickListener {

    Button krekobutton;
    RatingBar krekobar, krekobar1;
    RatingBar krekobar2, krekobar4;
    RatingBar krekobar3, krekobar5;
    FachBewertDBHelper db;

    TextInputLayout til_Prof9kreko;
    AutoCompleteTextView act_Prof9kreko;

    ArrayList<String> ArrayList_Prof9kreko;
    ArrayAdapter<String> ArrayAdapter_Prof9kreko;

    ImageButton krekonextButton;
    String selected_Profkreko;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kreko);

        db = new FachBewertDBHelper(kreko.this);
        krekobar = findViewById(R.id.krekoratingBar1);
        krekobar.setIsIndicator(true);
        krekobar1 =findViewById(R.id.krekoratingBar2);
        krekobar1.setVisibility(View.INVISIBLE);
        krekobar2 = findViewById(R.id.krekoratingBar3);
        krekobar2.setIsIndicator(true);
        krekobar3 = findViewById(R.id.krekoratingBar4);
        krekobar3.setVisibility(View.INVISIBLE);
        krekobar4 =findViewById(R.id.krekoratingBar5);
        krekobar4.setIsIndicator(true);
        krekobar5 =findViewById(R.id.krekoratingBar6);
        krekobar5.setVisibility(View.INVISIBLE);


        til_Prof9kreko = (TextInputLayout) findViewById(R.id.til_Prof9kreko);
        act_Prof9kreko = (AutoCompleteTextView) findViewById(R.id.act_Prof9kreko);

        ArrayList_Prof9kreko = new ArrayList<>();
        ArrayList_Prof9kreko.add("Michael Wekerle-Dreier");


        ArrayAdapter_Prof9kreko = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof9kreko);
        act_Prof9kreko.setAdapter(ArrayAdapter_Prof9kreko);

        act_Prof9kreko.setThreshold(1);

        krekobutton = findViewById(R.id.krekobutton6);
        krekonextButton = findViewById(R.id.krekonextButton12);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        krekonextButton.setOnClickListener((View.OnClickListener) this);
        krekobutton.setOnClickListener((View.OnClickListener) this);
    }
        public void opendreiner() {
            Intent Dreiner = new Intent(this, com.example.unirate30.PROFESSOR.dreiner.class);
            startActivity(Dreiner);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(kreko.this);


        boolean wahr = db.updateData("Kreativität und Komplexität",
                Username.getUsername(),
                Math.round(krekobar1.getRating()),
                Math.round(krekobar3.getRating()),
                Math.round(krekobar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(kreko.this);
        boolean wahr = db.insertData("Kreativität und Komplexität",
                Username.getUsername(),
                (int) krekobar1.getRating(),
                (int) krekobar3.getRating(),
                (int) krekobar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("Kreativität und Komplexität", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Kreativität und Komplexität", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Kreativität und Komplexität", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(kreko.this);
        List<Integer> list = db.getData("Kreativität und Komplexität");
        krekobar.setRating((float)list.get(0));
        krekobar2.setRating((float)list.get(1));
        krekobar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.krekobutton6:
                if(krekobutton.getText().toString().equals("Bewerten")){
                    krekobar1.setVisibility(View.VISIBLE);
                    krekobar3.setVisibility(View.VISIBLE);
                    krekobar5.setVisibility(View.VISIBLE);
                    krekobutton.setText("Speichern");
                } else if(krekobutton.getText().toString().equals("Speichern"))
                {
                    krekobar1.setVisibility(View.INVISIBLE);
                    krekobar3.setVisibility(View.INVISIBLE);
                    krekobar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    krekobutton.setText("Bewerten");
                }
                break;
            case R.id.krekonextButton12:
                selected_Profkreko = act_Prof9kreko.getText().toString();
                if (selected_Profkreko.equals("Michael Wekerle-Dreier")){
                    opendreiner();
                }
                break;
        }
    }
}

