/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author jacuela
 */
public class Cliente {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String email;

    public Cliente(String DNI, String nombre, String apellidos, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    
    
    /******** GETTER ANS SETTER AUTOMATICOS **************/
    
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //**********************************************
    
    public String aCadena (){
        return String.format("%10s - %10s %-10s  %s",DNI,nombre,apellidos,email);
        
    }
    
    
    public void imprimirDetalles(){
        System.out.println("");
        System.out.printf(" Nombre: %s %s\n",this.nombre,this.apellidos);
        System.out.printf(" DNI:    %s\n",this.DNI);
        System.out.printf(" Email:  %s\n",this.email);
    }
    
    
    
    
}
