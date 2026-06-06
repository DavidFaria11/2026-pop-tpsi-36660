package com.escolamusica.model;

import java.time.LocalDate;

// Aluno herda de Pessoa
public class Aluno extends Pessoa {

    private LocalDate dataNascimento;

    public Aluno() {}

    public Aluno(int id, String nome, String email, String telemovel, LocalDate dataNascimento) {
        super(id, nome, email, telemovel);
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    @Override
    public String getTipo() { return "ALUNO"; }

    @Override
    public String toString() { return getNome(); }
}