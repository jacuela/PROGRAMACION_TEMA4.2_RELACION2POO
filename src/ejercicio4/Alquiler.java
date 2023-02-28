/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Alquiler {
    
    private int id;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fecha_alquiler;
    private LocalDate fecha_devolucion;
    private double importe;
    private boolean finalizado;
    
    private static double IVA=21;
    private static int contadorID=1;
    private int diasAlquiler;
    
    public Alquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fecha_alquiler) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.vehiculo.setAlquilado(true); //indico que el vehiculo esta alquilado
        this.fecha_alquiler = fecha_alquiler;
        this.fecha_devolucion = null;
        this.finalizado=false;
        this.importe = -1;
        this.diasAlquiler = -1;
        this.id = Alquiler.contadorID;
        Alquiler.contadorID++;
        
        
    }
    
    
    //---------getter and setter ----------------------------------------

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    //Getter que me devuelve la matricula del vehiculo. Usado cuando 
    //busco un alquiler por matricula
    public String getMatricula(){
        return this.vehiculo.getMatricula();
    }
    

   //----------------------------------------------------
    
    
    private double calcularImporte(){
        int dias=(int)ChronoUnit.DAYS.between(fecha_alquiler, fecha_devolucion);
        
        //Si lo devuelvo el mismo dia, se cobra 1 día
        if (dias==0){
            dias=1;
        }
        this.diasAlquiler=dias;  //relleno el atributo de los dias alquilado
        
        double subtotal=dias*this.vehiculo.getPrecio_dia();
        double iva=subtotal*(Alquiler.IVA/100);
        double importeConIVA=subtotal+iva; 
        
        return importeConIVA;
    }
    
    
    
    
    public void devolverVehiculo(LocalDate f){
        this.fecha_devolucion=f;
        this.importe=this.calcularImporte();
        this.vehiculo.setAlquilado(false); //el vehiculo deja de estar alquilado
        this.finalizado=true;
        
        //Muestro info del alquiler
        this.imprimirDetalles();
        
        
    }
    
    public void imprimirDetalles(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("");
        System.out.printf("---------------------------\n");
        System.out.printf("DETALLES DEL ALQUILER\n");
System.out.printf("ID:             %d\n",this.id);
        System.out.printf("Matricula:      %s\n",this.vehiculo.getMatricula());
        System.out.printf("Cliente:        %s\n",this.cliente.getNombre());
        System.out.printf("Fecha alquiler: %s\n",this.fecha_alquiler.format(dtf));
        if (this.finalizado==true){  //Podria haber comprobado si la fecha de devolucion era null o importe -1
            System.out.printf("Fecha devoluc:  %s\n",this.fecha_devolucion.format(dtf));
            System.out.printf("Dias alquilado: %d\n",this.diasAlquiler);
            System.out.println("");
            System.out.printf("Importe: %.2f €\n",this.importe);
        }
        else{
            System.out.printf("AÚN EN ALQUILER\n");
        }
        
        System.out.printf("---------------------------\n"); 
         
         
    }
    
    public String aCadena(){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (this.finalizado){
            return String.format("%d %s %s %.2f €",this.id, this.vehiculo.getMatricula(), this.fecha_alquiler.format(dtf),this.importe);
        }
        else{
            return String.format("%d %s %s AUN EN ALQUILER",this.id, this.vehiculo.getMatricula(), this.fecha_alquiler.format(dtf));
        }
    }
    
   
    
    
    
}
