/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import CapaEntidades.Proveedor;
import CapaEntidades.Departamento;
import CapaEntidades.Distrito;
import CapaEntidades.Estado;
import CapaEntidades.Provincia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProveedorDAL {

    Connection cn = new ConexionBD().abrirConexion();

    public List listarDepartamento() {
        List<Departamento> departamento = new ArrayList();
        departamento.add(new Departamento(0, "<Seleccionar>"));
        try {
            CallableStatement cs = cn.prepareCall("{call sp_listarDepartamento}");
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                departamento.add(new Departamento(rs.getInt(1), rs.getString(2)));
            }
            cs.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ListaDepartamento " + e.getMessage());
        }
        return departamento;
    }

    public List listarProvincia(String departamento) {
        List<Provincia> provincias = new ArrayList();
        provincias.add(new Provincia(0, "<Seleccionar>"));
        try {
            CallableStatement cs = cn.prepareCall("{call sp_listarProvincias(?)}");
            cs.setString(1, departamento);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                provincias.add(new Provincia(rs.getInt(1), rs.getString(2)));
            }
            cs.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ListaProvincia " + e.getMessage());
        }
        return provincias;
    }

    public List listarDistrito(String provincia) {
        List<Distrito> distrito = new ArrayList();
        distrito.add(new Distrito(0, "<Seleccionar>"));
        try {
            CallableStatement cs = cn.prepareCall("{call sp_listarDistritos(?)}");
            cs.setString(1, provincia);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                distrito.add(new Distrito(rs.getInt(1), rs.getString(2)));
            }
            cs.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("ListaDistrito " + e.getMessage());
        }
        return distrito;
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

    public List listarProveedor(){
        List<Proveedor> lista = new ArrayList<>();
        
        try {            
            CallableStatement cs = cn.prepareCall("{call sp_listarProveedor()}");
            ResultSet rs = cs.executeQuery();
            
            System.out.println("Registros encontrados.");
            while (rs.next()) {
                lista.add(new Proveedor(
                        rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), 
                        rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), 
                        rs.getString(11)));
            }             
        } catch (Exception e) {
            System.out.println("Error en listarProveedor" + e.getMessage());
        }
        return lista;
    }
    
    public boolean validarRUC(String RUC){
        String mensaje = "";
        try {
            PreparedStatement pst = cn.prepareStatement("select count(*) from proveedores where RUC =?");
            pst.setString(1, RUC);	    
	    ResultSet rs = pst.executeQuery();            
            if (rs.next()) {
                return rs.getInt(1)>0;
            }
            pst.close(); rs.close();
        } catch (Exception ex) {
            mensaje =ex.getMessage();
            System.out.println("Error al validar RUC"+mensaje);
        }
        return false;
    }
    
    public boolean validarRazonSocial(String RazonSocial){
        String mensaje = "";
        try {
            PreparedStatement pst = cn.prepareStatement("select count(*) from proveedores where RazonSocial =?");
            pst.setString(1, RazonSocial);	    
	    ResultSet rs = pst.executeQuery();            
            if (rs.next()) {
                return rs.getInt(1)>0;
            }
            pst.close(); rs.close();
        } catch (Exception ex) {
            mensaje =ex.getMessage();
            System.out.println("Error al validar RazonSocial"+mensaje);
        }
        return false;
    }

    public int agregarProveedor(Proveedor unProveedor) {
        int r;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_insertarProveedor(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, unProveedor.getRuc());
            cs.setString(2, unProveedor.getRazonsocial());
            cs.setString(3, unProveedor.getDireccion());
            cs.setString(4, unProveedor.getDepartamento());
            cs.setString(5, unProveedor.getProvincia());
            cs.setString(6, unProveedor.getDistrito());
            cs.setString(7, unProveedor.getTelefono());
            cs.setString(8, unProveedor.getCelular());
            cs.setString(9, unProveedor.getEmail());
            cs.setString(10, unProveedor.getEstado());            
            cs.setString(11, unProveedor.getUsuario());
            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception ex) {
            System.out.println("Error al agregar proveedor: "+ex.getMessage());
            r = 0;
        }
        return r;
    }

    public Proveedor buscarProveedor(String RUC) {
        Proveedor oproveedor = null;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_buscarProveedor(?)}");
            cs.setString(1, RUC);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                oproveedor = new Proveedor(
                        rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                    rs.getString(6), 
                        rs.getString(7),
                        rs.getString(8), 
                        rs.getString(9), 
                        rs.getString(10), 
                    rs.getString(11));
            } else {
                oproveedor = null;
            }
            cs.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return oproveedor;
    }
    
    public boolean validarRUCExcluyendoId(String RUC, int IdProveedor){
     String mensaje = "";
        try {
            PreparedStatement pst = cn.prepareStatement("select count(*) from proveedores where RUC =? and IdProveedor!=?");
            pst.setString(1, RUC);
            pst.setInt(2, IdProveedor);
	    ResultSet rs = pst.executeQuery();            
            if (rs.next()) {
                return rs.getInt(1)>0;
            }
            pst.close(); rs.close();
        } catch (Exception ex) {
            mensaje =ex.getMessage();
            System.out.println("Error al validar RUC"+mensaje);
        }
        return false; 
    }
    
    public boolean validarRazonSocialExcluyendoId(String RazonSocial, int IdProveedor){
        String mensaje = "";
        try {
            PreparedStatement pst = cn.prepareStatement("select count(*) from proveedores where RazonSocial =? AND IdProveedor !=?");
            pst.setString(1, RazonSocial);
            pst.setInt(2, IdProveedor);
	    ResultSet rs = pst.executeQuery();            
            if (rs.next()) {
                return rs.getInt(1)>0;
            }
            pst.close(); rs.close();
        } catch (Exception ex) {
            mensaje =ex.getMessage();
            System.out.println("Error al validar RazonSocial"+mensaje);
        }
        return false;
    }
    
    

    public int actualizarProveedor(Proveedor unProveedor) {
        int r;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_actualizarproveedor(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, unProveedor.getIdproveedor());
            cs.setString(2, unProveedor.getRuc());
            cs.setString(3, unProveedor.getRazonsocial());
            cs.setString(4, unProveedor.getDireccion());
            cs.setString(5, unProveedor.getDepartamento());
            cs.setString(6, unProveedor.getProvincia());
            cs.setString(7, unProveedor.getDistrito());
            cs.setString(8, unProveedor.getTelefono());
            cs.setString(9, unProveedor.getCelular());
            cs.setString(10, unProveedor.getEmail());
            cs.setString(11, unProveedor.getEstado());            
            cs.setString(12, unProveedor.getUsuario());
            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception e) {
            System.out.println("Error al actualizar proveedor: "+e.getMessage());
            r = 0;
        }
        return r;
    }

    public int eliminarProveedor(String RUC) {
        int r;
        try {
            CallableStatement cs = cn.prepareCall("{call sp_eliminarProveedor(?)}");
            cs.setString(1, RUC);
            int f = cs.executeUpdate();
            if (f > 0) {
                r = 1;
            } else {
                r = 0;
            }
            cs.close();
        } catch (Exception e) {
            r = -1;
        }
        return r;
    }

}
