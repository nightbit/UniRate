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

public class mohl extends AppCompatActivity implements View.OnClickListener {

    Button mohlbutton20;
    RatingBar mohlbar, mohlbar1, mohlbar2, mohlbar3, mohlbar4, mohlbar5, mohlbar6, mohlbar7, mohlbar8, mohlbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mohl);

        db = new ProfBewertDbHelper(mohl.this);

        mohlbar = findViewById(R.id.mohlratingBar);
        mohlbar.setVisibility(View.VISIBLE);
        mohlbar.setIsIndicator(true);
        mohlbar1 = findViewById(R.id.mohlratingBar1);
        mohlbar1.setVisibility(View.INVISIBLE);
        mohlbar2 = findViewById(R.id.mohlratingBar2);
        mohlbar2.setVisibility(View.VISIBLE);
        mohlbar2.setIsIndicator(true);
        mohlbar3 = findViewById(R.id.mohlratingBar3);
        mohlbar3.setVisibility(View.INVISIBLE);
        mohlbar4 = findViewById(R.id.mohlratingBar4);
        mohlbar4.setVisibility(View.VISIBLE);
        mohlbar4.setIsIndicator(true);
        mohlbar5 = findViewById(R.id.mohlratingBar5);
        mohlbar5.setVisibility(View.INVISIBLE);
        mohlbar6 = findViewById(R.id.mohlratingBar6);
        mohlbar6.setVisibility(View.VISIBLE);
        mohlbar6.setIsIndicator(true);
        mohlbar7 = findViewById(R.id.mohlratingBar7);
        mohlbar7.setVisibility(View.INVISIBLE);
        mohlbar8 = findViewById(R.id.mohlratingBar8);
        mohlbar8.setVisibility(View.VISIBLE);
        mohlbar8.setIsIndicator(true);
        mohlbar9 = findViewById(R.id.mohlratingBar9);
        mohlbar9.setVisibility(View.INVISIBLE);

        mohlbutton20 = findViewById(R.id.mohlbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        mohlbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(mohl.this);


        boolean wahr = db.updateData("mohl",
                Username.getUsername(),
                Math.round(mohlbar1.getRating()),
                Math.round(mohlbar3.getRating()),
                Math.round(mohlbar5.getRating()),
                Math.round(mohlbar7.getRating()),
                Math.round(mohlbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(mohl.this);
        boolean wahr = db.insertData("mohl",
                Username.getUsername(),
                (int) mohlbar.getRating(),
                (int) mohlbar2.getRating(),
                (int) mohlbar4.getRating(),
                (int) mohlbar6.getRating(),
                (int) mohlbar8.getRating()
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
        if (sharedPreferences.getBoolean("mohl", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("mohl", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(mohl.this);
        List<Integer> list = db.getData("mohl");
        mohlbar.setRating((float)list.get(0));
        mohlbar2.setRating((float)list.get(1));
        mohlbar4.setRating((float)list.get(2));
        mohlbar6.setRating((float)list.get(3));
        mohlbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(mohlbutton20.getText().toString().equals("Bewerten")) {
            mohlbar1.setVisibility(View.VISIBLE);
            mohlbar3.setVisibility(View.VISIBLE);
            mohlbar5.setVisibility(View.VISIBLE);
            mohlbar7.setVisibility(View.VISIBLE);
            mohlbar9.setVisibility(View.VISIBLE);
            mohlbutton20.setText("Speichern");
        }else if(mohlbutton20.getText().toString().equals("Speichern")){


            mohlbar1.setVisibility(View.INVISIBLE);
            mohlbar3.setVisibility(View.INVISIBLE);
            mohlbar5.setVisibility(View.INVISIBLE);
            mohlbar7.setVisibility(View.INVISIBLE);
            mohlbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            mohlbutton20.setText("Bewerten");

        }
    }
}

