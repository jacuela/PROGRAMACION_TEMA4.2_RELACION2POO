/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

enum Estado{
    PENDIENTE, RESUELTA;
}

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Incidencia {
    private int codigo;
    private Puesto puesto;
    private String descripcion;
    private String resolucion;
    private LocalDate fecha_inicidencia;
    private LocalDate fecha_resolucion;
    private Estado estado;

    private static int contadorCodigo=1001;
    
    public Incidencia(Puesto puesto, String descripcion, LocalDate fecha_inicidencia) {
        this.codigo = Incidencia.contadorCodigo;
        Incidencia.contadorCodigo++;
        this.puesto=puesto;
        this.descripcion = descripcion;
        this.resolucion=null;
        this.fecha_inicidencia = fecha_inicidencia;
        this.fecha_resolucion= null;
        this.estado=Estado.PENDIENTE;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
    
    
    
    public void resolver(String resolucion, LocalDate fecha){
        this.resolucion=resolucion;
        this.fecha_resolucion=fecha;
        this.estado=Estado.RESUELTA;
    }

    public String aCadena(){
        String cadena;
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        
        if (this.estado==Estado.PENDIENTE){
            cadena=String.format("\033[31m [%10s] %d %25s [%s] \033[30m", this.estado, this.codigo, this.descripcion, this.fecha_inicidencia.format(dtf));
        }
        else{
            cadena=String.format("\033[32m [%10s] %d %25s [%s] \033[30m", this.estado, this.codigo, this.descripcion, this.fecha_inicidencia.format(dtf));
        }
        return cadena;
        
    }
    

    public void imprimirDetalles(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("");
        System.out.println("===========INCIDENCIA=============");
        if (this.estado==Estado.PENDIENTE) System.out.println("ESTADO: \033[31m"+this.estado+"\033[30m");
        else System.out.println("ESTADO: \033[32m"+this.estado+"\033[30m");
        System.out.println("CODIGO: "+this.codigo);
        System.out.println("PUESTO: "+this.puesto.getDescripcion());
        System.out.println("-------------------------");
        System.out.println("DESCRIPCION: "+this.descripcion);
        System.out.println("FECHA INCIDENCIA: "+this.fecha_inicidencia.format(dtf));
        System.out.println("-------------------------");
        
        
        if (this.estado==Estado.RESUELTA){
            System.out.println("RESOLUCION: "+this.resolucion);
            System.out.println("FECHA RESOLUCION: "+this.fecha_resolucion.format(dtf));
        }
        else{
            System.out.println("RESOLUCION: "+"--------");
            System.out.println("FECHA RESOLUCION: "+"-------");
        }
        System.out.println("==================================");

        System.out.println("");
        System.out.println("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
