package com.escolamusica.controller;

import com.escolamusica.dao.MatriculaDAO;
import com.escolamusica.model.Matricula;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class FormMatriculaController {

    @FXML private TextField txtIdAluno;
    @FXML private TextField txtIdCurso;
    @FXML private TextField txtIdFuncionario;
    @FXML private TextField txtDataInicio;
    @FXML private TextField txtValor;
    @FXML private TextField txtMetodo;
    @FXML private TextField txtEstado;
    @FXML private Label lblErro;

    private MatriculaDAO matriculaDAO = new MatriculaDAO();
    private Matricula matriculaAtual;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMatricula(Matricula matricula) {
        this.matriculaAtual = matricula;

        if (matricula != null) {
            txtIdAluno.setText(String.valueOf(matricula.getIdAluno()));
            txtIdCurso.setText(String.valueOf(matricula.getIdCurso()));
            txtIdFuncionario.setText(String.valueOf(matricula.getIdFuncionario()));
            if (matricula.getDataInicio() != null)
                txtDataInicio.setText(matricula.getDataInicio().toString());
            txtValor.setText(String.valueOf(matricula.getValorPago()));
            txtMetodo.setText(matricula.getMetodoPagamento());
            txtEstado.setText(matricula.getEstadoPagamento());
        }
    }

    @FXML
    private void handleGuardar() {
        String idAlunoStr = txtIdAluno.getText().trim();
        String idCursoStr = txtIdCurso.getText().trim();
        String idFuncStr = txtIdFuncionario.getText().trim();
        String dataInicioStr = txtDataInicio.getText().trim();
        String valorStr = txtValor.getText().trim();
        String metodo = txtMetodo.getText().trim();
        String estado = txtEstado.getText().trim();

        if (idAlunoStr.isEmpty() || idCursoStr.isEmpty() || dataInicioStr.isEmpty()) {
            lblErro.setText("ID Aluno, ID Curso e Data de Início são obrigatórios!");
            return;
        }

        try {
            int idAluno = Integer.parseInt(idAlunoStr);
            int idCurso = Integer.parseInt(idCursoStr);
            int idFunc = idFuncStr.isEmpty() ? 0 : Integer.parseInt(idFuncStr);
            double valor = valorStr.isEmpty() ? 0 : Double.parseDouble(valorStr);
            LocalDate dataInicio = LocalDate.parse(dataInicioStr);

            if (matriculaAtual == null) {
                Matricula nova = new Matricula(0, dataInicio, null, null,
                        valor, metodo, estado, idAluno, "", idCurso, "", idFunc);
                matriculaDAO.inserir(nova);
            } else {
                matriculaAtual.setIdAluno(idAluno);
                matriculaAtual.setIdCurso(idCurso);
                matriculaAtual.setIdFuncionario(idFunc);
                matriculaAtual.setDataInicio(dataInicio);
                matriculaAtual.setValorPago(valor);
                matriculaAtual.setMetodoPagamento(metodo);
                matriculaAtual.setEstadoPagamento(estado);
                matriculaDAO.atualizar(matriculaAtual);
            }

            stage.close();

        } catch (Exception e) {
            lblErro.setText("Dados inválidos! Verifica os campos.");
        }
    }

    @FXML
    private void handleCancelar() {
        stage.close();
    }
}