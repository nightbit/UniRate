package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Huber;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class anat1 extends AppCompatActivity {

    Button anat1button;
    RatingBar anat1bar1;
    RatingBar anat1bar2;
    RatingBar anat1bar3;

    TextInputLayout til_Prof3;
    AutoCompleteTextView act_Prof3;

    ArrayList<String> ArrayList_Prof3;
    ArrayAdapter<String> ArrayAdapter_Prof3;

    ImageButton anat1nextButton;
    String selected_Profanat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anat1);

        anat1bar1 = findViewById(R.id.anat1ratingBar2);
        anat1bar1.setVisibility(View.INVISIBLE);
        anat1bar2 = findViewById(R.id.anat1ratingBar4);
        anat1bar2.setVisibility(View.INVISIBLE);
        anat1bar3 = findViewById(R.id.anat1ratingBar6);
        anat1bar3.setVisibility(View.INVISIBLE);

        til_Prof3 = (TextInputLayout) findViewById(R.id.til_Profanat1);
        act_Prof3 = (AutoCompleteTextView) findViewById(R.id.act_Profanat1);

        ArrayList_Prof3 = new ArrayList<>();
        ArrayList_Prof3.add("Marlis Huber");


        ArrayAdapter_Prof3 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof3);
        act_Prof3.setAdapter(ArrayAdapter_Prof3);

        act_Prof3.setThreshold(1);

        anat1button = findViewById(R.id.anat1button);
        anat1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    anat1bar1.setVisibility(View.VISIBLE);
                    anat1bar2.setVisibility(View.VISIBLE);
                    anat1bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        anat1nextButton = findViewById(R.id.anat1nextButton);
        anat1nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHuber();
            }
        });
    }
    public void openHuber(){
        Intent huber = new Intent(this, Huber.class );
        startActivity(huber);
    }
}