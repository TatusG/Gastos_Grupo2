/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import CapaEntidades.ConsultaGasto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yenko
 */
public class ConsultaGastosDAL {
    Connection cn= new ConexionBD().abrirConexion();
    
    public List listarGastoFiltro(String concepto,String proveedor){
        List<ConsultaGasto> lista = new ArrayList();
        try {
            CallableStatement cs= cn.prepareCall("call sp_listarGastoxDepartamento(?,?)");
            cs.setString(1, proveedor);
            cs.setString(2,concepto);
            ResultSet rs= cs.executeQuery();
            while (rs.next()) {
                lista.add(new ConsultaGasto (rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5),rs.getString(6),rs.getDouble(7)));                
            }
        } catch (Exception e) {
            System.out.println("ListaGastoesDep: "+e.getMessage());
        }
        return lista;
    }
    
}
