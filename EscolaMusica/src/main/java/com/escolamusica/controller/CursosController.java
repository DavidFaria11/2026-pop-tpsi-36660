package com.escolamusica.controller;

import com.escolamusica.dao.CursoDAO;
import com.escolamusica.model.Curso;
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

public class CursosController {

    @FXML private TableView<Curso> tabelaCursos;
    @FXML private TableColumn<Curso, Integer> colId;
    @FXML private TableColumn<Curso, String> colNome;
    @FXML private TableColumn<Curso, Double> colPreco;
    @FXML private TableColumn<Curso, String> colTipo;
    @FXML private TableColumn<Curso, String> colProfessor;
    @FXML private TableColumn<Curso, String> colInstrumento;

    private CursoDAO cursoDAO = new CursoDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idCurso"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nomeCurso"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("precoMensal"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colProfessor.setCellValueFactory(new PropertyValueFactory<>("nomeProfessor"));
        colInstrumento.setCellValueFactory(new PropertyValueFactory<>("nomeInstrumento"));

        carregarCursos();
    }

    private void carregarCursos() {
        List<Curso> lista = cursoDAO.listarTodos();
        ObservableList<Curso> dados = FXCollections.observableArrayList(lista);
        tabelaCursos.setItems(dados);
    }

    @FXML
    private void handleAdicionar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormCurso.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Adicionar Curso");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormCursoController controller = loader.getController();
            controller.setCurso(null);
            controller.setStage(stage);

            stage.showAndWait();
            carregarCursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditar() {
        Curso selecionado = tabelaCursos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona um curso para editar!");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormCurso.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Editar Curso");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormCursoController controller = loader.getController();
            controller.setCurso(selecionado);
            controller.setStage(stage);

            stage.showAndWait();
            carregarCursos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleApagar() {
        Curso selecionado = tabelaCursos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona um curso para apagar!");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar");
        confirm.setHeaderText("Apagar curso");
        confirm.setContentText("Tens a certeza que queres apagar " + selecionado.getNomeCurso() + "?");

        Optional<ButtonType> resultado = confirm.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            cursoDAO.apagar(selecionado.getIdCurso());
            carregarCursos();
        }
    }

    private void mostrarAviso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}