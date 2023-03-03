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
public class ControladorBarco extends ConexionBarco{
    public ControladorBarco(){}
    
    public boolean insertarBarco(int IdBarco, int NumMatricula, String Nombre, int NumAmarre, float Cuota){
    Barco barco = new Barco(IdBarco, NumMatricula, Nombre,NumAmarre, Cuota);
    return this.InsertarBarco(barco);
    }
    
    //Actualiza el anaquel Organizador
    public boolean actualizarBarco(int IdBarco, int NumMatricula, String Nombre, int NumAmarre, float Cuota){
    Barco barco = new Barco(IdBarco, NumMatricula, Nombre,NumAmarre, Cuota);
    return this.ActualizarBarco(barco);
    }
    
    //Recibe un id para poder eliminar un anaquel
    public boolean eliminarBarco(int IdBarco, int NumMatricula, String Nombre, int NumAmarre, float Cuota){
        if (IdBarco >= 0) {
            Barco barco = new Barco(IdBarco, NumMatricula, Nombre, NumAmarre, Cuota);
            return this.EliminarBarco(barco);
        }else{
            return false;
        }
    }
    //Para utilizar la tabla a insercion de la informacion
    public DefaultTableModel barcos(){
        String titulos[] = {"Id_Barco", "Numero Matricula", "Nombre", "Numero Amarre", "Cuota"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Barco barco = null;
        Barco[] a = this.ConsultarBarco(barco);
        if (a != null) {
            for (Barco alu : a) {
                Object[] cli = new Object[5];
                cli[0] = alu.getIdBarco();
                cli[1] = alu.getNumMatricula();
                cli[2] = alu.getNombre();
                cli[3] = alu.getNumAmarre();
                cli[4] = alu.getCuota();
                dtm.addRow(cli);
            }
        }
        return dtm;
    }
}
