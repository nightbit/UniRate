package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class mathe1 extends AppCompatActivity {

    TextInputLayout til_Prof5;
    AutoCompleteTextView act_Prof5;

    ArrayList<String> ArrayList_Prof5;
    ArrayAdapter<String> ArrayAdapter_Prof5;

    ImageButton nextButton8;
    String selected_Prof5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe1);

        til_Prof5 = (TextInputLayout) findViewById(R.id.til_Prof5);
        act_Prof5 = (AutoCompleteTextView) findViewById(R.id.act_Prof5);

        ArrayList_Prof5 = new ArrayList<>();
        ArrayList_Prof5.add("Simon Reif");


        ArrayAdapter_Prof5 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof5);
        act_Prof5.setAdapter(ArrayAdapter_Prof5);

        act_Prof5.setThreshold(1);

        nextButton8 = findViewById(R.id.nextButton8);
        nextButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof5 = act_Prof5.getText().toString();
                if (selected_Prof5.equals("Simon Reif")){
                    openReif();
                }
            }
        });
    }

    public void openReif(){
        Intent reif = new Intent(this, com.example.unirate30.PROFESSOR.reif.class);
        startActivity(reif);
    }

}