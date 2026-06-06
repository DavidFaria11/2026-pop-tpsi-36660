package com.escolamusica.controller;

import com.escolamusica.dao.ProfessorDAO;
import com.escolamusica.model.Professor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class FormProfessorController {

    @FXML private TextField txtNome;
    @FXML private TextField txtEmail;
    @FXML private TextField txtTelemovel;
    @FXML private TextField txtEspecialidade;
    @FXML private TextField txtDataNasc;
    @FXML private Label lblErro;

    private ProfessorDAO professorDAO = new ProfessorDAO();
    private Professor professorAtual;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setProfessor(Professor professor) {
        this.professorAtual = professor;

        if (professor != null) {
            txtNome.setText(professor.getNome());
            txtEmail.setText(professor.getEmail());
            txtTelemovel.setText(professor.getTelemovel());
            txtEspecialidade.setText(professor.getEspecialidade());
            if (professor.getDataNascimento() != null)
                txtDataNasc.setText(professor.getDataNascimento().toString());
        }
    }

    @FXML
    private void handleGuardar() {
        String nome = txtNome.getText().trim();
        String email = txtEmail.getText().trim();
        String telemovel = txtTelemovel.getText().trim();
        String especialidade = txtEspecialidade.getText().trim();
        String dataNascStr = txtDataNasc.getText().trim();

        if (nome.isEmpty() || email.isEmpty()) {
            lblErro.setText("Nome e email são obrigatórios!");
            return;
        }

        LocalDate dataNasc = null;
        if (!dataNascStr.isEmpty()) {
            try {
                dataNasc = LocalDate.parse(dataNascStr);
            } catch (Exception e) {
                lblErro.setText("Data inválida! Usa o formato AAAA-MM-DD");
                return;
            }
        }

        if (professorAtual == null) {
            Professor novo = new Professor(0, nome, email, telemovel, dataNasc, especialidade);
            professorDAO.inserir(novo);
        } else {
            professorAtual.setNome(nome);
            professorAtual.setEmail(email);
            professorAtual.setTelemovel(telemovel);
            professorAtual.setEspecialidade(especialidade);
            professorAtual.setDataNascimento(dataNasc);
            professorDAO.atualizar(professorAtual);
        }

        stage.close();
    }

    @FXML
    private void handleCancelar() {
        stage.close();
    }
}