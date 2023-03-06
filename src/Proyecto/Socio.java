/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 * @author lo397
 */
public class Socio {
    private int IdSocio;
    private String Nombre;
    private String Apellido;
    private String NomBarco;
    
    public Socio(){}

    public Socio(int IdSocio, String Nombre, String Apellido, String NomBarco) {
        this.IdSocio = IdSocio;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.NomBarco = NomBarco;
    }

    public int getIdSocio() {
        return IdSocio;
    }

    public void setIdSocio(int IdSocio) {
        this.IdSocio = IdSocio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNomBarco() {
        return NomBarco;
    }

    public void setNomBarco(String NomBarco) {
        this.NomBarco = NomBarco;
    }

    @Override
    public String toString() {
        return "Socio{" + "IdSocio=" + IdSocio 
                + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", NomBarco=" + NomBarco + '}';
    }

    
    
}
