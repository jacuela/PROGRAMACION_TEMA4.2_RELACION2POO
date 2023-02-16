/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.ArrayList;

/**
 *
 * @author juan.antonio
 */
public class BD_Producto {
    
    private ArrayList<Producto> bd;

    private static int ultimaRef; //para generar las referencias
    
    public BD_Producto() {
        this.bd=new ArrayList();
        ultimaRef=1;
              
    }
    
    public void add(String descripcion, double precioU){
        //Primero, me creo la referencia
        String nuevaRef=String.format("REF%d",ultimaRef);
        ultimaRef++;
        
        //Me creo el producto
        Producto p=new Producto(nuevaRef,descripcion,precioU);
        bd.add(p);
        
    }
  
    public void listarProductos(){
        
        for (Producto producto : bd) {
            System.out.println(producto.aCadena());
        }
        
    }
    
    public Producto buscar(String ref){
        Producto p=null;
        
        for (int i = 0; i < bd.size(); i++) {
            //Obtengo el producto i
            p=bd.get(i);
            
            if (p.getRef().equalsIgnoreCase(ref))
                return p;
            
        }
        //System.out.println("!!Error, producto no encontrado");
        return null;
       
    }
    
    
    
    
}
