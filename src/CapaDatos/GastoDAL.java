/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import CapaEntidades.Gasto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yenko
 */
public class GastoDAL {
    
    Connection cn = new ConexionBD().abrirConexion();
    
    public List listarGasto(){
        List<Gasto> lista = new ArrayList<>();
        
        try {            
            CallableStatement cs = cn.prepareCall("{call sp_listarGastos()}");
            ResultSet rs = cs.executeQuery();
            
            System.out.println("Registros encontrados.");
            while (rs.next()) {
                lista.add(new Gasto(
                        rs.getString(1), rs.getString(2), rs.getString(3), 
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getDouble(7)));
            }             
        } catch (Exception e) {
            System.out.println("Error en listarGasto" + e.getMessage());
        }
        return lista;
    }
    
    
    
    public int agregarGasto(Gasto unGasto) {
        int r;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_InsertarGasto(?,?,?,?,?,?,?)}");
            cs.setString(1, unGasto.getFechaGasto());
            cs.setString(2, unGasto.getTipoDoc());
            cs.setString(3, unGasto.getNumDoc());
            cs.setString(4, unGasto.getConcepto());
            cs.setString(5, unGasto.getProveedor());
            cs.setString(6, unGasto.getTipoMoneda());
            cs.setDouble(7, unGasto.getImporte());
            
            

            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception ex) {
            System.out.println("Error al agregar usuario: "+ex.getMessage());
            r = 0;
        }
        return r;
    }
    
    
    public int actualizarGasto(Gasto unGasto) {
        int r;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_ActualizarGasto(?,?,?,?,?,?,?,?)}");
            cs.setInt(1,unGasto.getIdGasto());
            cs.setString(2, unGasto.getFechaGasto());
            cs.setString(3, unGasto.getTipoDoc());
            cs.setString(4, unGasto.getNumDoc());
            cs.setString(5, unGasto.getConcepto());
            cs.setString(6, unGasto.getProveedor());
            cs.setString(7, unGasto.getTipoMoneda());
            cs.setDouble(8, unGasto.getImporte());

            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception ex) {
            System.out.println("Error al agregar usuario: "+ex.getMessage());
            r = 0;
        }
        return r;
    }
    
    
    
    
    
    public Gasto buscarGasto(int codigo) {
        Gasto ousuario = null;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_buscarGasto(?)}");
            cs.setInt(1, codigo);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                ousuario = new Gasto(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5),
                        rs.getString(6), rs.getString(7),
                        rs.getDouble(8));
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
    
    
    public int eliminarGasto(int codigo) {
        int r;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_eliminarGasto(?)}");
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
