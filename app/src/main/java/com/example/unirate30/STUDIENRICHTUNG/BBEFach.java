package com.example.unirate30.STUDIENRICHTUNG;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.unirate30.BBEFÄCHER.SEMESTER1.*;
import com.example.unirate30.BBEFÄCHER.SEMESTER2.*;
import com.example.unirate30.R;
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
                    ArrayList_Faecher.add("Technical English");
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
                }if (selceted_Faecher.equals("Allgemeine Chemie Labor")){
                    openallgchemlab();
                }if (selceted_Faecher.equals("Anatomie, Physiologie und Pathophysiologie 1")){
                    openanat1();
                }if (selceted_Faecher.equals("Grundlagen der Anataomie und Physiologie")){
                    openaphys();
                }if (selceted_Faecher.equals("Technical English mit Nutte")){
                    openeng1();
                }if (selceted_Faecher.equals("Kompetenz und Kooperation")){
                    openkoko();
                }if (selceted_Faecher.equals("Mathematik für Engineering Science 1")){
                    openmathe1();
                }if (selceted_Faecher.equals("Grundlagen der Physik für Ingenieurswissenschaften")){
                    openphysik();
                }if (selceted_Faecher.equals("Grundlagenlabor Physik")){
                    openphysiklab();
                }if (selceted_Faecher.equals("Grundlagen der Programmierung")){
                    openprog1();
                }if (selceted_Faecher.equals("Anwendungen der Programmierung in Life Science Engineering")){
                    openprogaw1();
                }

                if (selceted_Faecher.equals("Angewandte Chemie")){
                    openangchem();
                }if (selceted_Faecher.equals("Angewandte Chemie Labor")){
                    openangchemlab();
                }if (selceted_Faecher.equals("Anatomie, Physiologie und Pathophysiologie 2")){
                    openanat2();
                }if (selceted_Faecher.equals("Analysemethoden biomedizinischer Daten")){
                    openBIODA();
                }if (selceted_Faecher.equals("Grundlagen der Elektronik")){
                    openelek();
                }if (selceted_Faecher.equals("Business English")){
                    openeng2();
                }if (selceted_Faecher.equals("Mathematik für Engineering Science 2")){
                    openmathe2();
                }if (selceted_Faecher.equals("Elektronik in der biomedizinischen Technik")){
                    openphysiklab();
                }if (selceted_Faecher.equals("Kreativität und Komplexität")){
                    openkreko();
                }if (selceted_Faecher.equals("Medizinische Informatik - Projekt")){
                    openprogaw1();
                }if (selceted_Faecher.equals("Physiologielabor")){
                    openprogaw1();}
            }
        });

        }

    public void openallgchem() {
        Intent intent18 = new Intent(this, allgchem.class);
        startActivity(intent18);
    }
    public void openallgchemlab() {
        Intent allglab = new Intent(this, allgchemlab.class);
        startActivity(allglab);
    }
    public void openaphys() {
        Intent aphys = new Intent(this, com.example.unirate30.BBEFÄCHER.SEMESTER1.aphys.class);
        startActivity(aphys);
    }
    public void openmathe1() {
        Intent mathe1 = new Intent(this, mathe1.class);
        startActivity(mathe1);
    }
    public void openprog1() {
        Intent prog1 = new Intent(this,  prog1.class);
        startActivity(prog1);
    }
    public void openprogaw1() {
        Intent progaw1 = new Intent(this, progaw1.class);
        startActivity(progaw1);
    }
    public void openeng1() {
        Intent eng1 = new Intent(this, com.example.unirate30.BBEFÄCHER.SEMESTER1.eng1.class);
        startActivity(eng1);
    }
    public void openkoko() {
        Intent koko = new Intent(this, koko.class);
        startActivity(koko);
    }
    public void openphysik() {
        Intent physik = new Intent(this, physik.class);
        startActivity(physik);
    }
    public void openphysiklab() {
        Intent physiklab = new Intent(this, physiklab.class);
        startActivity(physiklab);
    }
    public void openanat1() {
        Intent anat1 = new Intent(this, com.example.unirate30.BBEFÄCHER.SEMESTER1.anat1.class);
        startActivity(anat1);
    }
    public void openangchem(){
        Intent angchem = new Intent(this, com.example.unirate30.BBEFÄCHER.SEMESTER2.angchem.class);
        startActivity(angchem);
    }
    public void openangchemlab(){
        Intent angchemlab= new Intent(this, com.example.unirate30.BBEFÄCHER.SEMESTER2.angchemlab.class);
        startActivity(angchemlab);
    }
    public void openanat2(){
        Intent anat2 = new Intent(this, com.example.unirate30.BBEFÄCHER.SEMESTER2.anat2.class);
        startActivity(anat2);
    }
    public void openBIODA(){
        Intent bioda = new Intent(this, BIODA.class);
        startActivity(bioda);
    }
    public void openelek(){
        Intent elek = new Intent(this, com.example.unirate30.BBEFÄCHER.SEMESTER2.elek.class);
        startActivity(elek);
    }
    public void openeng2(){
        Intent eng2 = new Intent(this, eng2.class);
        startActivity(eng2);
    }
    public void openkreko(){
        Intent kreko = new Intent(this, kreko.class);
        startActivity(kreko);
    }
    public void openmathe2(){
        Intent mathe2 = new Intent(this, mathe2.class);
        startActivity(mathe2);
    }
}
