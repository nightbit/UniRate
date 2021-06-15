package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Eitel;
import com.example.unirate30.PROFESSOR.Varvara;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class angchemlab extends AppCompatActivity {

    Button anglabbutton;
    RatingBar anglabbar1;
    RatingBar anglabbar2;
    RatingBar anglabbar3;

    TextInputLayout til_Prof13;
    AutoCompleteTextView act_Prof13;

    ArrayList<String> ArrayList_Prof13;
    ArrayAdapter<String> ArrayAdapter_Prof13;

    ImageButton labnextButton;
    String labselected_Prof;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angchemlab);

        anglabbar1 = findViewById(R.id.anglabratingBar2);
        anglabbar1.setVisibility(View.INVISIBLE);
        anglabbar2 = findViewById(R.id.anglabratingBar4);
        anglabbar2.setVisibility(View.INVISIBLE);
        anglabbar3 = findViewById(R.id.anglabratingBar6);
        anglabbar3.setVisibility(View.INVISIBLE);


        til_Prof13 = (TextInputLayout) findViewById(R.id.til_Profanglab);
        act_Prof13 = (AutoCompleteTextView) findViewById(R.id.act_Profanglab);

        ArrayList_Prof13 = new ArrayList<>();
        ArrayList_Prof13.add("Barbara Gepp");
        ArrayList_Prof13.add("Ursula Knaack");
        ArrayList_Prof13.add("Heidemarie Fuchs-Eitel");
        ArrayList_Prof13.add("Varvara Liousia");

        ArrayAdapter_Prof13 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof13);
        act_Prof13.setAdapter(ArrayAdapter_Prof13);

        act_Prof13.setThreshold(1);

        anglabbutton = findViewById(R.id.anglabbutton);
        anglabbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    anglabbar1.setVisibility(View.VISIBLE);
                    anglabbar2.setVisibility(View.VISIBLE);
                    anglabbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        labnextButton = findViewById(R.id.anglabnextButton);
        labnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                labselected_Prof = act_Prof13.getText().toString();
                if (labselected_Prof.equals("Barbara Gepp")){
                    openGepp();
                }if (labselected_Prof.equals("Ursula Knaack")){
                    openKnaack();
                }if (labselected_Prof.equals("Heidemarie Fuchs-Eitel")){
                    openEitel();
                }if (labselected_Prof.equals("Varvara Liousia")){
                    openVarvara();
                }

            }
        });
    }
    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openKnaack() {
        Intent Knaack = new Intent(this, com.example.unirate30.PROFESSOR.Knaack.class);
        startActivity(Knaack);
    }
    public void openEitel() {
        Intent eitel = new Intent(this, Eitel.class);
        startActivity(eitel);
    }
    public void openVarvara() {
        Intent varvara = new Intent(this, Varvara.class);
        startActivity(varvara);
    }
}