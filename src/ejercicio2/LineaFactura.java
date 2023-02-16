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
public class LineaFactura {
    
    private Producto producto;
    private int cantidad;
    private double importeLinea;

    public LineaFactura(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.importeLinea=producto.getPrecioUnitario()*cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporteLinea() {
        return importeLinea;
    }

    public void setImporteLinea(double importeLinea) {
        this.importeLinea = importeLinea;
    }
    
    public void imprimirLinea(){
        
        System.out.printf("%5s %-20s %3d   %4.2f€   %.2f€\n",
                                  this.producto.getRef(),
                                  this.producto.getDescripcion(),
                                  this.cantidad,
                                  this.producto.getPrecioUnitario(),
                                  this.importeLinea);
        
    }
    
    
    
    
}
