package com.escolamusica.controller;

import com.escolamusica.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DashboardAlunoController {

    @FXML
    private void mostrarMatriculas() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/MatriculasAluno.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("As Minhas Matrículas");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load(), 700, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrarNotas() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/NotasAluno.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("As Minhas Notas");
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