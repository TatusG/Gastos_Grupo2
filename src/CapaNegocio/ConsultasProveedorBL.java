/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.ConsultaProveedorDAL;
import java.util.List;

/**
 *
 * @author PC
 */
public class ConsultasProveedorBL {
    ConsultaProveedorDAL oConsultaProveedorDAL = new ConsultaProveedorDAL();
    
    public List listarProveedorporDepartamento(String departamento){
        return oConsultaProveedorDAL.listarProveedorporDepartamento(departamento);
    }
    
    public List listarProveedorporProvincia(String provincia){        
        return oConsultaProveedorDAL.listarProveedorporProvincia(provincia);
    }
    
    public List listarProveedorporDistrito(String distrito){
        return oConsultaProveedorDAL.listarProveedorporDistrito(distrito);
    }
    
}
