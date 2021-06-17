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

public class Wiessner extends AppCompatActivity implements View.OnClickListener {

    Button wiessbutton20;
    RatingBar wiessbar1;
    RatingBar wiessbar2;
    RatingBar wiessbar3;
    RatingBar wiessbar4;
    RatingBar wiessbar5;
    RatingBar wiessbar6;
    RatingBar wiessbar7;
    RatingBar wiessbar8;
    RatingBar wiessbar9;
    RatingBar wiessbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiessner);
        db = new ProfBewertDbHelper(Wiessner.this);


        wiessbar1 = findViewById(R.id.wiessratingBar1);
        wiessbar1.setVisibility(View.INVISIBLE);
        wiessbar2 = findViewById(R.id.wiessratingBar3);
        wiessbar2.setVisibility(View.INVISIBLE);
        wiessbar3 = findViewById(R.id.wiessratingBar5);
        wiessbar3.setVisibility(View.INVISIBLE);
        wiessbar4 = findViewById(R.id.wiessratingBar7);
        wiessbar4.setVisibility(View.INVISIBLE);
        wiessbar5 = findViewById(R.id.wiessratingBar9);
        wiessbar5.setVisibility(View.INVISIBLE);
        wiessbar6 =findViewById(R.id.wiessratingBar);
        wiessbar6.setVisibility(View.VISIBLE);
        wiessbar6.setIsIndicator(true);
        wiessbar7 =findViewById(R.id.wiessratingBar2);
        wiessbar7.setVisibility(View.VISIBLE);
        wiessbar7.setIsIndicator(true);
        wiessbar8 =findViewById(R.id.wiessratingBar4);
        wiessbar8.setVisibility(View.VISIBLE);
        wiessbar8.setIsIndicator(true);
        wiessbar9 =findViewById(R.id.wiessratingBar6);
        wiessbar9.setVisibility(View.VISIBLE);
        wiessbar9.setIsIndicator(true);
        wiessbar10 =findViewById(R.id.wiessratingBar8);
        wiessbar10.setVisibility(View.VISIBLE);
        wiessbar10.setIsIndicator(true);

        wiessbutton20 = findViewById(R.id.wiessbutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        wiessbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Wiessner.this);


        boolean wahr = db.updateData("Wiessner",
                Username.getUsername(),
                Math.round(wiessbar1.getRating()),
                Math.round(wiessbar2.getRating()),
                Math.round(wiessbar3.getRating()),
                Math.round(wiessbar4.getRating()),
                Math.round(wiessbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Wiessner.this);
        boolean wahr = db.insertData("Wiessner",
                Username.getUsername(),
                (int) wiessbar1.getRating(),
                (int) wiessbar2.getRating(),
                (int) wiessbar3.getRating(),
                (int) wiessbar4.getRating(),
                (int) wiessbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Wiessner", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Wiessner", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Wiessner", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Wiessner.this);
        List<Integer> list = db.getData("Wiessner");
        wiessbar6.setRating((float)list.get(0));
        wiessbar7.setRating((float)list.get(1));
        wiessbar8.setRating((float)list.get(2));
        wiessbar9.setRating((float)list.get(3));
        wiessbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(wiessbutton20.getText().toString().equals("Bewerten")) {
            wiessbar1.setVisibility(View.VISIBLE);
            wiessbar2.setVisibility(View.VISIBLE);
            wiessbar3.setVisibility(View.VISIBLE);
            wiessbar4.setVisibility(View.VISIBLE);
            wiessbar5.setVisibility(View.VISIBLE);
            wiessbutton20.setText("Speichern");
        }else if(wiessbutton20.getText().toString().equals("Speichern")){


            wiessbar1.setVisibility(View.INVISIBLE);
            wiessbar2.setVisibility(View.INVISIBLE);
            wiessbar3.setVisibility(View.INVISIBLE);
            wiessbar4.setVisibility(View.INVISIBLE);
            wiessbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            wiessbutton20.setText("Bewerten");

        }
    }
}