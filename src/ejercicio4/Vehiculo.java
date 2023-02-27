/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private boolean alquilado;
    private double precio_dia;

    public Vehiculo(String matricula, String marca, String modelo, double precio_dia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio_dia = precio_dia;
    }
    
    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio_dia = Empresa.getPrecioDiaDefecto();
    }
    
    

    //--------  getter and setter --------------------------
    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public double getPrecio_dia() {
        return precio_dia;
    }

    public void setPrecio_dia(double precio_dia) {
        this.precio_dia = precio_dia;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    
    
    
    //------------------------------------------------
    
    public String aCadena(){
        
        if (this.alquilado){
            return String.format("\033[31mA   %6s %10s %5s %.2f €/dia\033[30m",this.matricula, this.marca, this.modelo,this.precio_dia);
            
        }
        else{
            return String.format("    %6s %10s %5s %.2f €/dia",this.matricula, this.marca, this.modelo,this.precio_dia);
        }
        
    }
    
    
}
