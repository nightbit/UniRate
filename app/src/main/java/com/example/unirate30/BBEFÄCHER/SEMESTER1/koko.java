package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class koko extends AppCompatActivity {

    Button kokobutton20;
    RatingBar kokobar1;
    RatingBar kokobar2;
    RatingBar kokobar3;

    TextInputLayout til_Prof9;
    AutoCompleteTextView act_Prof9;

    ArrayList<String> ArrayList_Prof9;
    ArrayAdapter<String> ArrayAdapter_Prof9;

    ImageButton nextButton12;
    String selected_Prof9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koko);

        kokobar1 = findViewById(R.id.kokoratingBar2);
        kokobar1.setVisibility(View.INVISIBLE);
        kokobar2 = findViewById(R.id.kokoratingBar4);
        kokobar2.setVisibility(View.INVISIBLE);
        kokobar3 = findViewById(R.id.kokoratingBar6);
        kokobar3.setVisibility(View.INVISIBLE);

        til_Prof9 = (TextInputLayout) findViewById(R.id.til_Prof9);
        act_Prof9 = (AutoCompleteTextView) findViewById(R.id.act_Prof9);

        ArrayList_Prof9 = new ArrayList<>();
        ArrayList_Prof9.add("Christian Brabetz");
        ArrayList_Prof9.add("Johannes Martinek");
        ArrayList_Prof9.add("Philipp Urbauer");


        ArrayAdapter_Prof9 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof9);
        act_Prof9.setAdapter(ArrayAdapter_Prof9);

        act_Prof9.setThreshold(1);

        kokobutton20 = findViewById(R.id.kokobutton6);
        kokobutton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    kokobar1.setVisibility(View.VISIBLE);
                    kokobar2.setVisibility(View.VISIBLE);
                    kokobar3.setVisibility(View.VISIBLE);

                }
            }
        });

        nextButton12 = findViewById(R.id.nextButton12);
        nextButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof9 = act_Prof9.getText().toString();
                if (selected_Prof9.equals("Christian Brabetz")){
                    openBrabetz();
                }
            }
        });
    }

    public void openBrabetz(){
        Intent brabetz = new Intent(this, com.example.unirate30.PROFESSOR.brabetz.class);
        startActivity(brabetz);
    }
}
