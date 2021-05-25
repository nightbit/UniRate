package com.example.unirate30;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.STUDIENRICHTUNG.BBEFach;
import com.example.unirate30.STUDIENRICHTUNG.EaBFach;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Degree extends AppCompatActivity {

    public String selected_bachelor;
    private ImageButton nextButton2;

    TextInputLayout til_BsC;
    AutoCompleteTextView act_BsC;

    ArrayList<String> ArrayList_BsC;
    ArrayAdapter<String> ArrayAdapter_BsC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree);

        nextButton2 = findViewById(R.id.nextButton2);
        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_bachelor = act_BsC.getText().toString();
                if (selected_bachelor.equals("Biomedical Engineering")){
                    openBBEFach();
                }if (selected_bachelor.equals("Electronics and Business")){
                    openEaBFach();
                }
            }
        });
 
        til_BsC = (TextInputLayout) findViewById(R.id.til_BsC);
        act_BsC = (AutoCompleteTextView) findViewById(R.id.act_BsC);

        ArrayList_BsC = new ArrayList<>();
        ArrayList_BsC.add("Biomedical Engineering");
        ArrayList_BsC.add("Electronics and Business");

        ArrayAdapter_BsC = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_BsC);
        act_BsC.setAdapter(ArrayAdapter_BsC);

        act_BsC.setThreshold(1);
    }


    public void openBBEFach() {
        Intent intent3 = new Intent(this, BBEFach.class);
        startActivity(intent3);
    }
    public void openEaBFach() {
        Intent intent4 = new Intent(this, EaBFach.class);
        startActivity(intent4);
    }
    public void openEFach() {
        Intent intent5 = new Intent(this, BBEFach.class);
        startActivity(intent5);
    }
    public void openEWFach() {
        Intent intent6 = new Intent(this, BBEFach.class);
        startActivity(intent6);
    }
    public void openEEFach() {
        Intent intent7 = new Intent(this, BBEFach.class);
        startActivity(intent7);
    }
    public void openHFSEFach() {
        Intent intent8 = new Intent(this, BBEFach.class);
        startActivity(intent8);
    }
    public void openIFach() {
        Intent intent9 = new Intent(this, BBEFach.class);
        startActivity(intent9);
    }
    public void openIDualFach() {
        Intent intent10 = new Intent(this, BBEFach.class);
        startActivity(intent10);
    }
    public void openITJointFach() {
        Intent intent11 = new Intent(this, BBEFach.class);
        startActivity(intent11);
    }
    public void openIKFach() {
        Intent intent12 = new Intent(this, BBEFach.class);
        startActivity(intent12);
    }
    public void openIWFach() {
        Intent intent13 = new Intent(this, BBEFach.class);
        startActivity(intent13);
    }
    public void openMFach() {
        Intent intent14 = new Intent(this, BBEFach.class);
        startActivity(intent14);
    }
    public void openMRFach() {
        Intent intent15 = new Intent(this, BBEFach.class);
        startActivity(intent15);
    }
    public void openSHATFach() {
        Intent intent16 = new Intent(this, BBEFach.class);
        startActivity(intent16);
    }
    public void openWIFach() {
        Intent intent17 = new Intent(this, BBEFach.class);
        startActivity(intent17);
    }



}