/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

import java.sql.*;

public class ConexionBD {
    Connection cn = null;
    
    public Connection abrirConexion(){
        try {
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/gastos_grupo2?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false","root","123456");
        } catch (Exception e1) {
            System.out.println("Error Sql:"+e1.getMessage());
        }
        return cn;
    }
    
    public void cerrarConexion(){
        try {
            cn.close();
        } catch (Exception e1) {
            System.out.println("Error al Cerrar Conexion: "+e1.getMessage());
        }
    }
}
