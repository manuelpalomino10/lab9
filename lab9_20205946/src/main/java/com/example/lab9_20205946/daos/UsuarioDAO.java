package com.example.lab9_20205946.daos;



import com.example.lab9_20205946.beans.usuarios;
import java.sql.*;

public class UsuarioDAO extends BaseDao {

    private static final String URL = "jdbc:mysql://localhost:3306/lab9?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";





    public usuarios validarUsuario(String correo, String contraseñaHasheada) {
        usuarios usuario = null;
        String sql = "SELECT  nombres, apellido, pass, dni, correo FROM usuarios " +
                "WHERE correo = ? AND contraseña = ?";

        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, correo);
            pstmt.setString(2, contraseñaHasheada);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error SQL al validar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return usuario;
    }

    private usuarios mapearUsuario(ResultSet rs) throws SQLException {
        usuarios usuario = new usuarios();
        usuario.setIdusuarios(rs.getInt("idUsuario"));
        usuario.setNombre(rs.getString("nombres"));
        usuario.setApellido(rs.getString("apellidos"));
        usuario.setPass(rs.getString("contraseña"));
        usuario.setDni(rs.getString("dni"));
        usuario.setCorreo(rs.getString("correo"));

        return usuario;
    }


}


