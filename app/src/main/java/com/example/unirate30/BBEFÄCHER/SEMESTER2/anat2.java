package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.PROFESSOR.Huber;
import com.example.unirate30.PROFESSOR.Jesen;
import com.example.unirate30.PROFESSOR.Praher;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class anat2 extends AppCompatActivity implements View.OnClickListener {

    Button anat2button;
    RatingBar anat2bar, anat2bar1;
    RatingBar anat2bar2, anat2bar4;
    RatingBar anat2bar3, anat2bar5;
    FachBewertDBHelper db;
    String db_name = "anat2";

    TextInputLayout til_Prof14;
    AutoCompleteTextView act_Prof14;

    ArrayList<String> ArrayList_Prof14;
    ArrayAdapter<String> ArrayAdapter_Prof14;

    ImageButton anat2nextButton;
    String selected_Profanat2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anat2);

        db = new FachBewertDBHelper(anat2.this, db_name);

        anat2bar = findViewById(R.id.anat2ratingBar1);
        anat2bar.setIsIndicator(true);
        anat2bar1 =findViewById(R.id.anat2ratingBar2);
        anat2bar1.setVisibility(View.INVISIBLE);
        anat2bar2 = findViewById(R.id.anat2ratingBar3);
        anat2bar2.setIsIndicator(true);
        anat2bar3 = findViewById(R.id.anat2ratingBar4);
        anat2bar3.setVisibility(View.INVISIBLE);
        anat2bar4 =findViewById(R.id.anat2ratingBar5);
        anat2bar4.setIsIndicator(true);
        anat2bar5 =findViewById(R.id.anat2ratingBar6);
        anat2bar5.setVisibility(View.INVISIBLE);

        til_Prof14 = (TextInputLayout) findViewById(R.id.til_Profanat2);
        act_Prof14 = (AutoCompleteTextView) findViewById(R.id.act_Profanat2);

        ArrayList_Prof14 = new ArrayList<>();
        ArrayList_Prof14.add("Marlis Huber");
        ArrayList_Prof14.add("Veronika Jesenberger");
        ArrayList_Prof14.add("Daniela Praher");


        ArrayAdapter_Prof14 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof14);
        act_Prof14.setAdapter(ArrayAdapter_Prof14);

        act_Prof14.setThreshold(1);

        anat2button = findViewById(R.id.anat2button);
        anat2nextButton = findViewById(R.id.anat2nextButton);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        anat2nextButton.setOnClickListener((View.OnClickListener) this);
        anat2button.setOnClickListener((View.OnClickListener) this);
    }
    public void openHuber(){
        Intent huber = new Intent(this, Huber.class );
        startActivity(huber);
    }
    public void openJesen(){
        Intent jesen = new Intent(this, Jesen.class );
        startActivity(jesen);
    }
    public void openPraher(){
        Intent praher = new Intent(this, Praher.class );
        startActivity(praher);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(anat2.this, db_name);


        boolean wahr = db.updateData("Anatomie 2",
                Username.getUsername(),
                Math.round(anat2bar1.getRating()),
                Math.round(anat2bar3.getRating()),
                Math.round(anat2bar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(anat2.this, db_name);
        boolean wahr = db.insertData("Anatomie 2",
                Username.getUsername(),
                (int) anat2bar1.getRating(),
                (int) anat2bar3.getRating(),
                (int) anat2bar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("Anatomie 2", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Anatomie 2", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Anatomie 2", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(anat2.this,db_name);
        List<Integer> list = db.getData("Anatomie 2");
        anat2bar.setRating((float)list.get(0));
        anat2bar2.setRating((float)list.get(1));
        anat2bar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.anat2button:
                if(anat2button.getText().toString().equals("Bewerten")){
                    anat2bar1.setVisibility(View.VISIBLE);
                    anat2bar3.setVisibility(View.VISIBLE);
                    anat2bar5.setVisibility(View.VISIBLE);
                    anat2button.setText("Speichern");
                } else if(anat2button.getText().toString().equals("Speichern"))
                {
                    anat2bar1.setVisibility(View.INVISIBLE);
                    anat2bar3.setVisibility(View.INVISIBLE);
                    anat2bar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    anat2button.setText("Bewerten");
                }
                break;
            case R.id.anat2nextButton:
                selected_Profanat2 = act_Prof14.getText().toString();
                if (selected_Profanat2.equals("Marlies Huber")){
                    openHuber();
                }if (selected_Profanat2.equals("Veronika Jesenberger")){
                openJesen();
            } if (selected_Profanat2.equals("Daniela Praher")) {
                openPraher();
            }
                break;
        }
    }
}
