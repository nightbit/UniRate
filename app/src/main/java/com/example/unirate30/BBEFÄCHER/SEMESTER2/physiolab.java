package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class physiolab extends AppCompatActivity {

    Button physlabbutton;
    RatingBar physlabbar1;
    RatingBar physlabbar2;
    RatingBar physlabbar3;

    TextInputLayout til_Profphyslab;
    AutoCompleteTextView act_Profphyslab;

    ArrayList<String> ArrayList_Profphyslab;
    ArrayAdapter<String> ArrayAdapter_Profphyslab;

    ImageButton physlabnextButton;
    String selected_Profphyslab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiolab);

        physlabbar1 = findViewById(R.id.physlabratingBar2);
        physlabbar1.setVisibility(View.INVISIBLE);
        physlabbar2 = findViewById(R.id.physlabratingBar4);
        physlabbar2.setVisibility(View.INVISIBLE);
        physlabbar3 = findViewById(R.id.physlabratingBar6);
        physlabbar3.setVisibility(View.INVISIBLE);

        til_Profphyslab = (TextInputLayout) findViewById(R.id.til_Profphyslab);
        act_Profphyslab = (AutoCompleteTextView) findViewById(R.id.act_Profphyslab);

        ArrayList_Profphyslab = new ArrayList<>();
        ArrayList_Profphyslab.add("Iris Nemec");
        ArrayList_Profphyslab.add("Andrea Balz");
        ArrayList_Profphyslab.add("Richard Pasteka");
        ArrayList_Profphyslab.add("Mathias Forjan");


        ArrayAdapter_Profphyslab = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Profphyslab);
        act_Profphyslab.setAdapter(ArrayAdapter_Profphyslab);

        act_Profphyslab.setThreshold(1);

        physlabbutton = findViewById(R.id.physlabbutton);
        physlabbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    physlabbar1.setVisibility(View.VISIBLE);
                    physlabbar2.setVisibility(View.VISIBLE);
                    physlabbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        physlabnextButton = findViewById(R.id.physlabnextButton);
        physlabnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Profphyslab= act_Profphyslab.getText().toString();
                if (selected_Profphyslab.equals("Iris Nemec")){
                    openNemec();
                }if (selected_Profphyslab.equals("Andrea Balz")){
                    openBalz();
                }if (selected_Profphyslab.equals("Richard Pasteka")){
                    openPasteka();
                }if (selected_Profphyslab.equals("Mathias Forjan")){
                    openForjan();
                }
            }
        });

    }

    public void openBalz(){
        Intent balz = new Intent(this, com.example.unirate30.PROFESSOR.Balz.class);
        startActivity(balz);
    }
    public void openPasteka(){
        Intent pasteka = new Intent(this, com.example.unirate30.PROFESSOR.pasteka.class);
        startActivity(pasteka);
    }
    public void openNemec(){
        Intent nemec = new Intent(this, com.example.unirate30.PROFESSOR.Nemec.class);
        startActivity(nemec);
    }
    public void openForjan(){
        Intent forjan = new Intent(this, com.example.unirate30.PROFESSOR.Forjan.class);
        startActivity(forjan);
    }

}