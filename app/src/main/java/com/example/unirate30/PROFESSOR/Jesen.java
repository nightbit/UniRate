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

public class Jesen extends AppCompatActivity implements View.OnClickListener {

    Button jesenbutton20;
    RatingBar jesenbar, jesenbar1, jesenbar2, jesenbar3, jesenbar4, jesenbar5, jesenbar6, jesenbar7, jesenbar8, jesenbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jesen);
        db = new ProfBewertDbHelper(Jesen.this);

        jesenbar = findViewById(R.id.jesenratingBar);
        jesenbar.setVisibility(View.VISIBLE);
        jesenbar.setIsIndicator(true);
        jesenbar1 = findViewById(R.id.jesenratingBar1);
        jesenbar1.setVisibility(View.INVISIBLE);
        jesenbar2 = findViewById(R.id.jesenratingBar2);
        jesenbar2.setVisibility(View.VISIBLE);
        jesenbar2.setIsIndicator(true);
        jesenbar3 = findViewById(R.id.jesenratingBar3);
        jesenbar3.setVisibility(View.INVISIBLE);
        jesenbar4 = findViewById(R.id.jesenratingBar4);
        jesenbar4.setVisibility(View.VISIBLE);
        jesenbar4.setIsIndicator(true);
        jesenbar5 = findViewById(R.id.jesenratingBar5);
        jesenbar5.setVisibility(View.INVISIBLE);
        jesenbar6 = findViewById(R.id.jesenratingBar6);
        jesenbar6.setVisibility(View.VISIBLE);
        jesenbar6.setIsIndicator(true);
        jesenbar7 = findViewById(R.id.jesenratingBar7);
        jesenbar7.setVisibility(View.INVISIBLE);
        jesenbar8 = findViewById(R.id.jesenratingBar8);
        jesenbar8.setVisibility(View.VISIBLE);
        jesenbar8.setIsIndicator(true);
        jesenbar9 = findViewById(R.id.jesenratingBar9);
        jesenbar9.setVisibility(View.INVISIBLE);

        jesenbutton20 = findViewById(R.id.jesenbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        jesenbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Jesen.this);


        boolean wahr = db.updateData("Jesen",
                Username.getUsername(),
                Math.round(jesenbar1.getRating()),
                Math.round(jesenbar3.getRating()),
                Math.round(jesenbar5.getRating()),
                Math.round(jesenbar7.getRating()),
                Math.round(jesenbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Jesen.this);
        boolean wahr = db.insertData("Jesen",
                Username.getUsername(),
                (int) jesenbar.getRating(),
                (int) jesenbar2.getRating(),
                (int) jesenbar4.getRating(),
                (int) jesenbar6.getRating(),
                (int) jesenbar8.getRating()
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
        if (sharedPreferences.getBoolean("Jesen", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Jesen", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Jesen.this);
        List<Integer> list = db.getData("Jesen");
        jesenbar.setRating((float)list.get(0));
        jesenbar2.setRating((float)list.get(1));
        jesenbar4.setRating((float)list.get(2));
        jesenbar6.setRating((float)list.get(3));
        jesenbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(jesenbutton20.getText().toString().equals("Bewerten")) {
            jesenbar1.setVisibility(View.VISIBLE);
            jesenbar3.setVisibility(View.VISIBLE);
            jesenbar5.setVisibility(View.VISIBLE);
            jesenbar7.setVisibility(View.VISIBLE);
            jesenbar9.setVisibility(View.VISIBLE);
            jesenbutton20.setText("Speichern");
        }else if(jesenbutton20.getText().toString().equals("Speichern")){


            jesenbar1.setVisibility(View.INVISIBLE);
            jesenbar3.setVisibility(View.INVISIBLE);
            jesenbar5.setVisibility(View.INVISIBLE);
            jesenbar7.setVisibility(View.INVISIBLE);
            jesenbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            jesenbutton20.setText("Bewerten");

        }
    }
}