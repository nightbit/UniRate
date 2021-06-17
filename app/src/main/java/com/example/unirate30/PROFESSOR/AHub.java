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


public class AHub extends AppCompatActivity implements View.OnClickListener {

    Button button20;
    RatingBar bar, bar1, bar2, bar3, bar4, bar5, bar6, bar7, bar8, bar9;
    ProfBewertDbHelper db;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_hub);

        db = new ProfBewertDbHelper(AHub.this,"AHub");

        bar = findViewById(R.id.barbratingBar);
        bar.setVisibility(View.VISIBLE);
        bar.setIsIndicator(true);
        bar1 = findViewById(R.id.barbratingBar1);
        bar1.setVisibility(View.INVISIBLE);
        bar2 = findViewById(R.id.barbratingBar2);
        bar2.setVisibility(View.VISIBLE);
        bar2.setIsIndicator(true);
        bar3 = findViewById(R.id.barbratingBar3);
        bar3.setVisibility(View.INVISIBLE);
        bar4 = findViewById(R.id.barbratingBar4);
        bar4.setVisibility(View.VISIBLE);
        bar4.setIsIndicator(true);
        bar5 = findViewById(R.id.barbratingBar5);
        bar5.setVisibility(View.INVISIBLE);
        bar6 = findViewById(R.id.barbratingBar6);
        bar6.setVisibility(View.VISIBLE);
        bar6.setIsIndicator(true);
        bar7 = findViewById(R.id.barbratingBar7);
        bar7.setVisibility(View.INVISIBLE);
        bar8 = findViewById(R.id.barbratingBar8);
        bar8.setVisibility(View.VISIBLE);
        bar8.setIsIndicator(true);
        bar9 = findViewById(R.id.barbratingBar9);
        bar9.setVisibility(View.INVISIBLE);

        button20 = findViewById(R.id.barbbutton6);


       if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }
        button20.setOnClickListener(this);
    }


        public void update ()
        {


            db = new ProfBewertDbHelper(AHub.this,"AHub");


            boolean wahr = db.updateData("AHub",
                    Username.getUsername(),
                    Math.round(bar1.getRating()),
                    Math.round(bar3.getRating()),
                    Math.round(bar5.getRating()),
                    Math.round(bar7.getRating()),
                    Math.round(bar9.getRating())
                    );


            if (wahr) {
                Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
            }

        }


        public void AddData () {
            db=new ProfBewertDbHelper(AHub.this,"AHub");
            boolean wahr = db.insertData("AHub",
                        Username.getUsername(),
                        (int) bar.getRating(),
                        (int) bar2.getRating(),
                        (int) bar4.getRating(),
                        (int) bar6.getRating(),
                        (int) bar8.getRating()
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
        if (sharedPreferences.getBoolean("AHub", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("AHub", true);
            sharedPreferencesEditor.apply();
        }

        return first;
        }

        private void ergebnisse() {
           db =  new ProfBewertDbHelper(AHub.this,"AHub");
            List<Integer> list = db.getData("AHub");
            bar.setRating((float)list.get(0));
            bar2.setRating((float)list.get(1));
            bar4.setRating((float)list.get(2));
            bar6.setRating((float)list.get(3));
            bar8.setRating((float)list.get(4));
         //   db.updateData("AHub",(int)list.get(0),list.get(1),list.get(2),list.get(3),list.get(4));*/
    }

        @Override
          public void onClick(View view) {
                if(button20.getText().toString().equals("Bewerten") && Username.getUsername()!="nichterlaubt") {
                    bar1.setVisibility(View.VISIBLE);
                    bar3.setVisibility(View.VISIBLE);
                    bar5.setVisibility(View.VISIBLE);
                    bar7.setVisibility(View.VISIBLE);
                    bar9.setVisibility(View.VISIBLE);
                    button20.setText("Speichern");
                }else if(button20.getText().toString().equals("Speichern")){


                    bar1.setVisibility(View.INVISIBLE);
                    bar3.setVisibility(View.INVISIBLE);
                    bar5.setVisibility(View.INVISIBLE);
                    bar7.setVisibility(View.INVISIBLE);
                    bar9.setVisibility(View.INVISIBLE);

                    AddData();
                    update();
                    ergebnisse();
                    button20.setText("Bewerten");

                }else
                {
                    Toast.makeText(getApplicationContext(),"Bitte Einloggen",Toast.LENGTH_SHORT).show();
                }
            }
    }



