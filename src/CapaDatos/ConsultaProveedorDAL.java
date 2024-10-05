/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import CapaEntidades.ConsultaProveedor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ConsultaProveedorDAL {
    Connection cn= new ConexionBD().abrirConexion();
    
    public List listarProveedorporDepartamento(String departamento){
        List<ConsultaProveedor> lista = new ArrayList();
        try {
            CallableStatement cs= cn.prepareCall("call sp_listarProveedorxDepartamento(?)");
            cs.setString(1, departamento);
            ResultSet rs= cs.executeQuery();
            while (rs.next()) {
                lista.add(new ConsultaProveedor (rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5)));                
            }
        } catch (Exception e) {
            System.out.println("ListaProveedoresDep: "+e.getMessage());
        }
        return lista;
    }
    
    public List listarProveedorporProvincia(String provincia){
        List<ConsultaProveedor> lista = new ArrayList();
        try {
            CallableStatement cs= cn.prepareCall("call sp_listarProveedorxprovincia(?)");
            cs.setString(1, provincia);
            ResultSet rs= cs.executeQuery();
            while (rs.next()) {
                lista.add(new ConsultaProveedor (rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5)));                
            }
        } catch (Exception e) {
            System.out.println("ListaProveedoresProv: "+e.getMessage());
        }
        return lista;
    }
    
    public List listarProveedorporDistrito(String distrito){
        List<ConsultaProveedor> lista = new ArrayList();
        try {
            CallableStatement cs= cn.prepareCall("call sp_listarProveedorxdistrito(?)");
            cs.setString(1, distrito);
            ResultSet rs= cs.executeQuery();
            while (rs.next()) {
                lista.add(new ConsultaProveedor (rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5)));                
            }
        } catch (Exception e) {
            System.out.println("ListaProveedoresDistrito: "+e.getMessage());
        }
        return lista;
    }
}
