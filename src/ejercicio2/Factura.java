/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author juan.antonio
 */
public class Factura {
    private String cif;
    private String numero;
    private LocalDate fecha;
    private ArrayList<LineaFactura> lineas;
    private final double IVA=21;

    public Factura(String cif, String numero, LocalDate fecha) {
        this.cif = cif;
        this.numero = numero;
        this.fecha = fecha;
        this.lineas=new ArrayList();
    }
   
    public void añadirLinea(Producto p, int cantidad){
        LineaFactura nuevaLinea=new LineaFactura(p,cantidad);
        lineas.add(nuevaLinea);
    }
    
    
    
    public void imprimir(){
        
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("************************************************");
        System.out.printf("CIF: %s\n",this.cif);
        System.out.printf("FECHA: %s              FACTURA NUM: %s",this.fecha.format(dtf),this.numero);        
        System.out.println("");
        System.out.println("");
        System.out.println("REF       DESCRIPCION     CANT   PRECIOU    IMPORTE");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < lineas.size(); i++) {
            lineas.get(i).imprimirLinea();
        }
        System.out.println("");
        System.out.println("");
        System.out.printf("                         SUBTOTAL:  %.2f€\n",this.getSubtotal());
        System.out.printf("   IVA:%.0f             IMPORTE IVA:  %.2f€\n",this.IVA,this.getImporteIva());
        System.out.printf("                            \033[31mTOTAL:  %.2f€\033[30m\n",this.getTotal());
        
        System.out.println("************************************************");
       
        
        
    }
    
    
    private double getSubtotal(){
        
        double subtotal=0;

        //Recorro linea a linea acumulano el importe de la misma
        for (int i = 0; i < lineas.size(); i++) {
            subtotal=subtotal+lineas.get(i).getImporteLinea();
        }
        return subtotal;
    }
    
    private double getImporteIva(){
        
        double importeIva=0;    
        //Obtengo el IVA del subtotal
        
        importeIva=getSubtotal()*(IVA/100);
        return importeIva;
    }
 
    private double getTotal(){
        return getSubtotal()+getImporteIva();
    }
 
    
    
    
    
}
