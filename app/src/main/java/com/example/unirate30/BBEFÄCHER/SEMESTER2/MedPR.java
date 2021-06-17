package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MedPR extends AppCompatActivity {

    Button medbutton;
    RatingBar medbar1;
    RatingBar medbar2;
    RatingBar medbar3;

    TextInputLayout til_Profmed;
    AutoCompleteTextView act_Profmed;

    ArrayList<String> ArrayList_Profmed;
    ArrayAdapter<String> ArrayAdapter_Profmed;

    ImageButton mednextButton;
    String selected_Profmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_p_r);

        medbar1 = findViewById(R.id.medratingBar2);
        medbar1.setVisibility(View.INVISIBLE);
        medbar2 = findViewById(R.id.medratingBar4);
        medbar2.setVisibility(View.INVISIBLE);
        medbar3 = findViewById(R.id.medratingBar6);
        medbar3.setVisibility(View.INVISIBLE);

        til_Profmed = (TextInputLayout) findViewById(R.id.til_Profmed);
        act_Profmed = (AutoCompleteTextView) findViewById(R.id.act_Profmed);

        ArrayList_Profmed = new ArrayList<>();
        ArrayList_Profmed.add("Johannes Martinek");
        ArrayList_Profmed.add("Matthias Scherer");
        ArrayList_Profmed.add("Philipp Urbauer");

        ArrayAdapter_Profmed = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Profmed);
        act_Profmed.setAdapter(ArrayAdapter_Profmed);

        act_Profmed.setThreshold(1);

        medbutton = findViewById(R.id.medbutton);
        medbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    medbar1.setVisibility(View.VISIBLE);
                    medbar2.setVisibility(View.VISIBLE);
                    medbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        mednextButton = findViewById(R.id.mednextButton);
        mednextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profmed= act_Profmed.getText().toString();
                if (selected_Profmed.equals("Johannes Martinek")){
                    openMartinek();
                }if (selected_Profmed.equals("Matthias Scherer")){
                    openScherer();
                }if (selected_Profmed.equals("Philipp Urbauer")){
                    openUrbauer();
                }
            }
        });

    }

    public void openScherer(){
        Intent scherer = new Intent(this, com.example.unirate30.PROFESSOR.Scherer.class);
        startActivity(scherer);
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