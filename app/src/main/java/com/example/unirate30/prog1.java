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

public class prog1 extends AppCompatActivity {

    TextInputLayout til_Prof6;
    AutoCompleteTextView act_Prof6;

    ArrayList<String> ArrayList_Prof6;
    ArrayAdapter<String> ArrayAdapter_Prof6;

    ImageButton nextButton9;
    String selected_Prof6;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog1);

        til_Prof6 = (TextInputLayout) findViewById(R.id.til_Prof6);
        act_Prof6 = (AutoCompleteTextView) findViewById(R.id.act_Prof6);

        ArrayList_Prof6 = new ArrayList<>();
        ArrayList_Prof6.add("Matthias Frohner");
        ArrayList_Prof6.add("Johannes Martinek");
        ArrayList_Prof6.add("Philipp Urbauer");


        ArrayAdapter_Prof6 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof6);
        act_Prof6.setAdapter(ArrayAdapter_Prof6);

        act_Prof6.setThreshold(1);

        nextButton9 = findViewById(R.id.nextButton9);
        nextButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof6 = act_Prof6.getText().toString();
                if (selected_Prof6.equals("Matthias Frohner")){
                    openFrohner();
                }if (selected_Prof6.equals("Johannes Martinek")){
                    openMartinek();
                }if (selected_Prof6.equals("Philipp Urbauer")){
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