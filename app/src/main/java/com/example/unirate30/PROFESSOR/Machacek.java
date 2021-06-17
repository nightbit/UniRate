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

public class Machacek extends AppCompatActivity implements View.OnClickListener {

    Button machabutton20;
    RatingBar machabar, machabar1, machabar2, machabar3, machabar4, machabar5, machabar6, machabar7, machabar8, machabar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_machacek);
        db = new ProfBewertDbHelper(Machacek.this,"Machacek");

        machabar = findViewById(R.id.machacekratingBar);
        machabar.setVisibility(View.VISIBLE);
        machabar.setIsIndicator(true);
        machabar1 = findViewById(R.id.machacekratingBar1);
        machabar1.setVisibility(View.INVISIBLE);
        machabar2 = findViewById(R.id.machacekratingBar2);
        machabar2.setVisibility(View.VISIBLE);
        machabar2.setIsIndicator(true);
        machabar3 = findViewById(R.id.machacekratingBar3);
        machabar3.setVisibility(View.INVISIBLE);
        machabar4 = findViewById(R.id.machacekratingBar4);
        machabar4.setVisibility(View.VISIBLE);
        machabar4.setIsIndicator(true);
        machabar5 = findViewById(R.id.machacekratingBar5);
        machabar5.setVisibility(View.INVISIBLE);
        machabar6 = findViewById(R.id.machacekratingBar6);
        machabar6.setVisibility(View.VISIBLE);
        machabar6.setIsIndicator(true);
        machabar7 = findViewById(R.id.machacekratingBar7);
        machabar7.setVisibility(View.INVISIBLE);
        machabar8 = findViewById(R.id.machacekratingBar8);
        machabar8.setVisibility(View.VISIBLE);
        machabar8.setIsIndicator(true);
        machabar9 = findViewById(R.id.machacekratingBar9);
        machabar9.setVisibility(View.INVISIBLE);

        machabutton20 = findViewById(R.id.machacekbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        machabutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Machacek.this,"Machacek");


        boolean wahr = db.updateData("Machacek",
                Username.getUsername(),
                Math.round(machabar1.getRating()),
                Math.round(machabar3.getRating()),
                Math.round(machabar5.getRating()),
                Math.round(machabar7.getRating()),
                Math.round(machabar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Machacek.this,"Machacek");
        boolean wahr = db.insertData("Machacek",
                Username.getUsername(),
                (int) machabar.getRating(),
                (int) machabar2.getRating(),
                (int) machabar4.getRating(),
                (int) machabar6.getRating(),
                (int) machabar8.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Machacek", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Machacek", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Machacek", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Machacek.this,"Machacek");
        List<Integer> list = db.getData("Machacek");
        machabar.setRating((float)list.get(0));
        machabar2.setRating((float)list.get(1));
        machabar4.setRating((float)list.get(2));
        machabar6.setRating((float)list.get(3));
        machabar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(machabutton20.getText().toString().equals("Bewerten")) {
            machabar1.setVisibility(View.VISIBLE);
            machabar3.setVisibility(View.VISIBLE);
            machabar5.setVisibility(View.VISIBLE);
            machabar7.setVisibility(View.VISIBLE);
            machabar9.setVisibility(View.VISIBLE);
            machabutton20.setText("Speichern");
        }else if(machabutton20.getText().toString().equals("Speichern")){


            machabar1.setVisibility(View.INVISIBLE);
            machabar3.setVisibility(View.INVISIBLE);
            machabar5.setVisibility(View.INVISIBLE);
            machabar7.setVisibility(View.INVISIBLE);
            machabar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            machabutton20.setText("Bewerten");

        }
    }
}