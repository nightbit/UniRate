package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class eng2 extends AppCompatActivity {

    TextInputLayout til_Prof17;
    AutoCompleteTextView act_Prof17;

    ArrayList<String> ArrayList_Prof17;
    ArrayAdapter<String> ArrayAdapter_Prof17;

    ImageButton nextButton20;
    String selected_Prof17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng2);

        til_Prof17 = (TextInputLayout) findViewById(R.id.til_Prof17);
        act_Prof17 = (AutoCompleteTextView) findViewById(R.id.act_Prof17);

        ArrayList_Prof17 = new ArrayList<>();
        ArrayList_Prof17.add("Ruth Schenk");
        ArrayList_Prof17.add("Chanda Vanderhart");



        ArrayAdapter_Prof17 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof17);
        act_Prof17.setAdapter(ArrayAdapter_Prof17);

        act_Prof17.setThreshold(1);

        nextButton20 = findViewById(R.id.nextButton20);
        nextButton20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof17 = act_Prof17.getText().toString();
                if (selected_Prof17.equals("Ruth Schenk")) {
                    openSchenk();
                }
                    if (selected_Prof17.equals("Chanda Vanderhart")){
                        openVander();
                    }
                }

        });
    }
    public void openSchenk(){
        Intent Schenk = new Intent(this, com.example.unirate30.PROFESSOR.Schenk.class);
        startActivity(Schenk);
    }

    public void openVander(){
        Intent Vander = new Intent(this, com.example.unirate30.PROFESSOR.Vander.class);
        startActivity(Vander);
    }

}

