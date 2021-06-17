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

public class pasteka extends AppCompatActivity implements View.OnClickListener {

    Button pastekabutton20;
    RatingBar pastekabar, pastekabar1, pastekabar2, pastekabar3, pastekabar4, pastekabar5, pastekabar6, pastekabar7, pastekabar8, pastekabar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasteka);
        db = new ProfBewertDbHelper(pasteka.this,"pasteka");

        pastekabar = findViewById(R.id.pastekaratingBar);
        pastekabar.setVisibility(View.VISIBLE);
        pastekabar.setIsIndicator(true);
        pastekabar1 = findViewById(R.id.pastekaratingBar1);
        pastekabar1.setVisibility(View.INVISIBLE);
        pastekabar2 = findViewById(R.id.pastekaratingBar2);
        pastekabar2.setVisibility(View.VISIBLE);
        pastekabar2.setIsIndicator(true);
        pastekabar3 = findViewById(R.id.pastekaratingBar3);
        pastekabar3.setVisibility(View.INVISIBLE);
        pastekabar4 = findViewById(R.id.pastekaratingBar4);
        pastekabar4.setVisibility(View.VISIBLE);
        pastekabar4.setIsIndicator(true);
        pastekabar5 = findViewById(R.id.pastekaratingBar5);
        pastekabar5.setVisibility(View.INVISIBLE);
        pastekabar6 = findViewById(R.id.barbratingBar6);
        pastekabar6.setVisibility(View.VISIBLE);
        pastekabar6.setIsIndicator(true);
        pastekabar7 = findViewById(R.id.pastekaratingBar7);
        pastekabar7.setVisibility(View.INVISIBLE);
        pastekabar8 = findViewById(R.id.pastekaratingBar8);
        pastekabar8.setVisibility(View.VISIBLE);
        pastekabar8.setIsIndicator(true);
        pastekabar9 = findViewById(R.id.pastekaratingBar9);
        pastekabar9.setVisibility(View.INVISIBLE);

        pastekabutton20 = findViewById(R.id.pastekabutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        pastekabutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(pasteka.this,"pasteka");


        boolean wahr = db.updateData("pasteka",
                Username.getUsername(),
                Math.round(pastekabar1.getRating()),
                Math.round(pastekabar3.getRating()),
                Math.round(pastekabar5.getRating()),
                Math.round(pastekabar7.getRating()),
                Math.round(pastekabar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(pasteka.this,"pasteka");
        boolean wahr = db.insertData("pasteka",
                Username.getUsername(),
                (int) pastekabar.getRating(),
                (int) pastekabar2.getRating(),
                (int) pastekabar4.getRating(),
                (int) pastekabar6.getRating(),
                (int) pastekabar8.getRating()
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
        if (sharedPreferences.getBoolean("pasteka", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("pasteka", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(pasteka.this,"pasteka");
        List<Integer> list = db.getData("pasteka");
        pastekabar.setRating((float)list.get(0));
        pastekabar2.setRating((float)list.get(1));
        pastekabar4.setRating((float)list.get(2));
        pastekabar6.setRating((float)list.get(3));
        pastekabar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(pastekabutton20.getText().toString().equals("Bewerten")) {
            pastekabar1.setVisibility(View.VISIBLE);
            pastekabar3.setVisibility(View.VISIBLE);
            pastekabar5.setVisibility(View.VISIBLE);
            pastekabar7.setVisibility(View.VISIBLE);
            pastekabar9.setVisibility(View.VISIBLE);
            pastekabutton20.setText("Speichern");
        }else if(pastekabutton20.getText().toString().equals("Speichern")){


            pastekabar1.setVisibility(View.INVISIBLE);
            pastekabar3.setVisibility(View.INVISIBLE);
            pastekabar5.setVisibility(View.INVISIBLE);
            pastekabar7.setVisibility(View.INVISIBLE);
            pastekabar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            pastekabutton20.setText("Bewerten");

        }
    }
}