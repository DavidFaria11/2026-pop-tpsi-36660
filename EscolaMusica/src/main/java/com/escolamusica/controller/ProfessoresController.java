package com.escolamusica.controller;

import com.escolamusica.dao.ProfessorDAO;
import com.escolamusica.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

public class ProfessoresController {

    @FXML private TableView<Professor> tabelaProfessores;
    @FXML private TableColumn<Professor, Integer> colId;
    @FXML private TableColumn<Professor, String> colNome;
    @FXML private TableColumn<Professor, String> colEmail;
    @FXML private TableColumn<Professor, String> colTelemovel;
    @FXML private TableColumn<Professor, String> colEspecialidade;

    private ProfessorDAO professorDAO = new ProfessorDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelemovel.setCellValueFactory(new PropertyValueFactory<>("telemovel"));
        colEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));

        carregarProfessores();
    }

    private void carregarProfessores() {
        List<Professor> lista = professorDAO.listarTodos();
        ObservableList<Professor> dados = FXCollections.observableArrayList(lista);
        tabelaProfessores.setItems(dados);
    }

    @FXML
    private void handleAdicionar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormProfessor.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Adicionar Professor");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormProfessorController controller = loader.getController();
            controller.setProfessor(null);
            controller.setStage(stage);

            stage.showAndWait();
            carregarProfessores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditar() {
        Professor selecionado = tabelaProfessores.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona um professor para editar!");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormProfessor.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Editar Professor");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormProfessorController controller = loader.getController();
            controller.setProfessor(selecionado);
            controller.setStage(stage);

            stage.showAndWait();
            carregarProfessores();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleApagar() {
        Professor selecionado = tabelaProfessores.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona um professor para apagar!");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar");
        confirm.setHeaderText("Apagar professor");
        confirm.setContentText("Tens a certeza que queres apagar " + selecionado.getNome() + "?");

        Optional<ButtonType> resultado = confirm.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            professorDAO.apagar(selecionado.getId());
            carregarProfessores();
        }
    }

    private void mostrarAviso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}