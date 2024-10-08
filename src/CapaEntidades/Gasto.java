/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

import java.sql.Date;

/**
 *
 * @author yenko
 */
public class Gasto {
    
    private int idGasto;
    private String fechaGasto;
    private String tipoDoc;
    private String numDoc;
    private String proveedor;
    private String Concepto;    
    private String tipoMoneda;
    private double importe;
    private Date fecha;
    private String usuario;

    public Gasto() {
    }

    public Gasto(int idGasto, String fechaGasto, String tipoDoc, String numDoc, String proveedor, String Concepto, String tipoMoneda, double importe) {
        this.idGasto = idGasto;
        this.fechaGasto = fechaGasto;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.proveedor = proveedor;
        this.Concepto = Concepto;
        this.tipoMoneda = tipoMoneda;
        this.importe = importe;
    }

    public Gasto(String fechaGasto, String tipoDoc, String numDoc, String proveedor, String Concepto, String tipoMoneda, double importe) {
        this.fechaGasto = fechaGasto;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.proveedor = proveedor;
        this.Concepto = Concepto;
        this.tipoMoneda = tipoMoneda;
        this.importe = importe;
    }

    public Gasto(String fechaGasto, String tipoDoc, String numDoc, String proveedor, String Concepto, String tipoMoneda, double importe, Date fecha, String usuario) {
        this.fechaGasto = fechaGasto;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.proveedor = proveedor;
        this.Concepto = Concepto;
        this.tipoMoneda = tipoMoneda;
        this.importe = importe;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Gasto(int idGasto, String fechaGasto, String tipoDoc, String numDoc, String proveedor, String Concepto, String tipoMoneda, double importe, Date fecha, String usuario) {
        this.idGasto = idGasto;
        this.fechaGasto = fechaGasto;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.proveedor = proveedor;
        this.Concepto = Concepto;
        this.tipoMoneda = tipoMoneda;
        this.importe = importe;
        this.fecha = fecha;
        this.usuario = usuario;
    }
    
    

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }

    public String getFechaGasto() {
        return fechaGasto;
    }

    public void setFechaGasto(String fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    
    
}
