/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import CapaEntidades.Estado;
import CapaEntidades.Perfil;
import CapaEntidades.Usuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author yenko
 */
public class UsuarioDAL {

    Connection cn = new ConexionBD().abrirConexion();

    public List listarUsuario() {
        List<Usuario> lista = new ArrayList<>();

        try {
            CallableStatement cs = cn.prepareCall("{call sp_listarUsuario()}");
            ResultSet rs = cs.executeQuery();
            System.out.println("Registros encontrados.");
            while (rs.next()) {
                Blob blob = rs.getBlob(9);
                byte[] data = blob != null ? blob.getBytes(1, (int) blob.length()) : null;
                BufferedImage img = null;
                if (data != null) {
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                        System.out.println("Error al leer la imagen; " + ex.getMessage());
                    }
                }
                lista.add(new Usuario(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), img));
            }
        } catch (Exception e) {
            System.out.println("Error en listarUsuario" + e.getMessage());
        }
        return lista;
    }
    
    public List listarEstado() {
        List<Estado> estado = new ArrayList();
        estado.add(new Estado (0,"<Seleccionar>"));
        try {
            CallableStatement cs = cn.prepareCall("{call sp_listarEstado}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                estado.add(new Estado(rs.getInt(1),rs.getString(2)));
            }
            cs.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Estado " + e.getMessage());
        }
        return estado;
    }
    
    public List listarPerfil() {
        List<Perfil> perfil = new ArrayList();
        perfil.add(new Perfil (0,"<Seleccionar>"));
        try {
            CallableStatement cs = cn.prepareCall("{call sp_listarPerfil}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                perfil.add(new Perfil(rs.getInt(1),rs.getString(2)));
            }
            cs.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Perfil " + e.getMessage());
        }
        return perfil;
    }

    public boolean validarUsuario(String Usuario) {
        String mensaje = "";
        try {
            PreparedStatement pst = cn.prepareStatement("select count(*) from usuario where Usuario=?");
            pst.setString(1, Usuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            pst.close();
            rs.close();
        } catch (Exception ex) {
            mensaje = ex.getMessage();
            System.out.println("Error al validar Usuario " + mensaje);
        }
        return false;
    }

    public int agregarUsuario(Usuario unUsuario, String archivo) {
        int r;
        FileInputStream fis = null;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_InsertarUsuario(?,?,?,?,?,?,?,?,?)}");
            File file = new File(archivo);
            fis = new FileInputStream(file);
            cs.setString(1, unUsuario.getPerfil());
            cs.setString(2, unUsuario.getEstado());
            cs.setString(3, unUsuario.getUsuario());
            cs.setString(4, unUsuario.getPassword());
            cs.setString(5, unUsuario.getApellidoPaterno());
            cs.setString(6, unUsuario.getApellidoMaterno());
            cs.setString(7, unUsuario.getNombres());
            cs.setBinaryStream(8, fis, (int) file.length());
            cs.setString(9, unUsuario.getUsuariomod());
            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error al agregar usuario: " + ex.getMessage());
            r = 0;
        }
        return r;
    }

    public Usuario buscarUsuario(int codigo) {
        Usuario ousuario = null;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_buscarUsuario(?)}");
            cs.setInt(1, codigo);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                Blob blob = rs.getBlob(9);
                byte[] data = blob != null ? blob.getBytes(1, (int) blob.length()) : null;
                Image img = null;
                if (data != null) {
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                        System.out.println("Error al leer la imagen; " + ex.getMessage());
                    }
                }
                ousuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), img);
            } else {
                ousuario = null;
            }
            cs.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return ousuario;
    }

    public int actualizarUsuario(Usuario unUsuario, String archivoFoto) {
        int r;
        FileInputStream fis = null;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_actualizarusuario(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, unUsuario.getIdUsuario());
            cs.setString(2, unUsuario.getPerfil());
            cs.setString(3, unUsuario.getEstado());
            cs.setString(4, unUsuario.getUsuario());
            if (unUsuario.getPassword() != null && !unUsuario.getPassword().isEmpty()) {
                cs.setString(5, unUsuario.getPassword());
            } else {
                cs.setNull(5, java.sql.Types.VARCHAR); 
            }
            cs.setString(6, unUsuario.getApellidoPaterno());
            cs.setString(7, unUsuario.getApellidoMaterno());
            cs.setString(8, unUsuario.getNombres());
            if (archivoFoto != null && !archivoFoto.isEmpty()) {
                File file = new File(archivoFoto);
                fis = new FileInputStream(file);
                cs.setBinaryStream(9, fis, (int) file.length());
            } else {
                cs.setNull(9, java.sql.Types.BLOB);
            }
            cs.setString(10, unUsuario.getUsuariomod());
            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
            r = 0;
        }
        return r;
    }

    public int eliminarUsuario(int codigo) {
        int r;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_eliminarUsuario(?)}");
            cs.setInt(1, codigo);
            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception e) {
            r = 1;
        }
        return r;
    }

}
