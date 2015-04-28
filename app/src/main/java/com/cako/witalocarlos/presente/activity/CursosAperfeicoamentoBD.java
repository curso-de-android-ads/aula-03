package com.cako.witalocarlos.presente.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WitaloCarlos on 23/04/2015.
 */
public class CursosAperfeicoamentoBD extends SQLiteOpenHelper {

    private final static  int VERSAO = 1;
    private final static String NOME_BD = "cursos.db";

    public CursosAperfeicoamentoBD(Context context){
        super(context, NOME_BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
