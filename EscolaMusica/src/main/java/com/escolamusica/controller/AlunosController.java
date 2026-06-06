package com.escolamusica.controller;

import com.escolamusica.controller.FormAlunoController;
import com.escolamusica.dao.AlunoDAO;
import com.escolamusica.model.Aluno;
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

public class AlunosController {

    @FXML private TableView<Aluno> tabelaAlunos;
    @FXML private TableColumn<Aluno, Integer> colId;
    @FXML private TableColumn<Aluno, String> colNome;
    @FXML private TableColumn<Aluno, String> colEmail;
    @FXML private TableColumn<Aluno, String> colTelemovel;
    @FXML private TableColumn<Aluno, String> colDataNasc;

    private AlunoDAO alunoDAO = new AlunoDAO();

    @FXML
    public void initialize() {
        // Ligar colunas aos atributos do Aluno
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colTelemovel.setCellValueFactory(new PropertyValueFactory<>("telemovel"));
        colDataNasc.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));

        carregarAlunos();
    }

    private void carregarAlunos() {
        List<Aluno> lista = alunoDAO.listarTodos();
        ObservableList<Aluno> dados = FXCollections.observableArrayList(lista);
        tabelaAlunos.setItems(dados);
    }

    @FXML
    private void handleAdicionar() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormAluno.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Adicionar Aluno");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormAlunoController controller = loader.getController();
            controller.setAluno(null);
            controller.setStage(stage);

            stage.showAndWait();
            carregarAlunos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEditar() {
        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona um aluno para editar!");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/escolamusica/fxml/FormAluno.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Editar Aluno");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));

            FormAlunoController controller = loader.getController();
            controller.setAluno(selecionado);
            controller.setStage(stage);

            stage.showAndWait();
            carregarAlunos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleApagar() {
        Aluno selecionado = tabelaAlunos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAviso("Seleciona um aluno para apagar!");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar");
        confirm.setHeaderText("Apagar aluno");
        confirm.setContentText("Tens a certeza que queres apagar " + selecionado.getNome() + "?");

        Optional<ButtonType> resultado = confirm.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            alunoDAO.apagar(selecionado.getId());
            carregarAlunos();
        }
    }

    private void mostrarAviso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}