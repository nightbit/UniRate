package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.FachBewertDBHelper;
import com.example.unirate30.R;
import com.example.unirate30.Username;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class aphys extends AppCompatActivity implements View.OnClickListener{

    Button aphysbutton;
    RatingBar aphysbar1;
    RatingBar aphysbar2;
    RatingBar aphysbar3;
    RatingBar aphysbar4;
    RatingBar aphysbar5;
    RatingBar aphysbar6;
    FachBewertDBHelper db;

    TextInputLayout til_Prof4;
    AutoCompleteTextView act_Prof4;

    ArrayList<String> ArrayList_Prof4;
    ArrayAdapter<String> ArrayAdapter_Prof4;

    ImageButton aphysnextButton;
    String selected_Profaphys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aphys);
        db = new FachBewertDBHelper(aphys.this);

        aphysbar1 = findViewById(R.id.aphysratingBar2);
        aphysbar1.setVisibility(View.INVISIBLE);
        aphysbar2 = findViewById(R.id.aphysratingBar4);
        aphysbar2.setVisibility(View.INVISIBLE);
        aphysbar3 = findViewById(R.id.aphysratingBar6);
        aphysbar3.setVisibility(View.INVISIBLE);
        aphysbar4 = findViewById(R.id.aphysratingBar1);
        aphysbar4.setIsIndicator(true);
        aphysbar5 = findViewById(R.id.aphysratingBar3);
        aphysbar5.setIsIndicator(true);
        aphysbar6 = findViewById(R.id.aphysratingBar5);
        aphysbar6.setIsIndicator(true);

        til_Prof4 = (TextInputLayout) findViewById(R.id.til_Profaphys);
        act_Prof4 = (AutoCompleteTextView) findViewById(R.id.act_Profaphys);

        ArrayList_Prof4 = new ArrayList<>();
        ArrayList_Prof4.add("Christoph Mohl");


        ArrayAdapter_Prof4 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof4);
        act_Prof4.setAdapter(ArrayAdapter_Prof4);

        act_Prof4.setThreshold(1);

        aphysbutton = findViewById(R.id.aphysbutton);

        aphysnextButton = findViewById(R.id.aphysnextButton);

        if (firststart()) {

            AddData();

        } else {
            ergebnisse();
        }

        aphysnextButton.setOnClickListener((View.OnClickListener) this);
        aphysbutton.setOnClickListener((View.OnClickListener) this);
    }

    public void openMohl(){
        Intent mohl = new Intent(this, com.example.unirate30.PROFESSOR.mohl.class);
        startActivity(mohl);
    }

    public void update ()
    {


        db = new FachBewertDBHelper(aphys.this);


        boolean wahr = db.updateData("aphys",
                Username.getUsername(),
                Math.round(aphysbar1.getRating()),
                Math.round(aphysbar2.getRating()),
                Math.round(aphysbar3.getRating())
        );


        if (wahr) {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Die Bewertung wurde nicht gespeichert", Toast.LENGTH_SHORT).show();
        }

    }
    public void AddData () {
        db = new FachBewertDBHelper(aphys.this);
        boolean wahr = db.insertData("aphys",
                Username.getUsername(),
                (int) aphysbar1.getRating(),
                (int) aphysbar2.getRating(),
                (int) aphysbar3.getRating()

        );
        if (wahr) {
            Toast.makeText(getApplicationContext(), "Bewertung wurde gespeichert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bewertung wurde nicht erstellt", Toast.LENGTH_SHORT).show();
        }
    }
    private boolean firststart() {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("aphys", MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("aphys", false)) {
            first = true;
            sharedPreferencesEditor.putBoolean("aphys", true);
            sharedPreferencesEditor.apply();
        }

        return first;
    }
    private void ergebnisse() {
        db =  new FachBewertDBHelper(aphys.this);
        List<Integer> list = db.getData("aphys");
        aphysbar4.setRating((float)list.get(0));
        aphysbar5.setRating((float)list.get(1));
        aphysbar6.setRating((float)list.get(2));

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.aphysbutton:ton:
            if(aphysbutton.getText().toString().equals("Bewerten")){
                aphysbar1.setVisibility(View.VISIBLE);
                aphysbar2.setVisibility(View.VISIBLE);
                aphysbar3.setVisibility(View.VISIBLE);
                aphysbutton.setText("Speichern");
            } else if(aphysbutton.getText().toString().equals("Speichern"))
            {
                aphysbar1.setVisibility(View.INVISIBLE);
                aphysbar2.setVisibility(View.INVISIBLE);
                aphysbar3.setVisibility(View.INVISIBLE);

                update();
                AddData();

                ergebnisse();
                aphysbutton.setText("Bewerten");
            }
                break;
            case R.id.aphysnextButton:
                selected_Profaphys = act_Prof4.getText().toString();
                if (selected_Profaphys.equals("Katharina Wiessner")){
                    openMohl();
                }
                break;
        }
    }

}