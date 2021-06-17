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

public class patricia extends AppCompatActivity implements View.OnClickListener {

    Button patriciabutton20;
    RatingBar patriciabar, patriciabar1, patriciabar2, patriciabar3, patriciabar4, patriciabar5, patriciabar6, patriciabar7, patriciabar8, patriciabar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patricia);

        db = new ProfBewertDbHelper(patricia.this,"patricia");

        patriciabar = findViewById(R.id.patriciaratingBar);
        patriciabar.setVisibility(View.VISIBLE);
        patriciabar.setIsIndicator(true);
        patriciabar1 = findViewById(R.id.patriciaratingBar1);
        patriciabar1.setVisibility(View.INVISIBLE);
        patriciabar2 = findViewById(R.id.patriciaratingBar2);
        patriciabar2.setVisibility(View.VISIBLE);
        patriciabar2.setIsIndicator(true);
        patriciabar3 = findViewById(R.id.patriciaratingBar3);
        patriciabar3.setVisibility(View.INVISIBLE);
        patriciabar4 = findViewById(R.id.patriciaratingBar4);
        patriciabar4.setVisibility(View.VISIBLE);
        patriciabar4.setIsIndicator(true);
        patriciabar5 = findViewById(R.id.patriciaratingBar5);
        patriciabar5.setVisibility(View.INVISIBLE);
        patriciabar6 = findViewById(R.id.patriciaratingBar6);
        patriciabar6.setVisibility(View.VISIBLE);
        patriciabar6.setIsIndicator(true);
        patriciabar7 = findViewById(R.id.patriciaratingBar7);
        patriciabar7.setVisibility(View.INVISIBLE);
        patriciabar8 = findViewById(R.id.patriciaratingBar8);
        patriciabar8.setVisibility(View.VISIBLE);
        patriciabar8.setIsIndicator(true);
        patriciabar9 = findViewById(R.id.patriciaratingBar9);
        patriciabar9.setVisibility(View.INVISIBLE);

        patriciabutton20 = findViewById(R.id.patriciabutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        patriciabutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(patricia.this,"patricia");


        boolean wahr = db.updateData("patricia",
                Username.getUsername(),
                Math.round(patriciabar1.getRating()),
                Math.round(patriciabar3.getRating()),
                Math.round(patriciabar5.getRating()),
                Math.round(patriciabar7.getRating()),
                Math.round(patriciabar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(patricia.this,"patricia");
        boolean wahr = db.insertData("patricia",
                Username.getUsername(),
                (int) patriciabar.getRating(),
                (int) patriciabar2.getRating(),
                (int) patriciabar4.getRating(),
                (int) patriciabar6.getRating(),
                (int) patriciabar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("patricia", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("patricia", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("patricia", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(patricia.this,"patricia");
        List<Integer> list = db.getData("patricia");
        patriciabar.setRating((float)list.get(0));
        patriciabar2.setRating((float)list.get(1));
        patriciabar4.setRating((float)list.get(2));
        patriciabar6.setRating((float)list.get(3));
        patriciabar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(patriciabutton20.getText().toString().equals("Bewerten")) {
            patriciabar1.setVisibility(View.VISIBLE);
            patriciabar3.setVisibility(View.VISIBLE);
            patriciabar5.setVisibility(View.VISIBLE);
            patriciabar7.setVisibility(View.VISIBLE);
            patriciabar9.setVisibility(View.VISIBLE);
            patriciabutton20.setText("Speichern");
        }else if(patriciabutton20.getText().toString().equals("Speichern")){


            patriciabar1.setVisibility(View.INVISIBLE);
            patriciabar3.setVisibility(View.INVISIBLE);
            patriciabar5.setVisibility(View.INVISIBLE);
            patriciabar7.setVisibility(View.INVISIBLE);
            patriciabar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            patriciabutton20.setText("Bewerten");

        }
    }
}