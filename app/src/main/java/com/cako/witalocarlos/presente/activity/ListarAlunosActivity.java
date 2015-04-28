package com.cako.witalocarlos.presente.activity;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by WitaloCarlos on 23/04/2015.
 */
public class ListarAlunosActivity extends ListActivity {

    AlunoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Witalo Carlos Xavier Albuquerque","201215020236",false));
        alunos.add(new Aluno("Cássio da Silva Oliveira", "00000000000", true));
        alunos.add(new Aluno("Elysangela de Souza Santos", "00000000000", true));


        adapter = new AlunoAdapter(getApplicationContext(), alunos);
        setListAdapter(adapter);


    }



}
