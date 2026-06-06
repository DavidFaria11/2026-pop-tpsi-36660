package com.escolamusica.dao;

import com.escolamusica.model.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    // Listar todos os cursos
    public List<Curso> listarTodos() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT c.*, p.nome_professor, i.nome_instrumento " +
                "FROM Curso c " +
                "JOIN Professor p ON p.id_professor = c.id_professor " +
                "JOIN Instrumento i ON i.id_instrumento = c.id_instrumento " +
                "ORDER BY c.nome_curso";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Curso c = new Curso();
                c.setIdCurso(rs.getInt("id_curso"));
                c.setNomeCurso(rs.getString("nome_curso"));
                c.setPrecoMensal(rs.getDouble("preco_mensal"));
                c.setTipo(rs.getString("tipo"));
                c.setIdProfessor(rs.getInt("id_professor"));
                c.setNomeProfessor(rs.getString("nome_professor"));
                c.setIdInstrumento(rs.getInt("id_instrumento"));
                c.setNomeInstrumento(rs.getString("nome_instrumento"));
                cursos.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    // Inserir novo curso
    public boolean inserir(Curso c) {
        String sql = "INSERT INTO Curso (nome_curso, preco_mensal, tipo, id_professor, id_instrumento) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNomeCurso());
            stmt.setDouble(2, c.getPrecoMensal());
            stmt.setString(3, c.getTipo());
            stmt.setInt(4, c.getIdProfessor());
            stmt.setInt(5, c.getIdInstrumento());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar curso
    public boolean atualizar(Curso c) {
        String sql = "UPDATE Curso SET nome_curso=?, preco_mensal=?, tipo=?, id_professor=?, id_instrumento=? WHERE id_curso=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getNomeCurso());
            stmt.setDouble(2, c.getPrecoMensal());
            stmt.setString(3, c.getTipo());
            stmt.setInt(4, c.getIdProfessor());
            stmt.setInt(5, c.getIdInstrumento());
            stmt.setInt(6, c.getIdCurso());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Apagar curso
    public boolean apagar(int id) {
        String sql = "DELETE FROM Curso WHERE id_curso = ?";

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