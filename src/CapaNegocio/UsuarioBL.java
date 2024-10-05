/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.UsuarioDAL;
import CapaEntidades.Usuario;
import java.util.List;

/**
 *
 * @author yenko
 */
public class UsuarioBL {
    
    UsuarioDAL oUsuarioDAL = new UsuarioDAL();
    
    public List listarUsuario(){
        return oUsuarioDAL.listarUsuario();
    }
    
    public boolean validarUsuario(String Usuario){
        return oUsuarioDAL.validarUsuario(Usuario);
    }
        
    public int agregarUsuario(Usuario unUsuario, String archivo){
        String mensaje="";
        if (validarUsuario(unUsuario.getUsuario())) {
            mensaje="El usuario ya existe";
            return -1;            
        }else{
            return oUsuarioDAL.agregarUsuario(unUsuario, archivo);
        }
    }
    
    public int actualizarUsuario(Usuario unUsuario, String archivoFoto){
        return oUsuarioDAL.actualizarUsuario(unUsuario, archivoFoto);
    }
    
    public int eliminarUsuario(int id){
        return oUsuarioDAL.eliminarUsuario(id);
    }
    
    public Usuario buscarUsuario(int codigo){
        return oUsuarioDAL.buscarUsuario(codigo);        
    }
    
    
}
