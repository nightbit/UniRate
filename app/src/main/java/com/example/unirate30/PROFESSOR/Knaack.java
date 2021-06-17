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

public class Knaack extends AppCompatActivity implements View.OnClickListener {

    Button knackbutton20;
    RatingBar knackbar, knackbar1, knackbar2, knackbar3, knackbar4, knackbar5, knackbar6, knackbar7, knackbar8, knackbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knaack);

        db = new ProfBewertDbHelper(Knaack.this,"Knaack");

        knackbar = findViewById(R.id.knaackratingBar);
        knackbar.setVisibility(View.VISIBLE);
        knackbar.setIsIndicator(true);
        knackbar1 = findViewById(R.id.knaackratingBar1);
        knackbar1.setVisibility(View.INVISIBLE);
        knackbar2 = findViewById(R.id.knaackratingBar2);
        knackbar2.setVisibility(View.VISIBLE);
        knackbar2.setIsIndicator(true);
        knackbar3 = findViewById(R.id.knaackratingBar3);
        knackbar3.setVisibility(View.INVISIBLE);
        knackbar4 = findViewById(R.id.knaackratingBar4);
        knackbar4.setVisibility(View.VISIBLE);
        knackbar4.setIsIndicator(true);
        knackbar5 = findViewById(R.id.knaackratingBar5);
        knackbar5.setVisibility(View.INVISIBLE);
        knackbar6 = findViewById(R.id.knaackratingBar6);
        knackbar6.setVisibility(View.VISIBLE);
        knackbar6.setIsIndicator(true);
        knackbar7 = findViewById(R.id.knaackratingBar7);
        knackbar7.setVisibility(View.INVISIBLE);
        knackbar8 = findViewById(R.id.knaackratingBar8);
        knackbar8.setVisibility(View.VISIBLE);
        knackbar8.setIsIndicator(true);
        knackbar9 = findViewById(R.id.knaackratingBar9);
        knackbar9.setVisibility(View.INVISIBLE);

        knackbutton20 = findViewById(R.id.knaackbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        knackbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Knaack.this,"Knaack");


        boolean wahr = db.updateData("Knaack",
                Username.getUsername(),
                Math.round(knackbar1.getRating()),
                Math.round(knackbar3.getRating()),
                Math.round(knackbar5.getRating()),
                Math.round(knackbar7.getRating()),
                Math.round(knackbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Knaack.this,"Knaack");
        boolean wahr = db.insertData("Knaack",
                Username.getUsername(),
                (int) knackbar.getRating(),
                (int) knackbar2.getRating(),
                (int) knackbar4.getRating(),
                (int) knackbar6.getRating(),
                (int) knackbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Knaack", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Knaack", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Knaack", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Knaack.this,"Knaack");
        List<Integer> list = db.getData("Knaack");
        knackbar.setRating((float)list.get(0));
        knackbar2.setRating((float)list.get(1));
        knackbar4.setRating((float)list.get(2));
        knackbar6.setRating((float)list.get(3));
        knackbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(knackbutton20.getText().toString().equals("Bewerten")) {
            knackbar1.setVisibility(View.VISIBLE);
            knackbar3.setVisibility(View.VISIBLE);
            knackbar5.setVisibility(View.VISIBLE);
            knackbar7.setVisibility(View.VISIBLE);
            knackbar9.setVisibility(View.VISIBLE);
            knackbutton20.setText("Speichern");
        }else if(knackbutton20.getText().toString().equals("Speichern")){


            knackbar1.setVisibility(View.INVISIBLE);
            knackbar3.setVisibility(View.INVISIBLE);
            knackbar5.setVisibility(View.INVISIBLE);
            knackbar7.setVisibility(View.INVISIBLE);
            knackbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            knackbutton20.setText("Bewerten");

        }
    }
}