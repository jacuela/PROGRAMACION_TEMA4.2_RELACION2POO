/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author juan.antonio
 */
public class Producto {
    
    private String ref;
    private String descripcion;
    private double precioU;

    public Producto(String ref, String descripcion, double precioUnitario) {
        this.ref = ref;
        this.descripcion = descripcion;
        this.precioU = precioUnitario;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioU;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioU = precioUnitario;
    }
    
    public String aCadena(){
        return String.format("%s - %s - %.2f",this.ref,this.descripcion,this.precioU);
    }
    
    
}
