package com.escolamusica.controller;

import com.escolamusica.MainApp;
import com.escolamusica.dao.utilizadorDAO;
import com.escolamusica.model.Utilizador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblErro;

    private utilizadorDAO utilizadorDAO = new utilizadorDAO();

    @FXML
    private void handleLogin() {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            lblErro.setText("Preenche todos os campos!");
            return;
        }

        Utilizador u = utilizadorDAO.login(username, password);

        if (u == null) {
            lblErro.setText("Username ou password incorretos!");
            return;
        }

        try {
            switch (u.getPerfil()) {
                case "ADMIN":
                    SessaoAtual.setUtilizador(u);
                    MainApp.mostrarTela("DashboardAdmin.fxml");
                    break;
                case "PROFESSOR":
                    SessaoAtual.setUtilizador(u);
                    MainApp.mostrarTela("DashboardProfessor.fxml");
                    break;
                case "ALUNO":
                    SessaoAtual.setUtilizador(u);
                    MainApp.mostrarTela("DashboardAluno.fxml");
                    break;
                default:
                    lblErro.setText("Perfil desconhecido!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            lblErro.setText("Erro ao carregar o ecrã!");
        }
    }
}