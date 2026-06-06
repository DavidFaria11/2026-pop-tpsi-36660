package com.escolamusica.dao;

import com.escolamusica.model.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // Listar todos os alunos
    public List<Aluno> listarTodos() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM Aluno ORDER BY nome_aluno";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id_aluno"));
                a.setNome(rs.getString("nome_aluno"));
                a.setEmail(rs.getString("email_aluno"));
                a.setTelemovel(rs.getString("telemovel_aluno"));
                if (rs.getDate("data_nascimento") != null)
                    a.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                alunos.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alunos;
    }

    // Buscar aluno por ID
    public Aluno buscarPorId(int id) {
        String sql = "SELECT * FROM Aluno WHERE id_aluno = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id_aluno"));
                a.setNome(rs.getString("nome_aluno"));
                a.setEmail(rs.getString("email_aluno"));
                a.setTelemovel(rs.getString("telemovel_aluno"));
                if (rs.getDate("data_nascimento") != null)
                    a.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                return a;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Inserir novo aluno
    public boolean inserir(Aluno a) {
        String sql = "INSERT INTO Aluno (nome_aluno, email_aluno, telemovel_aluno, data_nascimento) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getTelemovel());
            stmt.setDate(4, a.getDataNascimento() != null ? Date.valueOf(a.getDataNascimento()) : null);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Atualizar aluno
    public boolean atualizar(Aluno a) {
        String sql = "UPDATE Aluno SET nome_aluno=?, email_aluno=?, telemovel_aluno=?, data_nascimento=? WHERE id_aluno=?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getTelemovel());
            stmt.setDate(4, a.getDataNascimento() != null ? Date.valueOf(a.getDataNascimento()) : null);
            stmt.setInt(5, a.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Apagar aluno
    public boolean apagar(int id) {
        String sql = "DELETE FROM Aluno WHERE id_aluno = ?";

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