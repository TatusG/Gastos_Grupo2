/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.ValidarLogin;



/**
 *
 * @author yenko
 */
public class LoginBL {
    
    ValidarLogin oValidar = new ValidarLogin();
    
    
    public String validarUsuario(String usuario, String contraseña){
        return oValidar.validarUsuario(usuario, contraseña);
    }
    
}
