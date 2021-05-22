package com.example.unirate30;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class BBEFach extends AppCompatActivity {

    TextInputLayout til_Semester;
    AutoCompleteTextView act_Semester;

    ArrayList<String> ArrayList_Semester;
    ArrayAdapter<String> ArrayAdapter_Semester;

    TextInputLayout til_Faecher;
    AutoCompleteTextView act_Faecher;

    ArrayList<String> ArrayList_Faecher;
    ArrayAdapter<String> ArrayAdapter_Faecher;

    public String selceted_Semester;
    ImageButton nextButton3;
    String selceted_Faecher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_b_e_fach);

        til_Semester = (TextInputLayout) findViewById(R.id.til_Semester);
        act_Semester = (AutoCompleteTextView) findViewById(R.id.act_Semester);

        ArrayList_Semester = new ArrayList<>();
        ArrayList_Semester.add("1.Semester");
        ArrayList_Semester.add("2.Semester");
        ArrayList_Semester.add("3.Semester");
        ArrayList_Semester.add("4.Semester");
        ArrayList_Semester.add("5.Semester");
        ArrayList_Semester.add("6.Semester");

        ArrayAdapter_Semester = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Semester);
        act_Semester.setAdapter(ArrayAdapter_Semester);
       // act_Semester.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        act_Semester.setThreshold(1);

        act_Semester.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selceted_Semester = act_Semester.getText().toString();

                if (selceted_Semester.equals("1.Semester")){

                    til_Faecher = (TextInputLayout) findViewById(R.id.til_Faecher);
                    act_Faecher = (AutoCompleteTextView) findViewById(R.id.act_Faecher);

                    ArrayList_Faecher = new ArrayList<>();
                    ArrayList_Faecher.add("Allgemeine Chemie");
                    ArrayList_Faecher.add("Allgemeine Chemie Labor");
                    ArrayList_Faecher.add("Anatomie, Physiologie und Pathophysiologie 1");
                    ArrayList_Faecher.add("Grundlagen der Anataomie und Physiologie");
                    ArrayList_Faecher.add("Technical English mit Nutte");
                    ArrayList_Faecher.add("Kompetenz und Kooperation");
                    ArrayList_Faecher.add("Mathematik für Engineering Science 1");
                    ArrayList_Faecher.add("Grundlagen der Physik für Ingenieurswissenschaften");
                    ArrayList_Faecher.add("Grundlagenlabor Physik");
                    ArrayList_Faecher.add("Grundlagen der Programmierung");
                    ArrayList_Faecher.add("Anwendungen der Programmierung in Life Science Engineering");


                    ArrayAdapter_Faecher = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Faecher);
                    act_Faecher.setAdapter(ArrayAdapter_Faecher);

                    act_Faecher.setThreshold(1);

                }if (selceted_Semester.equals("2.Semester")){
                    til_Faecher = (TextInputLayout) findViewById(R.id.til_Faecher);
                    act_Faecher = (AutoCompleteTextView) findViewById(R.id.act_Faecher);

                    ArrayList_Faecher = new ArrayList<>();
                    ArrayList_Faecher.add("Angewandte Chemie");
                    ArrayList_Faecher.add("Angewandte Chemie Labor");
                    ArrayList_Faecher.add("Anatomie, Physiologie und Pathophysiologie 2");
                    ArrayList_Faecher.add("Analysemethoden biomedizinischer Daten");
                    ArrayList_Faecher.add("Grundlagen der Elektronik");
                    ArrayList_Faecher.add("Business English");
                    ArrayList_Faecher.add("Mathematik für Engineering Science 2");
                    ArrayList_Faecher.add("Elektronik in der biomedizinischen Technik");
                    ArrayList_Faecher.add("Kreativität und Komplexität");
                    ArrayList_Faecher.add("Medizinische Informatik - Projekt");
                    ArrayList_Faecher.add("Physiologielabor");


                    ArrayAdapter_Faecher = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Faecher);
                    act_Faecher.setAdapter(ArrayAdapter_Faecher);

                    act_Faecher.setThreshold(1);
                }
            }
        });

        nextButton3 = findViewById(R.id.nextButton3);
        nextButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selceted_Faecher = act_Faecher.getText().toString();
                if (selceted_Faecher.equals("Allgemeine Chemie")){
                    openallgchem();
                }
            }
        });

        }


    public void openallgchem() {
        Intent intent18 = new Intent(this, allgchem.class);
        startActivity(intent18);
    }
}
