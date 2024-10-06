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
            return oGastoDAL.agregarGasto(oGasto);
    }
    
    
    public int eliminarGasto(int id){
        return oGastoDAL.eliminarGasto(id);
    }
    
    
    public Gasto buscarGasto(int codigo){
        return oGastoDAL.buscarGasto(codigo);        
    }
}
