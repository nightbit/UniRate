package com.example.unirate30;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Degree extends AppCompatActivity {

    TextInputLayout til_BsC;
    AutoCompleteTextView act_BsC;

    ArrayList<Button> buttonList_BsC;
    ArrayAdapter<Button> buttonAdapter_BsC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degree);

        til_BsC = (TextInputLayout)findViewById(R.id.til_BsC);
        act_BsC = (AutoCompleteTextView) findViewById(R.id.act_BsC);

       buttonList_BsC = new ArrayList<>();
       buttonList_BsC.add((Button)findViewById(R.id.button6));

       buttonAdapter_BsC = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,buttonList_BsC);
       act_BsC.setAdapter(buttonAdapter_BsC);

       act_BsC.setThreshold(1);

    }
}