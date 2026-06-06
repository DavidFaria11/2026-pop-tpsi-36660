package com.escolamusica.controller;

import com.escolamusica.dao.CursoDAO;
import com.escolamusica.model.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormCursoController {

    @FXML private TextField txtNome;
    @FXML private TextField txtPreco;
    @FXML private TextField txtTipo;
    @FXML private TextField txtIdProfessor;
    @FXML private TextField txtIdInstrumento;
    @FXML private Label lblErro;

    private CursoDAO cursoDAO = new CursoDAO();
    private Curso cursoAtual;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setCurso(Curso curso) {
        this.cursoAtual = curso;

        if (curso != null) {
            txtNome.setText(curso.getNomeCurso());
            txtPreco.setText(String.valueOf(curso.getPrecoMensal()));
            txtTipo.setText(curso.getTipo());
            txtIdProfessor.setText(String.valueOf(curso.getIdProfessor()));
            txtIdInstrumento.setText(String.valueOf(curso.getIdInstrumento()));
        }
    }

    @FXML
    private void handleGuardar() {
        String nome = txtNome.getText().trim();
        String precoStr = txtPreco.getText().trim();
        String tipo = txtTipo.getText().trim();
        String idProfStr = txtIdProfessor.getText().trim();
        String idInstStr = txtIdInstrumento.getText().trim();

        if (nome.isEmpty() || precoStr.isEmpty() || idProfStr.isEmpty() || idInstStr.isEmpty()) {
            lblErro.setText("Preenche todos os campos obrigatórios!");
            return;
        }

        double preco;
        int idProf, idInst;

        try {
            preco = Double.parseDouble(precoStr);
            idProf = Integer.parseInt(idProfStr);
            idInst = Integer.parseInt(idInstStr);
        } catch (NumberFormatException e) {
            lblErro.setText("Preço e IDs têm de ser números!");
            return;
        }

        if (cursoAtual == null) {
            Curso novo = new Curso(0, nome, preco, tipo, idProf, "", idInst, "");
            cursoDAO.inserir(novo);
        } else {
            cursoAtual.setNomeCurso(nome);
            cursoAtual.setPrecoMensal(preco);
            cursoAtual.setTipo(tipo);
            cursoAtual.setIdProfessor(idProf);
            cursoAtual.setIdInstrumento(idInst);
            cursoDAO.atualizar(cursoAtual);
        }

        stage.close();
    }

    @FXML
    private void handleCancelar() {
        stage.close();
    }
}