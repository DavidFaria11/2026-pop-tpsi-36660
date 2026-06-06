package com.escolamusica.dao;

import com.escolamusica.model.Matricula;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO {

    // Listar todas as matrículas
    public List<Matricula> listarTodos() {
        List<Matricula> matriculas = new ArrayList<>();
        String sql = "SELECT m.*, a.nome_aluno, c.nome_curso " +
                "FROM Matricula m " +
                "JOIN Aluno a ON a.id_aluno = m.id_aluno " +
                "JOIN Curso c ON c.id_curso = m.id_curso " +
                "ORDER BY m.data_inicio DESC";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdMatricula(rs.getInt("id_matricula"));
                m.setIdAluno(rs.getInt("id_aluno"));
                m.setNomeAluno(rs.getString("nome_aluno"));
                m.setIdCurso(rs.getInt("id_curso"));
                m.setNomeCurso(rs.getString("nome_curso"));
                m.setIdFuncionario(rs.getInt("id_funcionario"));
                m.setValorPago(rs.getDouble("valor_pago"));
                m.setMetodoPagamento(rs.getString("metodo_pagamento"));
                m.setEstadoPagamento(rs.getString("estado_pagamento"));
                if (rs.getDate("data_inicio") != null)
                    m.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                if (rs.getDate("data_fim") != null)
                    m.setDataFim(rs.getDate("data_fim").toLocalDate());
                if (rs.getDate("data_pagamento") != null)
                    m.setDataPagamento(rs.getDate("data_pagamento").toLocalDate());
                matriculas.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matriculas;
    }

    // Listar matrículas por aluno
    public List<Matricula> listarPorAluno(int idAluno) {
        List<Matricula> matriculas = new ArrayList<>();
        String sql = "SELECT m.*, a.nome_aluno, c.nome_curso " +
                "FROM Matricula m " +
                "JOIN Aluno a ON a.id_aluno = m.id_aluno " +
                "JOIN Curso c ON c.id_curso = m.id_curso " +
                "WHERE m.id_aluno = ? " +
                "ORDER BY m.data_inicio DESC";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdMatricula(rs.getInt("id_matricula"));
                m.setIdAluno(rs.getInt("id_aluno"));
                m.setNomeAluno(rs.getString("nome_aluno"));
                m.setIdCurso(rs.getInt("id_curso"));
                m.setNomeCurso(rs.getString("nome_curso"));
                m.setIdFuncionario(rs.getInt("id_funcionario"));
                m.setValorPago(rs.getDouble("valor_pago"));
                m.setMetodoPagamento(rs.getString("metodo_pagamento"));
                m.setEstadoPagamento(rs.getString("estado_pagamento"));
                if (rs.getDate("data_inicio") != null)
                    m.setDataInicio(rs.getDate("data_inicio").toLocalDate());
                if (rs.getDate("data_fim") != null)
                    m.setDataFim(rs.getDate("data_fim").toLocalDate());
                if (rs.getDate("data_pagamento") != null)
                    m.setDataPagamento(rs.getDate("data_pagamento").toLocalDate());
                matriculas.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matriculas;
    }

    // Inserir nova matrícula
    public boolean inserir(Matricula m) {
        String sql = "INSERT INTO Matricula (data_inicio, data_fim, data_pagamento, " +
                "valor_pago, metodo_pagamento, estado_pagamento, " +
                "id_aluno, id_curso, id_funcionario) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, m.getDataInicio() != null ? Date.valueOf(m.getDataInicio()) : null);
            stmt.setDate(2, m.getDataFim() != null ? Date.valueOf(m.getDataFim()) : null);
            stmt.setDate(3, m.getDataPagamento() != null ? Date.valueOf(m.getDataPagamento()) : null);
            stmt.setDouble(4, m.getValorPago());
            stmt.setString(5, m.getMetodoPagamento());
            stmt.setString(6, m.getEstadoPagamento());
            stmt.setInt(7, m.getIdAluno());
            stmt.setInt(8, m.getIdCurso());
            stmt.setInt(9, m.getIdFuncionario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar matrícula
    public boolean atualizar(Matricula m) {
        String sql = "UPDATE Matricula SET data_fim=?, data_pagamento=?, " +
                "valor_pago=?, metodo_pagamento=?, estado_pagamento=? " +
                "WHERE id_matricula=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDate(1, m.getDataFim() != null ? Date.valueOf(m.getDataFim()) : null);
            stmt.setDate(2, m.getDataPagamento() != null ? Date.valueOf(m.getDataPagamento()) : null);
            stmt.setDouble(3, m.getValorPago());
            stmt.setString(4, m.getMetodoPagamento());
            stmt.setString(5, m.getEstadoPagamento());
            stmt.setInt(6, m.getIdMatricula());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Apagar matrícula
    public boolean apagar(int id) {
        String sql = "DELETE FROM Matricula WHERE id_matricula = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}