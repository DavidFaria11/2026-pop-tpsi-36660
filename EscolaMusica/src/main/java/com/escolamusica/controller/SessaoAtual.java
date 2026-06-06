package com.escolamusica.controller;

import com.escolamusica.model.Utilizador;

public class SessaoAtual {

    private static Utilizador utilizador;

    public static Utilizador getUtilizador() { return utilizador; }
    public static void setUtilizador(Utilizador u) { utilizador = u; }

    public static boolean isAdmin() {
        return utilizador != null && utilizador.getPerfil().equals("ADMIN");
    }

    public static boolean isProfessor() {
        return utilizador != null && utilizador.getPerfil().equals("PROFESSOR");
    }

    public static boolean isAluno() {
        return utilizador != null && utilizador.getPerfil().equals("ALUNO");
    }

    public static void logout() { utilizador = null; }
}