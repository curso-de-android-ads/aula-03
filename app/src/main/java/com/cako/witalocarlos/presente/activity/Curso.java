package com.cako.witalocarlos.presente.activity;

/**
 * Created by cassio on 14/04/15.
 */
public class Curso {

    private String nome;
    private String instrutor;
    private String matriculaInstrutor;
    private int cargaHoraria;
    private String descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }

    public String getMatriculaInstrutor() {
        return matriculaInstrutor;
    }

    public void setMatriculaInstrutor(String matriculaInstrutor) {
        this.matriculaInstrutor = matriculaInstrutor;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
