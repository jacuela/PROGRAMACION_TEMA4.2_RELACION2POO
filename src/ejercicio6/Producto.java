/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Producto {
    private String referencia;
    private String descripcion;
    private double precioUnitario;
    private int unidades;
    
    private static int contadorRef=101;

    public Producto(String descripcion, double precioUnitario, int unidades) {
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.unidades = unidades;
        
        this.referencia="REF"+Producto.contadorRef;
        Producto.contadorRef++;
        
    }
    
    //--- getter and setter
    
    
    

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    //--------------------
    
    @Override
    public String toString(){
        
        if (this.unidades<=10){
            //En rojo
            return String.format("\033[31m %6s [%15s] %6.2f€      %d uni. \033[30m",this.referencia, this.descripcion, this.precioUnitario,this.unidades);
        }
        else{
            return String.format("\033[30m %6s [%15s] %6.2f€      %d uni. \033[30m",this.referencia, this.descripcion, this.precioUnitario,this.unidades);
      
        }
        
    }
    
    
    
    
    
}
