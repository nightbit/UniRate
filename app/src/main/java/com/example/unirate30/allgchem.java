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

public class allgchem extends AppCompatActivity {
    TextInputLayout til_Prof1;
    AutoCompleteTextView act_Prof1;

    ArrayList<String> ArrayList_Prof1;
    ArrayAdapter<String> ArrayAdapter_Prof1;

    ImageButton nextButton4;
    String selected_Prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgchem);

        til_Prof1 = (TextInputLayout) findViewById(R.id.til_Prof1);
        act_Prof1 = (AutoCompleteTextView) findViewById(R.id.act_Prof1);

        ArrayList_Prof1 = new ArrayList<>();
        ArrayList_Prof1.add("Barbara Gepp");
        ArrayList_Prof1.add("Katharina Wiessner");

        ArrayAdapter_Prof1 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof1);
        act_Prof1.setAdapter(ArrayAdapter_Prof1);

        act_Prof1.setThreshold(1);


        nextButton4 = findViewById(R.id.nextButton4);
        nextButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof = act_Prof1.getText().toString();
                if (selected_Prof.equals("Barbara Gepp")){
                    openGepp();
                }if (selected_Prof.equals("Katharina Wiessner")){
                    openWiessner();
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

}