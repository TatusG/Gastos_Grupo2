/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

import java.sql.Date;



public class Proveedor {
    private int idproveedor;
    private String ruc;
    private String razonsocial;
    private String direccion;
    private String departamento;
    private String provincia;
    private String distrito; 
    private String  telefono; 
    private String celular;
    private String email;
    private String estado;
    private Date fecha;    
    private String usuario;

    public Proveedor() {
    }

    public Proveedor(int idproveedor, String ruc, String razonsocial, String direccion, String departamento, String provincia, String distrito, String telefono, String celular, String email, String estado, Date fecha, String usuario) {
        this.idproveedor = idproveedor;
        this.ruc = ruc;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Proveedor(String ruc, String razonsocial, String direccion, String departamento, String provincia, String distrito, String telefono, String celular, String email, String estado, Date fecha, String usuario) {
        this.ruc = ruc;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public Proveedor(String ruc, String razonsocial, String direccion, String departamento, String provincia, String distrito, String telefono, String celular, String email, String estado) {
        this.ruc = ruc;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
    }

    public Proveedor(int idproveedor, String ruc, String razonsocial, String direccion, String departamento, String provincia, String distrito, String telefono, String celular, String email, String estado) {
        this.idproveedor = idproveedor;
        this.ruc = ruc;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.telefono = telefono;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
    }
    
    

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
