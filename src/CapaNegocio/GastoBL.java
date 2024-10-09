/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.GastoDAL;
import CapaEntidades.Gasto;
import java.util.List;
import java.sql.*;

/**
 *
 * @author yenko
 */
public class GastoBL {
    
    GastoDAL oGastoDAL = new GastoDAL();
    
    public List listarGasto(){
        return oGastoDAL.listarGasto();
    }
    
    
    public int agregarGasto(Gasto oGasto){
            return oGastoDAL.agregarGasto(oGasto);
    }
    
    
    public int actualizarGasto(Gasto oGasto){
            return oGastoDAL.actualizarGasto(oGasto);
    }
    
    
    public int eliminarGasto(String NroDocumento){
        return oGastoDAL.eliminarGasto(NroDocumento);
    }
    
    
    public Gasto buscarGasto(String NroDocumento){
        return oGastoDAL.buscarGasto(NroDocumento);        
    }
    
    public List listarDocumento(){
        return oGastoDAL.listarTipoDocumento();
    }
    
    public List listarMoneda(){
        return oGastoDAL.listarMoneda();
    }
    
    public boolean validarRazonSocial(String RazonSocial) {
        return oGastoDAL.validarRazonSocial(RazonSocial);
    }
}
