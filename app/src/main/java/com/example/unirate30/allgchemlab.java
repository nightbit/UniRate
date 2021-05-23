package com.example.unirate30;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class allgchemlab extends AppCompatActivity {
    TextInputLayout til_Prof2;
    AutoCompleteTextView act_Prof2;

    ArrayList<String> ArrayList_Prof2;
    ArrayAdapter<String> ArrayAdapter_Prof2;

    ImageButton nextButton5;
    String selected_Prof2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgchemlab);

        til_Prof2 = (TextInputLayout) findViewById(R.id.til_Prof2);
        act_Prof2 = (AutoCompleteTextView) findViewById(R.id.act_Prof2);

        ArrayList_Prof2 = new ArrayList<>();
        ArrayList_Prof2.add("Barbara Gepp");
        ArrayList_Prof2.add("Katharina Wiessner");
        ArrayList_Prof2.add("Thomas Machacek");
        ArrayList_Prof2.add("Elisabeth Simboeck");
        ArrayList_Prof2.add("Ursula Knaack");

        ArrayAdapter_Prof2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof2);
        act_Prof2.setAdapter(ArrayAdapter_Prof2);

        act_Prof2.setThreshold(1);


        nextButton5 = findViewById(R.id.nextButton5);
        nextButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof2 = act_Prof2.getText().toString();
                if (selected_Prof2.equals("Barbara Gepp")){
                    openGepp();
                }if (selected_Prof2.equals("Katharina Wiessner")){
                    openWiessner();
                }if (selected_Prof2.equals("Thomas Machacek")){
                    openMachacek();
                }if (selected_Prof2.equals("Elisabeth Simboeck")){
                    openSimboeck();
                }if (selected_Prof2.equals("Ursula Knaack")){
                    openKnaack();
                }
            }
        });

    }

    public void openGepp() {
        Intent Gepp = new Intent(this, Gepp.class);
        startActivity(Gepp);
    }
    public void openWiessner() {
        Intent Wiessner = new Intent(this, Wiessner.class);
        startActivity(Wiessner);
    }
    public void openMachacek() {
        Intent Machacek = new Intent(this, Machacek.class);
        startActivity(Machacek);
    }
    public void openKnaack() {
        Intent Knaack = new Intent(this, Knaack.class);
        startActivity(Knaack);
    }
    public void openSimboeck() {
        Intent Simboeck = new Intent(this, Simboeck.class);
        startActivity(Simboeck);
    }

}
