/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaEntidades;

/**
 *
 * @author PC
 */
public class TipoDocumento {
    private int idDocumento;
    private String TipoDocumento;

    public TipoDocumento() {
    }

    public TipoDocumento(int idDocumento, String TipoDocumento) {
        this.idDocumento = idDocumento;
        this.TipoDocumento = TipoDocumento;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

   
}
