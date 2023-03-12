/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class LineaVenta {
    private Producto producto;
    private int cantidad;
    private double importe;
    
    public LineaVenta(Producto p, int cantidad){
        this.producto=p;
        this.cantidad=cantidad;
        this.importe=this.producto.getPrecioUnitario()*this.cantidad;
        
    }
   
    public void imprimirLinea(){
       System.out.printf("\033[34m%2d  %15s   %6.2f€  %.2f\n",this.cantidad, this.producto.getDescripcion(),this.producto.getPrecioUnitario(), this.importe);
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    
    
}
