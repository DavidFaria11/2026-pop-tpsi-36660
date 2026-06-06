package com.escolamusica.controller;

import com.escolamusica.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashboardProfessorController {

    @FXML
    private void mostrarUCs() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/UCsProfessor.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("As Minhas Unidades Curriculares");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 700, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarAlunos() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/AlunosProfessor.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Os Meus Alunos");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 700, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLogout() {
        try {
            SessaoAtual.logout();
            MainApp.mostrarLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}