package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Costa;
import com.example.unirate30.PROFESSOR.Drausch;
import com.example.unirate30.PROFESSOR.Enghuber;
import com.example.unirate30.PROFESSOR.Knoebl;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

public class etbio extends AppCompatActivity {

    TextInputLayout til_Prof19;
    AutoCompleteTextView act_Prof19;

    ArrayList<String> ArrayList_Prof19;
    ArrayAdapter<String> ArrayAdapter_Prof19;

    ImageButton nextButton22;
    String selected_Prof19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etbio);

        til_Prof19 = (TextInputLayout) findViewById(R.id.til_Prof19);
        act_Prof19 = (AutoCompleteTextView) findViewById(R.id.act_Prof19);

        ArrayList_Prof19 = new ArrayList<>();
        ArrayList_Prof19.add("Andreas Drauschke");
        ArrayList_Prof19.add("Florian Enghuber");
        ArrayList_Prof19.add("Karl Knoebl");
        ArrayList_Prof19.add("Joao Pedro Santos da Costa");


        ArrayAdapter_Prof19 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof19);
        act_Prof19.setAdapter(ArrayAdapter_Prof19);
        act_Prof19.setThreshold(1);

        nextButton22 = findViewById(R.id.nextButton22);
        nextButton22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof19 = act_Prof19.getText().toString();

                if (selected_Prof19.equals("Andread Drauschke")) {
                    openDrausch();
                }
                    if (selected_Prof19.equals("Florian Enghuber")){
                        openEnghuber();
                    }
                    if (selected_Prof19.equals("Karl Knoebl")){
                        openKnoebl();
                    }
                    if (selected_Prof19.equals("Joao Pedro Santos da Costa")){
                        openCosta();
                    }
            }
        });

    }
        public void openDrausch(){
            Intent Drausch = new Intent(this, com.example.unirate30.PROFESSOR.Drausch.class);
            startActivity(Drausch);
        }
        public void openEnghuber(){
            Intent Enghuber = new Intent(this, com.example.unirate30.PROFESSOR.Enghuber.class);
            startActivity(Enghuber);
        }
        public void openKnoebl(){
            Intent Knoebl = new Intent(this, com.example.unirate30.PROFESSOR.Knoebl.class);
            startActivity(Knoebl);
        }
        public void openCosta(){
            Intent Costa = new Intent(this, com.example.unirate30.PROFESSOR.Costa.class);
            startActivity(Costa);
        }
}