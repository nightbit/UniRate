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

public class Schenk extends AppCompatActivity implements View.OnClickListener {

    Button schenkbutton20;
    RatingBar schenkbar1;
    RatingBar schenkbar2;
    RatingBar schenkbar3;
    RatingBar schenkbar4;
    RatingBar schenkbar5;
    RatingBar schenkbar6;
    RatingBar schenkbar7;
    RatingBar schenkbar8;
    RatingBar schenkbar9;
    RatingBar schenkbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schenk);
        db = new ProfBewertDbHelper(Schenk.this,"Schenk");

        schenkbar1 = findViewById(R.id.schenkratingBar1);
        schenkbar1.setVisibility(View.INVISIBLE);
        schenkbar2 = findViewById(R.id.schenkratingBar3);
        schenkbar2.setVisibility(View.INVISIBLE);
        schenkbar3 = findViewById(R.id.schenkratingBar5);
        schenkbar3.setVisibility(View.INVISIBLE);
        schenkbar4 = findViewById(R.id.schenkratingBar7);
        schenkbar4.setVisibility(View.INVISIBLE);
        schenkbar5 = findViewById(R.id.schenkratingBar9);
        schenkbar5.setVisibility(View.INVISIBLE);
        schenkbar6 =findViewById(R.id.schenkratingBar);
        schenkbar6.setVisibility(View.VISIBLE);
        schenkbar6.setIsIndicator(true);
        schenkbar7 =findViewById(R.id.schenkratingBar2);
        schenkbar7.setVisibility(View.VISIBLE);
        schenkbar7.setIsIndicator(true);
        schenkbar8 =findViewById(R.id.schenkratingBar4);
        schenkbar8.setVisibility(View.VISIBLE);
        schenkbar8.setIsIndicator(true);
        schenkbar9 =findViewById(R.id.schenkratingBar6);
        schenkbar9.setVisibility(View.VISIBLE);
        schenkbar9.setIsIndicator(true);
        schenkbar10 =findViewById(R.id.schenkratingBar8);
        schenkbar10.setVisibility(View.VISIBLE);
        schenkbar10.setIsIndicator(true);

        schenkbutton20 = findViewById(R.id.schenkbutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        schenkbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Schenk.this,"Schenk");


        boolean wahr = db.updateData("Schenk",
                Username.getUsername(),
                Math.round(schenkbar1.getRating()),
                Math.round(schenkbar2.getRating()),
                Math.round(schenkbar3.getRating()),
                Math.round(schenkbar4.getRating()),
                Math.round(schenkbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Schenk.this,"Schenk");
        boolean wahr = db.insertData("Schenk",
                Username.getUsername(),
                (int) schenkbar1.getRating(),
                (int) schenkbar2.getRating(),
                (int) schenkbar3.getRating(),
                (int) schenkbar4.getRating(),
                (int) schenkbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Schenk", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Schenk", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Schenk", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Schenk.this,"Schenk");
        List<Integer> list = db.getData("Schenk");
        schenkbar6.setRating((float)list.get(0));
        schenkbar7.setRating((float)list.get(1));
        schenkbar8.setRating((float)list.get(2));
        schenkbar9.setRating((float)list.get(3));
        schenkbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(schenkbutton20.getText().toString().equals("Bewerten")) {
            schenkbar1.setVisibility(View.VISIBLE);
            schenkbar2.setVisibility(View.VISIBLE);
            schenkbar3.setVisibility(View.VISIBLE);
            schenkbar4.setVisibility(View.VISIBLE);
            schenkbar5.setVisibility(View.VISIBLE);
            schenkbutton20.setText("Speichern");
        }else if(schenkbutton20.getText().toString().equals("Speichern")){


            schenkbar1.setVisibility(View.INVISIBLE);
            schenkbar2.setVisibility(View.INVISIBLE);
            schenkbar3.setVisibility(View.INVISIBLE);
            schenkbar4.setVisibility(View.INVISIBLE);
            schenkbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            schenkbutton20.setText("Bewerten");

        }
    }
}