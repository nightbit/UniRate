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

public class Nemec extends AppCompatActivity implements View.OnClickListener {

    Button nemecbutton20;
    RatingBar nemecbar, nemecbar1, nemecbar2, nemecbar3, nemecbar4, nemecbar5, nemecbar6, nemecbar7, nemecbar8, nemecbar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nemec);

        db = new ProfBewertDbHelper(Nemec.this,"Nemec");

        nemecbar = findViewById(R.id.nemecratingBar);
        nemecbar.setVisibility(View.VISIBLE);
        nemecbar.setIsIndicator(true);
        nemecbar1 = findViewById(R.id.nemecratingBar1);
        nemecbar1.setVisibility(View.INVISIBLE);
        nemecbar2 = findViewById(R.id.nemecratingBar2);
        nemecbar2.setVisibility(View.VISIBLE);
        nemecbar2.setIsIndicator(true);
        nemecbar3 = findViewById(R.id.nemecratingBar3);
        nemecbar3.setVisibility(View.INVISIBLE);
        nemecbar4 = findViewById(R.id.nemecratingBar4);
        nemecbar4.setVisibility(View.VISIBLE);
        nemecbar4.setIsIndicator(true);
        nemecbar5 = findViewById(R.id.nemecratingBar5);
        nemecbar5.setVisibility(View.INVISIBLE);
        nemecbar6 = findViewById(R.id.nemecratingBar6);
        nemecbar6.setVisibility(View.VISIBLE);
        nemecbar6.setIsIndicator(true);
        nemecbar7 = findViewById(R.id.nemecratingBar7);
        nemecbar7.setVisibility(View.INVISIBLE);
        nemecbar8 = findViewById(R.id.nemecratingBar8);
        nemecbar8.setVisibility(View.VISIBLE);
        nemecbar8.setIsIndicator(true);
        nemecbar9 = findViewById(R.id.nemecratingBar9);
        nemecbar9.setVisibility(View.INVISIBLE);

        nemecbutton20 = findViewById(R.id.nemecbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        nemecbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Nemec.this,"Nemec");


        boolean wahr = db.updateData("Nemec",
                Username.getUsername(),
                Math.round(nemecbar1.getRating()),
                Math.round(nemecbar3.getRating()),
                Math.round(nemecbar5.getRating()),
                Math.round(nemecbar7.getRating()),
                Math.round(nemecbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Nemec.this,"Nemec");
        boolean wahr = db.insertData("nemec",
                Username.getUsername(),
                (int) nemecbar.getRating(),
                (int) nemecbar2.getRating(),
                (int) nemecbar4.getRating(),
                (int) nemecbar6.getRating(),
                (int) nemecbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("nemec", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("nemec", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("nemec", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Nemec.this,"Nemec");
        List<Integer> list = db.getData("nemec");
        nemecbar.setRating((float)list.get(0));
        nemecbar2.setRating((float)list.get(1));
        nemecbar4.setRating((float)list.get(2));
        nemecbar6.setRating((float)list.get(3));
        nemecbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(nemecbutton20.getText().toString().equals("Bewerten")) {
            nemecbar1.setVisibility(View.VISIBLE);
            nemecbar3.setVisibility(View.VISIBLE);
            nemecbar5.setVisibility(View.VISIBLE);
            nemecbar7.setVisibility(View.VISIBLE);
            nemecbar9.setVisibility(View.VISIBLE);
            nemecbutton20.setText("Speichern");
        }else if(nemecbutton20.getText().toString().equals("Speichern")){


            nemecbar1.setVisibility(View.INVISIBLE);
            nemecbar3.setVisibility(View.INVISIBLE);
            nemecbar5.setVisibility(View.INVISIBLE);
            nemecbar7.setVisibility(View.INVISIBLE);
            nemecbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            nemecbutton20.setText("Bewerten");

        }
    }
}
