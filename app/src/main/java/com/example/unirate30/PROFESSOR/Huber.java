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

public class Huber extends AppCompatActivity implements View.OnClickListener {

    Button huberbutton20;
    RatingBar huberbar, huberbar1, huberbar2, huberbar3, huberbar4, huberbar5, huberbar6, huberbar7, huberbar8, huberbar9;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huber);
        db = new ProfBewertDbHelper(Huber.this,"Huber");

        huberbar = findViewById(R.id.huberratingBar);
        huberbar.setVisibility(View.VISIBLE);
        huberbar.setIsIndicator(true);
        huberbar1 = findViewById(R.id.huberratingBar1);
        huberbar1.setVisibility(View.INVISIBLE);
        huberbar2 = findViewById(R.id.huberratingBar2);
        huberbar2.setVisibility(View.VISIBLE);
        huberbar2.setIsIndicator(true);
        huberbar3 = findViewById(R.id.huberratingBar3);
        huberbar3.setVisibility(View.INVISIBLE);
        huberbar4 = findViewById(R.id.huberratingBar4);
        huberbar4.setVisibility(View.VISIBLE);
        huberbar4.setIsIndicator(true);
        huberbar5 = findViewById(R.id.huberratingBar5);
        huberbar5.setVisibility(View.INVISIBLE);
        huberbar6 = findViewById(R.id.huberratingBar6);
        huberbar6.setVisibility(View.VISIBLE);
        huberbar6.setIsIndicator(true);
        huberbar7 = findViewById(R.id.huberratingBar7);
        huberbar7.setVisibility(View.INVISIBLE);
        huberbar8 = findViewById(R.id.huberratingBar8);
        huberbar8.setVisibility(View.VISIBLE);
        huberbar8.setIsIndicator(true);
        huberbar9 = findViewById(R.id.huberratingBar9);
        huberbar9.setVisibility(View.INVISIBLE);

        huberbutton20 = findViewById(R.id.huberbutton6);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        huberbutton20.setOnClickListener(this);
    }


    public void update ()
    {


        db = new ProfBewertDbHelper(Huber.this,"Huber");


        boolean wahr = db.updateData("Huber",
                Username.getUsername(),
                Math.round(huberbar1.getRating()),
                Math.round(huberbar3.getRating()),
                Math.round(huberbar5.getRating()),
                Math.round(huberbar7.getRating()),
                Math.round(huberbar9.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }


    public void AddData () {
        db=new ProfBewertDbHelper(Huber.this,"Huber");
        boolean wahr = db.insertData("Huber",
                Username.getUsername(),
                (int) huberbar.getRating(),
                (int) huberbar2.getRating(),
                (int) huberbar4.getRating(),
                (int) huberbar6.getRating(),
                (int) huberbar8.getRating()
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
        if (sharedPreferences.getBoolean("Huber", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Huber", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Huber.this,"Huber");
        List<Integer> list = db.getData("Huber");
        huberbar.setRating((float)list.get(0));
        huberbar2.setRating((float)list.get(1));
        huberbar4.setRating((float)list.get(2));
        huberbar6.setRating((float)list.get(3));
        huberbar8.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

    @Override
    public void onClick(View view) {
        if(huberbutton20.getText().toString().equals("Bewerten")) {
            huberbar1.setVisibility(View.VISIBLE);
            huberbar3.setVisibility(View.VISIBLE);
            huberbar5.setVisibility(View.VISIBLE);
            huberbar7.setVisibility(View.VISIBLE);
            huberbar9.setVisibility(View.VISIBLE);
            huberbutton20.setText("Speichern");
        }else if(huberbutton20.getText().toString().equals("Speichern")){


            huberbar1.setVisibility(View.INVISIBLE);
            huberbar3.setVisibility(View.INVISIBLE);
            huberbar5.setVisibility(View.INVISIBLE);
            huberbar7.setVisibility(View.INVISIBLE);
            huberbar9.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            huberbutton20.setText("Bewerten");

        }
    }
}