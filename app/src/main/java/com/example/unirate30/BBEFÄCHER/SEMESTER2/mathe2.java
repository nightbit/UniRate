package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.reif;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

public class mathe2 extends AppCompatActivity {

    TextInputLayout til_Prof18;
    AutoCompleteTextView act_Prof18;

    ArrayList<String> ArrayList_Prof18;
    ArrayAdapter<String> ArrayAdapter_Prof18;

    ImageButton nextButton21;
    String selected_Prof18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathe2);

        til_Prof18 = (TextInputLayout) findViewById(R.id.til_Prof18);
        act_Prof18 = (AutoCompleteTextView) findViewById(R.id.act_Prof18);

        ArrayList_Prof18 = new ArrayList<>();
        ArrayList_Prof18.add("Simon Reif");
        ArrayList_Prof18.add("Filler");



        ArrayAdapter_Prof18 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof18);
        act_Prof18.setAdapter(ArrayAdapter_Prof18);

        act_Prof18.setThreshold(1);

        nextButton21 = findViewById(R.id.nextButton21);
        nextButton21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof18 = act_Prof18.getText().toString();
                if (selected_Prof18.equals("Simon Reif")) {
                    openreif();
                }
                    if (selected_Prof18.equals("Filler")) {
                        openFiller();
                    }
            }
        });

    }
        public void openreif(){
            Intent Reif = new Intent(this, com.example.unirate30.PROFESSOR.reif.class);
            startActivity(Reif);
        }
        public void openFiller(){
            Intent Filler = new Intent(this, com.example.unirate30.PROFESSOR.Filler.class);
            startActivity(Filler);
        }
}