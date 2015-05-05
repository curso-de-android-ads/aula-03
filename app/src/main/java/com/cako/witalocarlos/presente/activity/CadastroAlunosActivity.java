package com.cako.witalocarlos.presente.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.cako.witalocarlos.presente.R;

import java.util.ArrayList;


public class CadastroAlunosActivity extends ActionBarActivity {

    EditText etNomeAluno;
    EditText etCPF;
    EditText etRG;
    EditText etMatricula;
    RadioButton rbSexoM;
    RadioButton rbSexoF;
    Spinner spPeriodos;
    CheckBox cbCursoAndroid;
    CheckBox cbCursoJogos;
    Switch swAlunoAtivo;
    Aluno aluno;
    String periodo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_alunos);

        etNomeAluno = (EditText) findViewById(R.id.et_nome_aluno);
        etCPF = (EditText) findViewById(R.id.et_cpf);
        etRG = (EditText) findViewById(R.id.et_rg);
        etMatricula = (EditText) findViewById(R.id.et_matricula);
        rbSexoF = (RadioButton) findViewById(R.id.rb_sexo_f);
        rbSexoM = (RadioButton) findViewById(R.id.rb_sexo_m);
        cbCursoAndroid = (CheckBox) findViewById(R.id.ck_android);
        cbCursoJogos = (CheckBox) findViewById(R.id.ck_jogos);
        swAlunoAtivo = (Switch) findViewById(R.id.sw_aluno_ativo);
        spPeriodos = (Spinner) findViewById(R.id.sp_periodos);
        aluno = new Aluno();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.periodos,
                android.R.layout.simple_spinner_item);

        spPeriodos.setAdapter(adapter);
        spPeriodos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                periodo = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro_alunos, menu);
        return true;
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

        if (id == R.id.ac_salvar){
            return salvar(aluno);

        }

        if (id == R.id.ac_cancelar){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean salvar(Aluno aluno){
        AlunoCRUD crud = new AlunoCRUD(this);
        ArrayList<Curso> cursos = new ArrayList<>();
        aluno.setNome(etNomeAluno.getText().toString());
        aluno.setCpf(etCPF.getText().toString());
        aluno.setRg(etRG.getText().toString());
        aluno.setMatricula(etMatricula.getText().toString());

        if (rbSexoF.isChecked()){
            aluno.setSexo('F');
        }
        if (rbSexoM.isChecked()){
            aluno.setSexo('M');
        }

        if(cbCursoJogos.isChecked()){
            Curso cursoJogos = new Curso();
            cursoJogos.setNome("Curso de Jogos");
            cursos.add(cursoJogos);
        }
        if(cbCursoAndroid.isChecked()){
            Curso cursoAndroid = new Curso();
            cursoAndroid.setNome("Curso de Android");
            cursos.add(cursoAndroid);
        }

        aluno.setCursos(cursos);
        aluno.setAlunoAtivo(swAlunoAtivo.isChecked());
        aluno.setPeriodo(periodo);

        exibeDialogoSimples(aluno.toString(), this);

        crud.criar(aluno);

        return true;
    }

    private void exibeDialogoSimples(String msg, Context context){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setMessage(msg);
        alert.setTitle("ATENÇÃO!");
        alert.setNeutralButton("Ok", null);
        alert.show();
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Você deseja realmente cancelar o cadastro?");
        alert.setTitle("ATENÇÃO!");
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), ListarAlunosActivity.class);
                startActivity(intent);
                finish();
            }
        });

        alert.setNegativeButton("Não", null);
        alert.show();
    }
}