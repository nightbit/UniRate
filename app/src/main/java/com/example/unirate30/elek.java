package com.example.unirate30;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class elek extends AppCompatActivity {

    TextInputLayout til_Prof16;
    AutoCompleteTextView act_Prof16;

    ArrayList<String> ArrayList_Prof16;
    ArrayAdapter<String> ArrayAdapter_Prof16;

    ImageButton nextButton19;
    String selected_Prof16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elek);

        til_Prof16 = (TextInputLayout) findViewById(R.id.til_Prof16);
        act_Prof16 = (AutoCompleteTextView) findViewById(R.id.act_Prof16);

        ArrayList_Prof16 = new ArrayList<>();
        ArrayList_Prof16.add("Stefan Sauermann");
        ArrayList_Prof16.add("Helmut Votzi");
        ArrayList_Prof16.add("Michael Windisch");


        ArrayAdapter_Prof16 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof16);
        act_Prof16.setAdapter(ArrayAdapter_Prof16);

        act_Prof16.setThreshold(1);

        nextButton19 = findViewById(R.id.nextButton19);
        nextButton19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof16 = act_Prof16.getText().toString();
                if (selected_Prof16.equals("Stefan Sauermann")){
                    openSauer();
                }if (selected_Prof16.equals("Helmut Votzi")){
                    openVotzi();
                }if (selected_Prof16.equals("Michael Windisch")){
                    openWindisch();
                }
            }
        });
    }

    public void openSauer(){
        Intent sauer = new Intent(this, Sauer.class);
        startActivity(sauer);
    }
    public void openVotzi(){
        Intent votzi = new Intent(this, Votzi.class);
        startActivity(votzi);
    }
    public void openWindisch(){
        Intent windisch = new Intent(this, Windisch.class);
        startActivity(windisch);
    }

}