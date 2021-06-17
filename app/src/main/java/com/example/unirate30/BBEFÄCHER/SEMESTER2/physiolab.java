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

public class physiolab extends AppCompatActivity implements View.OnClickListener{

    Button physlabbutton;
    RatingBar physlabbar, physlabbar1;
    RatingBar physlabbar2, physlabbar4;
    RatingBar physlabbar3, physlabbar5;
    FachBewertDBHelper db;
    String db_name="physiolab";

    TextInputLayout til_Profphyslab;
    AutoCompleteTextView act_Profphyslab;

    ArrayList<String> ArrayList_Profphyslab;
    ArrayAdapter<String> ArrayAdapter_Profphyslab;

    ImageButton physlabnextButton;
    String selected_Profphyslab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiolab);

        db = new FachBewertDBHelper(physiolab.this,db_name);

        physlabbar = findViewById(R.id.physlabratingBar1);
        physlabbar.setIsIndicator(true);
        physlabbar1 =findViewById(R.id.physlabratingBar2);
        physlabbar1.setVisibility(View.INVISIBLE);
        physlabbar2 = findViewById(R.id.physlabratingBar3);
        physlabbar2.setIsIndicator(true);
        physlabbar3 = findViewById(R.id.physlabratingBar4);
        physlabbar3.setVisibility(View.INVISIBLE);
        physlabbar4 =findViewById(R.id.physlabratingBar5);
        physlabbar4.setIsIndicator(true);
        physlabbar5 =findViewById(R.id.physlabratingBar6);
        physlabbar5.setVisibility(View.INVISIBLE);

        til_Profphyslab = (TextInputLayout) findViewById(R.id.til_Profphyslab);
        act_Profphyslab = (AutoCompleteTextView) findViewById(R.id.act_Profphyslab);

        ArrayList_Profphyslab = new ArrayList<>();
        ArrayList_Profphyslab.add("Iris Nemec");
        ArrayList_Profphyslab.add("Andrea Balz");
        ArrayList_Profphyslab.add("Richard Pasteka");
        ArrayList_Profphyslab.add("Mathias Forjan");


        ArrayAdapter_Profphyslab = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Profphyslab);
        act_Profphyslab.setAdapter(ArrayAdapter_Profphyslab);

        act_Profphyslab.setThreshold(1);

        physlabbutton = findViewById(R.id.physlabbutton);
        physlabnextButton = findViewById(R.id.physlabnextButton);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        physlabnextButton.setOnClickListener((View.OnClickListener) this);
        physlabbutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openBalz(){
        Intent balz = new Intent(this, com.example.unirate30.PROFESSOR.Balz.class);
        startActivity(balz);
    }
    public void openPasteka(){
        Intent pasteka = new Intent(this, com.example.unirate30.PROFESSOR.pasteka.class);
        startActivity(pasteka);
    }
    public void openNemec(){
        Intent nemec = new Intent(this, com.example.unirate30.PROFESSOR.Nemec.class);
        startActivity(nemec);
    }
    public void openForjan(){
        Intent forjan = new Intent(this, com.example.unirate30.PROFESSOR.Forjan.class);
        startActivity(forjan);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(physiolab.this,db_name);


        boolean wahr = db.updateData("physiologielab",
                Username.getUsername(),
                Math.round(physlabbar1.getRating()),
                Math.round(physlabbar3.getRating()),
                Math.round(physlabbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(physiolab.this,db_name);
        boolean wahr = db.insertData("physiologielab",
                Username.getUsername(),
                (int) physlabbar1.getRating(),
                (int) physlabbar3.getRating(),
                (int) physlabbar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("physiologielab", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("physiologielab", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("physiologielab", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(physiolab.this,db_name);
        List<Integer> list = db.getData("physiologielab");
        physlabbar.setRating((float)list.get(0));
        physlabbar2.setRating((float)list.get(1));
        physlabbar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.physlabbutton:
                if(physlabbutton.getText().toString().equals("Bewerten")){
                    physlabbar1.setVisibility(View.VISIBLE);
                    physlabbar3.setVisibility(View.VISIBLE);
                    physlabbar5.setVisibility(View.VISIBLE);
                    physlabbutton.setText("Speichern");
                } else if(physlabbutton.getText().toString().equals("Speichern"))
                {
                    physlabbar1.setVisibility(View.INVISIBLE);
                    physlabbar3.setVisibility(View.INVISIBLE);
                    physlabbar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    physlabbutton.setText("Bewerten");
                }
                break;
            case R.id.physlabnextButton:
                selected_Profphyslab = act_Profphyslab.getText().toString();
                if (selected_Profphyslab.equals("Iris Nemec")){
                    openBalz();
                }if (selected_Profphyslab.equals("Andrea Balz")){
                    openPasteka();
                } if (selected_Profphyslab.equals("Richard Pasteka")) {
                    openNemec();
                }  if (selected_Profphyslab.equals("Mathias Forjan")) {
                    openForjan();
            }
                break;
        }
    }
}
