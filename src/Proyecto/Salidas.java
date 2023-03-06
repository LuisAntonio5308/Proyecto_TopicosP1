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
public class Salidas{
    private int Id_Salida;
    private String Fecha;
    private String HoraSalida;
    private String Destino;
    private String NomSocio;
    private String NomBarco;
    
    public Salidas(){}

    public Salidas(int Id_Salida, String Fecha, String HoraSalida, String Destino, String NomSocio, String NomBarco) {
        this.Id_Salida = Id_Salida;
        this.Fecha = Fecha;
        this.HoraSalida = HoraSalida;
        this.Destino = Destino;
        this.NomSocio = NomSocio;
        this.NomBarco = NomBarco;
    }

    public int getId_Salida() {
        return Id_Salida;
    }

    public void setId_Salida(int Id_Salida) {
        this.Id_Salida = Id_Salida;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public String getNomSocio() {
        return NomSocio;
    }

    public void setNomSocio(String NomSocio) {
        this.NomSocio = NomSocio;
    }

    public String getNomBarco() {
        return NomBarco;
    }

    public void setNomBarco(String NomBarco) {
        this.NomBarco = NomBarco;
    }

    @Override
    public String toString() {
        return "Salidas{" + "Id_Salida=" + Id_Salida + ", Fecha=" + Fecha + 
                ", HoraSalida=" + HoraSalida + ", Destino=" + Destino + ", NomSocio=" + 
                NomSocio + ", NomBarco=" + NomBarco + '}';
    }
}
