package com.example.unirate30;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class  UniRating extends AppCompatActivity {

    private Button button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uni_rating);

        button11 = findViewById(R.id.button);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDegree();
            }
        });
    }
    // @Override
    // public void onClick(View v) {
    //   switch(v.getId()) {
    //    case R.id.button:
    //          openDegree();
    //            break;
    public void openDegree(){
        Intent intent1 = new Intent(this, Degree.class);
        startActivity(intent1);
    }
}

