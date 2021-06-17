package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.BBEFÄCHER.SEMESTER1.physiklab;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.PROFESSOR.Teuschel;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class angchem extends AppCompatActivity implements View.OnClickListener {

    Button angchembutton;
    RatingBar angchembar, angchembar1;
    RatingBar angchembar2, angchembar4;
    RatingBar angchembar3, angchembar5;
    FachBewertDBHelper db;
    String db_name = "angchem";

    TextInputLayout til_Prof12;
    AutoCompleteTextView act_Prof12;

    ArrayList<String> ArrayList_Prof12;
    ArrayAdapter<String> ArrayAdapter_Prof12;

    ImageButton angchemnextButton;
    String selected_Profangchem;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angchem);

        db = new FachBewertDBHelper(angchem.this, db_name);

        angchembar = findViewById(R.id.angratingBar1);
        angchembar.setIsIndicator(true);
        angchembar1 =findViewById(R.id.angratingBar2);
        angchembar1.setVisibility(View.INVISIBLE);
        angchembar2 = findViewById(R.id.angratingBar3);
        angchembar2.setIsIndicator(true);
        angchembar3 = findViewById(R.id.angratingBar4);
        angchembar3.setVisibility(View.INVISIBLE);
        angchembar4 =findViewById(R.id.angratingBar5);
        angchembar4.setIsIndicator(true);
        angchembar5 =findViewById(R.id.angratingBar6);
        angchembar5.setVisibility(View.INVISIBLE);

        til_Prof12 = (TextInputLayout) findViewById(R.id.til_Profang);
        act_Prof12 = (AutoCompleteTextView) findViewById(R.id.act_Profang);

        ArrayList_Prof12 = new ArrayList<>();
        ArrayList_Prof12.add("Barbara Gepp");
        ArrayList_Prof12.add("Andreas Teuschl");

        ArrayAdapter_Prof12 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof12);
        act_Prof12.setAdapter(ArrayAdapter_Prof12);

        act_Prof12.setThreshold(1);

        angchembutton = findViewById(R.id.angbutton);
        angchemnextButton = findViewById(R.id.angnextButton);


        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        angchemnextButton.setOnClickListener((View.OnClickListener) this);
        angchembutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openTeuschel() {
        Intent teuschel = new Intent(this, com.example.unirate30.PROFESSOR.Teuschel.class);
        startActivity(teuschel);
    }




    public void update ()
    {


        db = new FachBewertDBHelper(angchem.this, db_name);


        boolean wahr = db.updateData("physiklab",
                Username.getUsername(),
                Math.round(angchembar1.getRating()),
                Math.round(angchembar3.getRating()),
                Math.round(angchembar5.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(angchem.this, db_name);
        boolean wahr = db.insertData("angchem",
                Username.getUsername(),
                (int) angchembar1.getRating(),
                (int) angchembar3.getRating(),
                (int) angchembar5.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("angchem", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("angchem", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("angchem", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(angchem.this, db_name);
        List<Integer> list = db.getData("angchem");
        angchembar.setRating((float)list.get(0));
        angchembar2.setRating((float)list.get(1));
        angchembar4.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.angbutton:
                if(angchembutton.getText().toString().equals("Bewerten")){
                    angchembar1.setVisibility(View.VISIBLE);
                    angchembar3.setVisibility(View.VISIBLE);
                    angchembar5.setVisibility(View.VISIBLE);
                    angchembutton.setText("Speichern");
                } else if(angchembutton.getText().toString().equals("Speichern"))
                {
                    angchembar1.setVisibility(View.INVISIBLE);
                    angchembar3.setVisibility(View.INVISIBLE);
                    angchembar5.setVisibility(View.INVISIBLE);

                    update();
                    AddData();

                    ergebnisse();
                    angchembutton.setText("Bewerten");
                }
                break;
            case R.id.angnextButton:
                selected_Profangchem = act_Prof12.getText().toString();
                if (selected_Profangchem.equals("Barbera Gepp")){
                    openGepp();
                }if (selected_Profangchem.equals("Andreas Teuschel")){
                    openTeuschel();
            }
                break;
        }
    }
}
