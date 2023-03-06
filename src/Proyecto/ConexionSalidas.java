/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import java.io.File;

public class ConexionSalidas {
    private ObjectContainer oc;
    File file = new File("database5.yap");
    int Idsalida;
    
     private void open(){
        this.oc = Db4o.openFile("database5.yap");
    }
     
        //--------------------SALIDAS---------------------------
    public int IdSalida(Salidas objeto){
        try {
           Salidas[] salidas = null;
           this.open();
           ObjectSet resultados = this.oc.queryByExample(objeto);
           int i = 0;
            if (resultados.hasNext()) {
                salidas = new Salidas[resultados.size()];
                while (resultados.hasNext()){
                    salidas[i] = (Salidas) resultados.next();
                    i++;
                }
                Idsalida = (salidas[salidas.length-1].getId_Salida())+1;
            }
            this.oc.close();
            return Idsalida;
           
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            return 0;
        }
    }
    
    
    public boolean InsertarSalida(Salidas objeto){
        try {
            this.open();
            oc.store(objeto);
            this.oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarSalida() : "+ e);
            return false;
        }
    }
    
    public boolean ActualizarSalida(Salidas objeto){
        try {
            this.open();
            ObjectSet resultados = this.oc.queryByExample(new Salidas(objeto.getId_Salida(), null, null, null, null, null));
            if (resultados.size() > 0) {
                Salidas resultado = (Salidas) resultados.next();
                resultado.setId_Salida(objeto.getId_Salida());
                resultado.setFecha(objeto.getFecha());
                resultado.setHoraSalida(objeto.getHoraSalida());
                resultado.setDestino(objeto.getDestino());
                resultado.setNomSocio(objeto.getNomSocio());
                resultado.setNomBarco(objeto.getNomBarco());
                this.oc.store(resultado);
                this.oc.close();
                return true;
            }else{
                this.oc.close();
                return false;
            }
            
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.actualizarSalida() : "+ e);
            return false;
        }
        
    }
    
    
    public void BuscarSalida(Salidas objeto){
        this.open();
        Salidas encontrado = null;
        ObjectSet resultados = this.oc.queryByExample(objeto);
        if (resultados.hasNext()) {
            encontrado = (Salidas) resultados.next();
            System.out.println(resultados.size());
        }
    }
    
    
    public Salidas[] ConsultarSalida(Salidas objeto){
        try {
           Salidas[] salidas = null;
           this.open();
           ObjectSet resultados = this.oc.queryByExample(objeto);
           int i = 0;
            if (resultados.hasNext()) {
                salidas = new Salidas[resultados.size()];
                while (resultados.hasNext()){
                    salidas[i] = (Salidas) resultados.next();
                    i++;
                }
            }
            this.oc.close();
            return salidas;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.consultarSalida() :" + e);
            return null;
        }
      }
    
    public boolean EliminarSalida(Salidas objeto){
        try {
            this.open();
            ObjectSet resultados = this.oc.queryByExample(objeto);
            if (resultados.size() > 0) {
                Salidas salidas = (Salidas) resultados.next();
                this.oc.delete(salidas);
                this.oc.close();
                return true;
            }else{
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.EiminarSalida() :"+e);
            return false;
        }
    }
    
}
