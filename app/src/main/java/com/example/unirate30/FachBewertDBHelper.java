package com.example.unirate30;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FachBewertDBHelper extends SQLiteOpenHelper {

    public static final String table_name="FachBewertung";
    public static final String col_1= "FachName";
    public static final String col_2= "Username";
    public static final String col_3= "Lehrplan";
    public static final String col_4= "Unterlagen";
    public static final String col_5= "Stoffmenge";

    public FachBewertDBHelper(Context context,String database_name)
    {
        super(context,database_name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ table_name+ "("+col_1+" TEXT ,"+col_2+ " TEXT PRIMARY KEY ,"+ col_3+ " INTEGER ,"+col_4+" INTEGER ," +col_5+ " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);
    }

    public boolean insertData(String FachName ,String Username,int Lehrplan,int Unterlagen,int Stoffmenge)
    {

        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,FachName);
        contentValues.put(col_2,Username);
        contentValues.put(col_3,Lehrplan);
        contentValues.put(col_4,Unterlagen);
        contentValues.put(col_5,Stoffmenge);

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

    public List<Integer> getData(String fachName){
        String queryString = "SELECT * FROM " + table_name ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null );
        List<Integer> list = new ArrayList<>();
        List<Integer> Lehr =new ArrayList<>();
        List<Integer> Unter =new ArrayList<>();
        List<Integer> Stoff =new ArrayList<>();
        int i=0;
        int lehr1=0,unter1=0,stoff1=0;
        if(cursor.moveToFirst()) {
            do{
                String FachName = cursor.getString(0);
                int lehrplan= cursor.getInt(2);
                int unterlagen= cursor.getInt(3);
                int stoffmenge= cursor.getInt(4);


                if(fachName.equals(FachName)) {
                    Lehr.add(lehrplan);
                    Unter.add(unterlagen);
                    Stoff.add(stoffmenge);
                    i = i + 1;
                }

            } while(cursor.moveToNext());
        } else
        {
            lehr1=0;
            unter1=0;
            stoff1=0;

        }
        if(i>0) {
            for (int j = 0; j <i; j++) {
                lehr1 = lehr1 + Lehr.get(j);
                unter1 = unter1+ Unter.get(j);
                stoff1 = stoff1+ Stoff.get(j);

            }
            lehr1=lehr1/i;
            unter1=unter1/i;
            stoff1=stoff1/i;

        }



        list.add(lehr1);
        list.add(unter1);
        list.add(stoff1);

        cursor.close();
        db.close();
        return list;
    }

    public boolean updateData(String FachName,String Username,int Lehrplan,int Unterlagen,int Stoffmenge){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(col_3,Lehrplan);
        contentValues.put(col_4,Unterlagen);
        contentValues.put(col_5,Stoffmenge);

        db.update(table_name,contentValues,"  FachName = ?  AND Username = ?",new String[] { FachName , Username });
        db.close();
        return true;

    }
}

