/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Venta {
    private int numVenta;
    private ArrayList<LineaVenta> lineas;
    private double IVA;
    private double importeTotal;
    
    private static int contadorNumVenta=1;
    

    public Venta() {
        this.numVenta=Venta.contadorNumVenta;
        Venta.contadorNumVenta++;
        lineas=new ArrayList<>();
        this.IVA=21;
        this.importeTotal=0;
    }

    //---getter and setter
    
    
    
    //--------------------
    

    
    public void añadirLinea(Producto p, int cantidad){
                
        this.lineas.add(new LineaVenta(p,cantidad));
        
        //Cada vez que añado un producto, calculo el total
        this.importeTotal=this.getTotal();
        
        //Disminuyo las unidades del producto
        p.setUnidades(p.getUnidades()-cantidad);
        System.out.printf("............................añadido [%d %s]\n\n",cantidad,p.getDescripcion());
        
        
    }
    
    private double getSubtotal(){
        double subtotal=0;
        for (LineaVenta linea : lineas) {
            subtotal=subtotal+linea.getImporte();
        }
        return subtotal;
    }
    
    
    private double getIVAsubtotal(){
        return this.getSubtotal()*(this.IVA/100);
    }
    
    private double getTotal(){
        return this.getSubtotal()+this.getIVAsubtotal();
    }
    
    
    
    public void imprimirVenta(){
        System.out.println("\033[34m===================================================");
        System.out.println("\033[34m   VENTA NUMERO:  "+this.numVenta);
        System.out.println("");
        System.out.println("\033[34mCANT    DESCRIPCION   PRECIO U    IMPORTE");
        System.out.println("\033[34m---------------------------------------------");
        for (LineaVenta linea : lineas) {
            linea.imprimirLinea();
            //System.out.println(linea); //si lo hubieramos programado toString()
        }
        System.out.println("");
        System.out.printf("\033[34m                          Subtotal: %.2f €\n",this.getSubtotal());
        System.out.printf("\033[34m                          IVA %.0f:   %.2f €\n",this.IVA,this.getIVAsubtotal());
        System.out.printf("\033[34m                          TOTAL:    %.2f €\n",this.getTotal());
        System.out.println("\033[34m===================================================\033[30m");

    }
    
    @Override
    public String toString(){
        return String.format("%2d - %6.2f€ [%d lineas de venta]",this.numVenta, this.importeTotal, this.lineas.size());
    }
    
    
    
}
