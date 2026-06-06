package com.escolamusica.model;

// Funcionario herda de Pessoa
public class Funcionario extends Pessoa {

    private int idCargo;
    private String nomeCargo;

    public Funcionario() {}

    public Funcionario(int id, String nome, String email, String telemovel,
                       int idCargo, String nomeCargo) {
        super(id, nome, email, telemovel);
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
    }

    public int getIdCargo() { return idCargo; }
    public void setIdCargo(int idCargo) { this.idCargo = idCargo; }

    public String getNomeCargo() { return nomeCargo; }
    public void setNomeCargo(String nomeCargo) { this.nomeCargo = nomeCargo; }

    @Override
    public String getTipo() { return "ADMIN"; }

    @Override
    public String toString() { return getNome(); }
}