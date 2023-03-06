/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javax.swing.table.DefaultTableModel;

public class ControladorSocio extends Conexion{
    public ControladorSocio(){}
    
    //Se utiliza para insertar un anaquel organizador
    public boolean insertarSocio(int id, String Nombre, String Apellido, String NomBarco){
    Socio socio = new Socio(id, Nombre, Apellido, NomBarco);
    return this.InsertarSocio(socio);
    }
    
    //Actualiza el anaquel Organizador
    public boolean actualizarSocio(int id, String Nombre, String Apellido, String NomBarco){
    Socio socio = new Socio(id, Nombre, Apellido, NomBarco);
    return this.ActualizarSocio(socio);
    }
    
    //Recibe un id para poder eliminar un anaquel
    public boolean eliminarSocio(int id, String Nombre, String Apellido, String NomBarco){
        if (id >= 0) {
            Socio socio = new Socio(id, Nombre, Apellido, NomBarco);
            return this.EliminarSocio(socio);
        }else{
            return false;
        }
    }
    //Para utilizar la tabla a insercion de la informacion
    public DefaultTableModel socios(){
        String titulos[] = {"Id_Socio", "Nombre", "Apellido", "Nombre Barco"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        Socio socio = null;
        Socio[] a = this.ConsultarSocio(socio);
        if (a != null) {
            for (Socio alu : a) {
                Object[] cli = new Object[4];
                cli[0] = alu.getIdSocio();
                cli[1] = alu.getNombre();
                cli[2] = alu.getApellido();
                cli[3] = alu.getNomBarco();
                dtm.addRow(cli);
                
            }
        }
        return dtm;
    }
   
    
    
}
