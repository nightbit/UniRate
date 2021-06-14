package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.AHub;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class physiklab extends AppCompatActivity {

    Button phlabbutton;
    RatingBar phlabbar1;
    RatingBar phlabbar2;
    RatingBar phlabbar3;

    TextInputLayout til_Prof11;
    AutoCompleteTextView act_Prof11;

    ArrayList<String> ArrayList_Prof11;
    ArrayAdapter<String> ArrayAdapter_Prof11;

    ImageButton phlabnextButton;
    String selected_Profphlab;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiklab);

        phlabbar1 = findViewById(R.id.phlabratingBar2);
        phlabbar1.setVisibility(View.INVISIBLE);
        phlabbar2 = findViewById(R.id.phlabratingBar4);
        phlabbar2.setVisibility(View.INVISIBLE);
        phlabbar3 = findViewById(R.id.phlabratingBar6);
        phlabbar3.setVisibility(View.INVISIBLE);

        til_Prof11 = (TextInputLayout) findViewById(R.id.til_Profphlab);
        act_Prof11 = (AutoCompleteTextView) findViewById(R.id.act_Profphlab);

        ArrayList_Prof11 = new ArrayList<>();
        ArrayList_Prof11.add("Albert Huber");

        ArrayAdapter_Prof11 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof11);
        act_Prof11.setAdapter(ArrayAdapter_Prof11);

        act_Prof11.setThreshold(1);

        phlabbutton = findViewById(R.id.phlabbutton);
        phlabbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    phlabbar1.setVisibility(View.VISIBLE);
                    phlabbar2.setVisibility(View.VISIBLE);
                    phlabbar3.setVisibility(View.VISIBLE);

                }
            }
        });


        phlabnextButton = findViewById(R.id.phlabnextButton);
        phlabnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profphlab = act_Prof11.getText().toString();
                if (selected_Profphlab.equals("Albert Huber")){
                    openAHub();
                }
            }
        });
    }

    public void openAHub(){
        Intent ahub = new Intent(this, AHub.class);
        startActivity(ahub);
    }

}