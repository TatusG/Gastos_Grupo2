/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import CapaDatos.ConexionBD;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yenko
 */
public class ValidarLogin {

    public String validarUsuario(String usuario, String contraseña) {
        String perfil = null;        
        Connection cn = new ConexionBD().abrirConexion();

        try {
            String contraseñaHasheada = encriptarContraseña(contraseña);
            PreparedStatement ps = cn.prepareStatement("select p.Perfil from perfil p inner join usuario u on p.IdPerfil = u.IdPerfil "
                    + "where Usuario = ? AND contraseña = ? AND IdEliminado = 0");
            ps.setString(1, usuario);
            ps.setString(2, contraseñaHasheada);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {                
                perfil = rs.getString("Perfil");
            }
            cn.close();
        } catch (SQLException e) {
            e.printStackTrace();        
        }
        return perfil;
    }

    private String encriptarContraseña(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(contraseña.getBytes("UTF-8"));

            // Convertir bytes a hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
