package com.example.unirate30.PROFESSOR;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.unirate30.ProfBewertDbHelper;
import com.example.unirate30.R;
import com.example.unirate30.Username;

import java.util.List;

public class Windisch extends AppCompatActivity implements View.OnClickListener {

    Button windbutton20;
    RatingBar windbar1;
    RatingBar windbar2;
    RatingBar windbar3;
    RatingBar windbar4;
    RatingBar windbar5;
    RatingBar windbar6;
    RatingBar windbar7;
    RatingBar windbar8;
    RatingBar windbar9;
    RatingBar windbar10;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windisch);
        db = new ProfBewertDbHelper(Windisch.this,"Windisch");

        windbar1 = findViewById(R.id.windratingBar1);
        windbar1.setVisibility(View.INVISIBLE);
        windbar6 =findViewById(R.id.windratingBar);
        windbar6.setVisibility(View.VISIBLE);
        windbar6.setIsIndicator(true);
        windbar2 = findViewById(R.id.windratingBar3);
        windbar2.setVisibility(View.INVISIBLE);
        windbar7 =findViewById(R.id.windratingBar2);
        windbar7.setVisibility(View.VISIBLE);
        windbar7.setIsIndicator(true);
        windbar3 = findViewById(R.id.windratingBar5);
        windbar3.setVisibility(View.INVISIBLE);
        windbar8 =findViewById(R.id.windratingBar4);
        windbar8.setVisibility(View.VISIBLE);
        windbar8.setIsIndicator(true);
        windbar4 = findViewById(R.id.windratingBar7);
        windbar4.setVisibility(View.INVISIBLE);
        windbar9 =findViewById(R.id.windratingBar6);
        windbar9.setVisibility(View.VISIBLE);
        windbar9.setIsIndicator(true);
        windbar5 = findViewById(R.id.windratingBar9);
        windbar5.setVisibility(View.INVISIBLE);
        windbar10 =findViewById(R.id.windratingBar8);
        windbar10.setVisibility(View.VISIBLE);
        windbar10.setIsIndicator(true);

        windbutton20 = findViewById(R.id.windbutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        windbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Windisch.this,"Windisch");


        boolean wahr = db.updateData("Windisch",
                Username.getUsername(),
                Math.round(windbar1.getRating()),
                Math.round(windbar2.getRating()),
                Math.round(windbar3.getRating()),
                Math.round(windbar4.getRating()),
                Math.round(windbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Windisch.this,"Windisch");
        boolean wahr = db.insertData("Windisch",
                Username.getUsername(),
                (int) windbar1.getRating(),
                (int) windbar2.getRating(),
                (int) windbar3.getRating(),
                (int) windbar4.getRating(),
                (int) windbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Windisch", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Windisch", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Windisch", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Windisch.this,"Windisch");
        List<Integer> list = db.getData("Windisch");
        windbar6.setRating((float)list.get(0));
        windbar7.setRating((float)list.get(1));
        windbar8.setRating((float)list.get(2));
        windbar9.setRating((float)list.get(3));
        windbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(windbutton20.getText().toString().equals("Bewerten")) {
            windbar1.setVisibility(View.VISIBLE);
            windbar2.setVisibility(View.VISIBLE);
            windbar3.setVisibility(View.VISIBLE);
            windbar4.setVisibility(View.VISIBLE);
            windbar5.setVisibility(View.VISIBLE);
            windbutton20.setText("Speichern");
        }else if(windbutton20.getText().toString().equals("Speichern")){


            windbar1.setVisibility(View.INVISIBLE);
            windbar2.setVisibility(View.INVISIBLE);
            windbar3.setVisibility(View.INVISIBLE);
            windbar4.setVisibility(View.INVISIBLE);
            windbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            windbutton20.setText("Bewerten");

        }
    }
}