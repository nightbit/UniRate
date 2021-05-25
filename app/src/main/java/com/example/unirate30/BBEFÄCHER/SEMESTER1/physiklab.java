package com.example.unirate30.BBEFÄCHER.SEMESTER1;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.AHub;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class physiklab extends AppCompatActivity {

    TextInputLayout til_Prof11;
    AutoCompleteTextView act_Prof11;

    ArrayList<String> ArrayList_Prof11;
    ArrayAdapter<String> ArrayAdapter_Prof11;

    ImageButton nextButton14;
    String selected_Prof11;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physiklab);

        til_Prof11 = (TextInputLayout) findViewById(R.id.til_Prof11);
        act_Prof11 = (AutoCompleteTextView) findViewById(R.id.act_Prof11);

        ArrayList_Prof11 = new ArrayList<>();
        ArrayList_Prof11.add("Albert Huber");

        ArrayAdapter_Prof11 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof11);
        act_Prof11.setAdapter(ArrayAdapter_Prof11);

        act_Prof11.setThreshold(1);

        nextButton14 = findViewById(R.id.nextButton14);
        nextButton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof11 = act_Prof11.getText().toString();
                if (selected_Prof11.equals("Albert Huber")){
                    openAHub();
                }
            }
        });
    }

    public void openAHub(){
        Intent ahub = new Intent(this, AHub.class);
        startActivity(ahub);
    }

}