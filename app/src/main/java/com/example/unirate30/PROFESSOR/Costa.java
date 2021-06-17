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

public class Costa extends AppCompatActivity implements View.OnClickListener {

    Button costabutton20;
    RatingBar costabar, costabar1, costabar2, costabar3, costabar4, costabar5, costabar6, costabar7, costabar8, costabar9;
    ProfBewertDbHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costa);
        db = new ProfBewertDbHelper(Costa.this,"Costa");



        costabar = findViewById(R.id.costaratingBar);
        costabar.setVisibility(View.VISIBLE);
        costabar.setIsIndicator(true);
        costabar1 = findViewById(R.id.costaratingBar1);
        costabar1.setVisibility(View.INVISIBLE);
        costabar2 = findViewById(R.id.costaratingBar2);
        costabar2.setVisibility(View.VISIBLE);
        costabar2.setIsIndicator(true);
        costabar3 = findViewById(R.id.costaratingBar3);
        costabar3.setVisibility(View.INVISIBLE);
        costabar4 = findViewById(R.id.costaratingBar4);
        costabar4.setVisibility(View.VISIBLE);
        costabar4.setIsIndicator(true);
        costabar5 = findViewById(R.id.costaratingBar5);
        costabar5.setVisibility(View.INVISIBLE);
        costabar6 = findViewById(R.id.costaratingBar6);
        costabar6.setVisibility(View.VISIBLE);
        costabar6.setIsIndicator(true);
        costabar7 = findViewById(R.id.costaratingBar7);
        costabar7.setVisibility(View.INVISIBLE);
        costabar8 = findViewById(R.id.costaratingBar8);
        costabar8.setVisibility(View.VISIBLE);
        costabar8.setIsIndicator(true);
        costabar9 = findViewById(R.id.costaratingBar9);
        costabar9.setVisibility(View.INVISIBLE);

        costabutton20 = findViewById(R.id.costabutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        costabutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Costa.this,"Costa");


        boolean wahr = db.updateData("Costa",
                Username.getUsername(),
                Math.round(costabar1.getRating()),
                Math.round(costabar3.getRating()),
                Math.round(costabar5.getRating()),
                Math.round(costabar7.getRating()),
                Math.round(costabar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Costa.this,"Costa");
        boolean wahr = db.insertData("Costa",
                Username.getUsername(),
                (int) costabar.getRating(),
                (int) costabar2.getRating(),
                (int) costabar4.getRating(),
                (int) costabar6.getRating(),
                (int) costabar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Costa", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Costa", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Costa", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Costa.this,"Costa");
        List<Integer> list = db.getData("Costa");
        costabar.setRating((float)list.get(0));
        costabar2.setRating((float)list.get(1));
        costabar4.setRating((float)list.get(2));
        costabar6.setRating((float)list.get(3));
        costabar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(costabutton20.getText().toString().equals("Bewerten")) {
            costabar1.setVisibility(View.VISIBLE);
            costabar3.setVisibility(View.VISIBLE);
            costabar5.setVisibility(View.VISIBLE);
            costabar7.setVisibility(View.VISIBLE);
            costabar9.setVisibility(View.VISIBLE);
            costabutton20.setText("Speichern");
        }else if(costabutton20.getText().toString().equals("Speichern")){


            costabar1.setVisibility(View.INVISIBLE);
            costabar3.setVisibility(View.INVISIBLE);
            costabar5.setVisibility(View.INVISIBLE);
            costabar7.setVisibility(View.INVISIBLE);
            costabar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            costabutton20.setText("Bewerten");

        }
    }
}



