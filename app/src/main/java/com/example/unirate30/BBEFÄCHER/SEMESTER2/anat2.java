package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Huber;
import com.example.unirate30.PROFESSOR.Jesen;
import com.example.unirate30.PROFESSOR.Praher;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class anat2 extends AppCompatActivity {

    TextInputLayout til_Prof14;
    AutoCompleteTextView act_Prof14;

    ArrayList<String> ArrayList_Prof14;
    ArrayAdapter<String> ArrayAdapter_Prof14;

    ImageButton nextButton17;
    String selected_Prof14;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anat2);

        til_Prof14 = (TextInputLayout) findViewById(R.id.til_Prof14);
        act_Prof14 = (AutoCompleteTextView) findViewById(R.id.act_Prof14);

        ArrayList_Prof14 = new ArrayList<>();
        ArrayList_Prof14.add("Marlis Huber");
        ArrayList_Prof14.add("Veronika Jesenberger");
        ArrayList_Prof14.add("Daniela Praher");


        ArrayAdapter_Prof14 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof14);
        act_Prof14.setAdapter(ArrayAdapter_Prof14);

        act_Prof14.setThreshold(1);

        nextButton17 = findViewById(R.id.nextButton17);
        nextButton17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            selected_Prof14 = act_Prof14.getText().toString();
            if (selected_Prof14.equals("Marlis Huber")){
                openHuber();
            }if (selected_Prof14.equals("Veronika Jesenberger")){
                openJesen();
            }if (selected_Prof14.equals("Daniela Praher")){
                openPraher();
                }
            }
        });
    }
    public void openHuber(){
        Intent huber = new Intent(this, Huber.class );
        startActivity(huber);
    }
    public void openJesen(){
        Intent jesen = new Intent(this, Jesen.class );
        startActivity(jesen);
    }
    public void openPraher(){
        Intent praher = new Intent(this, Praher.class );
        startActivity(praher);
    }

}