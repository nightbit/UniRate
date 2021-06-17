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

public class urbauer extends AppCompatActivity implements View.OnClickListener {

    Button urbbutton20;
    RatingBar urbbar1;
    RatingBar urbbar2;
    RatingBar urbbar3;
    RatingBar urbbar4;
    RatingBar urbbar5;
    RatingBar urbbar6;
    RatingBar urbbar7;
    RatingBar urbbar8;
    RatingBar urbbar9;
    RatingBar urbbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urbauer);
        db = new ProfBewertDbHelper(urbauer.this,"urbauer");

        urbbar1 = findViewById(R.id.chanratingBar1);
        urbbar1.setVisibility(View.INVISIBLE);
        urbbar2 = findViewById(R.id.chanratingBar3);
        urbbar2.setVisibility(View.INVISIBLE);
        urbbar3 = findViewById(R.id.chanratingBar5);
        urbbar3.setVisibility(View.INVISIBLE);
        urbbar4 = findViewById(R.id.chanratingBar7);
        urbbar4.setVisibility(View.INVISIBLE);
        urbbar5 = findViewById(R.id.chanratingBar9);
        urbbar5.setVisibility(View.INVISIBLE);
        urbbar6 =findViewById(R.id.chanratingBar);
        urbbar6.setVisibility(View.VISIBLE);
        urbbar6.setIsIndicator(true);
        urbbar7 =findViewById(R.id.chanratingBar2);
        urbbar7.setVisibility(View.VISIBLE);
        urbbar7.setIsIndicator(true);
        urbbar8 =findViewById(R.id.chanratingBar4);
        urbbar8.setVisibility(View.VISIBLE);
        urbbar8.setIsIndicator(true);
        urbbar9 =findViewById(R.id.chanratingBar6);
        urbbar9.setVisibility(View.VISIBLE);
        urbbar9.setIsIndicator(true);
        urbbar10 =findViewById(R.id.chanratingBar8);
        urbbar10.setVisibility(View.VISIBLE);
        urbbar10.setIsIndicator(true);

        urbbutton20 = findViewById(R.id.urbbutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        urbbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(urbauer.this,"urbauer");


        boolean wahr = db.updateData("urbauer",
                Username.getUsername(),
                Math.round(urbbar1.getRating()),
                Math.round(urbbar2.getRating()),
                Math.round(urbbar3.getRating()),
                Math.round(urbbar4.getRating()),
                Math.round(urbbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(urbauer.this,"urbauer");
        boolean wahr = db.insertData("urbauer",
                Username.getUsername(),
                (int) urbbar1.getRating(),
                (int) urbbar2.getRating(),
                (int) urbbar3.getRating(),
                (int) urbbar4.getRating(),
                (int) urbbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("urbauer", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("urbauer", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("urbauer", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(urbauer.this,"urbauer");
        List<Integer> list = db.getData("urbauer");
        urbbar6.setRating((float)list.get(0));
        urbbar7.setRating((float)list.get(1));
        urbbar8.setRating((float)list.get(2));
        urbbar9.setRating((float)list.get(3));
        urbbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(urbbutton20.getText().toString().equals("Bewerten")) {
            urbbar1.setVisibility(View.VISIBLE);
            urbbar2.setVisibility(View.VISIBLE);
            urbbar3.setVisibility(View.VISIBLE);
            urbbar4.setVisibility(View.VISIBLE);
            urbbar5.setVisibility(View.VISIBLE);
            urbbutton20.setText("Speichern");
        }else if(urbbutton20.getText().toString().equals("Speichern")){


            urbbar1.setVisibility(View.INVISIBLE);
            urbbar2.setVisibility(View.INVISIBLE);
            urbbar3.setVisibility(View.INVISIBLE);
            urbbar4.setVisibility(View.INVISIBLE);
            urbbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            urbbutton20.setText("Bewerten");

        }
    }
}