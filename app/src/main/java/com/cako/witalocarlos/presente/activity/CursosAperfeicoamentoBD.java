package com.cako.witalocarlos.presente.activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WitaloCarlos on 23/04/2015.
 */
public class CursosAperfeicoamentoBD extends SQLiteOpenHelper {

    //Nome e versão do Banco
    private final static int VERSAO = 1;
    private final static String NOME_BD = "cursos.db";

    //Nomes das Tabelas
    public final static String ALUNO_TB = "aluno_tb";
    public final static String PROJETO_TB = "projeto_tb";
    public final static String CURSO_TB = "curso_tb";
    public final static String ALUNO_CURSO_TB = "aluno_curso_tb";

    //Colunas das Tabelas
    public final static String[] ALUNO_COLS = {"id", "nome", "sexo", "cpf", "rg", "matricula", "periodo", "aluno_ativo"};
    public final static String[] PROJETO_COLS = {"id", "titulo", "resumo", "nota", "id_aluno"};

    //DDL das Tabelas
    public final static String CRIA_TABELA_PROJETO = "CREATE TABLE " + PROJETO_TB + "(" +
            PROJETO_COLS[0] + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            PROJETO_COLS[1] + " TEXT NOT NULL," +
            PROJETO_COLS[2] + " TEXT," +
            PROJETO_COLS[3] + " REAL," +
            PROJETO_COLS[4] + " INTEGER NOT NULL," +
            "FOREIGN KEY (" + PROJETO_COLS[4] + ") REFERENCES " +
            ALUNO_TB + " (" + ALUNO_COLS[0] + "));";

    public final static String CRIA_TABELA_ALUNO = "CREATE TABLE " + ALUNO_TB + "(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "sexo TEXT," +
            "cpf TEXT," +
            "rg TEXT," +
            "matricula TEXT NOT NULL,"+
            "periodo TEXT,"+
            "aluno_ativo NUMERIC);";


    public final static String CRIA_TABELA_CURSO = "CREATE TABLE "+CURSO_TB+"(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "instrutor TEXT NOT NULL, " +
            "matricula_intrutor TEXT NOT NULL," +
            "carga_horaria INTEGER NOT NULL," +
            "descricao TEXT);";


    public final static String CRIA_TABELA_ALUNO_CURSO = "CREATE TABLE "+ALUNO_CURSO_TB+"(" +
            "id_aluno INTEGER NOT NULL, " +
            "id_curso INTEGER NOT NULL," +
            "FOREIGN KEY (id_aluno) REFERENCES "+ALUNO_TB+"(id), " +
            "FOREIGN KEY (id_curso) REFERENCES "+CURSO_TB+"(id));";

    //Variavel de Instancia
    private static CursosAperfeicoamentoBD instancia;

    private CursosAperfeicoamentoBD(Context context) {
        super(context, NOME_BD, null, VERSAO);
        Log.i("CURSOS BD", "Banco criado ou acessado com sucesso");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("PRAGMA foreign_keys = ON");
        Log.i("CURSOS BD", "Chaves estrangeiras liberadas");

        db.execSQL(CRIA_TABELA_ALUNO);
        Log.i("CURSOS BD", "Tabela aluno");

        db.execSQL(CRIA_TABELA_CURSO);
        Log.i("CURSOS BD", "Tabela curso");

        db.execSQL(CRIA_TABELA_PROJETO);
        Log.i("CURSOS BD", "Tabela projeto");

        db.execSQL(CRIA_TABELA_ALUNO_CURSO);
        Log.i("CURSOS BD", "Tabela aluno_curso");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Nesse método vc faz operações ao atualizar o esquema do banco
    }

    public static CursosAperfeicoamentoBD getInstancia(Context context){

        if(instancia == null){
            instancia = new CursosAperfeicoamentoBD(context);
        }

        return instancia;
    }


}
