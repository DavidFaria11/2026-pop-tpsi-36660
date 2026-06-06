package com.escolamusica.model;

import java.time.LocalDate;

// Professor herda de Pessoa
public class Professor extends Pessoa {

    private LocalDate dataNascimento;
    private String especialidade;

    public Professor() {}

    public Professor(int id, String nome, String email, String telemovel,
                     LocalDate dataNascimento, String especialidade) {
        super(id, nome, email, telemovel);
        this.dataNascimento = dataNascimento;
        this.especialidade = especialidade;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    @Override
    public String getTipo() { return "PROFESSOR"; }

    @Override
    public String toString() { return getNome(); }
}