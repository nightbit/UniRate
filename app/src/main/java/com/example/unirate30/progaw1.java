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

public class progaw1 extends AppCompatActivity {

    TextInputLayout til_Prof7;
    AutoCompleteTextView act_Prof7;

    ArrayList<String> ArrayList_Prof7;
    ArrayAdapter<String> ArrayAdapter_Prof7;

    ImageButton nextButton10;
    String selected_Prof7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progaw1);

        til_Prof7 = (TextInputLayout) findViewById(R.id.til_Prof7);
        act_Prof7 = (AutoCompleteTextView) findViewById(R.id.act_Prof7);

        ArrayList_Prof7 = new ArrayList<>();
        ArrayList_Prof7.add("Matthias Frohner");
        ArrayList_Prof7.add("Johannes Martinek");
        ArrayList_Prof7.add("Philipp Urbauer");


        ArrayAdapter_Prof7 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof7);
        act_Prof7.setAdapter(ArrayAdapter_Prof7);

        act_Prof7.setThreshold(1);

        nextButton10 = findViewById(R.id.nextButton10);
        nextButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof7 = act_Prof7.getText().toString();
                if (selected_Prof7.equals("Matthias Frohner")){
                    openFrohner();
                }if (selected_Prof7.equals("Johannes Martinek")){
                    openMartinek();
                }if (selected_Prof7.equals("Philipp Urbauer")){
                    openUrbauer();
                }
            }
        });
    }

    public void openFrohner(){
        Intent frohner = new Intent(this, frohner.class);
        startActivity(frohner);
    }
    public void openMartinek(){
        Intent martinek = new Intent(this, martinek.class);
        startActivity(martinek);
    }
    public void openUrbauer(){
        Intent urbauer = new Intent(this, urbauer.class);
        startActivity(urbauer);
    }

}