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

public class martinek extends AppCompatActivity implements View.OnClickListener {

    Button martinekbutton20;
    RatingBar martinekbar, martinekbar1, martinekbar2, martinekbar3, martinekbar4, martinekbar5, martinekbar6, martinekbar7, martinekbar8, martinekbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_martinek);

        db = new ProfBewertDbHelper(martinek.this);

        martinekbar = findViewById(R.id.martinekratingBar);
        martinekbar.setVisibility(View.VISIBLE);
        martinekbar.setIsIndicator(true);
        martinekbar1 = findViewById(R.id.martinekratingBar1);
        martinekbar1.setVisibility(View.INVISIBLE);
        martinekbar2 = findViewById(R.id.martinekratingBar2);
        martinekbar2.setVisibility(View.VISIBLE);
        martinekbar2.setIsIndicator(true);
        martinekbar3 = findViewById(R.id.martinekratingBar3);
        martinekbar3.setVisibility(View.INVISIBLE);
        martinekbar4 = findViewById(R.id.martinekratingBar4);
        martinekbar4.setVisibility(View.VISIBLE);
        martinekbar4.setIsIndicator(true);
        martinekbar5 = findViewById(R.id.martinekratingBar5);
        martinekbar5.setVisibility(View.INVISIBLE);
        martinekbar6 = findViewById(R.id.martinekratingBar6);
        martinekbar6.setVisibility(View.VISIBLE);
        martinekbar6.setIsIndicator(true);
        martinekbar7 = findViewById(R.id.martinekratingBar7);
        martinekbar7.setVisibility(View.INVISIBLE);
        martinekbar8 = findViewById(R.id.martinekratingBar8);
        martinekbar8.setVisibility(View.VISIBLE);
        martinekbar8.setIsIndicator(true);
        martinekbar9 = findViewById(R.id.martinekratingBar9);
        martinekbar9.setVisibility(View.INVISIBLE);

        martinekbutton20 = findViewById(R.id.martinekbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        martinekbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(martinek.this);


        boolean wahr = db.updateData("martinek",
                Username.getUsername(),
                Math.round(martinekbar1.getRating()),
                Math.round(martinekbar3.getRating()),
                Math.round(martinekbar5.getRating()),
                Math.round(martinekbar7.getRating()),
                Math.round(martinekbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(martinek.this);
        boolean wahr = db.insertData("martinek",
                Username.getUsername(),
                (int) martinekbar.getRating(),
                (int) martinekbar2.getRating(),
                (int) martinekbar4.getRating(),
                (int) martinekbar6.getRating(),
                (int) martinekbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("martinek", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("martinek", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("martinek", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(martinek.this);
        List<Integer> list = db.getData("martinek");
        martinekbar.setRating((float)list.get(0));
        martinekbar2.setRating((float)list.get(1));
        martinekbar4.setRating((float)list.get(2));
        martinekbar6.setRating((float)list.get(3));
        martinekbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(martinekbutton20.getText().toString().equals("Bewerten")) {
            martinekbar1.setVisibility(View.VISIBLE);
            martinekbar3.setVisibility(View.VISIBLE);
            martinekbar5.setVisibility(View.VISIBLE);
            martinekbar7.setVisibility(View.VISIBLE);
            martinekbar9.setVisibility(View.VISIBLE);
            martinekbutton20.setText("Speichern");
        }else if(martinekbutton20.getText().toString().equals("Speichern")){


            martinekbar1.setVisibility(View.INVISIBLE);
            martinekbar3.setVisibility(View.INVISIBLE);
            martinekbar5.setVisibility(View.INVISIBLE);
            martinekbar7.setVisibility(View.INVISIBLE);
            martinekbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            martinekbutton20.setText("Bewerten");

        }
    }
}