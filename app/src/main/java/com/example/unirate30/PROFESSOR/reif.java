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

public class reif extends AppCompatActivity implements View.OnClickListener {

    Button reifbutton20;
    RatingBar reifbar1;
    RatingBar reifbar2;
    RatingBar reifbar3;
    RatingBar reifbar4;
    RatingBar reifbar5;
    RatingBar reifbar6;
    RatingBar reifbar7;
    RatingBar reifbar8;
    RatingBar reifbar9;
    RatingBar reifbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reif);
        db = new ProfBewertDbHelper(reif.this,"reif");

        reifbar1 = findViewById(R.id.reifratingBar1);
        reifbar1.setVisibility(View.INVISIBLE);
        reifbar2 = findViewById(R.id.reifratingBar3);
        reifbar2.setVisibility(View.INVISIBLE);
        reifbar3 = findViewById(R.id.reifratingBar5);
        reifbar3.setVisibility(View.INVISIBLE);
        reifbar4 = findViewById(R.id.reifratingBar7);
        reifbar4.setVisibility(View.INVISIBLE);
        reifbar5 = findViewById(R.id.reifratingBar9);
        reifbar5.setVisibility(View.INVISIBLE);
        reifbar6 =findViewById(R.id.reifratingBar);
        reifbar6.setVisibility(View.VISIBLE);
        reifbar6.setIsIndicator(true);
        reifbar7 =findViewById(R.id.reifratingBar2);
        reifbar7.setVisibility(View.VISIBLE);
        reifbar7.setIsIndicator(true);
        reifbar8 =findViewById(R.id.reifratingBar4);
        reifbar8.setVisibility(View.VISIBLE);
        reifbar8.setIsIndicator(true);
        reifbar9 =findViewById(R.id.reifratingBar6);
        reifbar9.setVisibility(View.VISIBLE);
        reifbar9.setIsIndicator(true);
        reifbar10 =findViewById(R.id.reifratingBar8);
        reifbar10.setVisibility(View.VISIBLE);
        reifbar10.setIsIndicator(true);

        reifbutton20 = findViewById(R.id.reifbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
       reifbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(reif.this,"reif");


        boolean wahr = db.updateData("reif",
                Username.getUsername(),
                Math.round(reifbar1.getRating()),
                Math.round(reifbar2.getRating()),
                Math.round(reifbar3.getRating()),
                Math.round(reifbar4.getRating()),
                Math.round(reifbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(reif.this,"reif");
        boolean wahr = db.insertData("reif",
                Username.getUsername(),
                (int) reifbar1.getRating(),
                (int) reifbar2.getRating(),
                (int) reifbar3.getRating(),
                (int) reifbar4.getRating(),
                (int) reifbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("reif", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("reif", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("reif", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(reif.this,"reif");
        List<Integer> list = db.getData("reif");
        reifbar6.setRating((float)list.get(0));
        reifbar7.setRating((float)list.get(1));
        reifbar8.setRating((float)list.get(2));
        reifbar9.setRating((float)list.get(3));
        reifbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(reifbutton20.getText().toString().equals("Bewerten")) {
            reifbar1.setVisibility(View.VISIBLE);
            reifbar2.setVisibility(View.VISIBLE);
            reifbar3.setVisibility(View.VISIBLE);
            reifbar4.setVisibility(View.VISIBLE);
            reifbar5.setVisibility(View.VISIBLE);
            reifbutton20.setText("Speichern");
        }else if(reifbutton20.getText().toString().equals("Speichern")){


            reifbar1.setVisibility(View.INVISIBLE);
            reifbar2.setVisibility(View.INVISIBLE);
            reifbar3.setVisibility(View.INVISIBLE);
            reifbar4.setVisibility(View.INVISIBLE);
            reifbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            reifbutton20.setText("Bewerten");

        }
    }
}