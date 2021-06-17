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

public class maierhofer extends AppCompatActivity implements View.OnClickListener {

    Button mairhoferbutton20;
    RatingBar mairhoferbar, mairhoferbar1, mairhoferbar2, mairhoferbar3, mairhoferbar4, mairhoferbar5, mairhoferbar6, mairhoferbar7, mairhoferbar8, mairhoferbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maierhofer);
        db = new ProfBewertDbHelper(maierhofer.this,"maierhofer");

        mairhoferbar = findViewById(R.id.maierhoferratingBar);
        mairhoferbar.setVisibility(View.VISIBLE);
        mairhoferbar.setIsIndicator(true);
        mairhoferbar1 = findViewById(R.id.maierhoferratingBar1);
        mairhoferbar1.setVisibility(View.INVISIBLE);
        mairhoferbar2 = findViewById(R.id.maierhoferratingBar2);
        mairhoferbar2.setVisibility(View.VISIBLE);
        mairhoferbar2.setIsIndicator(true);
        mairhoferbar3 = findViewById(R.id.maierhoferratingBar3);
        mairhoferbar3.setVisibility(View.INVISIBLE);
        mairhoferbar4 = findViewById(R.id.maierhoferratingBar4);
        mairhoferbar4.setVisibility(View.VISIBLE);
        mairhoferbar4.setIsIndicator(true);
        mairhoferbar5 = findViewById(R.id.maierhoferratingBar5);
        mairhoferbar5.setVisibility(View.INVISIBLE);
        mairhoferbar6 = findViewById(R.id.maierhoferratingBar6);
        mairhoferbar6.setVisibility(View.VISIBLE);
        mairhoferbar6.setIsIndicator(true);
        mairhoferbar7 = findViewById(R.id.maierhoferratingBar7);
        mairhoferbar7.setVisibility(View.INVISIBLE);
        mairhoferbar8 = findViewById(R.id.maierhoferratingBar8);
        mairhoferbar8.setVisibility(View.VISIBLE);
        mairhoferbar8.setIsIndicator(true);
        mairhoferbar9 = findViewById(R.id.maierhoferratingBar9);
        mairhoferbar9.setVisibility(View.INVISIBLE);

        mairhoferbutton20 = findViewById(R.id.maierhoferbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        mairhoferbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(maierhofer.this,"maierhofer");


        boolean wahr = db.updateData("maierhofer",
                Username.getUsername(),
                Math.round(mairhoferbar1.getRating()),
                Math.round(mairhoferbar3.getRating()),
                Math.round(mairhoferbar5.getRating()),
                Math.round(mairhoferbar7.getRating()),
                Math.round(mairhoferbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(maierhofer.this,"maierhofer");
        boolean wahr = db.insertData("maierhofer",
                Username.getUsername(),
                (int) mairhoferbar.getRating(),
                (int) mairhoferbar2.getRating(),
                (int) mairhoferbar4.getRating(),
                (int) mairhoferbar6.getRating(),
                (int) mairhoferbar8.getRating()
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
        if (sharedPreferences.getBoolean("maierhofer", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("maierhofer", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(maierhofer.this,"maierhofer");
        List<Integer> list = db.getData("maierhofer");
        mairhoferbar.setRating((float)list.get(0));
        mairhoferbar2.setRating((float)list.get(1));
        mairhoferbar4.setRating((float)list.get(2));
        mairhoferbar6.setRating((float)list.get(3));
        mairhoferbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(mairhoferbutton20.getText().toString().equals("Bewerten")) {
            mairhoferbar1.setVisibility(View.VISIBLE);
            mairhoferbar3.setVisibility(View.VISIBLE);
            mairhoferbar5.setVisibility(View.VISIBLE);
            mairhoferbar7.setVisibility(View.VISIBLE);
            mairhoferbar9.setVisibility(View.VISIBLE);
            mairhoferbutton20.setText("Speichern");
        }else if(mairhoferbutton20.getText().toString().equals("Speichern")){


            mairhoferbar1.setVisibility(View.INVISIBLE);
            mairhoferbar3.setVisibility(View.INVISIBLE);
            mairhoferbar5.setVisibility(View.INVISIBLE);
            mairhoferbar7.setVisibility(View.INVISIBLE);
            mairhoferbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            mairhoferbutton20.setText("Bewerten");

        }
    }
}