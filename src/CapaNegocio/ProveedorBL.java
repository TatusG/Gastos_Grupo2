/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;
import CapaDatos.ProveedorDAL;
import CapaEntidades.Proveedor;
import java.util.List;

public class ProveedorBL {    
    
    ProveedorDAL oProveedorDAL = new ProveedorDAL();
    
    public List listarProveedor(){
        return oProveedorDAL.listarProveedor();
    }
    
    public List listarEstado(){
        return oProveedorDAL.listarEstado();
    }
    
    public List listarDepartamento(){
        return oProveedorDAL.listarDepartamento();
    }
    
    public List listarProvincia(String departamento){
        return oProveedorDAL.listarProvincia(departamento);
    }
    
    public List listarDistrito(String provincia){
        return oProveedorDAL.listarDistrito(provincia);
    }
    
    public boolean validarRUC(String RUC){
        return oProveedorDAL.validarRUC(RUC);
    }      
    
    public int agregarProveedor(Proveedor oProveedor){
        String mensaje="";
        if (validarRUC(oProveedor.getRuc())) {
            mensaje="El RUC ya existe";   
            return -1;
        }else{
            return oProveedorDAL.agregarProveedor(oProveedor);
        }        
    }
    
    public Proveedor buscarProveedor(String RUC){
        return oProveedorDAL.buscarProveedor(RUC);        
    }
    
    public int actualizarProveedor(Proveedor oProveedor){
        return oProveedorDAL.actualizarProveedor(oProveedor);
    }
    public int eliminarProveedor(String RUC){
        return oProveedorDAL.eliminarProveedor(RUC);
    }
}
