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

public class Sauer extends AppCompatActivity implements View.OnClickListener {

    Button sauerbutton20;
    RatingBar sauerbar1;
    RatingBar sauerbar2;
    RatingBar sauerbar3;
    RatingBar sauerbar4;
    RatingBar sauerbar5;
    RatingBar sauerbar6;
    RatingBar sauerbar7;
    RatingBar sauerbar8;
    RatingBar sauerbar9;
    RatingBar sauerbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauer);
        db = new ProfBewertDbHelper(Sauer.this,"Sauer");

        sauerbar1 = findViewById(R.id.sauerratingBar1);
        sauerbar1.setVisibility(View.INVISIBLE);
        sauerbar2 = findViewById(R.id.sauerratingBar3);
        sauerbar2.setVisibility(View.INVISIBLE);
        sauerbar3 = findViewById(R.id.sauerratingBar5);
        sauerbar3.setVisibility(View.INVISIBLE);
        sauerbar4 = findViewById(R.id.sauerratingBar7);
        sauerbar4.setVisibility(View.INVISIBLE);
        sauerbar5 = findViewById(R.id.sauerratingBar9);
        sauerbar5.setVisibility(View.INVISIBLE);
        sauerbar6 =findViewById(R.id.sauerratingBar);
        sauerbar6.setVisibility(View.VISIBLE);
        sauerbar6.setIsIndicator(true);
        sauerbar7 =findViewById(R.id.sauerratingBar2);
        sauerbar7.setVisibility(View.VISIBLE);
        sauerbar7.setIsIndicator(true);
        sauerbar8 =findViewById(R.id.sauerratingBar4);
        sauerbar8.setVisibility(View.VISIBLE);
        sauerbar8.setIsIndicator(true);
        sauerbar9 =findViewById(R.id.sauerratingBar6);
        sauerbar9.setVisibility(View.VISIBLE);
        sauerbar9.setIsIndicator(true);
        sauerbar10 =findViewById(R.id.sauerratingBar8);
        sauerbar10.setVisibility(View.VISIBLE);
        sauerbar10.setIsIndicator(true);

        sauerbutton20 = findViewById(R.id.sauerbutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        sauerbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Sauer.this,"Sauer");


        boolean wahr = db.updateData("Sauer",
                Username.getUsername(),
                Math.round(sauerbar1.getRating()),
                Math.round(sauerbar2.getRating()),
                Math.round(sauerbar3.getRating()),
                Math.round(sauerbar4.getRating()),
                Math.round(sauerbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Sauer.this,"Sauer");
        boolean wahr = db.insertData("Sauer",
                Username.getUsername(),
                (int) sauerbar1.getRating(),
                (int) sauerbar2.getRating(),
                (int) sauerbar3.getRating(),
                (int) sauerbar4.getRating(),
                (int) sauerbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Sauer", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Sauer", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Sauer", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Sauer.this,"Sauer");
        List<Integer> list = db.getData("Sauer");
        sauerbar6.setRating((float)list.get(0));
        sauerbar7.setRating((float)list.get(1));
        sauerbar8.setRating((float)list.get(2));
        sauerbar9.setRating((float)list.get(3));
        sauerbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(sauerbutton20.getText().toString().equals("Bewerten")) {
            sauerbar1.setVisibility(View.VISIBLE);
            sauerbar2.setVisibility(View.VISIBLE);
            sauerbar3.setVisibility(View.VISIBLE);
            sauerbar4.setVisibility(View.VISIBLE);
            sauerbar5.setVisibility(View.VISIBLE);
            sauerbutton20.setText("Speichern");
        }else if(sauerbutton20.getText().toString().equals("Speichern")){


            sauerbar1.setVisibility(View.INVISIBLE);
            sauerbar2.setVisibility(View.INVISIBLE);
            sauerbar3.setVisibility(View.INVISIBLE);
            sauerbar4.setVisibility(View.INVISIBLE);
            sauerbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            sauerbutton20.setText("Bewerten");

        }
    }
}
