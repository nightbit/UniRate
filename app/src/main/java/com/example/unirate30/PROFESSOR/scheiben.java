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

public class scheiben extends AppCompatActivity implements View.OnClickListener {

    Button scheibenbutton20;
    RatingBar scheibenbar1;
    RatingBar scheibenbar2;
    RatingBar scheibenbar3;
    RatingBar scheibenbar4;
    RatingBar scheibenbar5;
    RatingBar scheibenbar6;
    RatingBar scheibenbar7;
    RatingBar scheibenbar8;
    RatingBar scheibenbar9;
    RatingBar scheibenbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheiben);
        db = new ProfBewertDbHelper(scheiben.this);

        scheibenbar1 = findViewById(R.id.scheibenratingBar1);
        scheibenbar1.setVisibility(View.INVISIBLE);
        scheibenbar2 = findViewById(R.id.scheibenratingBar3);
        scheibenbar2.setVisibility(View.INVISIBLE);
        scheibenbar3 = findViewById(R.id.scheibenratingBar5);
        scheibenbar3.setVisibility(View.INVISIBLE);
        scheibenbar4 = findViewById(R.id.scheibenratingBar7);
        scheibenbar4.setVisibility(View.INVISIBLE);
        scheibenbar5 = findViewById(R.id.scheibenratingBar9);
        scheibenbar5.setVisibility(View.INVISIBLE);
        scheibenbar6 =findViewById(R.id.scheibenratingBar);
        scheibenbar6.setVisibility(View.VISIBLE);
        scheibenbar6.setIsIndicator(true);
        scheibenbar7 =findViewById(R.id.scheibenratingBar2);
        scheibenbar7.setVisibility(View.VISIBLE);
        scheibenbar7.setIsIndicator(true);
        scheibenbar8 =findViewById(R.id.scheibenratingBar4);
        scheibenbar8.setVisibility(View.VISIBLE);
        scheibenbar8.setIsIndicator(true);
        scheibenbar9 =findViewById(R.id.scheibenratingBar6);
        scheibenbar9.setVisibility(View.VISIBLE);
        scheibenbar9.setIsIndicator(true);
        scheibenbar10 =findViewById(R.id.scheibenratingBar8);
        scheibenbar10.setVisibility(View.VISIBLE);
        scheibenbar10.setIsIndicator(true);

        scheibenbutton20 = findViewById(R.id.scheibenbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        scheibenbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(scheiben.this);


        boolean wahr = db.updateData("scheiben",
                Username.getUsername(),
                Math.round(scheibenbar1.getRating()),
                Math.round(scheibenbar2.getRating()),
                Math.round(scheibenbar3.getRating()),
                Math.round(scheibenbar4.getRating()),
                Math.round(scheibenbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(scheiben.this);
        boolean wahr = db.insertData("scheiben",
                Username.getUsername(),
                (int) scheibenbar1.getRating(),
                (int) scheibenbar2.getRating(),
                (int) scheibenbar3.getRating(),
                (int) scheibenbar4.getRating(),
                (int) scheibenbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("scheiben", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("scheiben", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("scheiben", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(scheiben.this);
        List<Integer> list = db.getData("scheiben");
        scheibenbar6.setRating((float)list.get(0));
        scheibenbar7.setRating((float)list.get(1));
        scheibenbar8.setRating((float)list.get(2));
        scheibenbar9.setRating((float)list.get(3));
        scheibenbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(scheibenbutton20.getText().toString().equals("Bewerten")) {
            scheibenbar1.setVisibility(View.VISIBLE);
            scheibenbar2.setVisibility(View.VISIBLE);
            scheibenbar3.setVisibility(View.VISIBLE);
            scheibenbar4.setVisibility(View.VISIBLE);
            scheibenbar5.setVisibility(View.VISIBLE);
            scheibenbutton20.setText("Speichern");
        }else if(scheibenbutton20.getText().toString().equals("Speichern")){


            scheibenbar1.setVisibility(View.INVISIBLE);
            scheibenbar2.setVisibility(View.INVISIBLE);
            scheibenbar3.setVisibility(View.INVISIBLE);
            scheibenbar4.setVisibility(View.INVISIBLE);
            scheibenbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            scheibenbutton20.setText("Bewerten");

        }
    }
}