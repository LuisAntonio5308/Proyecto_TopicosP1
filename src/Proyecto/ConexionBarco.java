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

/**
 *
 * @author lo397
 */
public class ConexionBarco {
     private ObjectContainer oc;
    File file = new File("database4.yap");
    int IdBarco;
    
     private void open(){
        this.oc = Db4o.openFile("database4.yap");
    }
     
        //--------------------BARCO---------------------------
    public int IdBarco(Barco objeto){
        try {
           Barco[] barco = null;
           this.open();
           ObjectSet resultados = this.oc.queryByExample(objeto);
           int i = 0;
           
            if (resultados.hasNext()) {
                barco = new Barco[resultados.size()];
                
                while (resultados.hasNext()){
                    barco[i] = (Barco) resultados.next();
                    i++;
                }
                
                IdBarco = (barco[barco.length-1].getIdBarco())+1;
            }
            this.oc.close();
            return IdBarco;
           
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            
            return 0;
        }
    }
    
    public boolean InsertarBarco(Barco objeto){
        try {
            this.open();
            oc.store(objeto);
            this.oc.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.insertarBarco() : "+ e);
            return false;
        }
    }
    
    public boolean ActualizarBarco(Barco objeto){
        try {
            this.open();
            ObjectSet resultados = this.oc.queryByExample(new Barco(objeto.getIdBarco(),0, null, 0, 0));
            if (resultados.size() > 0) {
                Barco resultado = (Barco) resultados.next();
                resultado.setIdBarco(objeto.getIdBarco());
                resultado.setNumMatricula(objeto.getNumMatricula());
                resultado.setNombre(objeto.getNombre());
                resultado.setNumAmarre(objeto.getNumAmarre());
                resultado.setCuota(objeto.getCuota());
                this.oc.store(resultado);
                this.oc.close();
                return true;
            }else{
                this.oc.close();
                return false;
            }
            
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.actualizarBarco() : "+ e);
            return false;
        }
        
    }
    
    public void BuscarBarco(Barco objeto){
        this.open();
        Barco encontrado = null;
        ObjectSet resultados = this.oc.queryByExample(objeto);
        if (resultados.hasNext()) {
            encontrado = (Barco) resultados.next();
            System.out.println(resultados.size());
        }
    }
    
    public Barco[] ConsultarBarco(Barco objeto){
        try {
           Barco[] barco = null;
           this.open();
           ObjectSet resultados = this.oc.queryByExample(objeto);
           
           int i = 0;
           
            if (resultados.hasNext()) {
                barco = new Barco[resultados.size()];
                while (resultados.hasNext()){
                    System.out.println(i);
                    barco[i] = (Barco) resultados.next();
                    System.out.println(i);
                    i++;
                }
            }
            this.oc.close();
            return barco;
           
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.consultarBarco() :" + e);
            return null;
            
        }
      }
    
    public boolean EliminarBarco(Barco objeto){
        try {
            this.open();
            ObjectSet resultados = this.oc.queryByExample(objeto);
            if (resultados.size() > 0) {
                Barco barco = (Barco) resultados.next();
                this.oc.delete(barco);
                this.oc.close();
                return true;
            }else{
                this.oc.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("bdoo.Controlador.EiminarBarco() :"+e);
            return false;
        }
    }
    
    
}
