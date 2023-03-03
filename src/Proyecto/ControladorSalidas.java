/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lo397
 */
public class ControladorSalidas extends ConexionSalidas{
    public ControladorSalidas(){}
    
    
    public boolean insertarSalida(int Id_Salida, String Fecha, String HoraSalida, String Destino, String NomSocio, String NomBarco){
    Salidas salidas = new Salidas(Id_Salida, Fecha, HoraSalida, Destino, NomSocio, NomBarco);
    return this.InsertarSalida(salidas);
    }
    
    //Actualiza el anaquel Organizador
    public boolean actualizarSalida(int Id_Salida, String Fecha, String HoraSalida, String Destino, String NomSocio, String NomBarco){
    Salidas salidas = new Salidas(Id_Salida, Fecha, HoraSalida, Destino, NomSocio, NomBarco);
    return this.ActualizarSalida(salidas);
    }
    
    //Recibe un id para poder eliminar un anaquel
    public boolean eliminarSalida(int Id_Salida, String Fecha, String HoraSalida, String Destino, String NomSocio, String NomBarco){
        if (Id_Salida >= 0) {
            Salidas salidas = new Salidas(Id_Salida, Fecha, HoraSalida, Destino, NomSocio, NomBarco);
            return this.EliminarSalida(salidas);
        }else{
            return false;
        }
    }
    
    //Para utilizar la tabla a insercion de la informacion
    public DefaultTableModel salidas(){
        String titulos[] = {"Id_Salida", "Fecha", "Hora Salida", "Destino", "Nombre_Socio", "Nombre Barco"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Salidas salidas = null;
        Salidas[] a = this.ConsultarSalida(salidas);
        if (a != null) {
            for (Salidas alu : a) {
                Object[] cli = new Object[6];
                cli[0] = alu.getId_Salida();
                cli[1] = alu.getFecha();
                cli[2] = alu.getHoraSalida();
                cli[3] = alu.getDestino();
                cli[4] = alu.getNomSocio();
                cli[5] = alu.getNomBarco();
                dtm.addRow(cli);
            }
        }
        return dtm;
    }
    
    
}
