/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6;

import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Ferreteria {
    private String nombre;
    private ArrayList<Producto> almacenProductos; // = new ArrayList();
    private ArrayList<Venta> listaVentas;
 
    public Ferreteria(String nombre) {
        this.nombre = nombre;
        this.almacenProductos= new ArrayList();
        this.listaVentas=new ArrayList();
    }
  
    //--- getter and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //--------------------
    
    
    public void nuevoProducto(String descrip, double precioU, int unidades){
        Producto nuevoProducto=new Producto(descrip,precioU,unidades);
        this.almacenProductos.add(nuevoProducto);
        
    }
    
    public boolean añadirStock(String ref, int unidades){
        Producto p=this.buscarProducto(ref);
        
        if (p!=null){
            p.setUnidades(p.getUnidades()+unidades);
            return true;
        }
        else{
            System.out.println("  -ERROR: no existe dicha referencia");
            return false;
        }
        
    }
    
    public Producto buscarProducto(String ref){
        for (Producto p : almacenProductos) {
            if (p.getReferencia().equalsIgnoreCase(ref)){
                return p;
            }
        }
        
        return null;
        
    }
    
    //Método interesante
    public Venta nuevaVenta(){
        Venta v=new Venta();
        listaVentas.add(v);
        return v;
        
    }
    
    
    public void mostrarAlmacen(){
        System.out.println("===  "+this.nombre+" - ALMANCEN PRODUCTOS  ===");
        System.out.println("  REF     DESCRIPCION      PRECIO      UNIDADES");
        System.out.println("-----------------------------------------------");
        for (Producto p : almacenProductos) {
            System.out.println(p);
            
        }
        System.out.println("===============================================");
        
    }
    
    public void listadoReferencias(){
        System.out.println("      --------------------------------");
        for (Producto p : almacenProductos) {
            System.out.printf("      %7s  %s\n", p.getReferencia(),p.getDescripcion());
            
        }
        System.out.println("      --------------------------------");
        
    }
    
    public void mostrarVentas(){
        System.out.println("\033[34m===================================================");
        for (Venta v : listaVentas) {
            System.out.println(v);
        }
        System.out.println("\033[34m===================================================");
        
        
    }
    
    
    
}
