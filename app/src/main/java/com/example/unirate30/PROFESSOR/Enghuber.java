package com.example.unirate30.PROFESSOR;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.ProfBewertDbHelper;
import com.example.unirate30.R;
import com.example.unirate30.Username;

import java.util.List;

public class Enghuber extends AppCompatActivity implements View.OnClickListener {

    Button enghubbutton20;
    RatingBar enghubbar, enghubbar1, enghubbar2, enghubbar3, enghubbar4, enghubbar5, enghubbar6, enghubbar7, enghubbar8, enghubbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enghuber);

        db = new ProfBewertDbHelper(Enghuber.this);

        enghubbar = findViewById(R.id.enghuberratingBar);
        enghubbar.setVisibility(View.VISIBLE);
        enghubbar.setIsIndicator(true);
        enghubbar1 = findViewById(R.id.enghuberratingBar1);
        enghubbar1.setVisibility(View.INVISIBLE);
        enghubbar2 = findViewById(R.id.enghuberratingBar2);
        enghubbar2.setVisibility(View.VISIBLE);
        enghubbar2.setIsIndicator(true);
        enghubbar3 = findViewById(R.id.enghuberratingBar3);
        enghubbar3.setVisibility(View.INVISIBLE);
        enghubbar4 = findViewById(R.id.enghuberratingBar4);
        enghubbar4.setVisibility(View.VISIBLE);
        enghubbar4.setIsIndicator(true);
        enghubbar5 = findViewById(R.id.enghuberratingBar5);
        enghubbar5.setVisibility(View.INVISIBLE);
        enghubbar6 = findViewById(R.id.enghuberratingBar6);
        enghubbar6.setVisibility(View.VISIBLE);
        enghubbar6.setIsIndicator(true);
        enghubbar7 = findViewById(R.id.enghuberratingBar7);
        enghubbar7.setVisibility(View.INVISIBLE);
        enghubbar8 = findViewById(R.id.enghuberratingBar8);
        enghubbar8.setVisibility(View.VISIBLE);
        enghubbar8.setIsIndicator(true);
        enghubbar9 = findViewById(R.id.enghuberratingBar9);
        enghubbar9.setVisibility(View.INVISIBLE);

        enghubbutton20 = findViewById(R.id.enghuberbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        enghubbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Enghuber.this);


        boolean wahr = db.updateData("AHub",
                Username.getUsername(),
                Math.round(enghubbar1.getRating()),
                Math.round(enghubbar3.getRating()),
                Math.round(enghubbar5.getRating()),
                Math.round(enghubbar7.getRating()),
                Math.round(enghubbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Enghuber.this);
        boolean wahr = db.insertData("Enghuber",
                Username.getUsername(),
                (int) enghubbar.getRating(),
                (int) enghubbar2.getRating(),
                (int) enghubbar4.getRating(),
                (int) enghubbar6.getRating(),
                (int) enghubbar8.getRating()
        );
        if (wahr){
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }

        /* private boolean controll()
        {
            db=new ProfDbHelper(AHub.this);
            boolean okay= db.controll("AHub",Username.getUsername());
            return okay;
        }*/

    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("Enghuber", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Enghuber", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Enghuber", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Enghuber.this);
        List<Integer> list = db.getData("Enghuber");
        enghubbar.setRating((float)list.get(0));
        enghubbar2.setRating((float)list.get(1));
        enghubbar4.setRating((float)list.get(2));
        enghubbar6.setRating((float)list.get(3));
        enghubbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(enghubbutton20.getText().toString().equals("Bewerten")) {
            enghubbar1.setVisibility(View.VISIBLE);
            enghubbar3.setVisibility(View.VISIBLE);
            enghubbar5.setVisibility(View.VISIBLE);
            enghubbar7.setVisibility(View.VISIBLE);
            enghubbar9.setVisibility(View.VISIBLE);
            enghubbutton20.setText("Speichern");
        }else if(enghubbutton20.getText().toString().equals("Speichern")){


            enghubbar1.setVisibility(View.INVISIBLE);
            enghubbar3.setVisibility(View.INVISIBLE);
            enghubbar5.setVisibility(View.INVISIBLE);
            enghubbar7.setVisibility(View.INVISIBLE);
            enghubbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            enghubbutton20.setText("Bewerten");

        }
    }
}


