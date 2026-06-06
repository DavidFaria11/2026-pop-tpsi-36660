package com.escolamusica.dao;

import com.escolamusica.model.Utilizador;
import java.sql.*;

public class utilizadorDAO {

    // Verifica login - devolve o utilizador se existir, null se não existir
    public Utilizador login(String username, String password) {
        String sql = "SELECT * FROM Utilizador WHERE username = ? AND password = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Utilizador u = new Utilizador();
                u.setIdUtilizador(rs.getInt("id_utilizador"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setPerfil(rs.getString("perfil"));
                u.setIdReferencia(rs.getInt("id_referencia"));
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // login falhou
    }
}