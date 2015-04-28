package com.cako.witalocarlos.presente.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cako.witalocarlos.presente.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WitaloCarlos on 23/04/2015.
 */
public class AlunoAdapter extends BaseAdapter {

    List<Aluno> alunos;
    LayoutInflater inflater;
    Context context;

    public AlunoAdapter(Context context, List<Aluno> alunos) {

        this.alunos = alunos;
        this.context = context;
        inflater = LayoutInflater.from(this.context);

    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        ViewHolder holder;

        if (convertView == null){
            v = inflater.inflate(R.layout.list_item_aluno, parent, false);
            holder = new ViewHolder();
            holder.tvNomeAluno = (TextView) v.findViewById(R.id.tv_lv_nome_aluno);
            holder.tvMatriculaAluno = (TextView) v.findViewById(R.id.tv_lv_matricula_aluno);
            holder.cbAlunoAtivo = (CheckBox) v.findViewById(R.id.ck_lv_aluno_ativo);
            v.setTag(holder);

         } else {
            v = convertView;
            holder = (ViewHolder) v.getTag();
        }

        Aluno aluno = alunos.get(position);
        holder.tvNomeAluno.setText(aluno.getNome());
        holder.tvMatriculaAluno.setText(aluno.getMatricula());
        holder.cbAlunoAtivo.setChecked(aluno.isAlunoAtivo());









        return v;
    }

    private class ViewHolder{
        public TextView tvNomeAluno;
        public TextView tvMatriculaAluno;
        public CheckBox cbAlunoAtivo;
    }
}







