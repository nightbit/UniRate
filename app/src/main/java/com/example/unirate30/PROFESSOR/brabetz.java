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

public class brabetz extends AppCompatActivity implements View.OnClickListener {

    Button barbbutton20;
    RatingBar barbbar, barbbar1, barbbar2, barbbar3, barbbar4, barbbar5, barbbar6, barbbar7, barbbar8, barbbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brabetz);

        db = new ProfBewertDbHelper(brabetz.this);



        barbbar = findViewById(R.id.barbratingBar);
        barbbar.setVisibility(View.VISIBLE);
        barbbar.setIsIndicator(true);
        barbbar1 = findViewById(R.id.barbratingBar1);
        barbbar1.setVisibility(View.INVISIBLE);
        barbbar2 = findViewById(R.id.barbratingBar2);
        barbbar2.setVisibility(View.VISIBLE);
        barbbar2.setIsIndicator(true);
        barbbar3 = findViewById(R.id.barbratingBar3);
        barbbar3.setVisibility(View.INVISIBLE);
        barbbar4 = findViewById(R.id.barbratingBar4);
        barbbar4.setVisibility(View.VISIBLE);
        barbbar4.setIsIndicator(true);
        barbbar5 = findViewById(R.id.barbratingBar5);
        barbbar5.setVisibility(View.INVISIBLE);
        barbbar6 = findViewById(R.id.barbratingBar6);
        barbbar6.setVisibility(View.VISIBLE);
        barbbar6.setIsIndicator(true);
        barbbar7 = findViewById(R.id.barbratingBar7);
        barbbar7.setVisibility(View.INVISIBLE);
        barbbar8 = findViewById(R.id.barbratingBar8);
        barbbar8.setVisibility(View.VISIBLE);
        barbbar8.setIsIndicator(true);
        barbbar9 = findViewById(R.id.barbratingBar9);
        barbbar9.setVisibility(View.INVISIBLE);

        barbbutton20 = findViewById(R.id.barbbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        barbbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(brabetz.this);


        boolean wahr = db.updateData("barb",
                Username.getUsername(),
                Math.round(barbbar1.getRating()),
                Math.round(barbbar3.getRating()),
                Math.round(barbbar5.getRating()),
                Math.round(barbbar7.getRating()),
                Math.round(barbbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(brabetz.this);
        boolean wahr = db.insertData("barb",
                Username.getUsername(),
                (int) barbbar.getRating(),
                (int) barbbar2.getRating(),
                (int) barbbar4.getRating(),
                (int) barbbar6.getRating(),
                (int) barbbar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("barb", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("barb", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("barb", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(brabetz.this);
        List<Integer> list = db.getData("barb");
        barbbar.setRating((float)list.get(0));
        barbbar2.setRating((float)list.get(1));
        barbbar4.setRating((float)list.get(2));
        barbbar6.setRating((float)list.get(3));
        barbbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(barbbutton20.getText().toString().equals("Bewerten")) {
            barbbar1.setVisibility(View.VISIBLE);
            barbbar3.setVisibility(View.VISIBLE);
            barbbar5.setVisibility(View.VISIBLE);
            barbbar7.setVisibility(View.VISIBLE);
            barbbar9.setVisibility(View.VISIBLE);
            barbbutton20.setText("Speichern");
        }else if(barbbutton20.getText().toString().equals("Speichern")){


            barbbar1.setVisibility(View.INVISIBLE);
            barbbar3.setVisibility(View.INVISIBLE);
            barbbar5.setVisibility(View.INVISIBLE);
            barbbar7.setVisibility(View.INVISIBLE);
            barbbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            barbbutton20.setText("Bewerten");

        }
    }
}