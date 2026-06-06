package com.escolamusica.controller;

import com.escolamusica.dao.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class UCsProfessorController {

    @FXML private TableView<ObservableList<String>> tabelaUCs;
    @FXML private TableColumn<ObservableList<String>, String> colId;
    @FXML private TableColumn<ObservableList<String>, String> colNome;
    @FXML private TableColumn<ObservableList<String>, String> colDia;
    @FXML private TableColumn<ObservableList<String>, String> colHora;
    @FXML private TableColumn<ObservableList<String>, String> colCurso;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(0)));
        colNome.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(1)));
        colDia.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(2)));
        colHora.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(3)));
        colCurso.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().get(4)));

        carregarUCs();
    }

    private void carregarUCs() {
        int idProfessor = SessaoAtual.getUtilizador().getIdReferencia();
        String sql = "SELECT uc.id_uc, uc.nome_uc, uc.dia_semana, uc.hora, c.nome_curso " +
                "FROM Unidade_Curricular uc " +
                "JOIN Curso c ON c.id_curso = uc.id_curso " +
                "WHERE uc.id_professor = ?";

        ObservableList<ObservableList<String>> dados = FXCollections.observableArrayList();

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProfessor);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                row.add(String.valueOf(rs.getInt("id_uc")));
                row.add(rs.getString("nome_uc"));
                row.add(rs.getString("dia_semana"));
                row.add(rs.getString("hora"));
                row.add(rs.getString("nome_curso"));
                dados.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        tabelaUCs.setItems(dados);
    }
}