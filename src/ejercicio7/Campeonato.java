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
        
        
        System.out.println("");
        System.out.println("JUGANDO EL CAMPEONATO........");
        
        try { Thread.sleep(1000); }
        catch(InterruptedException ex){ex.printStackTrace();}
        
        // Tengo una lista fija de 3 equipos. Cada equipo ocupa las posiciones
        // 0, 1 y 2 en el arraylist
        // Las combinaciones de partidos son (a ida y vuelta):
        // 0 vs 1     0 vs 2  
        // 1 vs 0     1 vs 2
        // 2 vs 0     2 vs 1
        if (this.equiposInscritos==3){
            
            BaseDatos.addPartido(new Partido(BaseDatos.obtenerEquipoPosi(0),BaseDatos.obtenerEquipoPosi(1)));
            BaseDatos.addPartido(new Partido(BaseDatos.obtenerEquipoPosi(0),BaseDatos.obtenerEquipoPosi(2)));
            BaseDatos.addPartido(new Partido(BaseDatos.obtenerEquipoPosi(1),BaseDatos.obtenerEquipoPosi(0)));
            BaseDatos.addPartido(new Partido(BaseDatos.obtenerEquipoPosi(1),BaseDatos.obtenerEquipoPosi(2)));
            BaseDatos.addPartido(new Partido(BaseDatos.obtenerEquipoPosi(2),BaseDatos.obtenerEquipoPosi(0)));
            BaseDatos.addPartido(new Partido(BaseDatos.obtenerEquipoPosi(2),BaseDatos.obtenerEquipoPosi(1)));

        }
        else{
            //Para más de 3 equipos, lo hago autimático. OJO, aqui tambien vale para 1 o 2 equipos. Tendría que
            //no permitir jugar campeonatos con menos de 3 equipos. Al igual que en este programa, no se conrola
            //que los equipos tengan o no jugadores fichados.
            
            
            //Hacerlo de forma automática con la cantidad de equipos que sean >3
            for (int i = 0; i < this.equiposInscritos; i++) {
                for (int j = 0; j < this.equiposInscritos; j++) {
                    if (i!=j){ //No juego contra mi mismo
                        BaseDatos.addPartido(new Partido(BaseDatos.obtenerEquipoPosi(i),BaseDatos.obtenerEquipoPosi(j)));
                    }
                }
            }
        }
        
        
    }
    
    
    public void mostrarClasificacion(){
        System.out.println("\nPUNTOS DE CADA EQUIPO");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        for (int i = 0; i < this.equiposInscritos; i++) {
            Equipo e=BaseDatos.obtenerEquipoPosi(i);
            System.out.printf("%15s %d puntos\n",e.getNombre(),e.getPuntos());
        }

    }

    
    
    
}
