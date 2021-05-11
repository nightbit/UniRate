package com.example.unirate30;

import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

    TextInputLayout til_Fächer;
    AutoCompleteTextView act_Fächer;

    ArrayList<String> ArrayList_Fächer;
    ArrayAdapter<String> ArrayAdapter_Fächer;

    String selceted_Semester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_b_e_fach);


        til_Semester = (TextInputLayout) findViewById(R.id.til_Semester);
        act_Semester = (AutoCompleteTextView) findViewById(R.id.act_Semester);

        ArrayList_Semester = new ArrayList<>();
        ArrayList_Semester.add("1.Semester");
        ArrayList_Semester.add("2.Semester");

        ArrayAdapter_Semester = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Semester);
        act_Semester.setAdapter(ArrayAdapter_Semester);

        act_Semester.setThreshold(1);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        selceted_Semester = act_Semester.getText().toString();
        if (selceted_Semester.equals("1.Semester")) {
            til_Fächer = (TextInputLayout) findViewById(R.id.til_Faecher);
            act_Fächer = (AutoCompleteTextView) findViewById(R.id.act_Faecher);

            ArrayList_Fächer = new ArrayList<>();
            ArrayList_Fächer.add("Allgemeine Chemie");
            ArrayList_Fächer.add("Allgemeine Chemie Labor");

            ArrayAdapter_Fächer = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, ArrayList_Fächer);
            act_Fächer.setAdapter(ArrayAdapter_Fächer);

            act_Fächer.setThreshold(1);
        }
            return true;
    }
}
