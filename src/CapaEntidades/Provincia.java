/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author PC
 */
public class Provincia {
    private int IdProvincia;
    private String Provincia;    

    public Provincia(int IdProvincia, String Provincia) {
        this.IdProvincia = IdProvincia;
        this.Provincia = Provincia;
      
    }

    public Provincia() {
    }

    public int getIdProvincia() {
        return IdProvincia;
    }

    public void setIdProvincia(int IdProvincia) {
        this.IdProvincia = IdProvincia;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

   
}
