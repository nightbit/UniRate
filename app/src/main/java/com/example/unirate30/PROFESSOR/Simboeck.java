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

public class Simboeck extends AppCompatActivity implements View.OnClickListener {

    Button simbutton20;
    RatingBar simbar1;
    RatingBar simbar2;
    RatingBar simbar3;
    RatingBar simbar4;
    RatingBar simbar5;
    RatingBar simbar6;
    RatingBar simbar7;
    RatingBar simbar8;
    RatingBar simbar9;
    RatingBar simbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simboeck);

        db = new ProfBewertDbHelper(Simboeck.this,"Simboeck");

        simbar1 = findViewById(R.id.simboeckratingBar1);
        simbar1.setVisibility(View.INVISIBLE);
        simbar2 = findViewById(R.id.simboeckratingBar3);
        simbar2.setVisibility(View.INVISIBLE);
        simbar3 = findViewById(R.id.simboeckratingBar5);
        simbar3.setVisibility(View.INVISIBLE);
        simbar4 = findViewById(R.id.simboeckratingBar7);
        simbar4.setVisibility(View.INVISIBLE);
        simbar5 = findViewById(R.id.simboeckratingBar9);
        simbar5.setVisibility(View.INVISIBLE);
        simbar6 =findViewById(R.id.simboeckratingBar);
        simbar6.setVisibility(View.VISIBLE);
        simbar6.setIsIndicator(true);
        simbar7 =findViewById(R.id.simboeckratingBar2);
        simbar7.setVisibility(View.VISIBLE);
        simbar7.setIsIndicator(true);
        simbar8 =findViewById(R.id.simboeckratingBar4);
        simbar8.setVisibility(View.VISIBLE);
        simbar8.setIsIndicator(true);
        simbar9 =findViewById(R.id.simboeckratingBar6);
        simbar9.setVisibility(View.VISIBLE);
        simbar9.setIsIndicator(true);
        simbar10 =findViewById(R.id.simboeckratingBar8);
        simbar10.setVisibility(View.VISIBLE);
        simbar10.setIsIndicator(true);

        simbutton20 = findViewById(R.id.simboeckbutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        simbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Simboeck.this,"Simboeck");


        boolean wahr = db.updateData("Simboeck",
                Username.getUsername(),
                Math.round(simbar1.getRating()),
                Math.round(simbar2.getRating()),
                Math.round(simbar3.getRating()),
                Math.round(simbar4.getRating()),
                Math.round(simbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Simboeck.this,"Simbeock");
        boolean wahr = db.insertData("Simboeck",
                Username.getUsername(),
                (int) simbar1.getRating(),
                (int) simbar2.getRating(),
                (int) simbar3.getRating(),
                (int) simbar4.getRating(),
                (int) simbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Simboeck", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Simboeck", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Simboeck", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Simboeck.this,"Simboeck");
        List<Integer> list = db.getData("Simboeck");
        simbar6.setRating((float)list.get(0));
        simbar7.setRating((float)list.get(1));
        simbar8.setRating((float)list.get(2));
        simbar9.setRating((float)list.get(3));
        simbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(simbutton20.getText().toString().equals("Bewerten")) {
            simbar1.setVisibility(View.VISIBLE);
            simbar2.setVisibility(View.VISIBLE);
            simbar3.setVisibility(View.VISIBLE);
            simbar4.setVisibility(View.VISIBLE);
            simbar5.setVisibility(View.VISIBLE);
            simbutton20.setText("Speichern");
        }else if(simbutton20.getText().toString().equals("Speichern")){


            simbar1.setVisibility(View.INVISIBLE);
            simbar2.setVisibility(View.INVISIBLE);
            simbar3.setVisibility(View.INVISIBLE);
            simbar4.setVisibility(View.INVISIBLE);
            simbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            simbutton20.setText("Bewerten");

        }
    }
}