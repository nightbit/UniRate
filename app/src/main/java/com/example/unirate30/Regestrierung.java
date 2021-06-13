package com.example.unirate30;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class Regestrierung extends AppCompatActivity   {
    Button buttonRegist;
    EditText editMailRegist, editPassRegist, editPass2Regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestrierung);
    }

    buttonRegist = findViewById(R.id.buttonRegist);
    editMailRegist = findViewById(R.id.editMailRegist);
    editPassRegist= findViewById(R.id.editPassRegist);
    editPass2Regist=findViewById(R.id.editPass2Regist);

        buttonRegist.setOnClickListener(this);
    public void registrierung(String username, String passwort, String passwort2){
        if(checkpasswort(passwort2,passwort)&&emailConfirm(username))
        {
            creatAccount(username,passwort);
            loadActivity();

        }else if(!checkpasswort(passwort,passwort2))
        {
            Toast.makeText(getApplicationContext(),"Die Passwörter stimmen nicht über ein",Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(getApplicationContext(), " die Email passt nicht",Toast.LENGTH_SHORT).show();
        }

    }

    public boolean checkpasswort(String passwort, String passwort2)
    {
        boolean okay = false;

        if(passwort.equals(passwort2))
        {
            okay= true;
        }
        return okay;
    }

    public boolean emailConfirm(String mail)
    {
        boolean okay= false;

        if(mail.contains("@technikum-wien.at"))
        {
            okay = true;
        }
        return okay;
    }
    public void creatAccount(String username, String passwort)
    {
        SQLiteDatabase UniRateDB = getBaseContext().openOrCreateDatabase("UniRateDB", MODE_PRIVATE,null);
        UniRateDB.execSQL("INSERT INTO User VALUES('"+username+"'"+passwort+"')");
        UniRateDB.close();
    }

    public void loadActivity()
    {
        Intent Loggin = new Intent(this,com.example.unirate30.loggin.class);
        startActivity(Loggin);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonRegist:registrierung(editMailRegist.getText().toString(),editPassRegist.getText().toString(),editPass2Regist.getText().toString());
                break;
        }
    }

}