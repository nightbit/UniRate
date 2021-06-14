package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class aphys extends AppCompatActivity {

    Button aphysbutton;
    RatingBar aphysbar1;
    RatingBar aphysbar2;
    RatingBar aphysbar3;

    TextInputLayout til_Prof4;
    AutoCompleteTextView act_Prof4;

    ArrayList<String> ArrayList_Prof4;
    ArrayAdapter<String> ArrayAdapter_Prof4;

    ImageButton aphysnextButton;
    String selected_Profaphys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aphys);

        aphysbar1 = findViewById(R.id.aphysratingBar2);
        aphysbar1.setVisibility(View.INVISIBLE);
        aphysbar2 = findViewById(R.id.aphysratingBar4);
        aphysbar2.setVisibility(View.INVISIBLE);
        aphysbar3 = findViewById(R.id.aphysratingBar6);
        aphysbar3.setVisibility(View.INVISIBLE);

        til_Prof4 = (TextInputLayout) findViewById(R.id.til_Profaphys);
        act_Prof4 = (AutoCompleteTextView) findViewById(R.id.act_Profaphys);

        ArrayList_Prof4 = new ArrayList<>();
        ArrayList_Prof4.add("Christoph Mohl");


        ArrayAdapter_Prof4 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof4);
        act_Prof4.setAdapter(ArrayAdapter_Prof4);

        act_Prof4.setThreshold(1);

        aphysbutton = findViewById(R.id.aphysbutton);
        aphysbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true){
                    aphysbar1.setVisibility(View.VISIBLE);
                    aphysbar2.setVisibility(View.VISIBLE);
                    aphysbar3.setVisibility(View.VISIBLE);

                }
            }
        });

        aphysnextButton = findViewById(R.id.aphysnextButton);
        aphysnextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMohl();
            }
        });

    }

    public void openMohl(){
        Intent mohl = new Intent(this, com.example.unirate30.PROFESSOR.mohl.class);
        startActivity(mohl);
    }

}