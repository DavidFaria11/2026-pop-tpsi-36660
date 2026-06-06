package com.escolamusica.dao;

import com.escolamusica.model.Professor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    // Listar todos os professores
    public List<Professor> listarTodos() {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM Professor ORDER BY nome_professor";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Professor p = new Professor();
                p.setId(rs.getInt("id_professor"));
                p.setNome(rs.getString("nome_professor"));
                p.setEmail(rs.getString("email_professor"));
                p.setTelemovel(rs.getString("telemovel_professor"));
                p.setEspecialidade(rs.getString("especialidade"));
                if (rs.getDate("data_nascimento") != null)
                    p.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                professores.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professores;
    }

    // Buscar professor por ID
    public Professor buscarPorId(int id) {
        String sql = "SELECT * FROM Professor WHERE id_professor = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Professor p = new Professor();
                p.setId(rs.getInt("id_professor"));
                p.setNome(rs.getString("nome_professor"));
                p.setEmail(rs.getString("email_professor"));
                p.setTelemovel(rs.getString("telemovel_professor"));
                p.setEspecialidade(rs.getString("especialidade"));
                if (rs.getDate("data_nascimento") != null)
                    p.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                return p;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Inserir novo professor
    public boolean inserir(Professor p) {
        String sql = "INSERT INTO Professor (nome_professor, email_professor, telemovel_professor, data_nascimento, especialidade) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getTelemovel());
            stmt.setDate(4, p.getDataNascimento() != null ? Date.valueOf(p.getDataNascimento()) : null);
            stmt.setString(5, p.getEspecialidade());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar professor
    public boolean atualizar(Professor p) {
        String sql = "UPDATE Professor SET nome_professor=?, email_professor=?, telemovel_professor=?, data_nascimento=?, especialidade=? WHERE id_professor=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getEmail());
            stmt.setString(3, p.getTelemovel());
            stmt.setDate(4, p.getDataNascimento() != null ? Date.valueOf(p.getDataNascimento()) : null);
            stmt.setString(5, p.getEspecialidade());
            stmt.setInt(6, p.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Apagar professor
    public boolean apagar(int id) {
        String sql = "DELETE FROM Professor WHERE id_professor = ?";

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