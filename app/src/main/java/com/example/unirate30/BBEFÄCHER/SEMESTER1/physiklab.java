package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.PROFESSOR.AHub;

import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class physiklab extends AppCompatActivity implements View.OnClickListener {

    Button phlabbutton;
    RatingBar phlabbar,phlabbar1;
    RatingBar phlabbar2,phlabbar4;
    RatingBar phlabbar3,phlabbar5;
    FachBewertDBHelper db;

    TextInputLayout til_Prof11;
    AutoCompleteTextView act_Prof11;

    ArrayList<String> ArrayList_Prof11;
    ArrayAdapter<String> ArrayAdapter_Prof11;

    ImageButton phlabnextButton;
    String selected_Profphlab;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiklab);
        db = new FachBewertDBHelper(physiklab.this);

        phlabbar = findViewById(R.id.phlabratingBar1);
        phlabbar.setIsIndicator(true);
        phlabbar1=findViewById(R.id.phlabratingBar2);
        phlabbar1.setVisibility(View.INVISIBLE);
        phlabbar2 = findViewById(R.id.phlabratingBar3);
        phlabbar2.setIsIndicator(true);
        phlabbar3 = findViewById(R.id.phlabratingBar4);
        phlabbar3.setVisibility(View.INVISIBLE);
        phlabbar4=findViewById(R.id.phlabratingBar5);
        phlabbar4.setIsIndicator(true);
        phlabbar5=findViewById(R.id.phlabratingBar6);
        phlabbar5.setVisibility(View.INVISIBLE);


        til_Prof11 = (TextInputLayout) findViewById(R.id.til_Profphlab);
        act_Prof11 = (AutoCompleteTextView) findViewById(R.id.act_Profphlab);

        ArrayList_Prof11 = new ArrayList<>();
        ArrayList_Prof11.add("Katharina Wiessner");
        ArrayList_Prof11.add("Barbara Gepp");

        ArrayAdapter_Prof11 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof11);
        act_Prof11.setAdapter(ArrayAdapter_Prof11);

        act_Prof11.setThreshold(1);

        phlabbutton = findViewById(R.id.phlabbutton);
        phlabnextButton = findViewById(R.id.phlabnextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        phlabnextButton.setOnClickListener((View.OnClickListener) this);
        phlabbutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openAHub(){
        Intent ahub = new Intent(this, AHub.class);
        startActivity(ahub);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(physiklab.this);


        boolean wahr = db.updateData("physiklab",
                Username.getUsername(),
                Math.round(phlabbar1.getRating()),
                Math.round(phlabbar3.getRating()),
                Math.round(phlabbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(physiklab.this);
        boolean wahr = db.insertData("physiklab",
                Username.getUsername(),
                (int) phlabbar1.getRating(),
                (int) phlabbar3.getRating(),
                (int) phlabbar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
        private boolean firststart() {
            boolean first = false;

            SharedPreferences sharedPreferences = getSharedPreferences("physiklab", MODE_PRIVATE);
            SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
            if (sharedPreferences.getBoolean("physiklab", false)) {
                first = true;
                sharedPreferencesEditor.putBoolean("physiklab", true);
                sharedPreferencesEditor.apply();
            }

            return first;
        }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(physiklab.this);
        List<Integer> list = db.getData("physiklab");
        phlabbar.setRating((float)list.get(0));
        phlabbar2.setRating((float)list.get(1));
        phlabbar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phlabbutton:
                if(phlabbutton.getText().toString().equals("Bewerten")){
                    phlabbar1.setVisibility(View.VISIBLE);
                    phlabbar3.setVisibility(View.VISIBLE);
                    phlabbar5.setVisibility(View.VISIBLE);
                    phlabbutton.setText("Speichern");
                } else if(phlabbutton.getText().toString().equals("Speichern"))
                {
                    phlabbar1.setVisibility(View.INVISIBLE);
                    phlabbar3.setVisibility(View.INVISIBLE);
                    phlabbar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    phlabbutton.setText("Bewerten");
                }
                break;
            case R.id.phlabnextButton:
                selected_Profphlab = act_Prof11.getText().toString();
                if (selected_Profphlab.equals("Albert Huber")){
                    openAHub();
                }
                break;
        }
    }
}