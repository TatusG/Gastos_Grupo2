/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author yenko
 */
public class ConsultaGasto {
    
    private String fechaGasto;
    private String tipoDoc;
    private String numDoc;
    private String Concepto;
    private String proveedor;
    private String tipoMoneda;
    private double importe;

    public ConsultaGasto(String fechaGasto, String tipoDoc, String numDoc, String Concepto, String proveedor, String tipoMoneda, double importe) {
        this.fechaGasto = fechaGasto;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.Concepto = Concepto;
        this.proveedor = proveedor;
        this.tipoMoneda = tipoMoneda;
        this.importe = importe;
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

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
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
    
    
    
    
}
