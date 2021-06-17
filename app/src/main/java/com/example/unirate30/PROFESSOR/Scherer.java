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

public class Scherer extends AppCompatActivity implements View.OnClickListener {

    Button scherbutton20;
    RatingBar scherbar1;
    RatingBar scherbar2;
    RatingBar scherbar3;
    RatingBar scherbar4;
    RatingBar scherbar5;
    RatingBar scherbar6;
    RatingBar scherbar7;
    RatingBar scherbar8;
    RatingBar scherbar9;
    RatingBar scherbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scherer);
        db = new ProfBewertDbHelper(Scherer.this,"Scherer");

        scherbar1 = findViewById(R.id.schererratingBar1);
        scherbar1.setVisibility(View.INVISIBLE);
        scherbar2 = findViewById(R.id.schererratingBar3);
        scherbar2.setVisibility(View.INVISIBLE);
        scherbar3 = findViewById(R.id.schererratingBar5);
        scherbar3.setVisibility(View.INVISIBLE);
        scherbar4 = findViewById(R.id.schererratingBar7);
        scherbar4.setVisibility(View.INVISIBLE);
        scherbar5 = findViewById(R.id.schererratingBar9);
        scherbar5.setVisibility(View.INVISIBLE);
        scherbar6 =findViewById(R.id.schererratingBar);
        scherbar6.setVisibility(View.VISIBLE);
        scherbar6.setIsIndicator(true);
        scherbar7 =findViewById(R.id.schererratingBar2);
        scherbar7.setVisibility(View.VISIBLE);
        scherbar7.setIsIndicator(true);
        scherbar8 =findViewById(R.id.schererratingBar4);
        scherbar8.setVisibility(View.VISIBLE);
        scherbar8.setIsIndicator(true);
        scherbar9 =findViewById(R.id.schererratingBar6);
        scherbar9.setVisibility(View.VISIBLE);
        scherbar9.setIsIndicator(true);
        scherbar10 =findViewById(R.id.schererratingBar8);
        scherbar10.setVisibility(View.VISIBLE);
        scherbar10.setIsIndicator(true);

        scherbutton20 = findViewById(R.id.schererbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        scherbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Scherer.this,"Scherer");


        boolean wahr = db.updateData("Scherer",
                Username.getUsername(),
                Math.round(scherbar1.getRating()),
                Math.round(scherbar2.getRating()),
                Math.round(scherbar3.getRating()),
                Math.round(scherbar4.getRating()),
                Math.round(scherbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Scherer.this,"Scherer");
        boolean wahr = db.insertData("Scherer",
                Username.getUsername(),
                (int) scherbar1.getRating(),
                (int) scherbar2.getRating(),
                (int) scherbar3.getRating(),
                (int) scherbar4.getRating(),
                (int) scherbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Scherer", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Scherer", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Scherer", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Scherer.this,"Scherer");
        List<Integer> list = db.getData("Scherer");
        scherbar6.setRating((float)list.get(0));
        scherbar7.setRating((float)list.get(1));
        scherbar8.setRating((float)list.get(2));
        scherbar9.setRating((float)list.get(3));
        scherbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(scherbutton20.getText().toString().equals("Bewerten")) {
            scherbar1.setVisibility(View.VISIBLE);
            scherbar2.setVisibility(View.VISIBLE);
            scherbar3.setVisibility(View.VISIBLE);
            scherbar4.setVisibility(View.VISIBLE);
            scherbar5.setVisibility(View.VISIBLE);
            scherbutton20.setText("Speichern");
        }else if(scherbutton20.getText().toString().equals("Speichern")){


            scherbar1.setVisibility(View.INVISIBLE);
            scherbar2.setVisibility(View.INVISIBLE);
            scherbar3.setVisibility(View.INVISIBLE);
            scherbar4.setVisibility(View.INVISIBLE);
            scherbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            scherbutton20.setText("Bewerten");

        }
    }
}