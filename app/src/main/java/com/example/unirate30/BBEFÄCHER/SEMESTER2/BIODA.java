package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class BIODA extends AppCompatActivity {

    Button biobutton;
    RatingBar biobar1;
    RatingBar biobar2;
    RatingBar biobar3;

    TextInputLayout til_Prof15;
    AutoCompleteTextView act_Prof15;

    ArrayList<String> ArrayList_Prof15;
    ArrayAdapter<String> ArrayAdapter_Prof15;

    ImageButton bionextButton;
    String bioselected_Prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_i_o_d);

        biobar1 = findViewById(R.id.bioratingBar2);
        biobar1.setVisibility(View.INVISIBLE);
        biobar2 = findViewById(R.id.bioratingBar4);
        biobar2.setVisibility(View.INVISIBLE);
        biobar3 = findViewById(R.id.bioratingBar6);
        biobar3.setVisibility(View.INVISIBLE);

        til_Prof15 = (TextInputLayout) findViewById(R.id.til_Profbio);
        act_Prof15 = (AutoCompleteTextView) findViewById(R.id.act_Profbio);

        ArrayList_Prof15 = new ArrayList<>();
        ArrayList_Prof15.add("Johannes Martinek");
        ArrayList_Prof15.add("Richard Pasteka");
        ArrayList_Prof15.add("Agnes Scheibenreif");


        ArrayAdapter_Prof15 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof15);
        act_Prof15.setAdapter(ArrayAdapter_Prof15);

        act_Prof15.setThreshold(1);

        biobutton = findViewById(R.id.biobutton);
        biobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    biobar1.setVisibility(View.VISIBLE);
                    biobar2.setVisibility(View.VISIBLE);
                    biobar3.setVisibility(View.VISIBLE);

                }
            }
        });

        bionextButton = findViewById(R.id.bionextButton);
        bionextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bioselected_Prof = act_Prof15.getText().toString();
                if (bioselected_Prof.equals("Johannes Martinek")){
                    openMartinek();
                }if (bioselected_Prof.equals("Richard Pasteka")){
                    openPasteka();
                }if (bioselected_Prof.equals("Agnes Scheibenreif")){
                    openScheiben();
                }
            }
        });
    }
    public void openMartinek(){
        Intent martinek = new Intent(this, com.example.unirate30.PROFESSOR.martinek.class);
        startActivity(martinek);
    }
    public void openPasteka(){
        Intent pasteka = new Intent(this, com.example.unirate30.PROFESSOR.pasteka.class);
        startActivity(pasteka);
    }
    public void openScheiben(){
        Intent scheiben = new Intent(this, com.example.unirate30.PROFESSOR.scheiben.class);
        startActivity(scheiben);
    }

}