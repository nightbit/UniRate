package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class prog1 extends AppCompatActivity {

    Button prog1button;
    RatingBar prog1bar1;
    RatingBar prog1bar2;
    RatingBar prog1bar3;

    TextInputLayout til_Prof6;
    AutoCompleteTextView act_Prof6;

    ArrayList<String> ArrayList_Prof6;
    ArrayAdapter<String> ArrayAdapter_Prof6;

    ImageButton prog1nextButton;
    String selected_Profprog1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog1);

        prog1bar1 = findViewById(R.id.prog1ratingBar2);
        prog1bar1.setVisibility(View.INVISIBLE);
        prog1bar2 = findViewById(R.id.prog1ratingBar4);
        prog1bar2.setVisibility(View.INVISIBLE);
        prog1bar3 = findViewById(R.id.prog1ratingBar6);
        prog1bar3.setVisibility(View.INVISIBLE);

        til_Prof6 = (TextInputLayout) findViewById(R.id.til_Profprog1);
        act_Prof6 = (AutoCompleteTextView) findViewById(R.id.act_Profprog1);

        ArrayList_Prof6 = new ArrayList<>();
        ArrayList_Prof6.add("Matthias Frohner");
        ArrayList_Prof6.add("Johannes Martinek");
        ArrayList_Prof6.add("Philipp Urbauer");


        ArrayAdapter_Prof6 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof6);
        act_Prof6.setAdapter(ArrayAdapter_Prof6);

        act_Prof6.setThreshold(1);

        prog1button = findViewById(R.id.prog1button);
        prog1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    prog1bar1.setVisibility(View.VISIBLE);
                    prog1bar2.setVisibility(View.VISIBLE);
                    prog1bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        prog1nextButton = findViewById(R.id.prog1nextButton);
        prog1nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profprog1 = act_Prof6.getText().toString();
                if (selected_Profprog1.equals("Matthias Frohner")){
                    openFrohner();
                }if (selected_Profprog1.equals("Johannes Martinek")){
                    openMartinek();
                }if (selected_Profprog1.equals("Philipp Urbauer")){
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