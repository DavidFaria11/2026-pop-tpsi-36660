package com.escolamusica.controller;

import com.escolamusica.dao.AlunoDAO;
import com.escolamusica.model.Aluno;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class FormAlunoController {

    @FXML private TextField txtNome;
    @FXML private TextField txtEmail;
    @FXML private TextField txtTelemovel;
    @FXML private TextField txtDataNasc;
    @FXML private Label lblErro;

    private AlunoDAO alunoDAO = new AlunoDAO();
    private Aluno alunoAtual;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setAluno(Aluno aluno) {
        this.alunoAtual = aluno;

        if (aluno != null) {
            txtNome.setText(aluno.getNome());
            txtEmail.setText(aluno.getEmail());
            txtTelemovel.setText(aluno.getTelemovel());
            if (aluno.getDataNascimento() != null)
                txtDataNasc.setText(aluno.getDataNascimento().toString());
        }
    }

    @FXML
    private void handleGuardar() {
        String nome = txtNome.getText().trim();
        String email = txtEmail.getText().trim();
        String telemovel = txtTelemovel.getText().trim();
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

        if (alunoAtual == null) {
            Aluno novo = new Aluno(0, nome, email, telemovel, dataNasc);
            alunoDAO.inserir(novo);
        } else {
            alunoAtual.setNome(nome);
            alunoAtual.setEmail(email);
            alunoAtual.setTelemovel(telemovel);
            alunoAtual.setDataNascimento(dataNasc);
            alunoDAO.atualizar(alunoAtual);
        }

        stage.close();
    }

    @FXML
    private void handleCancelar() {
        stage.close();
    }
}