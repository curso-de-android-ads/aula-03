package com.cako.witalocarlos.presente.activity;

import java.util.ArrayList;

/**
 * Created by cassio on 14/04/15.
 */
public class Aluno {

    private String nome;
    private Character sexo;
    private String cpf;
    private String rg;
    private String matricula;
    private Integer periodo;
    private boolean alunoAtivo;
    private ArrayList<Curso> cursos;

    public Aluno(String nome, String matricula, boolean alunoAtivo) {
        this.nome = nome;
        this.matricula = matricula;
        this.alunoAtivo = alunoAtivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public boolean isAlunoAtivo() {
        return alunoAtivo;
    }

    public void setAlunoAtivo(boolean alunoAtivo) {
        this.alunoAtivo = alunoAtivo;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
}
