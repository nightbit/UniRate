package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class allgchem extends AppCompatActivity {

    Button allgbutton20;
    RatingBar allgbar1;
    RatingBar allgbar2;
    RatingBar allgbar3;

    TextInputLayout til_Prof1;
    AutoCompleteTextView act_Prof1;

    ArrayList<String> ArrayList_Prof1;
    ArrayAdapter<String> ArrayAdapter_Prof1;

    ImageButton allgnextButton12;
    String selected_Prof9allg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgchem);

        allgbar1 = findViewById(R.id.allgchemratingBar2);
        allgbar1.setVisibility(View.INVISIBLE);
        allgbar2 = findViewById(R.id.allgchemratingBar4);
        allgbar2.setVisibility(View.INVISIBLE);
        allgbar3 = findViewById(R.id.allgchemratingBar6);
        allgbar3.setVisibility(View.INVISIBLE);

        til_Prof1 = (TextInputLayout) findViewById(R.id.til_Prof9allg);
        act_Prof1 = (AutoCompleteTextView) findViewById(R.id.act_Prof9allg);

        ArrayList_Prof1 = new ArrayList<>();
        ArrayList_Prof1.add("Barbara Gepp");
        ArrayList_Prof1.add("Katharina Wiessner");

        ArrayAdapter_Prof1 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof1);
        act_Prof1.setAdapter(ArrayAdapter_Prof1);

        act_Prof1.setThreshold(1);

        allgbutton20 = findViewById(R.id.allgbutton6);
        allgbutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    allgbar1.setVisibility(View.VISIBLE);
                    allgbar2.setVisibility(View.VISIBLE);
                    allgbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        allgnextButton12 = findViewById(R.id.allgnextButton12);
        allgnextButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof9allg = act_Prof1.getText().toString();
                if (selected_Prof9allg.equals("Barbara Gepp")){
                    openGepp();
                }if (selected_Prof9allg.equals("Katharina Wiessner")){
                    openWiessner();
                }
            }
        });

    }

    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openWiessner() {
        Intent Wiessner = new Intent(this, com.example.unirate30.PROFESSOR.Wiessner.class);
        startActivity(Wiessner);
    }

}