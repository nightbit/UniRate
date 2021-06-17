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

public class Vander extends AppCompatActivity implements View.OnClickListener {

    Button chanbutton20;
    RatingBar chanbar1;
    RatingBar chanbar2;
    RatingBar chanbar3;
    RatingBar chanbar4;
    RatingBar chanbar5;
    RatingBar chanbar6;
    RatingBar chanbar7;
    RatingBar chanbar8;
    RatingBar chanbar9;
    RatingBar chanbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vander);
        db = new ProfBewertDbHelper(Vander.this,"Vander");

        chanbar1 = findViewById(R.id.chanratingBar1);
        chanbar1.setVisibility(View.INVISIBLE);
        chanbar2 = findViewById(R.id.chanratingBar3);
        chanbar2.setVisibility(View.INVISIBLE);
        chanbar3 = findViewById(R.id.chanratingBar5);
        chanbar3.setVisibility(View.INVISIBLE);
        chanbar4 = findViewById(R.id.chanratingBar7);
        chanbar4.setVisibility(View.INVISIBLE);
        chanbar5 = findViewById(R.id.chanratingBar9);
        chanbar5.setVisibility(View.INVISIBLE);
        chanbar6 =findViewById(R.id.chanratingBar);
        chanbar6.setVisibility(View.VISIBLE);
        chanbar6.setIsIndicator(true);
        chanbar7 =findViewById(R.id.chanratingBar2);
        chanbar7.setVisibility(View.VISIBLE);
        chanbar7.setIsIndicator(true);
        chanbar8 =findViewById(R.id.chanratingBar4);
        chanbar8.setVisibility(View.VISIBLE);
        chanbar8.setIsIndicator(true);
        chanbar9 =findViewById(R.id.chanratingBar6);
        chanbar9.setVisibility(View.VISIBLE);
        chanbar9.setIsIndicator(true);
        chanbar10 =findViewById(R.id.chanratingBar8);
        chanbar10.setVisibility(View.VISIBLE);
        chanbar10.setIsIndicator(true);

        chanbutton20 = findViewById(R.id.chanbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        chanbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Vander.this,"Vander");


        boolean wahr = db.updateData("Vander",
                Username.getUsername(),
                Math.round(chanbar1.getRating()),
                Math.round(chanbar2.getRating()),
                Math.round(chanbar3.getRating()),
                Math.round(chanbar4.getRating()),
                Math.round(chanbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Vander.this,"Vander");
        boolean wahr = db.insertData("Vander",
                Username.getUsername(),
                (int) chanbar1.getRating(),
                (int) chanbar2.getRating(),
                (int) chanbar3.getRating(),
                (int) chanbar4.getRating(),
                (int) chanbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Vander", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Vander", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Vander", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Vander.this,"Vander");
        List<Integer> list = db.getData("Vander");
        chanbar6.setRating((float)list.get(0));
        chanbar7.setRating((float)list.get(1));
        chanbar8.setRating((float)list.get(2));
        chanbar9.setRating((float)list.get(3));
        chanbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(chanbutton20.getText().toString().equals("Bewerten")) {
            chanbar1.setVisibility(View.VISIBLE);
            chanbar2.setVisibility(View.VISIBLE);
            chanbar3.setVisibility(View.VISIBLE);
            chanbar4.setVisibility(View.VISIBLE);
            chanbar5.setVisibility(View.VISIBLE);
            chanbutton20.setText("Speichern");
        }else if(chanbutton20.getText().toString().equals("Speichern")){


            chanbar1.setVisibility(View.INVISIBLE);
            chanbar2.setVisibility(View.INVISIBLE);
            chanbar3.setVisibility(View.INVISIBLE);
            chanbar4.setVisibility(View.INVISIBLE);
            chanbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            chanbutton20.setText("Bewerten");

        }
    }
}