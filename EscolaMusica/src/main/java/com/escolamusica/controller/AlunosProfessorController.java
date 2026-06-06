package com.escolamusica.controller;

import com.escolamusica.dao.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class AlunosProfessorController {

    @FXML private TableView<ObservableList<String>> tabelaAlunos;
    @FXML private TableColumn<ObservableList<String>, String> colId;
    @FXML private TableColumn<ObservableList<String>, String> colNome;
    @FXML private TableColumn<ObservableList<String>, String> colEmail;
    @FXML private TableColumn<ObservableList<String>, String> colCurso;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        colNome.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        colEmail.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(2)));
        colCurso.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(3)));

        carregarAlunos();
    }

    private void carregarAlunos() {
        int idProfessor = SessaoAtual.getUtilizador().getIdReferencia();
        String sql = "SELECT DISTINCT a.id_aluno, a.nome_aluno, a.email_aluno, c.nome_curso " +
                "FROM Matricula m " +
                "JOIN Aluno a ON a.id_aluno = m.id_aluno " +
                "JOIN Curso c ON c.id_curso = m.id_curso " +
                "WHERE c.id_professor = ?";

        ObservableList<ObservableList<String>> dados = FXCollections.observableArrayList();

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("id_aluno")));
                row.add(rs.getString("nome_aluno"));
                row.add(rs.getString("email_aluno"));
                row.add(rs.getString("nome_curso"));
                dados.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        tabelaAlunos.setItems(dados);
    }
}