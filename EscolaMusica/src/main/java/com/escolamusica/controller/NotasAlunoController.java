package com.escolamusica.controller;

import com.escolamusica.dao.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class NotasAlunoController {

    @FXML private TableView<ObservableList<String>> tabelaNotas;
    @FXML private TableColumn<ObservableList<String>, String> colId;
    @FXML private TableColumn<ObservableList<String>, String> colCurso;
    @FXML private TableColumn<ObservableList<String>, String> colNota;
    @FXML private TableColumn<ObservableList<String>, String> colData;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        colCurso.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        colNota.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(2)));
        colData.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(3)));

        carregarNotas();
    }

    private void carregarNotas() {
        int idAluno = SessaoAtual.getUtilizador().getIdReferencia();
        String sql = "SELECT av.id_avaliacao, c.nome_curso, av.nota, av.data_avaliacao " +
                "FROM Avaliacao av " +
                "JOIN Matricula m ON m.id_matricula = av.id_matricula " +
                "JOIN Curso c ON c.id_curso = av.id_curso " +
                "WHERE m.id_aluno = ?";

        ObservableList<ObservableList<String>> dados = FXCollections.observableArrayList();

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("id_avaliacao")));
                row.add(rs.getString("nome_curso"));
                row.add(String.valueOf(rs.getDouble("nota")));
                row.add(rs.getDate("data_avaliacao") != null ? rs.getDate("data_avaliacao").toString() : "");
                dados.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        tabelaNotas.setItems(dados);
    }
}