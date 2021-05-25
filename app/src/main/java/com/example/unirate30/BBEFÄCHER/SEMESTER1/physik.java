package com.example.unirate30.BBEFÄCHER.SEMESTER1;

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

public class physik extends AppCompatActivity {

    TextInputLayout til_Prof10;
    AutoCompleteTextView act_Prof10;

    ArrayList<String> ArrayList_Prof10;
    ArrayAdapter<String> ArrayAdapter_Prof10;

    ImageButton nextButton13;
    String selected_Prof10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physik);

        til_Prof10 = (TextInputLayout) findViewById(R.id.til_Prof10);
        act_Prof10 = (AutoCompleteTextView) findViewById(R.id.act_Prof10);

        ArrayList_Prof10 = new ArrayList<>();
        ArrayList_Prof10.add("Lukas Mairhofer");

        ArrayAdapter_Prof10 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof10);
        act_Prof10.setAdapter(ArrayAdapter_Prof10);

        act_Prof10.setThreshold(1);

        nextButton13 = findViewById(R.id.nextButton13);
        nextButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaierhofer();
            }
        });
    }

    public void openMaierhofer(){
        Intent maierhofer = new Intent(this, com.example.unirate30.PROFESSOR.maierhofer.class);
        startActivity(maierhofer);
    }
}