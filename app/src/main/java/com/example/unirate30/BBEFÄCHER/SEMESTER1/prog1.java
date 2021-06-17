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

public class prog1 extends AppCompatActivity implements View.OnClickListener{

    Button prog1button;
    RatingBar prog1bar1,prog1bar4,prog1bar5,prog1bar6;
    RatingBar prog1bar2;
    RatingBar prog1bar3;
    String fachname= "progaw1";
    FachBewertDBHelper db;

    TextInputLayout til_Prof6;
    AutoCompleteTextView act_Prof6;

    ArrayList<String> ArrayList_Prof6;
    ArrayAdapter<String> ArrayAdapter_Prof6;

    ImageButton prog1nextButton;
    String selected_Profprog1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog1);

        prog1bar1 = findViewById(R.id.prog1ratingBar2);
        prog1bar1.setVisibility(View.INVISIBLE);
        prog1bar2 = findViewById(R.id.prog1ratingBar4);
        prog1bar2.setVisibility(View.INVISIBLE);
        prog1bar3 = findViewById(R.id.prog1ratingBar6);
        prog1bar3.setVisibility(View.INVISIBLE);
        prog1bar4 = findViewById(R.id.prog1ratingBar1);
        prog1bar4.setIsIndicator(true);
        prog1bar5=findViewById(R.id.prog1ratingBar3);
        prog1bar5.setIsIndicator(true);
        prog1bar6=findViewById(R.id.prog1ratingBar5);
        prog1bar6.setIsIndicator(true);

        til_Prof6 = (TextInputLayout) findViewById(R.id.til_Profprog1);
        act_Prof6 = (AutoCompleteTextView) findViewById(R.id.act_Profprog1);

        ArrayList_Prof6 = new ArrayList<>();
        ArrayList_Prof6.add("Matthias Frohner");
        ArrayList_Prof6.add("Johannes Martinek");
        ArrayList_Prof6.add("Philipp Urbauer");


        ArrayAdapter_Prof6 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof6);
        act_Prof6.setAdapter(ArrayAdapter_Prof6);

        act_Prof6.setThreshold(1);

        prog1button = findViewById(R.id.prog1button);
        prog1button.setOnClickListener(this);

        prog1nextButton = findViewById(R.id.prog1nextButton);
        prog1nextButton.setOnClickListener(this);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
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


        db = new FachBewertDBHelper(prog1.this,fachname);


        boolean wahr = db.updateData(fachname,
                Username.getUsername(),
                Math.round(prog1bar1.getRating()),
                Math.round(prog1bar2.getRating()),
                Math.round(prog1bar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db = new FachBewertDBHelper(prog1.this,fachname);
        boolean wahr = db.insertData(fachname,
                Username.getUsername(),
                (int) prog1bar1.getRating(),
                (int) prog1bar2.getRating(),
                (int) prog1bar3.getRating()

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
        db =  new FachBewertDBHelper(prog1.this,fachname);
        List<Integer> list = db.getData(fachname);
        prog1bar4.setRating((float)list.get(0));
        prog1bar5.setRating((float)list.get(1));
        prog1bar6.setRating((float)list.get(2));

    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.prog1button:
                if(prog1button.getText().toString().equals("Bewerten")){
                    prog1bar1.setVisibility(View.VISIBLE);
                    prog1bar2.setVisibility(View.VISIBLE);
                    prog1bar3.setVisibility(View.VISIBLE);
                    prog1button.setText("Speichern");
                } else if(prog1button.getText().toString().equals("Speichern"))
                {
                    prog1bar1.setVisibility(View.INVISIBLE);
                    prog1bar2.setVisibility(View.INVISIBLE);
                    prog1bar3.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    prog1button.setText("Bewerten");
                }
                break;
            case R.id.prog1nextButton:
                selected_Profprog1 = act_Prof6.getText().toString();
                if (selected_Profprog1.equals("Matthias Frohner")){
                    openFrohner();
                }if (selected_Profprog1.equals("Johannes Martinek")){
                openMartinek();
            }if (selected_Profprog1.equals("Philipp Urbauer")){
                openUrbauer();
            }
                break;
        }
    }
}