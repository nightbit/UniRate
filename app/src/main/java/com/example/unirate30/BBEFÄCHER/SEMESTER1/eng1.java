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

public class eng1 extends AppCompatActivity implements View.OnClickListener {

    Button eng1button;
    RatingBar eng1bar1;
    RatingBar eng1bar2;
    RatingBar eng1bar3;
    RatingBar eng1bar4;
    RatingBar eng1bar5;
    RatingBar eng1bar6;
    FachBewertDBHelper db;

    TextInputLayout til_Prof8;
    AutoCompleteTextView act_Prof8;

    ArrayList<String> ArrayList_Prof8;
    ArrayAdapter<String> ArrayAdapter_Prof8;

    ImageButton eng1nextButton;
    String selected_Profeng1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng1);
        db = new FachBewertDBHelper(eng1.this);


        eng1bar1 = findViewById(R.id.eng1ratingBar2);
        eng1bar1.setVisibility(View.INVISIBLE);
        eng1bar2 = findViewById(R.id.eng1ratingBar4);
        eng1bar2.setVisibility(View.INVISIBLE);
        eng1bar3 = findViewById(R.id.eng1ratingBar6);
        eng1bar3.setVisibility(View.INVISIBLE);
        eng1bar4 = findViewById(R.id.eng1ratingBar1);
        eng1bar4.setIsIndicator(true);
        eng1bar5 = findViewById(R.id.eng1ratingBar3);
        eng1bar5.setIsIndicator(true);
        eng1bar6 = findViewById(R.id.eng1ratingBar5);
        eng1bar6.setIsIndicator(true);

        til_Prof8 = (TextInputLayout) findViewById(R.id.til_Profeng1);
        act_Prof8 = (AutoCompleteTextView) findViewById(R.id.act_Profeng1);

        ArrayList_Prof8 = new ArrayList<>();
        ArrayList_Prof8.add("Patricia Chan Stephenson");


        ArrayAdapter_Prof8 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof8);
        act_Prof8.setAdapter(ArrayAdapter_Prof8);

        act_Prof8.setThreshold(1);

        eng1button = findViewById(R.id.eng1button);



        eng1nextButton = findViewById(R.id.eng1nextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        eng1nextButton.setOnClickListener((View.OnClickListener) this);
        eng1button.setOnClickListener((View.OnClickListener) this);
    }

    public void openPatricia(){
        Intent patricia = new Intent(this, com.example.unirate30.PROFESSOR.patricia.class);
        startActivity(patricia);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(eng1.this);


        boolean wahr = db.updateData("eng1",
                Username.getUsername(),
                Math.round(eng1bar1.getRating()),
                Math.round(eng1bar2.getRating()),
                Math.round(eng1bar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(eng1.this);
        boolean wahr = db.insertData("eng1",
                Username.getUsername(),
                (int) eng1bar1.getRating(),
                (int) eng1bar2.getRating(),
                (int) eng1bar3.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("eng1", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("eng1", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("eng1", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(eng1.this);
        List<Integer> list = db.getData("eng1");
        eng1bar4.setRating((float)list.get(0));
        eng1bar5.setRating((float)list.get(1));
        eng1bar6.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.eng1button:ton:
            if(eng1button.getText().toString().equals("Bewerten")){
                eng1bar1.setVisibility(View.VISIBLE);
                eng1bar2.setVisibility(View.VISIBLE);
                eng1bar3.setVisibility(View.VISIBLE);
                eng1button.setText("Speichern");
            } else if(eng1button.getText().toString().equals("Speichern"))
            {
                eng1bar1.setVisibility(View.INVISIBLE);
                eng1bar2.setVisibility(View.INVISIBLE);
                eng1bar3.setVisibility(View.INVISIBLE);

                update();
                AddData();

                ergebnisse();
                eng1button.setText("Bewerten");
            }
                break;
            case R.id.eng1nextButton:
                selected_Profeng1 = act_Prof8.getText().toString();
                if (selected_Profeng1.equals("Patricia Chan Stephenson")){
                    openPatricia();
                }
                break;
        }
    }

}