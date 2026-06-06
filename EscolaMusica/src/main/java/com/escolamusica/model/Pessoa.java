package com.escolamusica.model;

// Classe abstrata - pai de Aluno, Professor e Funcionario
public abstract class Pessoa {

    private int id;
    private String nome;
    private String email;
    private String telemovel;

    public Pessoa() {}

    public Pessoa(int id, String nome, String email, String telemovel) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telemovel = telemovel;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelemovel() { return telemovel; }
    public void setTelemovel(String telemovel) { this.telemovel = telemovel; }

    // Método abstrato - cada subclasse implementa à sua maneira
    public abstract String getTipo();

    @Override
    public String toString() {
        return nome + " (" + email + ")";
    }
}