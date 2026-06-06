package com.escolamusica.controller;

import com.escolamusica.dao.MatriculaDAO;
import com.escolamusica.model.Matricula;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MatriculasAlunoController {

    @FXML private TableView<Matricula> tabelaMatriculas;
    @FXML private TableColumn<Matricula, Integer> colId;
    @FXML private TableColumn<Matricula, String> colCurso;
    @FXML private TableColumn<Matricula, String> colDataInicio;
    @FXML private TableColumn<Matricula, Double> colValor;
    @FXML private TableColumn<Matricula, String> colEstado;

    private MatriculaDAO matriculaDAO = new MatriculaDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("idMatricula"));
        colCurso.setCellValueFactory(new PropertyValueFactory<>("nomeCurso"));
        colDataInicio.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("valorPago"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estadoPagamento"));

        carregarMatriculas();
    }

    private void carregarMatriculas() {
        int idAluno = SessaoAtual.getUtilizador().getIdReferencia();
        List<Matricula> lista = matriculaDAO.listarPorAluno(idAluno);
        ObservableList<Matricula> dados = FXCollections.observableArrayList(lista);
        tabelaMatriculas.setItems(dados);
    }
}