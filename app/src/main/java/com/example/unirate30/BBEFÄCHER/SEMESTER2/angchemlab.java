package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Eitel;
import com.example.unirate30.PROFESSOR.Varvara;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class angchemlab extends AppCompatActivity {

    TextInputLayout til_Prof13;
    AutoCompleteTextView act_Prof13;

    ArrayList<String> ArrayList_Prof13;
    ArrayAdapter<String> ArrayAdapter_Prof13;

    ImageButton nextButton16;
    String selected_Prof13;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angchemlab);

        til_Prof13 = (TextInputLayout) findViewById(R.id.til_Prof13);
        act_Prof13 = (AutoCompleteTextView) findViewById(R.id.act_Prof13);

        ArrayList_Prof13 = new ArrayList<>();
        ArrayList_Prof13.add("Barbara Gepp");
        ArrayList_Prof13.add("Ursula Knaack");
        ArrayList_Prof13.add("Heidemarie Fuchs-Eitel");
        ArrayList_Prof13.add("Varvara Liousia");

        ArrayAdapter_Prof13 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof13);
        act_Prof13.setAdapter(ArrayAdapter_Prof13);

        act_Prof13.setThreshold(1);

        nextButton16 = findViewById(R.id.nextButton16);
        nextButton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof13 = act_Prof13.getText().toString();
                if (selected_Prof13.equals("Barbara Gepp")){
                    openGepp();
                }if (selected_Prof13.equals("Ursula Knaack")){
                    openKnaack();
                }if (selected_Prof13.equals("Heidemarie Fuchs-Eitel")){
                    openEitel();
                }if (selected_Prof13.equals("Varvara Liousia")){
                    openVarvara();
                }

            }
        });
    }
    public void openGepp() {
        Intent Gepp = new Intent(this, com.example.unirate30.PROFESSOR.Gepp.class);
        startActivity(Gepp);
    }
    public void openKnaack() {
        Intent Knaack = new Intent(this, com.example.unirate30.PROFESSOR.Knaack.class);
        startActivity(Knaack);
    }
    public void openEitel() {
        Intent eitel = new Intent(this, Eitel.class);
        startActivity(eitel);
    }
    public void openVarvara() {
        Intent varvara = new Intent(this, Varvara.class);
        startActivity(varvara);
    }
}