package com.escolamusica.model;

public class Utilizador {

    private int idUtilizador;
    private String username;
    private String password;
    private String perfil; // ADMIN, PROFESSOR, ALUNO
    private int idReferencia;

    public Utilizador() {}

    public Utilizador(int idUtilizador, String username, String password,
                      String perfil, int idReferencia) {
        this.idUtilizador = idUtilizador;
        this.username = username;
        this.password = password;
        this.perfil = perfil;
        this.idReferencia = idReferencia;
    }

    public int getIdUtilizador() { return idUtilizador; }
    public void setIdUtilizador(int idUtilizador) { this.idUtilizador = idUtilizador; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public int getIdReferencia() { return idReferencia; }
    public void setIdReferencia(int idReferencia) { this.idReferencia = idReferencia; }

    @Override
    public String toString() { return username + " (" + perfil + ")"; }
}