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

public class dreiner extends AppCompatActivity implements View.OnClickListener {

    Button dreinerbutton20;
    RatingBar dreinerbar, dreinerbar1, dreinerbar2, dreinerbar3, dreinerbar4, dreinerbar5, dreinerbar6, dreinerbar7, dreinerbar8, dreinerbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreiner);
        db = new ProfBewertDbHelper(dreiner.this);



        dreinerbar = findViewById(R.id.dreinerratingBar);
        dreinerbar.setVisibility(View.VISIBLE);
        dreinerbar.setIsIndicator(true);
        dreinerbar1 = findViewById(R.id.dreinerratingBar1);
        dreinerbar1.setVisibility(View.INVISIBLE);
        dreinerbar2 = findViewById(R.id.dreinerratingBar2);
        dreinerbar2.setVisibility(View.VISIBLE);
        dreinerbar2.setIsIndicator(true);
        dreinerbar3 = findViewById(R.id.dreinerratingBar3);
        dreinerbar3.setVisibility(View.INVISIBLE);
        dreinerbar4 = findViewById(R.id.dreinerratingBar4);
        dreinerbar4.setVisibility(View.VISIBLE);
        dreinerbar4.setIsIndicator(true);
        dreinerbar5 = findViewById(R.id.dreinerratingBar5);
        dreinerbar5.setVisibility(View.INVISIBLE);
        dreinerbar6 = findViewById(R.id.dreinerratingBar6);
        dreinerbar6.setVisibility(View.VISIBLE);
        dreinerbar6.setIsIndicator(true);
        dreinerbar7 = findViewById(R.id.dreinerratingBar7);
        dreinerbar7.setVisibility(View.INVISIBLE);
        dreinerbar8 = findViewById(R.id.dreinerratingBar8);
        dreinerbar8.setVisibility(View.VISIBLE);
        dreinerbar8.setIsIndicator(true);
        dreinerbar9 = findViewById(R.id.dreinerratingBar9);
        dreinerbar9.setVisibility(View.INVISIBLE);

        dreinerbutton20 = findViewById(R.id.dreinerbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        dreinerbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(dreiner.this);


        boolean wahr = db.updateData("dreiner",
                Username.getUsername(),
                Math.round(dreinerbar1.getRating()),
                Math.round(dreinerbar3.getRating()),
                Math.round(dreinerbar5.getRating()),
                Math.round(dreinerbar7.getRating()),
                Math.round(dreinerbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(dreiner.this);
        boolean wahr = db.insertData("dreiner",
                Username.getUsername(),
                (int) dreinerbar.getRating(),
                (int) dreinerbar2.getRating(),
                (int) dreinerbar4.getRating(),
                (int) dreinerbar6.getRating(),
                (int) dreinerbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("dreiner", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("dreiner", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("dreiner", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(dreiner.this);
        List<Integer> list = db.getData("dreiner");
        dreinerbar.setRating((float)list.get(0));
        dreinerbar2.setRating((float)list.get(1));
        dreinerbar4.setRating((float)list.get(2));
        dreinerbar6.setRating((float)list.get(3));
        dreinerbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(dreinerbutton20.getText().toString().equals("Bewerten")) {
            dreinerbar1.setVisibility(View.VISIBLE);
            dreinerbar3.setVisibility(View.VISIBLE);
            dreinerbar5.setVisibility(View.VISIBLE);
            dreinerbar7.setVisibility(View.VISIBLE);
            dreinerbar9.setVisibility(View.VISIBLE);
            dreinerbutton20.setText("Speichern");
        }else if(dreinerbutton20.getText().toString().equals("Speichern")){


            dreinerbar1.setVisibility(View.INVISIBLE);
            dreinerbar3.setVisibility(View.INVISIBLE);
            dreinerbar5.setVisibility(View.INVISIBLE);
            dreinerbar7.setVisibility(View.INVISIBLE);
            dreinerbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            dreinerbutton20.setText("Bewerten");

        }
    }
}



