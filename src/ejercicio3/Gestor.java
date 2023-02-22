/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Gestor {
    
    private ArrayList<Incidencia> listadoIncidencias;
    private ArrayList<Puesto> listadoPuestos;

    public Gestor(){
        this.listadoIncidencias=new ArrayList<>();
        this.listadoPuestos=new ArrayList<>();
    }
   
    public void addPuesto(int cod, String desc){
        listadoPuestos.add(new Puesto(cod,desc));
    }
   
    public void addIncidencia(Puesto puesto, String descripcion, LocalDate fecha){
        listadoIncidencias.add(new Incidencia(puesto, descripcion, fecha));
    }
   
    //Devuelvo el puesto dado si código o NULL su no existe
    public Puesto buscarPuesto(int codigo){
        
        
        for (Puesto puesto : listadoPuestos) {
            if (puesto.getCodigo()==codigo)
                return puesto;
        }
        
        return null;
    }
    
    //Devuelvo la incidencia dado su código o NULL su no existe
    public Incidencia buscarIncidencia(int codigo){
        for (Incidencia incidencia : listadoIncidencias) {
            if (incidencia.getCodigo()==codigo)
                return incidencia;
        }
        
        return null;
    }
    
    public void listarIncidencias(){
        
        for (Incidencia incidencia : listadoIncidencias) {
            System.out.println(incidencia.aCadena());
        }
    }
    
    public void listarPuestos(){
        for (Puesto puesto : listadoPuestos) {
            System.out.println(puesto.aCadena());
        }
    }
    
    public void resolverIncidencia(Incidencia inci, String resolucion, LocalDate fecha){
       inci.resolver(resolucion, fecha);
    }
    
    
    
    
}
