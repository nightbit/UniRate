package com.example.unirate30;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ProfDbHelper extends SQLiteOpenHelper {
    public static final String database_name = "UniRateDB";
    public static final String table_name="Prof";
    public static final String col_1= "idProf";
    public static final String col_2= "Name";
    public static final String col_3= "Fachwissen";
    public static final String col_4= "Verfügbarkeit";
    public static final String col_5= "Wissensvermittlung";
    public static final String col_6= "Erreichbarkeit";
    public static final String col_7= "Fairness";
    public static final String col_8= "Username";


    public ProfDbHelper(Context context) {
        super(context, database_name, null, 6);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ table_name+ "("+col_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+col_2+ " TEXT ,"+ col_3+ " INTEGER ,"+col_4+" INTEGER ,"+col_5+" INTEGER ,"+col_6+" INTEGER ,"+col_7+" INTEGER ,"+col_8+" TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(db);
    }

    public boolean insertData(String Name,int Fachwissen,int Verfuegbarkeit,int Wissensvermittlung,int Erreichbarkeit,int Fairness,String Username)
    {

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,Name);
        contentValues.put(col_3,Fachwissen);
        contentValues.put(col_4,Verfuegbarkeit);
        contentValues.put(col_5,Wissensvermittlung);
        contentValues.put(col_6,Erreichbarkeit);
        contentValues.put(col_7,Fairness);
        contentValues.put(col_8,Username);
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

    public List<Integer> getData(String name){
        String queryString = "SELECT * FROM " + table_name;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null );
        List<Integer> list = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do{
                String Name = cursor.getString(1);
                int fachwissen= cursor.getInt(2);
                int verfuegbarkeit= cursor.getInt(3);
                int wissensvermittlung= cursor.getInt(4);
                int erreichbarkeit= cursor.getInt(5);
                int fairness= cursor.getInt(6);



                if(name.equals(Name)){
                    list.add(fachwissen);
                    list.add(verfuegbarkeit);
                    list.add(wissensvermittlung);
                    list.add(erreichbarkeit);
                    list.add(fairness);
                }else
                {
                    list.add(0);
                    list.add(0);
                    list.add(0);
                    list.add(0);
                    list.add(0);

                }

            } while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public boolean updateData(String Name,int Fachwissen,int Verfuegbarkeit,int Wissensvermittlung,int Erreichbarkeit,int Fairness, String UserName){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,Name);
        contentValues.put(col_3,Fachwissen);
        contentValues.put(col_4,Verfuegbarkeit);
        contentValues.put(col_5,Wissensvermittlung);
        contentValues.put(col_6,Erreichbarkeit);
        contentValues.put(col_7,Fairness);
        db.update(table_name,contentValues," Name = ? AND Username = ?",new String[] { Name , UserName });

        db.close();

        return true;
    }
}
