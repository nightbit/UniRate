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

public class Gepp extends AppCompatActivity implements View.OnClickListener {

    Button geppbutton20;
    RatingBar geppbar, geppbar1, geppbar2, geppbar3, geppbar4, geppbar5, geppbar6, geppbar7, geppbar8, geppbar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gepp);
        db = new ProfBewertDbHelper(Gepp.this);

        geppbar = findViewById(R.id.geppratingBar);
        geppbar.setVisibility(View.VISIBLE);
        geppbar.setIsIndicator(true);
        geppbar1 = findViewById(R.id.geppratingBar1);
        geppbar1.setVisibility(View.INVISIBLE);
        geppbar2 = findViewById(R.id.geppratingBar2);
        geppbar2.setVisibility(View.VISIBLE);
        geppbar2.setIsIndicator(true);
        geppbar3 = findViewById(R.id.geppratingBar3);
        geppbar3.setVisibility(View.INVISIBLE);
        geppbar4 = findViewById(R.id.geppratingBar4);
        geppbar4.setVisibility(View.VISIBLE);
        geppbar4.setIsIndicator(true);
        geppbar5 = findViewById(R.id.geppratingBar5);
        geppbar5.setVisibility(View.INVISIBLE);
        geppbar6 = findViewById(R.id.geppratingBar6);
        geppbar6.setVisibility(View.VISIBLE);
        geppbar6.setIsIndicator(true);
        geppbar7 = findViewById(R.id.geppratingBar7);
        geppbar7.setVisibility(View.INVISIBLE);
        geppbar8 = findViewById(R.id.geppratingBar8);
        geppbar8.setVisibility(View.VISIBLE);
        geppbar8.setIsIndicator(true);
        geppbar9 = findViewById(R.id.geppratingBar9);
        geppbar9.setVisibility(View.INVISIBLE);

        geppbutton20 = findViewById(R.id.geppbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        geppbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Gepp.this);


        boolean wahr = db.updateData("Gepp",
                Username.getUsername(),
                Math.round(geppbar1.getRating()),
                Math.round(geppbar3.getRating()),
                Math.round(geppbar5.getRating()),
                Math.round(geppbar7.getRating()),
                Math.round(geppbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Gepp.this);
        boolean wahr = db.insertData("Gepp",
                Username.getUsername(),
                (int) geppbar.getRating(),
                (int) geppbar2.getRating(),
                (int) geppbar4.getRating(),
                (int) geppbar6.getRating(),
                (int) geppbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Gepp", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Gepp", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Gepp", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Gepp.this);
        List<Integer> list = db.getData("Gepp");
        geppbar.setRating((float)list.get(0));
        geppbar2.setRating((float)list.get(1));
        geppbar4.setRating((float)list.get(2));
        geppbar6.setRating((float)list.get(3));
        geppbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(geppbutton20.getText().toString().equals("Bewerten")) {
            geppbar1.setVisibility(View.VISIBLE);
            geppbar3.setVisibility(View.VISIBLE);
            geppbar5.setVisibility(View.VISIBLE);
            geppbar7.setVisibility(View.VISIBLE);
            geppbar9.setVisibility(View.VISIBLE);
            geppbutton20.setText("Speichern");
        }else if(geppbutton20.getText().toString().equals("Speichern")){


            geppbar1.setVisibility(View.INVISIBLE);
            geppbar3.setVisibility(View.INVISIBLE);
            geppbar5.setVisibility(View.INVISIBLE);
            geppbar7.setVisibility(View.INVISIBLE);
            geppbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            geppbutton20.setText("Bewerten");

        }
    }
}