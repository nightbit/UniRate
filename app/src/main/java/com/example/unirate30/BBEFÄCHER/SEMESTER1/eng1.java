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

public class eng1 extends AppCompatActivity {

    TextInputLayout til_Prof8;
    AutoCompleteTextView act_Prof8;

    ArrayList<String> ArrayList_Prof8;
    ArrayAdapter<String> ArrayAdapter_Prof8;

    ImageButton nextButton11;
    String selected_Prof8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng1);

        til_Prof8 = (TextInputLayout) findViewById(R.id.til_Prof8);
        act_Prof8 = (AutoCompleteTextView) findViewById(R.id.act_Prof8);

        ArrayList_Prof8 = new ArrayList<>();
        ArrayList_Prof8.add("Patricia Chan Stephenson");
        ArrayList_Prof8.add("Johannes Martinek");
        ArrayList_Prof8.add("Philipp Urbauer");


        ArrayAdapter_Prof8 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof8);
        act_Prof8.setAdapter(ArrayAdapter_Prof8);

        act_Prof8.setThreshold(1);

        nextButton11 = findViewById(R.id.nextButton11);
        nextButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof8 = act_Prof8.getText().toString();
                if (selected_Prof8.equals("Patricia Chan Stephenson")){
                    openPatricia();
                }
            }
        });
    }

    public void openPatricia(){
        Intent patricia = new Intent(this, com.example.unirate30.PROFESSOR.patricia.class);
        startActivity(patricia);
    }

}