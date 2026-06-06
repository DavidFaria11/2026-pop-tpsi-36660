package com.escolamusica.model;

import java.time.LocalDate;

public class Matricula {

    private int idMatricula;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDate dataPagamento;
    private double valorPago;
    private String metodoPagamento;
    private String estadoPagamento;
    private int idAluno;
    private String nomeAluno;
    private int idCurso;
    private String nomeCurso;
    private int idFuncionario;

    public Matricula() {}

    public Matricula(int idMatricula, LocalDate dataInicio, LocalDate dataFim,
                     LocalDate dataPagamento, double valorPago, String metodoPagamento,
                     String estadoPagamento, int idAluno, String nomeAluno,
                     int idCurso, String nomeCurso, int idFuncionario) {
        this.idMatricula = idMatricula;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.metodoPagamento = metodoPagamento;
        this.estadoPagamento = estadoPagamento;
        this.idAluno = idAluno;
        this.nomeAluno = nomeAluno;
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.idFuncionario = idFuncionario;
    }

    public int getIdMatricula() { return idMatricula; }
    public void setIdMatricula(int idMatricula) { this.idMatricula = idMatricula; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }

    public double getValorPago() { return valorPago; }
    public void setValorPago(double valorPago) { this.valorPago = valorPago; }

    public String getMetodoPagamento() { return metodoPagamento; }
    public void setMetodoPagamento(String metodoPagamento) { this.metodoPagamento = metodoPagamento; }

    public String getEstadoPagamento() { return estadoPagamento; }
    public void setEstadoPagamento(String estadoPagamento) { this.estadoPagamento = estadoPagamento; }

    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

    public String getNomeAluno() { return nomeAluno; }
    public void setNomeAluno(String nomeAluno) { this.nomeAluno = nomeAluno; }

    public int getIdCurso() { return idCurso; }
    public void setIdCurso(int idCurso) { this.idCurso = idCurso; }

    public String getNomeCurso() { return nomeCurso; }
    public void setNomeCurso(String nomeCurso) { this.nomeCurso = nomeCurso; }

    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    @Override
    public String toString() { return "Matrícula #" + idMatricula + " - " + nomeAluno; }
}