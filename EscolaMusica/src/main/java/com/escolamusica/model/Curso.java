package com.escolamusica.model;

public class Curso {

    private int idCurso;
    private String nomeCurso;
    private double precoMensal;
    private String tipo;
    private int idProfessor;
    private String nomeProfessor;
    private int idInstrumento;
    private String nomeInstrumento;

    public Curso() {}

    public Curso(int idCurso, String nomeCurso, double precoMensal, String tipo,
                 int idProfessor, String nomeProfessor,
                 int idInstrumento, String nomeInstrumento) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.precoMensal = precoMensal;
        this.tipo = tipo;
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.idInstrumento = idInstrumento;
        this.nomeInstrumento = nomeInstrumento;
    }

    public int getIdCurso() { return idCurso; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }

    public String getNomeCurso() { return nomeCurso; }
    public void setNomeCurso(String nomeCurso) { this.nomeCurso = nomeCurso; }

    public double getPrecoMensal() { return precoMensal; }
    public void setPrecoMensal(double precoMensal) { this.precoMensal = precoMensal; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getIdProfessor() { return idProfessor; }
    public void setIdProfessor(int idProfessor) { this.idProfessor = idProfessor; }

    public String getNomeProfessor() { return nomeProfessor; }
    public void setNomeProfessor(String nomeProfessor) { this.nomeProfessor = nomeProfessor; }

    public int getIdInstrumento() { return idInstrumento; }
    public void setIdInstrumento(int idInstrumento) { this.idInstrumento = idInstrumento; }

    public String getNomeInstrumento() { return nomeInstrumento; }
    public void setNomeInstrumento(String nomeInstrumento) { this.nomeInstrumento = nomeInstrumento; }

    @Override
    public String toString() { return nomeCurso; }
}