package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Teuschel;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class angchem extends AppCompatActivity {

    Button angbutton;
    RatingBar angbar1;
    RatingBar angbar2;
    RatingBar angbar3;

    TextInputLayout til_Prof12;
    AutoCompleteTextView act_Prof12;

    ArrayList<String> ArrayList_Prof12;
    ArrayAdapter<String> ArrayAdapter_Prof12;

    ImageButton angnextButton;
    String angselected_Prof;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angchem);

        angbar1 = findViewById(R.id.angratingBar2);
        angbar1.setVisibility(View.INVISIBLE);
        angbar2 = findViewById(R.id.angratingBar4);
        angbar2.setVisibility(View.INVISIBLE);
        angbar3 = findViewById(R.id.angratingBar6);
        angbar3.setVisibility(View.INVISIBLE);

        til_Prof12 = (TextInputLayout) findViewById(R.id.til_Profang);
        act_Prof12 = (AutoCompleteTextView) findViewById(R.id.act_Profang);

        ArrayList_Prof12 = new ArrayList<>();
        ArrayList_Prof12.add("Barbara Gepp");
        ArrayList_Prof12.add("Andreas Teuschl");

        ArrayAdapter_Prof12 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof12);
        act_Prof12.setAdapter(ArrayAdapter_Prof12);

        act_Prof12.setThreshold(1);

        angbutton = findViewById(R.id.angbutton);
        angbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    angbar1.setVisibility(View.VISIBLE);
                    angbar2.setVisibility(View.VISIBLE);
                    angbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        angnextButton = findViewById(R.id.angnextButton);
        angnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angselected_Prof = act_Prof12.getText().toString();
                if (angselected_Prof.equals("Barbara Gepp")){
                    openGepp();
                }if (angselected_Prof.equals("Andreas Teuschl")){
                    openTeuschel();
                }
            }
        });
    }

    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openTeuschel() {
        Intent teuschel = new Intent(this, Teuschel.class);
        startActivity(teuschel);
    }
}