/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.ArrayList;

/**
 *
 * @author paula.tudela
 */
public class Equipo {
    
    private int id;
    private String nombre;
    private ArrayList<Jugador> plantilla;
    private int puntos;
    private int totalPlantilla;
    
    private static int contadorID=1;

    public Equipo(String nombre) {
        this.id=Equipo.contadorID;
        Equipo.contadorID++;
        this.nombre = nombre;
        this.plantilla = new ArrayList();
        this.puntos = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getTotalPlantilla() {
        return totalPlantilla;
    }

    public void setTotalPlantilla(int totalPlantilla) {
        this.totalPlantilla = totalPlantilla;
    }
    
    
    public void fichar(Jugador j){
        if (j.isFichado()){
            System.out.println("");
            System.out.println("\033[31mERROR: jugador "+j.getNombre()+" ya fichado\033[30m");
            System.out.println("");
        }
        else{
            this.plantilla.add(j);
            this.totalPlantilla++;
            j.setFichado(true);
            
        }    
    }
    
    public void añadirVictoria(){
        this.puntos = this.puntos + 3;
    }
    
    public void añadirDerrota(){
        this.puntos = this.puntos + 0;
    }
    
    public void añadirEmpate(){
        this.puntos = this.puntos + 1;
    }
    
    
    @Override
    public String toString(){
        return String.format("%d - %15s [%d jugadores]",this.id,this.nombre,this.plantilla.size());
    }
    
    public void imprimirPlantilla(){
        System.out.println("\nPLANTILLA DEL "+this.nombre.toUpperCase());
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        for (Jugador jugador : plantilla) {
            System.out.printf("[%2d] %s\n",jugador.getDorsal(),jugador.getNombre());
            
        }
    }
    
    
    
}
