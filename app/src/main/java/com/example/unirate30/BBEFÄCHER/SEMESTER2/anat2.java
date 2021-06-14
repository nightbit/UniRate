package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Huber;
import com.example.unirate30.PROFESSOR.Jesen;
import com.example.unirate30.PROFESSOR.Praher;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class anat2 extends AppCompatActivity {

    Button anat2button;
    RatingBar anat2bar1;
    RatingBar anat2bar2;
    RatingBar anat2bar3;

    TextInputLayout til_Prof14;
    AutoCompleteTextView act_Prof14;

    ArrayList<String> ArrayList_Prof14;
    ArrayAdapter<String> ArrayAdapter_Prof14;

    ImageButton anat2nextButton;
    String selected_Profanat2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anat2);

        anat2bar1 = findViewById(R.id.anat2ratingBar2);
        anat2bar1.setVisibility(View.INVISIBLE);
        anat2bar2 = findViewById(R.id.anat2ratingBar4);
        anat2bar2.setVisibility(View.INVISIBLE);
        anat2bar3 = findViewById(R.id.anat2ratingBar6);
        anat2bar3.setVisibility(View.INVISIBLE);

        til_Prof14 = (TextInputLayout) findViewById(R.id.til_Profanat2);
        act_Prof14 = (AutoCompleteTextView) findViewById(R.id.act_Profanat2);

        ArrayList_Prof14 = new ArrayList<>();
        ArrayList_Prof14.add("Marlis Huber");
        ArrayList_Prof14.add("Veronika Jesenberger");
        ArrayList_Prof14.add("Daniela Praher");


        ArrayAdapter_Prof14 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof14);
        act_Prof14.setAdapter(ArrayAdapter_Prof14);

        act_Prof14.setThreshold(1);

        anat2button = findViewById(R.id.anat2button);
        anat2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    anat2bar1.setVisibility(View.VISIBLE);
                    anat2bar2.setVisibility(View.VISIBLE);
                    anat2bar3.setVisibility(View.VISIBLE);

                }
            }
        });

        anat2nextButton = findViewById(R.id.anat2nextButton);
        anat2nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            selected_Profanat2 = act_Prof14.getText().toString();
            if (selected_Profanat2.equals("Marlis Huber")){
                openHuber();
            }if (selected_Profanat2.equals("Veronika Jesenberger")){
                openJesen();
            }if (selected_Profanat2.equals("Daniela Praher")){
                openPraher();
                }
            }
        });
    }
    public void openHuber(){
        Intent huber = new Intent(this, Huber.class );
        startActivity(huber);
    }
    public void openJesen(){
        Intent jesen = new Intent(this, Jesen.class );
        startActivity(jesen);
    }
    public void openPraher(){
        Intent praher = new Intent(this, Praher.class );
        startActivity(praher);
    }

}