package com.cako.witalocarlos.presente.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WitaloCarlos on 28/04/2015.
 */
public class AlunoCRUD {

    private Context context;

    public AlunoCRUD(Context context){
        CursosAperfeicoamentoBD.getInstancia(context);
        this.context = context;
    }

    public void criar(Aluno aluno){

        ContentValues values = new ContentValues();
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[1], aluno.getNome());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[2], aluno.getSexo().toString());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[3], aluno.getCpf());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[4], aluno.getRg());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[5], aluno.getMatricula());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[6], aluno.getPeriodo());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[7], aluno.isAlunoAtivo());

        CursosAperfeicoamentoBD.getInstancia(context).getWritableDatabase()
                .insert(CursosAperfeicoamentoBD.ALUNO_TB, null, values);


    }

    public void remover(Aluno aluno){

        int idAluno = aluno.getId();
        CursosAperfeicoamentoBD.getInstancia(context).getWritableDatabase()
                .delete(CursosAperfeicoamentoBD.ALUNO_TB,
                        CursosAperfeicoamentoBD.ALUNO_COLS[0]+ " = "+ idAluno, null);
    }

    public void atualizar(Aluno aluno){

        ContentValues values = new ContentValues();
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[1], aluno.getNome());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[2], aluno.getSexo().toString());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[3], aluno.getCpf());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[4], aluno.getRg());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[5], aluno.getMatricula());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[6], aluno.getPeriodo());
        values.put(CursosAperfeicoamentoBD.ALUNO_COLS[7], aluno.isAlunoAtivo());

        CursosAperfeicoamentoBD.getInstancia(context).getWritableDatabase().update(
                CursosAperfeicoamentoBD.ALUNO_TB,
                values, CursosAperfeicoamentoBD.ALUNO_COLS[0]+ " = "+ aluno.getId(), null);
    }

    public Aluno buscaPorId(int id){

        Cursor cursor = CursosAperfeicoamentoBD.getInstancia(context).getReadableDatabase().
                query(CursosAperfeicoamentoBD.ALUNO_TB,
                      CursosAperfeicoamentoBD.ALUNO_COLS,
                      CursosAperfeicoamentoBD.ALUNO_COLS[0]+ " = "+ id,
                      null, null, null,null);

        ArrayList<Aluno> alunos = new ArrayList<>();

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            alunos.add(cursorParaAluno(cursor));
        }

        return alunos.get(0);

    }

    public List<Aluno> buscarTodos(){
        Cursor cursor = CursosAperfeicoamentoBD.getInstancia(context).getReadableDatabase().
                query(CursosAperfeicoamentoBD.ALUNO_TB,
                        CursosAperfeicoamentoBD.ALUNO_COLS,
                        null, null, null, null,null);

        ArrayList<Aluno> alunos = new ArrayList<>();

        cursor.moveToFirst();
        while (cursor.moveToNext()){
            alunos.add(cursorParaAluno(cursor));
        }

        return alunos;
    }

    public Aluno cursorParaAluno(Cursor cursor){
        Aluno aluno = new Aluno();

        aluno.setId(cursor.getInt(0));
        aluno.setNome(cursor.getString(1));
        aluno.setSexo(cursor.getString(2).charAt(0));
        aluno.setCpf(cursor.getString(3));
        aluno.setRg(cursor.getString(4));
        aluno.setMatricula(cursor.getString(5));
        aluno.setPeriodo(cursor.getInt(6));

        if (cursor.getInt(7) == 1){
            aluno.setAlunoAtivo(true);
        } else if (cursor.getInt(7) == 0){
            aluno.setAlunoAtivo(false);
        }


        return aluno;
    }


}
