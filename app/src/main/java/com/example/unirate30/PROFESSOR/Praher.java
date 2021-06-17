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

public class Praher extends AppCompatActivity implements View.OnClickListener {

    Button praherbutton20;
    RatingBar praherbar, praherbar1, praherbar2, praherbar3, praherbar4, praherbar5, praherbar6, praherbar7, praherbar8, praherbar9;
    ProfBewertDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praher);

        db = new ProfBewertDbHelper(Praher.this,"Praher");

        praherbar = findViewById(R.id.praherratingBar);
        praherbar.setVisibility(View.VISIBLE);
        praherbar.setIsIndicator(true);
        praherbar1 = findViewById(R.id.praherratingBar1);
        praherbar1.setVisibility(View.INVISIBLE);
        praherbar2 = findViewById(R.id.praherratingBar2);
        praherbar2.setVisibility(View.VISIBLE);
        praherbar2.setIsIndicator(true);
        praherbar3 = findViewById(R.id.praherratingBar3);
        praherbar3.setVisibility(View.INVISIBLE);
        praherbar4 = findViewById(R.id.praherratingBar4);
        praherbar4.setVisibility(View.VISIBLE);
        praherbar4.setIsIndicator(true);
        praherbar5 = findViewById(R.id.praherratingBar5);
        praherbar5.setVisibility(View.INVISIBLE);
        praherbar6 = findViewById(R.id.praherratingBar6);
        praherbar6.setVisibility(View.VISIBLE);
        praherbar6.setIsIndicator(true);
        praherbar7 = findViewById(R.id.praherratingBar7);
        praherbar7.setVisibility(View.INVISIBLE);
        praherbar8 = findViewById(R.id.praherratingBar8);
        praherbar8.setVisibility(View.VISIBLE);
        praherbar8.setIsIndicator(true);
        praherbar9 = findViewById(R.id.praherratingBar9);
        praherbar9.setVisibility(View.INVISIBLE);

        praherbutton20 = findViewById(R.id.praherbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        praherbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Praher.this,"Praher");


        boolean wahr = db.updateData("Praher",
                Username.getUsername(),
                Math.round(praherbar1.getRating()),
                Math.round(praherbar3.getRating()),
                Math.round(praherbar5.getRating()),
                Math.round(praherbar7.getRating()),
                Math.round(praherbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Praher.this,"Praher");
        boolean wahr = db.insertData("Praher",
                Username.getUsername(),
                (int) praherbar.getRating(),
                (int) praherbar2.getRating(),
                (int) praherbar4.getRating(),
                (int) praherbar6.getRating(),
                (int) praherbar8.getRating()
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
        if (sharedPreferences.getBoolean("Praher", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Praher", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Praher.this,"Praher");
        List<Integer> list = db.getData("Praher");
        praherbar.setRating((float)list.get(0));
        praherbar2.setRating((float)list.get(1));
        praherbar4.setRating((float)list.get(2));
        praherbar6.setRating((float)list.get(3));
        praherbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(praherbutton20.getText().toString().equals("Bewerten")) {
            praherbar1.setVisibility(View.VISIBLE);
            praherbar3.setVisibility(View.VISIBLE);
            praherbar5.setVisibility(View.VISIBLE);
            praherbar7.setVisibility(View.VISIBLE);
            praherbar9.setVisibility(View.VISIBLE);
            praherbutton20.setText("Speichern");
        }else if(praherbutton20.getText().toString().equals("Speichern")){


            praherbar1.setVisibility(View.INVISIBLE);
            praherbar3.setVisibility(View.INVISIBLE);
            praherbar5.setVisibility(View.INVISIBLE);
            praherbar7.setVisibility(View.INVISIBLE);
            praherbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            praherbutton20.setText("Bewerten");

        }
    }
}