package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.PROFESSOR.Huber;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class anat1 extends AppCompatActivity implements View.OnClickListener {

    Button anat1button;
    RatingBar anat1bar1;
    RatingBar anat1bar2;
    RatingBar anat1bar3;
    RatingBar anat1bar4;
    RatingBar anat1bar5;
    RatingBar anat1bar6;
    FachBewertDBHelper db;
    String db_name="anat1";

    TextInputLayout til_Prof3;
    AutoCompleteTextView act_Prof3;

    ArrayList<String> ArrayList_Prof3;
    ArrayAdapter<String> ArrayAdapter_Prof3;

    ImageButton anat1nextButton;
    String selected_Profanat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anat1);
        db = new FachBewertDBHelper(anat1.this,db_name);

        anat1bar1 = findViewById(R.id.anat1ratingBar2);
        anat1bar1.setVisibility(View.INVISIBLE);
        anat1bar2 = findViewById(R.id.anat1ratingBar4);
        anat1bar2.setVisibility(View.INVISIBLE);
        anat1bar3 = findViewById(R.id.anat1ratingBar6);
        anat1bar3.setVisibility(View.INVISIBLE);
        anat1bar4 = findViewById(R.id.anat1ratingBar1);
        anat1bar4.setIsIndicator(true);
        anat1bar5 = findViewById(R.id.anat1ratingBar3);
        anat1bar5.setIsIndicator(true);
        anat1bar6 = findViewById(R.id.anat1ratingBar5);
        anat1bar6.setIsIndicator(true);

        til_Prof3 = (TextInputLayout) findViewById(R.id.til_Profanat1);
        act_Prof3 = (AutoCompleteTextView) findViewById(R.id.act_Profanat1);

        ArrayList_Prof3 = new ArrayList<>();
        ArrayList_Prof3.add("Marlis Huber");


        ArrayAdapter_Prof3 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof3);
        act_Prof3.setAdapter(ArrayAdapter_Prof3);

        act_Prof3.setThreshold(1);

        anat1button = findViewById(R.id.anat1button);

        anat1nextButton = findViewById(R.id.anat1nextButton);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        anat1nextButton.setOnClickListener((View.OnClickListener) this);
        anat1button.setOnClickListener((View.OnClickListener) this);
    }

    public void openHuber(){
        Intent huber = new Intent(this, Huber.class );
        startActivity(huber);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(anat1.this,db_name);


        boolean wahr = db.updateData("anat1",
                Username.getUsername(),
                Math.round(anat1bar1.getRating()),
                Math.round(anat1bar2.getRating()),
                Math.round(anat1bar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(anat1.this,db_name);
        boolean wahr = db.insertData("anat1",
                Username.getUsername(),
                (int) anat1bar1.getRating(),
                (int) anat1bar2.getRating(),
                (int) anat1bar3.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("anat1", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("anat1", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("anat1", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(anat1.this,db_name);
        List<Integer> list = db.getData("anat1");
        anat1bar4.setRating((float)list.get(0));
        anat1bar5.setRating((float)list.get(1));
        anat1bar6.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.anat1button:ton:
            if(anat1button.getText().toString().equals("Bewerten")){
                anat1bar1.setVisibility(View.VISIBLE);
                anat1bar2.setVisibility(View.VISIBLE);
                anat1bar3.setVisibility(View.VISIBLE);
                anat1button.setText("Speichern");
            } else if(anat1button.getText().toString().equals("Speichern"))
            {
                anat1bar1.setVisibility(View.INVISIBLE);
                anat1bar2.setVisibility(View.INVISIBLE);
                anat1bar3.setVisibility(View.INVISIBLE);

                update();
                AddData();

                ergebnisse();
                anat1button.setText("Bewerten");
            }
                break;
            case R.id.anat1nextButton:
                selected_Profanat1 = act_Prof3.getText().toString();
                if (selected_Profanat1.equals("Marlis Huber")){
                    openHuber();
                }
                break;
        }
    }
}