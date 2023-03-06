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

public class Conexion {
     private ObjectContainer oc;
    File file = new File("database3.yap");
    int IdSocio;
    
    private void open(){
        this.oc = Db4o.openFile("database3.yap");
    }
   
    public int Id(Socio objeto){
        try {
           Socio[] socio = null;
           this.open();
           ObjectSet resultados = this.oc.queryByExample(objeto);
           int i = 0;
           
            if (resultados.hasNext()) {
                socio = new Socio[resultados.size()];
                while (resultados.hasNext()){
                    socio[i] = (Socio) resultados.next();
                    i++;
                }
                IdSocio = (socio[socio.length-1].getIdSocio())+1;
                System.out.println("Id: "+ IdSocio);
            }
            this.oc.close();
            return IdSocio;
           
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarSocio() :" + e);
            return 0;
        }
    }
    
    
    public boolean InsertarSocio(Socio objeto){
        try {
            this.open();
            oc.store(objeto);
            this.oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarSocio() : "+ e);
            return false;
        }
    }
    
    public boolean ActualizarSocio(Socio objeto){
        try {
            this.open();
            ObjectSet resultados = this.oc.queryByExample(new Socio(objeto.getIdSocio(), null, null, null));
            if (resultados.size() > 0) {
                Socio resultado = (Socio) resultados.next();
                resultado.setIdSocio(objeto.getIdSocio());
                resultado.setNombre(objeto.getNombre());
                resultado.setApellido(objeto.getApellido());
                resultado.setNomBarco(objeto.getNomBarco());
                this.oc.store(resultado);
                this.oc.close();
                return true;
            }else{
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.actualizarSocio() : "+ e);
            return false;
        }
    }
    
    
    public void BuscarSocio(Socio objeto){
        this.open();
        Socio encontrado = null;
        ObjectSet resultados = this.oc.queryByExample(objeto);
        if (resultados.hasNext()) {
            encontrado = (Socio) resultados.next();
            System.out.println(resultados.size());
        }
    }
    
    public Socio[] ConsultarSocio(Socio objeto){
        try {
           Socio[] socio = null;
           this.open();
           ObjectSet resultados = this.oc.queryByExample(objeto);
           int i = 0;
           
            if (resultados.hasNext()) {
                socio = new Socio[resultados.size()];
                
                while (resultados.hasNext()){
                    socio[i] = (Socio) resultados.next();
                    i++;
                }
            }
            this.oc.close();
            return socio;
           
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarSocio() :" + e);
            return null;
            
        }
      }
    
    public boolean EliminarSocio(Socio objeto){
        try {
            this.open();
            ObjectSet resultados = this.oc.queryByExample(objeto);
            if (resultados.size() > 0) {
                Socio socio = (Socio) resultados.next();
                this.oc.delete(socio);
                this.oc.close();
                return true;
            }else{
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.EiminarSocio() :"+e);
            return false;
        }
    }
}


