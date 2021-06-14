package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class kreko extends AppCompatActivity {

    Button krekobutton20;
    RatingBar krekobar1;
    RatingBar krekobar2;
    RatingBar krekobar3;

    TextInputLayout til_Prof9kreko;
    AutoCompleteTextView act_Prof9kreko;

    ArrayList<String> ArrayList_Prof9kreko;
    ArrayAdapter<String> ArrayAdapter_Prof9kreko;

    ImageButton krekonextButton12;
    String selected_Prof9kreko;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kreko);

        krekobar1 = findViewById(R.id.krekoratingBar2);
        krekobar1.setVisibility(View.INVISIBLE);
        krekobar2 = findViewById(R.id.krekoratingBar4);
        krekobar2.setVisibility(View.INVISIBLE);
        krekobar3 = findViewById(R.id.krekoratingBar6);
        krekobar3.setVisibility(View.INVISIBLE);


        til_Prof9kreko = (TextInputLayout) findViewById(R.id.til_Prof9kreko);
        act_Prof9kreko = (AutoCompleteTextView) findViewById(R.id.act_Prof9kreko);

        ArrayList_Prof9kreko = new ArrayList<>();
        ArrayList_Prof9kreko.add("Michael Wekerle-Dreier");


        ArrayAdapter_Prof9kreko = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof9kreko);
        act_Prof9kreko.setAdapter(ArrayAdapter_Prof9kreko);

        act_Prof9kreko.setThreshold(1);

        krekobutton20 = findViewById(R.id.krekobutton6);
        krekobutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    krekobar1.setVisibility(View.VISIBLE);
                    krekobar2.setVisibility(View.VISIBLE);
                    krekobar3.setVisibility(View.VISIBLE);

                }
            }
        });

        krekonextButton12 = findViewById(R.id.krekonextButton12);
        krekonextButton12.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selected_Prof9kreko = act_Prof9kreko.getText().toString();
                if (selected_Prof9kreko.equals("Michael Wekerle-Dreier")) {
                    opendreiner();
                }
            }
        });
    }
        public void opendreiner() {
            Intent Dreiner = new Intent(this, com.example.unirate30.PROFESSOR.dreiner.class);
            startActivity(Dreiner);
    }
}
