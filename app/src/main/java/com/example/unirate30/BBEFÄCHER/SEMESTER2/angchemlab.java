package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.PROFESSOR.Eitel;
import com.example.unirate30.PROFESSOR.Varvara;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class angchemlab extends AppCompatActivity implements View.OnClickListener {

    Button angchemlabbutton;
    RatingBar angchemlabbar, angchemlabbar1;
    RatingBar angchemlabbar2, angchemlabbar4;
    RatingBar angchemlabbar3, angchemlabbar5;
    FachBewertDBHelper db;
    String db_name = "angchemlab";

    TextInputLayout til_Prof13;
    AutoCompleteTextView act_Prof13;

    ArrayList<String> ArrayList_Prof13;
    ArrayAdapter<String> ArrayAdapter_Prof13;

    ImageButton angchemlabnextButton;
    String selected_Profangchemlab;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angchemlab);

        db = new FachBewertDBHelper(angchemlab.this, db_name);

        angchemlabbar = findViewById(R.id.anglabratingBar1);
        angchemlabbar.setIsIndicator(true);
        angchemlabbar1 =findViewById(R.id.anglabratingBar2);
        angchemlabbar1.setVisibility(View.INVISIBLE);
        angchemlabbar2 = findViewById(R.id.anglabratingBar3);
        angchemlabbar2.setIsIndicator(true);
        angchemlabbar3 = findViewById(R.id.anglabratingBar4);
        angchemlabbar3.setVisibility(View.INVISIBLE);
        angchemlabbar4 =findViewById(R.id.anglabratingBar5);
        angchemlabbar4.setIsIndicator(true);
        angchemlabbar5 =findViewById(R.id.anglabratingBar6);
        angchemlabbar5.setVisibility(View.INVISIBLE);


        til_Prof13 = (TextInputLayout) findViewById(R.id.til_Profanglab);
        act_Prof13 = (AutoCompleteTextView) findViewById(R.id.act_Profanglab);

        ArrayList_Prof13 = new ArrayList<>();
        ArrayList_Prof13.add("Barbara Gepp");
        ArrayList_Prof13.add("Ursula Knaack");
        ArrayList_Prof13.add("Heidemarie Fuchs-Eitel");
        ArrayList_Prof13.add("Varvara Liousia");

        ArrayAdapter_Prof13 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof13);
        act_Prof13.setAdapter(ArrayAdapter_Prof13);

        act_Prof13.setThreshold(1);

        angchemlabbutton = findViewById(R.id.anglabbutton);
        angchemlabnextButton = findViewById(R.id.anglabnextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        angchemlabnextButton.setOnClickListener((View.OnClickListener) this);
        angchemlabbutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openKnaack() {
        Intent Knaack = new Intent(this, com.example.unirate30.PROFESSOR.Knaack.class);
        startActivity(Knaack);
    }
    public void openEitel() {
        Intent eitel = new Intent(this, Eitel.class);
        startActivity(eitel);
    }
    public void openVarvara() {
        Intent varvara = new Intent(this, Varvara.class);
        startActivity(varvara);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(angchemlab.this, db_name);


        boolean wahr = db.updateData("angchemlab",
                Username.getUsername(),
                Math.round(angchemlabbar1.getRating()),
                Math.round(angchemlabbar3.getRating()),
                Math.round(angchemlabbar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(angchemlab.this,db_name);
        boolean wahr = db.insertData("angchemlab",
                Username.getUsername(),
                (int) angchemlabbar1.getRating(),
                (int) angchemlabbar3.getRating(),
                (int) angchemlabbar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("angchemlab", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("angchemlab", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("angchemlab", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(angchemlab.this,db_name);
        List<Integer> list = db.getData("angchemlab");
        angchemlabbar.setRating((float)list.get(0));
        angchemlabbar2.setRating((float)list.get(1));
        angchemlabbar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.anglabbutton:
                if(angchemlabbutton.getText().toString().equals("Bewerten")){
                    angchemlabbar1.setVisibility(View.VISIBLE);
                    angchemlabbar3.setVisibility(View.VISIBLE);
                    angchemlabbar5.setVisibility(View.VISIBLE);
                    angchemlabbutton.setText("Speichern");
                } else if(angchemlabbutton.getText().toString().equals("Speichern"))
                {
                    angchemlabbar1.setVisibility(View.INVISIBLE);
                    angchemlabbar3.setVisibility(View.INVISIBLE);
                    angchemlabbar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    angchemlabbutton.setText("Bewerten");
                }
                break;
            case R.id.anglabnextButton:
                selected_Profangchemlab = act_Prof13.getText().toString();
                if (selected_Profangchemlab.equals("Barbara Gepp")){
                    openGepp();
                }if (selected_Profangchemlab.equals("Ursula Knaack")) {
                openKnaack();
            }
                if (selected_Profangchemlab.equals("Heidemarie Fuchs-Eitel")){
                    openEitel();
                }
                if (selected_Profangchemlab.equals("Varvara Liousia")){
                    openVarvara();
                }

                break;
        }
    }
}
