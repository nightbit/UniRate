package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Huber;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class anat1 extends AppCompatActivity {

    TextInputLayout til_Prof3;
    AutoCompleteTextView act_Prof3;

    ArrayList<String> ArrayList_Prof3;
    ArrayAdapter<String> ArrayAdapter_Prof3;

    ImageButton nextButton6;
    String selected_Prof3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anat1);

        til_Prof3 = (TextInputLayout) findViewById(R.id.til_Prof3);
        act_Prof3 = (AutoCompleteTextView) findViewById(R.id.act_Prof3);

        ArrayList_Prof3 = new ArrayList<>();
        ArrayList_Prof3.add("Marlis Huber");


        ArrayAdapter_Prof3 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof3);
        act_Prof3.setAdapter(ArrayAdapter_Prof3);

        act_Prof3.setThreshold(1);

        nextButton6 = findViewById(R.id.nextButton6);
        nextButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHuber();
            }
        });
    }
    public void openHuber(){
        Intent huber = new Intent(this, Huber.class );
        startActivity(huber);
    }
}