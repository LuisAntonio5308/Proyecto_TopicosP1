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
public class Barco {
    /*número de matrícula, nombre, número del amarre y cuota que paga por el mismo. */
    private int IdBarco;
    private int NumMatricula;
    private String Nombre;
    private int NumAmarre;
    private float Cuota;

    public Barco() {
    }

    public Barco(int IdBarco, int NumMatricula, String Nombre, int NumAmarre, float Cuota) {
        this.IdBarco = IdBarco;
        this.NumMatricula = NumMatricula;
        this.Nombre = Nombre;
        this.NumAmarre = NumAmarre;
        this.Cuota = Cuota;
    }

    public int getIdBarco() {
        return IdBarco;
    }

    public void setIdBarco(int IdBarco) {
        this.IdBarco = IdBarco;
    }

    public int getNumMatricula() {
        return NumMatricula;
    }

    public void setNumMatricula(int NumMatricula) {
        this.NumMatricula = NumMatricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumAmarre() {
        return NumAmarre;
    }

    public void setNumAmarre(int NumAmarre) {
        this.NumAmarre = NumAmarre;
    }

    public float getCuota() {
        return Cuota;
    }

    public void setCuota(float Cuota) {
        this.Cuota = Cuota;
    }

    @Override
    public String toString() {
        return "Barco{" + "IdBarco=" + IdBarco + 
                ", NumMatricula=" + NumMatricula + ", Nombre=" + Nombre + ", NumAmarre=" 
                + NumAmarre + ", Cuota=" + Cuota + '}';
    }
   
}
