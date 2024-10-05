/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author yenko
 */
public class Usuario {
    
    private int idUsuario;
    private String perfil;
    private String estado;
    private String usuario;
    private String password;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private Image foto;
    private Date fecha;
    private String usuariomod;    

    
    public Usuario() {
    }

    public Usuario(int idUsuario, String perfil, String estado, String usuario, String password, String apellidoPaterno, String apellidoMaterno, String nombres, Date fecha, String usuariomod) {
        this.idUsuario = idUsuario;
        this.perfil = perfil;
        this.estado = estado;
        this.usuario = usuario;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;        
        this.fecha = fecha;
        this.usuariomod = usuariomod;
    }

    public Usuario(String perfil, String estado, String usuario, String password, String apellidoPaterno, String apellidoMaterno, String nombres, Image foto, Date fecha, String usuariomod) {
        this.perfil = perfil;
        this.estado = estado;
        this.usuario = usuario;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.foto = foto;
        this.fecha = fecha;
        this.usuariomod = usuariomod;
    }

    public Usuario(int idUsuario, String perfil, String estado, String usuario, String password, String apellidoPaterno, String apellidoMaterno, String nombres, Image foto) {
        this.idUsuario = idUsuario;
        this.perfil = perfil;
        this.estado = estado;
        this.usuario = usuario;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.foto = foto;
    }

    public Usuario(String perfil, String estado, String usuario, String password, String apellidoPaterno, String apellidoMaterno, String nombres, Date fecha, String usuariomod) {
        this.perfil = perfil;
        this.estado = estado;
        this.usuario = usuario;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.fecha = fecha;
        this.usuariomod = usuariomod;
    }

        public Usuario(String perfil, String estado, String usuario, String password, String apellidoPaterno, String apellidoMaterno, String nombres, Image foto) {
        this.perfil = perfil;
        this.estado = estado;
        this.usuario = usuario;
        this.password = password;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.foto = foto;
    }

    public Usuario(String perfil, String usuario, String password) {
        this.perfil = perfil;
        this.usuario = usuario;
        this.password = password;
    }
    
    
    
    

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuariomod() {
        return usuariomod;
    }

    public void setUsuariomod(String usuariomod) {
        this.usuariomod = usuariomod;
    }
    

     
    
  }
