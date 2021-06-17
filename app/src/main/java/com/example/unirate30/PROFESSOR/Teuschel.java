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

public class Teuschel extends AppCompatActivity implements View.OnClickListener {

    Button teuschbutton20;
    RatingBar teuschbar1;
    RatingBar teuschbar2;
    RatingBar teuschbar3;
    RatingBar teuschbar4;
    RatingBar teuschbar5;
    RatingBar teuschbar6;
    RatingBar teuschbar7;
    RatingBar teuschbar8;
    RatingBar teuschbar9;
    RatingBar teuschbar10;
    ProfBewertDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teuschel);
        db = new ProfBewertDbHelper(Teuschel.this,"Teuschel");

        teuschbar1 = findViewById(R.id.teuschratingBar1);
        teuschbar1.setVisibility(View.INVISIBLE);
        teuschbar2 = findViewById(R.id.teuschratingBar3);
        teuschbar2.setVisibility(View.INVISIBLE);
        teuschbar3 = findViewById(R.id.teuschratingBar5);
        teuschbar3.setVisibility(View.INVISIBLE);
        teuschbar4 = findViewById(R.id.teuschratingBar7);
        teuschbar4.setVisibility(View.INVISIBLE);
        teuschbar5 = findViewById(R.id.teuschratingBar9);
        teuschbar5.setVisibility(View.INVISIBLE);
        teuschbar6 =findViewById(R.id.teuschratingBar);
        teuschbar6.setVisibility(View.VISIBLE);
        teuschbar6.setIsIndicator(true);
        teuschbar7 =findViewById(R.id.teuschratingBar2);
        teuschbar7.setVisibility(View.VISIBLE);
        teuschbar7.setIsIndicator(true);
        teuschbar8 =findViewById(R.id.teuschratingBar4);
        teuschbar8.setVisibility(View.VISIBLE);
        teuschbar8.setIsIndicator(true);
        teuschbar9 =findViewById(R.id.teuschratingBar6);
        teuschbar9.setVisibility(View.VISIBLE);
        teuschbar9.setIsIndicator(true);
        teuschbar10 =findViewById(R.id.teuschratingBar8);
        teuschbar10.setVisibility(View.VISIBLE);
        teuschbar10.setIsIndicator(true);

        teuschbutton20 = findViewById(R.id.teuschbutton6);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        teuschbutton20.setOnClickListener(this);
    }

    public void update ()
    {


        db = new ProfBewertDbHelper(Teuschel.this,"Teuschel");


        boolean wahr = db.updateData("Teuschel",
                Username.getUsername(),
                Math.round(teuschbar1.getRating()),
                Math.round(teuschbar2.getRating()),
                Math.round(teuschbar3.getRating()),
                Math.round(teuschbar4.getRating()),
                Math.round(teuschbar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddData () {
        db=new ProfBewertDbHelper(Teuschel.this,"Teuschel");
        boolean wahr = db.insertData("Teuschel",
                Username.getUsername(),
                (int) teuschbar1.getRating(),
                (int) teuschbar2.getRating(),
                (int) teuschbar3.getRating(),
                (int) teuschbar4.getRating(),
                (int) teuschbar5.getRating()
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

        SharedPreferences sharedPreferences = getSharedPreferences("Teuschel", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("Teuschel", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("Teuschel", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }

    private void ergebnisse() {
        db =  new ProfBewertDbHelper(Teuschel.this,"Teuschel");
        List<Integer> list = db.getData("Teuschel");
        teuschbar6.setRating((float)list.get(0));
        teuschbar7.setRating((float)list.get(1));
        teuschbar8.setRating((float)list.get(2));
        teuschbar9.setRating((float)list.get(3));
        teuschbar10.setRating((float)list.get(4));
        //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }


    @Override
    public void onClick(View view) {
        if(teuschbutton20.getText().toString().equals("Bewerten")) {
            teuschbar1.setVisibility(View.VISIBLE);
            teuschbar2.setVisibility(View.VISIBLE);
            teuschbar3.setVisibility(View.VISIBLE);
            teuschbar4.setVisibility(View.VISIBLE);
            teuschbar5.setVisibility(View.VISIBLE);
            teuschbutton20.setText("Speichern");
        }else if(teuschbutton20.getText().toString().equals("Speichern")){


            teuschbar1.setVisibility(View.INVISIBLE);
            teuschbar2.setVisibility(View.INVISIBLE);
            teuschbar3.setVisibility(View.INVISIBLE);
            teuschbar4.setVisibility(View.INVISIBLE);
            teuschbar5.setVisibility(View.INVISIBLE);

            AddData();
            update();
            ergebnisse();
            teuschbutton20.setText("Bewerten");

        }
    }
}