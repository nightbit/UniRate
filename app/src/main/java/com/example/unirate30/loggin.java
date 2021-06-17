package com.example.unirate30;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class loggin extends AppCompatActivity implements View.OnClickListener {
    Button buttonEinloggen, buttonRegistrieren;
    ImageButton buttonWeiter;
    EditText mailLoggin, passwortLoggin;
    CheckBox checkLoggin;
    Username username= new Username();
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);


        buttonEinloggen = findViewById (R.id.buttonEinloggen);
        buttonRegistrieren = findViewById(R.id.buttonRegistrieren);
        mailLoggin = findViewById((R.id.maiLoggin));
        passwortLoggin = findViewById((R.id.passwortLoggin));
        checkLoggin= findViewById((R.id.checkLoggin));
        buttonWeiter = findViewById(R.id.buttonWeiter);
        buttonEinloggen.setOnClickListener(this);
        buttonRegistrieren.setOnClickListener(this);
        buttonWeiter.setOnClickListener(this);

        if(firstStart()){
            creatDB();
        }

        SharedPreferences prefstayLoggedIn = getSharedPreferences("loggedin", MODE_PRIVATE);
        if(prefstayLoggedIn.getBoolean("loggedin", false))
        {
            loadActivity();
        }
    }
    public void creatDB(){
        SQLiteDatabase UniRateDB = getBaseContext().openOrCreateDatabase("UniRateDB",MODE_PRIVATE,null);
        UniRateDB.execSQL("CREATE TABLE User(username TEXT , password TEXT)");
        UniRateDB.close();

    }

    public void login(String username, String passwort)
    {
        if(checklogin(username,passwort))
        {
            if(stayloggedIn())
            {
                setStayLoggedIn();
            }
            loadActivity();

        } else
        {
            Toast.makeText(getApplicationContext(),"Benutzername oder Passwort sind nicht richtig!",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checklogin(String email, String passwowrd)
    {
        boolean okay=false;
        SQLiteDatabase UniRateDB = getBaseContext().openOrCreateDatabase("UniRateDB",MODE_PRIVATE,null);
        Cursor curserUser = UniRateDB.rawQuery("SELECT password FROM User WHERE username = '"+ email +"'", null );
        curserUser.moveToFirst();

        if(curserUser.getCount()>0)
        {
            if(curserUser.getString(0).equals(passwowrd))
            {
                okay = true;
            }
        }
        curserUser.close();
        UniRateDB.close();
        return okay;
    }

    public boolean stayloggedIn(){
        return checkLoggin.isChecked();
    }

    public void setStayLoggedIn(){
        SharedPreferences prefStayLogged = getSharedPreferences("loggedin",MODE_PRIVATE);
        SharedPreferences.Editor editor =prefStayLogged.edit();
        editor.putBoolean("loggedin",true);
        editor.commit();
    }



    public void loadRegest(){
        Intent  Registriung = new Intent(this, Regestrierung.class);
        startActivity(Registriung);
    }

    public void loadActivity(){
        Intent  unirate = new Intent(this, UniRating.class);
        startActivity(unirate);
    }
    // wenn app erstes mal gestartet;
    public boolean firstStart()
    {
        boolean first = false;

        SharedPreferences sharedPreferences = getSharedPreferences("firstStart",MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        if(sharedPreferences.getBoolean("firstStart",false)==false)
        {
            first = true;
            sharedPreferencesEditor.putBoolean("firstStart",true);
            sharedPreferencesEditor.commit();
        }

        return first;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonEinloggen:

                username.setUsername(mailLoggin.getText().toString());
                login(mailLoggin.getText().toString(),passwortLoggin.getText().toString());
                break;
            case R.id.buttonRegistrieren:
                loadRegest();
                break;

            case R.id.buttonWeiter:

                username.setUsername("nichterlaubt");
                loadActivity();
                break;

        }
    }


}