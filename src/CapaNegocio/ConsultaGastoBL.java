/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaDatos.ConsultaGastosDAL;
import java.util.List;

/**
 *
 * @author yenko
 */
public class ConsultaGastoBL {
    ConsultaGastosDAL oConsultaGastosDAL = new ConsultaGastosDAL();
    
    public List ConsultarGasto(String razonSocial, String nombreConcepto){
        return oConsultaGastosDAL.listarGastoFiltro(razonSocial,nombreConcepto);
    }
}
