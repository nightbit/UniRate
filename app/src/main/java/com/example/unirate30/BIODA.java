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

public class BIODA extends AppCompatActivity {

    TextInputLayout til_Prof15;
    AutoCompleteTextView act_Prof15;

    ArrayList<String> ArrayList_Prof15;
    ArrayAdapter<String> ArrayAdapter_Prof15;

    ImageButton nextButton18;
    String selected_Prof15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_i_o_d);

        til_Prof15 = (TextInputLayout) findViewById(R.id.til_Prof15);
        act_Prof15 = (AutoCompleteTextView) findViewById(R.id.act_Prof15);

        ArrayList_Prof15 = new ArrayList<>();
        ArrayList_Prof15.add("Johannes Martinek");
        ArrayList_Prof15.add("Richard Pasteka");
        ArrayList_Prof15.add("Agnes Scheibenreif");


        ArrayAdapter_Prof15 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof15);
        act_Prof15.setAdapter(ArrayAdapter_Prof15);

        act_Prof15.setThreshold(1);

        nextButton18 = findViewById(R.id.nextButton18);
        nextButton18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof15 = act_Prof15.getText().toString();
                if (selected_Prof15.equals("Johannes Martinek")){
                    openMartinek();
                }if (selected_Prof15.equals("Richard Pasteka")){
                    openPasteka();
                }if (selected_Prof15.equals("Agnes Scheibenreif")){
                    openScheiben();
                }
            }
        });
    }
    public void openMartinek(){
        Intent martinek = new Intent(this, martinek.class);
        startActivity(martinek);
    }
    public void openPasteka(){
        Intent pasteka = new Intent(this, pasteka.class);
        startActivity(pasteka);
    }
    public void openScheiben(){
        Intent scheiben = new Intent(this, scheiben.class);
        startActivity(scheiben);
    }

}