/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author paula.tudela
 */
public class Partido {
    
    private int id;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    
    private static int contadorID=1;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        
        this.id=Partido.contadorID;
        Partido.contadorID++;
        
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = 0;
        this.golesVisitante = 0;
        jugarPartido();
        mostrarResultados();
    }
    
    private void jugarPartido(){
        this.golesLocal = (int) (Math.random()*10);
        this.golesVisitante = (int) (Math.random()*10);
        
        if (golesLocal>golesVisitante) {
            this.equipoLocal.añadirVictoria();
            this.equipoVisitante.añadirDerrota();
            
        }else if(golesLocal<golesVisitante){
            this.equipoVisitante.añadirVictoria();
            this.equipoLocal.añadirDerrota();
            
        }else if(golesLocal==golesVisitante){
            this.equipoVisitante.añadirEmpate();
            this.equipoLocal.añadirEmpate();
        }
        
    }
    
    private void mostrarResultados(){
        //System.out.printf("%12s ------ %-12s\n", "LOCAL", "VISITANTE");
        
        if (golesLocal>golesVisitante) {
            System.out.printf("\033[32m%12s %1d \033[30m", 
                        this.equipoLocal.getNombre(),
                        this.golesLocal);
            
            System.out.printf("VS %1d %-12s\n", 
                        this.golesVisitante,
                        this.equipoVisitante.getNombre());
            
        }else if(golesLocal<golesVisitante){
            System.out.printf("%12s %1d ", 
                        this.equipoLocal.getNombre(),
                        this.golesLocal);
            
            System.out.printf("VS \033[32m%1d %-12s\033[30m\n", 
                        this.golesVisitante,
                        this.equipoVisitante.getNombre());
        }else if(golesLocal==golesVisitante){
            System.out.printf("\033[35m%12s %1d VS %1d %-12s\033[30m\n", 
                        this.equipoLocal.getNombre(),
                        this.golesLocal,
                        this.golesVisitante,
                        this.equipoVisitante.getNombre());
            
        }
        
    }
    
    @Override
    public String toString(){
        return String.format("%3d - [%s vs %s]",this.id,this.equipoLocal.getNombre(),this.equipoVisitante.getNombre());
        
    }
    
    
    
    
}
