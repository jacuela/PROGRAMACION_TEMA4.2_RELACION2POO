/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author paula.tudela y Cuello
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado=new Scanner(System.in);

        //BaseDatos bd=new BaseDatos();
        
        int opcion;
        String tecla,nombre;
        boolean ok;
        Equipo equipo;
        
        //Campeonato de 3 equipos 
        Campeonato ligaArcas = new Campeonato("Liga ARCAS",3);

        
        
        //   *******  DATOS PARA INICIALIZAR EL PROGAMA  ****************
        
        ligaArcas.altaJugador("Ramos", 5);
        ligaArcas.altaJugador("Cristiano", 7);
        ligaArcas.altaJugador("Ansu Fati", 17);
        ligaArcas.altaJugador("Mbappe", 10);
        ligaArcas.altaJugador("Haland", 9);
        
        ligaArcas.altaEquipo("Real de Madrid");
        ligaArcas.altaEquipo("Barcagate");
        
        
        //   ***********************************************************
        
        
        
        do {
            System.out.println("");
            System.out.println("=== "+ligaArcas.getNombre()+" ===");
            System.out.println("1. Alta jugador");
            System.out.println("2. Alta equipo");
            System.out.println("3. Fichajes");
            System.out.println("4. JUGAR CAMPEONATO");
            System.out.println("5. Listar Jugadores");
            System.out.println("6. Listar Equipos");
            System.out.println("7. Listar Partidos");
            System.out.println("8. Salir");
            System.out.println("========================");
            System.out.print("Dime tu opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch (opcion) {
                case 1:
                    System.out.println("\n ALTA DE JUGADOR");
                    System.out.println("=====================");
                    System.out.print("Nombre del jugador: ");
                    nombre=teclado.nextLine();
                    
                    do{
                        System.out.print("Dorsal: ");
                        int dorsal=Integer.parseInt(teclado.nextLine());
                    
                        ok=ligaArcas.altaJugador(nombre, dorsal);
                    }while(!ok);
                    
                    break;
                
                case 2:
                    System.out.println("\n ALTA DE EQUIPO");
                    System.out.println("=====================");
                    System.out.print(" >Nombre del equipo: ");
                    nombre=teclado.nextLine();
                    ligaArcas.altaEquipo(nombre);
                    break;
                
                case 3:
                    
                    
                    BaseDatos.listarEquipos();
                    System.out.println("\n FICHAJES");
                    do{
                       System.out.print(" >Escoge equipo: ");
                       int id=Integer.parseInt(teclado.nextLine());
                       
                       equipo=BaseDatos.obtenerEquipo(id);
                       if (equipo==null) System.out.println("  >ERROR: no existe dicho equipo");
                    }while(equipo==null);
                    
                    
                    //Llegado aqui, tengo ya el equipo
                    fichar(equipo);
                    break;
                case 4:
                    
                    break;
                case 5:
                    BaseDatos.listarJugadores();
                    break;
                case 6:
                    BaseDatos.listarEquipos();
                    break;
                case 7:
                    BaseDatos.listarPartidos();
                    break;    
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("ERROR. Opcion no valida");
                    break;
            }
        } while (opcion != 8);
    }

        
    
    
    public static void fichar (Equipo e){
        Scanner teclado=new Scanner(System.in);
        Jugador j;
        boolean fin=false;
        String tecla;
        
        if (e.getTotalPlantilla()==Campeonato.MAXPLANTILLA){
                 fin=true;
                 System.out.println("");
                 System.out.println(" -- PLANTILLA COMPLETA. INTRO PARA CONTINUAR --");
                 tecla=teclado.nextLine();
                 return;
        }
       
        BaseDatos.listarJugadores();
        
        do {
        
            System.out.println("EQUIPO: "+e.getNombre());
            System.out.print(" >Indica dorsal a fichar [INTRO par fin]: ");
            
            try{
             int dorsal=Integer.parseInt(teclado.nextLine());
             j=BaseDatos.obtenerJugador(dorsal);
             e.fichar(j);
             BaseDatos.listarJugadores();
             
             if (e.getTotalPlantilla()==Campeonato.MAXPLANTILLA){
                 fin=true;
                 System.out.println(" -- PLANTILLA COMPLETA. INTRO PARA CONTINUAR --");
                 tecla=teclado.nextLine();
             }
            
             
             
            }catch(Exception ex){
                fin=true;
            }
          
        }while (!fin);
        
        
    }
        
        
        
//        //PARTE 1
//        //Creo los jugadores y los añado a la BBDD
//        Jugador j1 = new Jugador("Ramos",5);
//        bd.addJugador(j1);
//        Jugador j2 = new Jugador("Mbappe",10);
//        bd.addJugador(j2);
//        Jugador j3 = new Jugador("RubenDiaz",3);
//        bd.addJugador(j3);
//        Jugador j4 = new Jugador("Bale",66); 
//        bd.addJugador(j4);
//        Jugador j5 = new Jugador("Cristiano",7); 
//        bd.addJugador(j5);
//        Jugador j6 = new Jugador("Haland",9);
//        bd.addJugador(j6);
//        Jugador j7 = new Jugador("Messi",10);
//        bd.addJugador(j7);
//        Jugador j8 = new Jugador("AnsuFati",17);
//        bd.addJugador(j8);
//        Jugador j9 = new Jugador("Pedri",16);
//        bd.addJugador(j9);
//        
//     
//        //Creo equipos y ficho
//        Equipo elPozo = new Equipo("El Pozo");
//        elPozo.fichar(j6);
//        elPozo.fichar(j2);
//        bd.addEquipo(elPozo);
//        
//        Equipo realMurcia = new Equipo("Real Murcia");
//        realMurcia.fichar(j1);
//        realMurcia.fichar(j5);
//        bd.addEquipo(realMurcia);
//        
//        Equipo lorcaFC = new Equipo("Lorca FC");
//        lorcaFC.fichar(j8);
//        lorcaFC.fichar(j1); //Esto debe dar error
//        lorcaFC.fichar(j9);
//        bd.addEquipo(lorcaFC);
//        
//      
//        //Listo plantillas y bd de jugadores
//        bd.listarPlantillasEquipos();
//        bd.listarJugadores();
//        
//        System.out.println("\n\n-- PULSE INTRO PARA CONTINUAR --");
//        String tecla=teclado.nextLine();
//        
//        
//        //PARTE2
//        //Jugamos los partidos
//        System.out.println("");
//        System.out.println("======= JUGAMOS LOS PARTIDOS ========");
//        Partido pozo_murcia = new Partido(elPozo, realMurcia);
//        Partido murcia_pozo = new Partido(realMurcia, elPozo);
//        Partido pozo_lorca = new Partido(elPozo, lorcaFC);
//        Partido lorca_pozo = new Partido(lorcaFC, elPozo);
//        Partido murcia_lorca = new Partido(realMurcia, lorcaFC);
//        Partido lorca_murcia = new Partido(lorcaFC, realMurcia);
//        

    
//        //Imprimos la clasificación
//        bd.mostrarClasificacion();
//  
        
    
    
}
