package com.example.unirate30.BBEFÄCHER.SEMESTER2;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.PROFESSOR.Teuschel;
import com.example.unirate30.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class angchem extends AppCompatActivity {

    TextInputLayout til_Prof12;
    AutoCompleteTextView act_Prof12;

    ArrayList<String> ArrayList_Prof12;
    ArrayAdapter<String> ArrayAdapter_Prof12;

    ImageButton nextButton15;
    String selected_Prof12;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angchem);

        til_Prof12 = (TextInputLayout) findViewById(R.id.til_Prof12);
        act_Prof12 = (AutoCompleteTextView) findViewById(R.id.act_Prof12);

        ArrayList_Prof12 = new ArrayList<>();
        ArrayList_Prof12.add("Barbara Gepp");
        ArrayList_Prof12.add("Andreas Teuschl");

        ArrayAdapter_Prof12 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Prof12);
        act_Prof12.setAdapter(ArrayAdapter_Prof12);

        act_Prof12.setThreshold(1);

        nextButton15 = findViewById(R.id.nextButton15);
        nextButton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selected_Prof12 = act_Prof12.getText().toString();
                if (selected_Prof12.equals("Barbara Gepp")){
                    openGepp();
                }if (selected_Prof12.equals("Andreas Teuschl")){
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