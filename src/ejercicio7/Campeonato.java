/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Campeonato {
    private String nombre;
    private int equiposInscritos;
    public static final int MAXPLANTILLA=2;
    private final int MAXEQUIPOS;

    
    public Campeonato(String nombre, int maxEquipos) {
        this.nombre = nombre;
        this.MAXEQUIPOS = maxEquipos;
        //this.MAXPLANTILLA = maxPlantilla;
        this.equiposInscritos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEquiposInscritos() {
        return equiposInscritos;
    }

    public static int getMAXPLANTILLA() {
        return MAXPLANTILLA;
    }

    public int getMAXEQUIPOS() {
        return MAXEQUIPOS;
    }

    
    
    
    
    public boolean altaJugador(String nombre, int dorsal){
        //Compruebo si el dorsal esta ocupado
        if (BaseDatos.dorsalLibre(dorsal)){
            Jugador j=new Jugador(nombre, dorsal);
            BaseDatos.addJugador(j);
            return true;
        }
        else{
            System.out.println("  >ERROR: el dorsal esta ocupado");
            return false;
        }
        
        
    }
    
    public boolean altaEquipo(String nombre){
        
        //Compruebo si no he llegado al maximo de equipos del campeonato 
        if (this.equiposInscritos < this.MAXEQUIPOS){
            Equipo equipo=new Equipo(nombre);
            BaseDatos.addEquipo(equipo);
            this.equiposInscritos++;
            return true;
            
        }else{
            System.out.println("  >ERROR: campeonato completo. Maximo"+this.MAXEQUIPOS+"equipos");
            return false;
        }
       
       //¿Tiene sentido aqúi que devuelve BOOLEAN?. ¿Puedo hacer el bucle en la llamada??
        
    }
    
    
    public void jugarCampeonato(){
        
        
    }
    
    public  void mostrarClasificacion(){
        System.out.println("\nPUNTOS DE CADA EQUIPO");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
//        for (Equipo e : listaEquipos) {
//            System.out.printf("%15s %d puntos\n",e.getNombre(),e.getPuntos());
//        }
    }

   
    
    
    
    
    
    
}
