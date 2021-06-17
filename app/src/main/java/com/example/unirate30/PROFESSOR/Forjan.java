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

public class Forjan extends AppCompatActivity implements View.OnClickListener {

    Button forjanbutton20;
    RatingBar forjanbar, forjanbar1, forjanbar2, forjanbar3, forjanbar4, forjanbar5, forjanbar6, forjanbar7, forjanbar8, forjanbar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forjan);
        db = new ProfBewertDbHelper(Forjan.this);

        forjanbar = findViewById(R.id.forjanratingBar);
        forjanbar.setVisibility(View.VISIBLE);
        forjanbar.setIsIndicator(true);
        forjanbar1 = findViewById(R.id.forjanratingBar1);
        forjanbar1.setVisibility(View.INVISIBLE);
        forjanbar2 = findViewById(R.id.forjanratingBar2);
        forjanbar2.setVisibility(View.VISIBLE);
        forjanbar2.setIsIndicator(true);
        forjanbar3 = findViewById(R.id.forjanratingBar3);
        forjanbar3.setVisibility(View.INVISIBLE);
        forjanbar4 = findViewById(R.id.forjanratingBar4);
        forjanbar4.setVisibility(View.VISIBLE);
        forjanbar4.setIsIndicator(true);
        forjanbar5 = findViewById(R.id.forjanratingBar5);
        forjanbar5.setVisibility(View.INVISIBLE);
        forjanbar6 = findViewById(R.id.forjanratingBar6);
        forjanbar6.setVisibility(View.VISIBLE);
        forjanbar6.setIsIndicator(true);
        forjanbar7 = findViewById(R.id.forjanratingBar7);
        forjanbar7.setVisibility(View.INVISIBLE);
        forjanbar8 = findViewById(R.id.forjanratingBar8);
        forjanbar8.setVisibility(View.VISIBLE);
        forjanbar8.setIsIndicator(true);
        forjanbar9 = findViewById(R.id.forjanratingBar9);
        forjanbar9.setVisibility(View.INVISIBLE);

        forjanbutton20 = findViewById(R.id.forjanbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        forjanbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Forjan.this);


        boolean wahr = db.updateData("Forjan",
                Username.getUsername(),
                Math.round(forjanbar1.getRating()),
                Math.round(forjanbar3.getRating()),
                Math.round(forjanbar5.getRating()),
                Math.round(forjanbar7.getRating()),
                Math.round(forjanbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Forjan.this);
        boolean wahr = db.insertData("Forjan",
                Username.getUsername(),
                (int) forjanbar.getRating(),
                (int) forjanbar2.getRating(),
                (int) forjanbar4.getRating(),
                (int) forjanbar6.getRating(),
                (int) forjanbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Forjan", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Forjan", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Forjan", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Forjan.this);
        List<Integer> list = db.getData("Forjan");
        forjanbar.setRating((float)list.get(0));
        forjanbar2.setRating((float)list.get(1));
        forjanbar4.setRating((float)list.get(2));
        forjanbar6.setRating((float)list.get(3));
        forjanbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(forjanbutton20.getText().toString().equals("Bewerten")) {
            forjanbar1.setVisibility(View.VISIBLE);
            forjanbar3.setVisibility(View.VISIBLE);
            forjanbar5.setVisibility(View.VISIBLE);
            forjanbar7.setVisibility(View.VISIBLE);
            forjanbar9.setVisibility(View.VISIBLE);
            forjanbutton20.setText("Speichern");
        }else if(forjanbutton20.getText().toString().equals("Speichern")){


            forjanbar1.setVisibility(View.INVISIBLE);
            forjanbar3.setVisibility(View.INVISIBLE);
            forjanbar5.setVisibility(View.INVISIBLE);
            forjanbar7.setVisibility(View.INVISIBLE);
            forjanbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            forjanbutton20.setText("Bewerten");

        }
    }
}