package com.escolamusica.controller;

import com.escolamusica.dao.MatriculaDAO;
import com.escolamusica.model.Matricula;
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

public class MatriculasController {

    @FXML private TableView<Matricula> tabelaMatriculas;
    @FXML private TableColumn<Matricula, Integer> colId;
    @FXML private TableColumn<Matricula, String> colAluno;
    @FXML private TableColumn<Matricula, String> colCurso;
    @FXML private TableColumn<Matricula, String> colDataInicio;
    @FXML private TableColumn<Matricula, Double> colValor;
    @FXML private TableColumn<Matricula, String> colEstado;

    private MatriculaDAO matriculaDAO = new MatriculaDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idMatricula"));
        colAluno.setCellValueFactory(new PropertyValueFactory<>("nomeAluno"));
        colCurso.setCellValueFactory(new PropertyValueFactory<>("nomeCurso"));
        colDataInicio.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valorPago"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoPagamento"));

        carregarMatriculas();
    }

    private void carregarMatriculas() {
        List<Matricula> lista = matriculaDAO.listarTodos();
        ObservableList<Matricula> dados = FXCollections.observableArrayList(lista);
        tabelaMatriculas.setItems(dados);
    }

    @FXML
    private void handleAdicionar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormMatricula.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Adicionar Matrícula");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormMatriculaController controller = loader.getController();
            controller.setMatricula(null);
            controller.setStage(stage);

            stage.showAndWait();
            carregarMatriculas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditar() {
        Matricula selecionado = tabelaMatriculas.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona uma matrícula para editar!");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormMatricula.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Editar Matrícula");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormMatriculaController controller = loader.getController();
            controller.setMatricula(selecionado);
            controller.setStage(stage);

            stage.showAndWait();
            carregarMatriculas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleApagar() {
        Matricula selecionado = tabelaMatriculas.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona uma matrícula para apagar!");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar");
        confirm.setHeaderText("Apagar matrícula");
        confirm.setContentText("Tens a certeza que queres apagar a matrícula de " + selecionado.getNomeAluno() + "?");

        Optional<ButtonType> resultado = confirm.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            matriculaDAO.apagar(selecionado.getIdMatricula());
            carregarMatriculas();
        }
    }

    private void mostrarAviso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}