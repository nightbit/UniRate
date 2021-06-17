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

public class Eitel extends AppCompatActivity implements View.OnClickListener {

    Button eitelbutton20;
    RatingBar eitelbar, eitelbar1, eitelbar2, eitelbar3, eitelbar4, eitelbar5, eitelbar6, eitelbar7, eitelbar8, eitelbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eitel);
        db = new ProfBewertDbHelper(Eitel.this);



        eitelbar = findViewById(R.id.eitelratingBar);
        eitelbar.setVisibility(View.VISIBLE);
        eitelbar.setIsIndicator(true);
        eitelbar1 = findViewById(R.id.eitelratingBar1);
        eitelbar1.setVisibility(View.INVISIBLE);
        eitelbar2 = findViewById(R.id.eitelratingBar2);
        eitelbar2.setVisibility(View.VISIBLE);
        eitelbar2.setIsIndicator(true);
        eitelbar3 = findViewById(R.id.eitelratingBar3);
        eitelbar3.setVisibility(View.INVISIBLE);
        eitelbar4 = findViewById(R.id.eitelratingBar4);
        eitelbar4.setVisibility(View.VISIBLE);
        eitelbar4.setIsIndicator(true);
        eitelbar5 = findViewById(R.id.eitelratingBar5);
        eitelbar5.setVisibility(View.INVISIBLE);
        eitelbar6 = findViewById(R.id.eitelratingBar6);
        eitelbar6.setVisibility(View.VISIBLE);
        eitelbar6.setIsIndicator(true);
        eitelbar7 = findViewById(R.id.eitelratingBar7);
        eitelbar7.setVisibility(View.INVISIBLE);
        eitelbar8 = findViewById(R.id.eitelratingBar8);
        eitelbar8.setVisibility(View.VISIBLE);
        eitelbar8.setIsIndicator(true);
        eitelbar9 = findViewById(R.id.eitelratingBar9);
        eitelbar9.setVisibility(View.INVISIBLE);

        eitelbutton20 = findViewById(R.id.eitelbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        eitelbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Eitel.this);


        boolean wahr = db.updateData("Eitel",
                Username.getUsername(),
                Math.round(eitelbar1.getRating()),
                Math.round(eitelbar3.getRating()),
                Math.round(eitelbar5.getRating()),
                Math.round(eitelbar7.getRating()),
                Math.round(eitelbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Eitel.this);
        boolean wahr = db.insertData("Eitel",
                Username.getUsername(),
                (int) eitelbar.getRating(),
                (int) eitelbar2.getRating(),
                (int) eitelbar4.getRating(),
                (int) eitelbar6.getRating(),
                (int) eitelbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("AHub", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Eitel", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Eitel", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Eitel.this);
        List<Integer> list = db.getData("AHub");
        eitelbar.setRating((float)list.get(0));
        eitelbar2.setRating((float)list.get(1));
        eitelbar4.setRating((float)list.get(2));
        eitelbar6.setRating((float)list.get(3));
        eitelbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(eitelbutton20.getText().toString().equals("Bewerten")) {
            eitelbar1.setVisibility(View.VISIBLE);
            eitelbar3.setVisibility(View.VISIBLE);
            eitelbar5.setVisibility(View.VISIBLE);
            eitelbar7.setVisibility(View.VISIBLE);
            eitelbar9.setVisibility(View.VISIBLE);
            eitelbutton20.setText("Speichern");
        }else if(eitelbutton20.getText().toString().equals("Speichern")){


            eitelbar1.setVisibility(View.INVISIBLE);
            eitelbar3.setVisibility(View.INVISIBLE);
            eitelbar5.setVisibility(View.INVISIBLE);
            eitelbar7.setVisibility(View.INVISIBLE);
            eitelbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            eitelbutton20.setText("Bewerten");

        }
    }
}




