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

public class Votzi extends AppCompatActivity implements View.OnClickListener {

    Button votzibutton20;
    RatingBar votzibar1;
    RatingBar votzibar2;
    RatingBar votzibar3;
    RatingBar votzibar4;
    RatingBar votzibar5;
    RatingBar votzibar6;
    RatingBar votzibar7;
    RatingBar votzibar8;
    RatingBar votzibar9;
    RatingBar votzibar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votzi);
        db = new ProfBewertDbHelper(Votzi.this,"Votzi");

        votzibar1 = findViewById(R.id.votziratingBar1);
        votzibar1.setVisibility(View.INVISIBLE);
        votzibar2 = findViewById(R.id.votziratingBar3);
        votzibar2.setVisibility(View.INVISIBLE);
        votzibar3 = findViewById(R.id.votziratingBar5);
        votzibar3.setVisibility(View.INVISIBLE);
        votzibar4 = findViewById(R.id.votziratingBar7);
        votzibar4.setVisibility(View.INVISIBLE);
        votzibar5 = findViewById(R.id.votziratingBar9);
        votzibar5.setVisibility(View.INVISIBLE);
        votzibar6 =findViewById(R.id.votziratingBar);
        votzibar6.setVisibility(View.VISIBLE);
        votzibar6.setIsIndicator(true);
        votzibar7 =findViewById(R.id.votziratingBar2);
        votzibar7.setVisibility(View.VISIBLE);
        votzibar7.setIsIndicator(true);
        votzibar8 =findViewById(R.id.votziratingBar4);
        votzibar8.setVisibility(View.VISIBLE);
        votzibar8.setIsIndicator(true);
        votzibar9 =findViewById(R.id.votziratingBar6);
        votzibar9.setVisibility(View.VISIBLE);
        votzibar9.setIsIndicator(true);
        votzibar10 =findViewById(R.id.votziratingBar8);
        votzibar10.setVisibility(View.VISIBLE);
        votzibar10.setIsIndicator(true);

        votzibutton20 = findViewById(R.id.votzibutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        votzibutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Votzi.this,"Votzi");


        boolean wahr = db.updateData("Votzi",
                Username.getUsername(),
                Math.round(votzibar1.getRating()),
                Math.round(votzibar2.getRating()),
                Math.round(votzibar3.getRating()),
                Math.round(votzibar4.getRating()),
                Math.round(votzibar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Votzi.this,"Votzi");
        boolean wahr = db.insertData("Votzi",
                Username.getUsername(),
                (int) votzibar1.getRating(),
                (int) votzibar2.getRating(),
                (int) votzibar3.getRating(),
                (int) votzibar4.getRating(),
                (int) votzibar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Votzi", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Votzi", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Votzi", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Votzi.this,"Votzi");
        List<Integer> list = db.getData("Votzi");
        votzibar6.setRating((float)list.get(0));
        votzibar7.setRating((float)list.get(1));
        votzibar8.setRating((float)list.get(2));
        votzibar9.setRating((float)list.get(3));
        votzibar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(votzibutton20.getText().toString().equals("Bewerten")) {
            votzibar1.setVisibility(View.VISIBLE);
            votzibar2.setVisibility(View.VISIBLE);
            votzibar3.setVisibility(View.VISIBLE);
            votzibar4.setVisibility(View.VISIBLE);
            votzibar5.setVisibility(View.VISIBLE);
            votzibutton20.setText("Speichern");
        }else if(votzibutton20.getText().toString().equals("Speichern")){


            votzibar1.setVisibility(View.INVISIBLE);
            votzibar2.setVisibility(View.INVISIBLE);
            votzibar3.setVisibility(View.INVISIBLE);
            votzibar4.setVisibility(View.INVISIBLE);
            votzibar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            votzibutton20.setText("Bewerten");

        }
    }
}
