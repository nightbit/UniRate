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

public class frohner extends AppCompatActivity implements View.OnClickListener {

    Button frohnerbutton20;
    RatingBar frohnerbar, frohnerbar1, frohnerbar2, frohnerbar3, frohnerbar4, frohnerbar5, frohnerbar6, frohnerbar7, frohnerbar8, frohnerbar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frohner);

        db = new ProfBewertDbHelper(frohner.this);

        frohnerbar = findViewById(R.id.frohnerratingBar);
        frohnerbar.setVisibility(View.VISIBLE);
        frohnerbar.setIsIndicator(true);
        frohnerbar1 = findViewById(R.id.frohnerratingBar1);
        frohnerbar1.setVisibility(View.INVISIBLE);
        frohnerbar2 = findViewById(R.id.frohnerratingBar2);
        frohnerbar2.setVisibility(View.VISIBLE);
        frohnerbar2.setIsIndicator(true);
        frohnerbar3 = findViewById(R.id.frohnerratingBar3);
        frohnerbar3.setVisibility(View.INVISIBLE);
        frohnerbar4 = findViewById(R.id.frohnerratingBar4);
        frohnerbar4.setVisibility(View.VISIBLE);
        frohnerbar4.setIsIndicator(true);
        frohnerbar5 = findViewById(R.id.frohnerratingBar5);
        frohnerbar5.setVisibility(View.INVISIBLE);
        frohnerbar6 = findViewById(R.id.frohnerratingBar6);
        frohnerbar6.setVisibility(View.VISIBLE);
        frohnerbar6.setIsIndicator(true);
        frohnerbar7 = findViewById(R.id.frohnerratingBar7);
        frohnerbar7.setVisibility(View.INVISIBLE);
        frohnerbar8 = findViewById(R.id.frohnerratingBar8);
        frohnerbar8.setVisibility(View.VISIBLE);
        frohnerbar8.setIsIndicator(true);
        frohnerbar9 = findViewById(R.id.frohnerratingBar9);
        frohnerbar9.setVisibility(View.INVISIBLE);

        frohnerbutton20 = findViewById(R.id.frohnerbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        frohnerbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(frohner.this);


        boolean wahr = db.updateData("frohner",
                Username.getUsername(),
                Math.round(frohnerbar1.getRating()),
                Math.round(frohnerbar3.getRating()),
                Math.round(frohnerbar5.getRating()),
                Math.round(frohnerbar7.getRating()),
                Math.round(frohnerbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(frohner.this);
        boolean wahr = db.insertData("frohner",
                Username.getUsername(),
                (int) frohnerbar.getRating(),
                (int) frohnerbar2.getRating(),
                (int) frohnerbar4.getRating(),
                (int) frohnerbar6.getRating(),
                (int) frohnerbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("frohner", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("frohner", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("frohner", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(frohner.this);
        List<Integer> list = db.getData("frohner");
        frohnerbar.setRating((float)list.get(0));
        frohnerbar2.setRating((float)list.get(1));
        frohnerbar4.setRating((float)list.get(2));
        frohnerbar6.setRating((float)list.get(3));
        frohnerbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(frohnerbutton20.getText().toString().equals("Bewerten")) {
            frohnerbar1.setVisibility(View.VISIBLE);
            frohnerbar3.setVisibility(View.VISIBLE);
            frohnerbar5.setVisibility(View.VISIBLE);
            frohnerbar7.setVisibility(View.VISIBLE);
            frohnerbar9.setVisibility(View.VISIBLE);
            frohnerbutton20.setText("Speichern");
        }else if(frohnerbutton20.getText().toString().equals("Speichern")){


            frohnerbar1.setVisibility(View.INVISIBLE);
            frohnerbar3.setVisibility(View.INVISIBLE);
            frohnerbar5.setVisibility(View.INVISIBLE);
            frohnerbar7.setVisibility(View.INVISIBLE);
            frohnerbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            frohnerbutton20.setText("Bewerten");

        }
    }
}