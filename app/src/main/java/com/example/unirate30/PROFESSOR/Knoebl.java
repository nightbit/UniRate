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

public class Knoebl extends AppCompatActivity implements View.OnClickListener {

    Button knoeblbutton20;
    RatingBar knoeblbar, knoeblbar1, knoeblbar2, knoeblbar3, knoeblbar4, knoeblbar5, knoeblbar6, knoeblbar7, knoeblbar8, knoeblbar9;
    ProfBewertDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knoebl);

        db = new ProfBewertDbHelper(Knoebl.this,"Knoebl");

        knoeblbar = findViewById(R.id.knoeblratingBar);
        knoeblbar.setVisibility(View.VISIBLE);
        knoeblbar.setIsIndicator(true);
        knoeblbar1 = findViewById(R.id.knoeblratingBar1);
        knoeblbar1.setVisibility(View.INVISIBLE);
        knoeblbar2 = findViewById(R.id.knoeblratingBar2);
        knoeblbar2.setVisibility(View.VISIBLE);
        knoeblbar2.setIsIndicator(true);
        knoeblbar3 = findViewById(R.id.knoeblratingBar3);
        knoeblbar3.setVisibility(View.INVISIBLE);
        knoeblbar4 = findViewById(R.id.knoeblratingBar4);
        knoeblbar4.setVisibility(View.VISIBLE);
        knoeblbar4.setIsIndicator(true);
        knoeblbar5 = findViewById(R.id.knoeblratingBar5);
        knoeblbar5.setVisibility(View.INVISIBLE);
        knoeblbar6 = findViewById(R.id.knoeblratingBar6);
        knoeblbar6.setVisibility(View.VISIBLE);
        knoeblbar6.setIsIndicator(true);
        knoeblbar7 = findViewById(R.id.knoeblratingBar7);
        knoeblbar7.setVisibility(View.INVISIBLE);
        knoeblbar8 = findViewById(R.id.knoeblratingBar8);
        knoeblbar8.setVisibility(View.VISIBLE);
        knoeblbar8.setIsIndicator(true);
        knoeblbar9 = findViewById(R.id.knoeblratingBar9);
        knoeblbar9.setVisibility(View.INVISIBLE);

        knoeblbutton20 = findViewById(R.id.knoeblbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        knoeblbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Knoebl.this,"Knoebl");


        boolean wahr = db.updateData("Knoebl",
                Username.getUsername(),
                Math.round(knoeblbar1.getRating()),
                Math.round(knoeblbar3.getRating()),
                Math.round(knoeblbar5.getRating()),
                Math.round(knoeblbar7.getRating()),
                Math.round(knoeblbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Knoebl.this,"Knoebl");
        boolean wahr = db.insertData("Knoebl",
                Username.getUsername(),
                (int) knoeblbar.getRating(),
                (int) knoeblbar2.getRating(),
                (int) knoeblbar4.getRating(),
                (int) knoeblbar6.getRating(),
                (int) knoeblbar8.getRating()
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
        if (sharedPreferences.getBoolean("Knoebl", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Knoebl", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Knoebl.this,"Knoebl");
        List<Integer> list = db.getData("Knoebl");
        knoeblbar.setRating((float)list.get(0));
        knoeblbar2.setRating((float)list.get(1));
        knoeblbar4.setRating((float)list.get(2));
        knoeblbar6.setRating((float)list.get(3));
        knoeblbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(knoeblbutton20.getText().toString().equals("Bewerten")) {
            knoeblbar1.setVisibility(View.VISIBLE);
            knoeblbar3.setVisibility(View.VISIBLE);
            knoeblbar5.setVisibility(View.VISIBLE);
            knoeblbar7.setVisibility(View.VISIBLE);
            knoeblbar9.setVisibility(View.VISIBLE);
            knoeblbutton20.setText("Speichern");
        }else if(knoeblbutton20.getText().toString().equals("Speichern")){


            knoeblbar1.setVisibility(View.INVISIBLE);
            knoeblbar3.setVisibility(View.INVISIBLE);
            knoeblbar5.setVisibility(View.INVISIBLE);
            knoeblbar7.setVisibility(View.INVISIBLE);
            knoeblbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            knoeblbutton20.setText("Bewerten");

        }
    }
}