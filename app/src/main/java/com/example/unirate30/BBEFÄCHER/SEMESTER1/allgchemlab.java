package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class allgchemlab extends AppCompatActivity {

    Button allglabbutton;
    RatingBar allglabbar1;
    RatingBar allglabbar2;
    RatingBar allglabbar3;

    TextInputLayout til_Prof2;
    AutoCompleteTextView act_Prof2;

    ArrayList<String> ArrayList_Prof2;
    ArrayAdapter<String> ArrayAdapter_Prof2;

    ImageButton allglabnextButton;
    String selected_Profallglab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgchemlab);

        allglabbar1 = findViewById(R.id.allglabratingBar2);
        allglabbar1.setVisibility(View.INVISIBLE);
        allglabbar2 = findViewById(R.id.allglabratingBar4);
        allglabbar2.setVisibility(View.INVISIBLE);
        allglabbar3 = findViewById(R.id.allglabratingBar6);
        allglabbar3.setVisibility(View.INVISIBLE);

        til_Prof2 = (TextInputLayout) findViewById(R.id.til_Profallglab);
        act_Prof2 = (AutoCompleteTextView) findViewById(R.id.act_Profallglab);

        ArrayList_Prof2 = new ArrayList<>();
        ArrayList_Prof2.add("Barbara Gepp");
        ArrayList_Prof2.add("Katharina Wiessner");
        ArrayList_Prof2.add("Thomas Machacek");
        ArrayList_Prof2.add("Elisabeth Simboeck");
        ArrayList_Prof2.add("Ursula Knaack");

        ArrayAdapter_Prof2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof2);
        act_Prof2.setAdapter(ArrayAdapter_Prof2);

        act_Prof2.setThreshold(1);

        allglabbutton = findViewById(R.id.allglabbutton);
        allglabbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    allglabbar1.setVisibility(View.VISIBLE);
                    allglabbar2.setVisibility(View.VISIBLE);
                    allglabbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        allglabnextButton = findViewById(R.id.allglabnextButton);
        allglabnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profallglab = act_Prof2.getText().toString();
                if (selected_Profallglab.equals("Barbara Gepp")){
                    openGepp();
                }if (selected_Profallglab.equals("Katharina Wiessner")){
                    openWiessner();
                }if (selected_Profallglab.equals("Thomas Machacek")){
                    openMachacek();
                }if (selected_Profallglab.equals("Elisabeth Simboeck")){
                    openSimboeck();
                }if (selected_Profallglab.equals("Ursula Knaack")){
                    openKnaack();
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
    public void openMachacek() {
        Intent Machacek = new Intent(this, com.example.unirate30.PROFESSOR.Machacek.class);
        startActivity(Machacek);
    }
    public void openKnaack() {
        Intent Knaack = new Intent(this, com.example.unirate30.PROFESSOR.Knaack.class);
        startActivity(Knaack);
    }
    public void openSimboeck() {
        Intent Simboeck = new Intent(this, com.example.unirate30.PROFESSOR.Simboeck.class);
        startActivity(Simboeck);
    }

}
