/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class BaseDatos {
    private static ArrayList<Jugador> listaJugadores=new ArrayList();
    private static ArrayList<Equipo> listaEquipos=new ArrayList();
    private static ArrayList<Partido> listaPartidos=new ArrayList();
    
    

//    public BaseDatos() {
//        listaJugadores=new ArrayList();
//        listaEquipos=new ArrayList();
//        
//    }
    
    public static void addJugador(Jugador j){
        listaJugadores.add(j);
    }
    
    public static void addEquipo(Equipo e){
        listaEquipos.add(e);
    }
    
    public static void addPartido(Partido p){
        listaPartidos.add(p);
    }
    
    
    public static  void listarJugadores(){
        System.out.println("");
        System.out.println("======BBDD jugadores======");
        for (Jugador j : listaJugadores) {
            System.out.println(j);
        }
        System.out.println("==========================");
        System.out.println("");
        System.out.println("");
    }
    
     
    public static  void listarEquipos(){
        System.out.println("");
        System.out.println("======  LISTADO DE EQUIPOS  ======");
        for (Equipo e : listaEquipos) {
            //e.imprimirPlantilla();
            System.out.println(e);
        }
        System.out.println("==================================");
        System.out.println("");
        System.out.println("");
    }
     
    
    public static  void listarPartidos(){
        
        
    }
     
    
    public static Equipo obtenerEquipo(int id){
        for (Equipo e : listaEquipos) {
            if (e.getId()==id){
                return e;
            }
        }
        //System.out.println("");
        return null;
    }
    
    
    public static Equipo obtenerEquipoPosi(int posicion){
        
        if (posicion<BaseDatos.listaEquipos.size()){
            return BaseDatos.listaEquipos.get(posicion);
        }else{
            System.out.println("  >ERROR: no existe equipo en esa posicion");
            return null;
        }
        
    }
    
    
    
    public static Jugador obtenerJugador(int dorsal){
        for (Jugador j : listaJugadores) {
            if (j.getDorsal()==dorsal){
                return j;
            }
        }
        //System.out.println("");
        return null;
    }
    
    
    
    
   
    public static boolean dorsalLibre(int dorsal){
        for (Jugador j : listaJugadores) {
            if (j.getDorsal()==dorsal){
                return false;
            }
            
        }
        
        return true;
    }
    
     
     
     
     
     
}
