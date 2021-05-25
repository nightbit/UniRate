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

public class aphys extends AppCompatActivity {

    TextInputLayout til_Prof4;
    AutoCompleteTextView act_Prof4;

    ArrayList<String> ArrayList_Prof4;
    ArrayAdapter<String> ArrayAdapter_Prof4;

    ImageButton nextButton6;
    String selected_Prof4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aphys);

        til_Prof4 = (TextInputLayout) findViewById(R.id.til_Prof4);
        act_Prof4 = (AutoCompleteTextView) findViewById(R.id.act_Prof4);

        ArrayList_Prof4 = new ArrayList<>();
        ArrayList_Prof4.add("Christoph Mohl");


        ArrayAdapter_Prof4 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof4);
        act_Prof4.setAdapter(ArrayAdapter_Prof4);

        act_Prof4.setThreshold(1);

        nextButton6 = findViewById(R.id.nextButton7);
        nextButton6.setOnClickListener(new View.OnClickListener() {
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