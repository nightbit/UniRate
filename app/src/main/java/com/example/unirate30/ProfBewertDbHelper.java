package com.example.unirate30;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ProfBewertDbHelper extends SQLiteOpenHelper {
    public static final String database_name = "UniRateDB.db";
    public static final String table_name="ProfBewertung";
    public static final String col_1= "ProfName";
    public static final String col_2= "Username";
    public static final String col_3= "Fachwissen";
    public static final String col_4= "Verfügbarkeit";
    public static final String col_5= "Wissensvermittlung";
    public static final String col_6= "Erreichbarkeit";
    public static final String col_7= "Fairness";

    public ProfBewertDbHelper(Context context)
    {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ table_name+ "("+col_1+" TEXT ,"+col_2+ " TEXT PRIMARY KEY ,"+ col_3+ " INTEGER ,"+col_4+" INTEGER ,"+col_5+" INTEGER ,"+col_6+" INTEGER ,"+col_7+" INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);
    }

    public boolean insertData(String ProfName ,String Username,int Fachwissen,int Verfuegbarkeit,int Wissensvermittlung,int Erreichbarkeit,int Fairness)
    {

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,ProfName);
        contentValues.put(col_2,Username);
        contentValues.put(col_3,Fachwissen);
        contentValues.put(col_4,Verfuegbarkeit);
        contentValues.put(col_5,Wissensvermittlung);
        contentValues.put(col_6,Erreichbarkeit);
        contentValues.put(col_7,Fairness);
        long result= db.insert(table_name,null,contentValues);
        if(result==-1)
        {
            db.close();
            return false;
        }else
        {
            db.close();
            return true;
        }
    }


 /*   public boolean controll(String ProfName, String UserName)
    {
        boolean okay = false;
        String queryString = "SELECT "+col_2+" FROM " + table_name +" WHERE " + col_1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null );
        cursor.moveToFirst();

        if(cursor.getCount()>0)
        {
            if(cursor.getString(0).equals(UserName))
            {
                okay = true;
            }
        }
        cursor.close();
        db.close();
        return okay;
    }*/

    public List<Integer> getData(String profName){
        String queryString = "SELECT * FROM " + table_name ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null );
        List<Integer> list = new ArrayList<>();
        List<Integer> fach =new ArrayList<>();
        List<Integer> verf =new ArrayList<>();
        List<Integer> wissen =new ArrayList<>();
        List<Integer> erreich =new ArrayList<>();
        List<Integer> fair =new ArrayList<>();
        int i=0;
        int fach1=0,verf1=0,wissen1=0,erreich1=0,fair1=0;
        if(cursor.moveToFirst()) {
            do{
                String ProfName = cursor.getString(0);
                int fachwissen= cursor.getInt(2);
                int verfuegbarkeit= cursor.getInt(3);
                int wissensvermittlung= cursor.getInt(4);
                int erreichbarkeit= cursor.getInt(5);
                int fairness= cursor.getInt(6);


                if(ProfName.equals(profName)) {
                    fach.add(fachwissen);
                    verf.add(verfuegbarkeit);
                    wissen.add(wissensvermittlung);
                    erreich.add(erreichbarkeit);
                    fair.add(fairness);
                    i = i + 1;
                }

            } while(cursor.moveToNext());
        } else
        {
            fach1=0;
            verf1=0;
            wissen1=0;
            erreich1=0;
            fair1=0;
        }
        if(i>0) {
            for (int j = 0; j <i; j++) {
                fach1 = fach1 + fach.get(j);
                verf1 = verf1+ verf.get(j);
                wissen1 = wissen1+ wissen.get(j);
                erreich1 = erreich1+ erreich.get(j);
                fair1 = fair1+ fair.get(j);
            }
            fach1=fach1/i;
            verf1=verf1/i;
            wissen1=wissen1/i;
            erreich1=erreich1/i;
            fair1=fair1/i;
        }



        list.add(fach1);
        list.add(verf1);
        list.add(wissen1);
        list.add(erreich1);
        list.add(fair1);
        cursor.close();
        db.close();
        return list;
    }

    public boolean updateData(String ProfName,String Username,int Fachwissen,int Verfuegbarkeit,int Wissensvermittlung,int Erreichbarkeit,int Fairness){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       //contentValues.put(col_1,ProfName);
        //contentValues.put(col_2,Username);
        contentValues.put(col_3,Fachwissen);
        contentValues.put(col_4,Verfuegbarkeit);
        contentValues.put(col_5,Wissensvermittlung);
        contentValues.put(col_6,Erreichbarkeit);
        contentValues.put(col_7,Fairness);
        db.update(table_name,contentValues,"  ProfName = ?  AND Username = ?",new String[] { ProfName ,Username});
        db.close();
        return true;

    }

    public void delet(String ProfName,String Username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = " DELET FROM " + table_name +  " WHERE " + col_1 + " = " + ProfName + " AND " + col_2 + " = " + Username;
        Cursor cursor= db.rawQuery(query,null);
        cursor.moveToFirst();
                cursor.close();

    }

}
