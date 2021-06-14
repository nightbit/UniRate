package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class progaw1 extends AppCompatActivity {

    Button progaw1button;
    RatingBar progaw1bar1;
    RatingBar progaw1bar2;
    RatingBar progaw1bar3;

    TextInputLayout til_Prof7;
    AutoCompleteTextView act_Prof7;

    ArrayList<String> ArrayList_Prof7;
    ArrayAdapter<String> ArrayAdapter_Prof7;

    ImageButton progaw1nextButton;
    String selected_Profprogaw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progaw1);

        progaw1bar1 = findViewById(R.id.progaw1ratingBar2);
        progaw1bar1.setVisibility(View.INVISIBLE);
        progaw1bar2 = findViewById(R.id.progaw1ratingBar4);
        progaw1bar2.setVisibility(View.INVISIBLE);
        progaw1bar3 = findViewById(R.id.progaw1ratingBar6);
        progaw1bar3.setVisibility(View.INVISIBLE);

        til_Prof7 = (TextInputLayout) findViewById(R.id.til_Profprogaw1);
        act_Prof7 = (AutoCompleteTextView) findViewById(R.id.act_Profprogaw1);

        ArrayList_Prof7 = new ArrayList<>();
        ArrayList_Prof7.add("Phillipp Urbauer");
        ArrayList_Prof7.add("Matthias Frohner");
        ArrayList_Prof7.add("Johannes Martinek");

        ArrayAdapter_Prof7 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof7);
        act_Prof7.setAdapter(ArrayAdapter_Prof7);

        act_Prof7.setThreshold(1);

        progaw1button = findViewById(R.id.progaw1button);
        progaw1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    progaw1bar1.setVisibility(View.VISIBLE);
                    progaw1bar2.setVisibility(View.VISIBLE);
                    progaw1bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        progaw1nextButton = findViewById(R.id.progaw1nextButton);
        progaw1nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profprogaw1 = act_Prof7.getText().toString();
                if (selected_Profprogaw1.equals("Matthias Frohner")){
                    openFrohner();
                }if (selected_Profprogaw1.equals("Johannes Martinek")){
                    openMartinek();
                }if (selected_Profprogaw1.equals("Philipp Urbauer")) {
                    openUrbauer();
                }
            }
        });
    }

    public void openFrohner(){
        Intent frohner = new Intent(this, com.example.unirate30.PROFESSOR.frohner.class);
        startActivity(frohner);
    }
    public void openMartinek(){
        Intent martinek = new Intent(this, com.example.unirate30.PROFESSOR.martinek.class);
        startActivity(martinek);
    }
    public void openUrbauer(){
        Intent urbauer = new Intent(this, com.example.unirate30.PROFESSOR.urbauer.class);
        startActivity(urbauer);
    }

}