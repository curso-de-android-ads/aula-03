package com.cako.witalocarlos.presente.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.cako.witalocarlos.presente.R;

import java.util.ArrayList;

/**
 * Created by WitaloCarlos on 23/04/2015.
 */
public class ListarAlunosActivity extends ListActivity {

    AlunoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        AlunoCRUD crud = new AlunoCRUD(this);
        ArrayList<Aluno> alunos = (ArrayList) crud.buscarTodos();
        Log.i("ALUNOS", alunos.size()+"");
        adapter = new AlunoAdapter(getApplicationContext(), alunos);
        setListAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_vizualizar_alunos, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.ac_novo){
            Intent intent = new Intent(this, CadastroAlunosActivity.class);
            startActivity(intent);
            finish();
            return true;

        }

        if (id == R.id.ac_editar){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
