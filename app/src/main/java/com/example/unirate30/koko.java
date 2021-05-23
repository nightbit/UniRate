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

public class koko extends AppCompatActivity {

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

        til_Prof9 = (TextInputLayout) findViewById(R.id.til_Prof9);
        act_Prof9 = (AutoCompleteTextView) findViewById(R.id.act_Prof9);

        ArrayList_Prof9 = new ArrayList<>();
        ArrayList_Prof9.add("Christian Brabetz");
        ArrayList_Prof9.add("Johannes Martinek");
        ArrayList_Prof9.add("Philipp Urbauer");


        ArrayAdapter_Prof9 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof9);
        act_Prof9.setAdapter(ArrayAdapter_Prof9);

        act_Prof9.setThreshold(1);

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
        Intent brabetz = new Intent(this, brabetz.class);
        startActivity(brabetz);
    }
}