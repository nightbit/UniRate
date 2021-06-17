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

public class Balz extends AppCompatActivity implements View.OnClickListener {

    Button balzbutton20;
    RatingBar balzbar, balzbar1, balzbar2, balzbar3, balzbar4, balzbar5, balzbar6, balzbar7, balzbar8, balzbar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balz);
        db = new ProfBewertDbHelper(Balz.this);



        balzbar = findViewById(R.id.balzratingBar);
        balzbar.setVisibility(View.VISIBLE);
        balzbar.setIsIndicator(true);
        balzbar1 = findViewById(R.id.balzratingBar1);
        balzbar1.setVisibility(View.INVISIBLE);
        balzbar2 = findViewById(R.id.balzratingBar2);
        balzbar2.setVisibility(View.VISIBLE);
        balzbar2.setIsIndicator(true);
        balzbar3 = findViewById(R.id.balzratingBar3);
        balzbar3.setVisibility(View.INVISIBLE);
        balzbar4 = findViewById(R.id.balzratingBar4);
        balzbar4.setVisibility(View.VISIBLE);
        balzbar4.setIsIndicator(true);
        balzbar5 = findViewById(R.id.balzratingBar5);
        balzbar5.setVisibility(View.INVISIBLE);
        balzbar6 = findViewById(R.id.balzratingBar6);
        balzbar6.setVisibility(View.VISIBLE);
        balzbar6.setIsIndicator(true);
        balzbar7 = findViewById(R.id.balzratingBar7);
        balzbar7.setVisibility(View.INVISIBLE);
        balzbar8 = findViewById(R.id.balzratingBar8);
        balzbar8.setVisibility(View.VISIBLE);
        balzbar8.setIsIndicator(true);
        balzbar9 = findViewById(R.id.balzratingBar9);
        balzbar9.setVisibility(View.INVISIBLE);

        balzbutton20 = findViewById(R.id.balzbutton6);



        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        balzbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Balz.this);


        boolean wahr = db.updateData("Balz",
                Username.getUsername(),
                Math.round(balzbar1.getRating()),
                Math.round(balzbar3.getRating()),
                Math.round(balzbar5.getRating()),
                Math.round(balzbar7.getRating()),
                Math.round(balzbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Balz.this);
        boolean wahr = db.insertData("Balz",
                Username.getUsername(),
                (int) balzbar.getRating(),
                (int) balzbar2.getRating(),
                (int) balzbar4.getRating(),
                (int) balzbar6.getRating(),
                (int) balzbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Balz", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Balz", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Balz", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Balz.this);
        List<Integer> list = db.getData("Balz");
        balzbar.setRating((float)list.get(0));
        balzbar2.setRating((float)list.get(1));
        balzbar4.setRating((float)list.get(2));
        balzbar6.setRating((float)list.get(3));
        balzbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(balzbutton20.getText().toString().equals("Bewerten")) {
            balzbar1.setVisibility(View.VISIBLE);
            balzbar3.setVisibility(View.VISIBLE);
            balzbar5.setVisibility(View.VISIBLE);
            balzbar7.setVisibility(View.VISIBLE);
            balzbar9.setVisibility(View.VISIBLE);
            balzbutton20.setText("Speichern");
        }else if(balzbutton20.getText().toString().equals("Speichern")){


            balzbar1.setVisibility(View.INVISIBLE);
            balzbar3.setVisibility(View.INVISIBLE);
            balzbar5.setVisibility(View.INVISIBLE);
            balzbar7.setVisibility(View.INVISIBLE);
            balzbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            balzbutton20.setText("Bewerten");

        }
    }
}

