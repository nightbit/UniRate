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

public class Drausch extends AppCompatActivity implements View.OnClickListener {

    Button drauschbutton20;
    RatingBar drauschbar, drauschbar1, drauschbar2, drauschbar3, drauschbar4, drauschbar5, drauschbar6, drauschbar7, drauschbar8, drauschbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drausch);

        db = new ProfBewertDbHelper(Drausch.this,"Drausch");



        drauschbar = findViewById(R.id.drauschratingBar);
        drauschbar.setVisibility(View.VISIBLE);
        drauschbar.setIsIndicator(true);
        drauschbar1 = findViewById(R.id.drauschratingBar1);
        drauschbar1.setVisibility(View.INVISIBLE);
        drauschbar2 = findViewById(R.id.drauschratingBar2);
        drauschbar2.setVisibility(View.VISIBLE);
        drauschbar2.setIsIndicator(true);
        drauschbar3 = findViewById(R.id.drauschratingBar3);
        drauschbar3.setVisibility(View.INVISIBLE);
        drauschbar4 = findViewById(R.id.drauschratingBar4);
        drauschbar4.setVisibility(View.VISIBLE);
        drauschbar4.setIsIndicator(true);
        drauschbar5 = findViewById(R.id.drauschratingBar5);
        drauschbar5.setVisibility(View.INVISIBLE);
        drauschbar6 = findViewById(R.id.drauschratingBar6);
        drauschbar6.setVisibility(View.VISIBLE);
        drauschbar6.setIsIndicator(true);
        drauschbar7 = findViewById(R.id.drauschratingBar7);
        drauschbar7.setVisibility(View.INVISIBLE);
        drauschbar8 = findViewById(R.id.drauschratingBar8);
        drauschbar8.setVisibility(View.VISIBLE);
        drauschbar8.setIsIndicator(true);
        drauschbar9 = findViewById(R.id.drauschratingBar9);
        drauschbar9.setVisibility(View.INVISIBLE);

        drauschbutton20 = findViewById(R.id.drauschbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        drauschbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Drausch.this,"Drausch");


        boolean wahr = db.updateData("Drausch",
                Username.getUsername(),
                Math.round(drauschbar1.getRating()),
                Math.round(drauschbar3.getRating()),
                Math.round(drauschbar5.getRating()),
                Math.round(drauschbar7.getRating()),
                Math.round(drauschbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Drausch.this,"Drausch");
        boolean wahr = db.insertData("Drausch",
                Username.getUsername(),
                (int) drauschbar.getRating(),
                (int) drauschbar2.getRating(),
                (int) drauschbar4.getRating(),
                (int) drauschbar6.getRating(),
                (int) drauschbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Drausch", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Drausch", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Drausch", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Drausch.this,"Drausch");
        List<Integer> list = db.getData("Drausch");
        drauschbar.setRating((float)list.get(0));
        drauschbar2.setRating((float)list.get(1));
        drauschbar4.setRating((float)list.get(2));
        drauschbar6.setRating((float)list.get(3));
        drauschbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(drauschbutton20.getText().toString().equals("Bewerten")) {
            drauschbar1.setVisibility(View.VISIBLE);
            drauschbar3.setVisibility(View.VISIBLE);
            drauschbar5.setVisibility(View.VISIBLE);
            drauschbar7.setVisibility(View.VISIBLE);
            drauschbar9.setVisibility(View.VISIBLE);
            drauschbutton20.setText("Speichern");
        }else if(drauschbutton20.getText().toString().equals("Speichern")){


            drauschbar1.setVisibility(View.INVISIBLE);
            drauschbar3.setVisibility(View.INVISIBLE);
            drauschbar5.setVisibility(View.INVISIBLE);
            drauschbar7.setVisibility(View.INVISIBLE);
            drauschbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            drauschbutton20.setText("Bewerten");

        }
    }
}



