package com.escolamusica.controller;

import com.escolamusica.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashboardAdminController {

    @FXML
    private void mostrarAlunos() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/Alunos.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Gestão de Alunos");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 700, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarProfessores() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/Professores.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Gestão de Professores");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 700, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarCursos() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/Cursos.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Gestão de Cursos");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 700, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarMatriculas() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/Matriculas.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Gestão de Matrículas");
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