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

public class Filler extends AppCompatActivity implements View.OnClickListener {

    Button fillerbutton20;
    RatingBar fillerbar, fillerbar1, fillerbar2, fillerbar3, fillerbar4, fillerbar5, fillerbar6, fillerbar7, fillerbar8, fillerbar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filler);


        db = new ProfBewertDbHelper(Filler.this,"Filler");

        fillerbar = findViewById(R.id.fillerratingBar);
        fillerbar.setVisibility(View.VISIBLE);
        fillerbar.setIsIndicator(true);
        fillerbar1 = findViewById(R.id.fillerratingBar1);
        fillerbar1.setVisibility(View.INVISIBLE);
        fillerbar2 = findViewById(R.id.fillerratingBar2);
        fillerbar2.setVisibility(View.VISIBLE);
        fillerbar2.setIsIndicator(true);
        fillerbar3 = findViewById(R.id.fillerratingBar3);
        fillerbar3.setVisibility(View.INVISIBLE);
        fillerbar4 = findViewById(R.id.fillerratingBar4);
        fillerbar4.setVisibility(View.VISIBLE);
        fillerbar4.setIsIndicator(true);
        fillerbar5 = findViewById(R.id.fillerratingBar5);
        fillerbar5.setVisibility(View.INVISIBLE);
        fillerbar6 = findViewById(R.id.fillerratingBar6);
        fillerbar6.setVisibility(View.VISIBLE);
        fillerbar6.setIsIndicator(true);
        fillerbar7 = findViewById(R.id.fillerratingBar7);
        fillerbar7.setVisibility(View.INVISIBLE);
        fillerbar8 = findViewById(R.id.fillerratingBar8);
        fillerbar8.setVisibility(View.VISIBLE);
        fillerbar8.setIsIndicator(true);
        fillerbar9 = findViewById(R.id.fillerratingBar9);
        fillerbar9.setVisibility(View.INVISIBLE);

        fillerbutton20 = findViewById(R.id.fillerbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        fillerbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Filler.this,"Filler");


        boolean wahr = db.updateData("Filler",
                Username.getUsername(),
                Math.round(fillerbar1.getRating()),
                Math.round(fillerbar3.getRating()),
                Math.round(fillerbar5.getRating()),
                Math.round(fillerbar7.getRating()),
                Math.round(fillerbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Filler.this,"Filler");
        boolean wahr = db.insertData("Filler",
                Username.getUsername(),
                (int) fillerbar.getRating(),
                (int) fillerbar2.getRating(),
                (int) fillerbar4.getRating(),
                (int) fillerbar6.getRating(),
                (int) fillerbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Filler", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Filler", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Filler", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Filler.this,"Filler");
        List<Integer> list = db.getData("Filler");
        fillerbar.setRating((float)list.get(0));
        fillerbar2.setRating((float)list.get(1));
        fillerbar4.setRating((float)list.get(2));
        fillerbar6.setRating((float)list.get(3));
        fillerbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(fillerbutton20.getText().toString().equals("Bewerten")) {
            fillerbar1.setVisibility(View.VISIBLE);
            fillerbar3.setVisibility(View.VISIBLE);
            fillerbar5.setVisibility(View.VISIBLE);
            fillerbar7.setVisibility(View.VISIBLE);
            fillerbar9.setVisibility(View.VISIBLE);
            fillerbutton20.setText("Speichern");
        }else if(fillerbutton20.getText().toString().equals("Speichern")){


            fillerbar1.setVisibility(View.INVISIBLE);
            fillerbar3.setVisibility(View.INVISIBLE);
            fillerbar5.setVisibility(View.INVISIBLE);
            fillerbar7.setVisibility(View.INVISIBLE);
            fillerbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            fillerbutton20.setText("Bewerten");

        }
    }
}


