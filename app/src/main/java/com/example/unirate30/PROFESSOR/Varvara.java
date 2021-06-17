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

public class Varvara extends AppCompatActivity implements View.OnClickListener {

    Button varvbutton20;
    RatingBar varvbar1;
    RatingBar varvbar2;
    RatingBar varvbar3;
    RatingBar varvbar4;
    RatingBar varvbar5;
    RatingBar varvbar6;
    RatingBar varvbar7;
    RatingBar varvbar8;
    RatingBar varvbar9;
    RatingBar varvbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varvara);
        db = new ProfBewertDbHelper(Varvara.this);

        varvbar1 = findViewById(R.id.varvratingBar1);
        varvbar1.setVisibility(View.INVISIBLE);
        varvbar2 = findViewById(R.id.varvratingBar3);
        varvbar2.setVisibility(View.INVISIBLE);
        varvbar3 = findViewById(R.id.varvratingBar5);
        varvbar3.setVisibility(View.INVISIBLE);
        varvbar4 = findViewById(R.id.varvratingBar7);
        varvbar4.setVisibility(View.INVISIBLE);
        varvbar5 = findViewById(R.id.varvratingBar9);
        varvbar5.setVisibility(View.INVISIBLE);
        varvbar6 =findViewById(R.id.varvratingBar);
        varvbar6.setVisibility(View.VISIBLE);
        varvbar6.setIsIndicator(true);
        varvbar7 =findViewById(R.id.varvratingBar2);
        varvbar7.setVisibility(View.VISIBLE);
        varvbar7.setIsIndicator(true);
        varvbar8 =findViewById(R.id.varvratingBar4);
        varvbar8.setVisibility(View.VISIBLE);
        varvbar8.setIsIndicator(true);
        varvbar9 =findViewById(R.id.varvratingBar6);
        varvbar9.setVisibility(View.VISIBLE);
        varvbar9.setIsIndicator(true);
        varvbar10 =findViewById(R.id.varvratingBar8);
        varvbar10.setVisibility(View.VISIBLE);
        varvbar10.setIsIndicator(true);

        varvbutton20 = findViewById(R.id.varvbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        varvbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Varvara.this);


        boolean wahr = db.updateData("Varvara",
                Username.getUsername(),
                Math.round(varvbar1.getRating()),
                Math.round(varvbar2.getRating()),
                Math.round(varvbar3.getRating()),
                Math.round(varvbar4.getRating()),
                Math.round(varvbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Varvara.this);
        boolean wahr = db.insertData("Varvara",
                Username.getUsername(),
                (int) varvbar1.getRating(),
                (int) varvbar2.getRating(),
                (int) varvbar3.getRating(),
                (int) varvbar4.getRating(),
                (int) varvbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Varvara", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Varvara", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Varvara", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Varvara.this);
        List<Integer> list = db.getData("Varvara");
        varvbar6.setRating((float)list.get(0));
        varvbar7.setRating((float)list.get(1));
        varvbar8.setRating((float)list.get(2));
        varvbar9.setRating((float)list.get(3));
        varvbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(varvbutton20.getText().toString().equals("Bewerten")) {
            varvbar1.setVisibility(View.VISIBLE);
            varvbar2.setVisibility(View.VISIBLE);
            varvbar3.setVisibility(View.VISIBLE);
            varvbar4.setVisibility(View.VISIBLE);
            varvbar5.setVisibility(View.VISIBLE);
            varvbutton20.setText("Speichern");
        }else if(varvbutton20.getText().toString().equals("Speichern")){


            varvbar1.setVisibility(View.INVISIBLE);
            varvbar2.setVisibility(View.INVISIBLE);
            varvbar3.setVisibility(View.INVISIBLE);
            varvbar4.setVisibility(View.INVISIBLE);
            varvbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            varvbutton20.setText("Bewerten");

        }
    }
}
