/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5_enclase;

/**
 *
 * @author Juan Antonio Cuello Alarcon <juanantonio.cuello@murciaeduca.es>
 */
public class Cliente {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String email;
    
    public Cliente (String DNI, String nombre, String ape, String email){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = ape;
        this.email = email;
    }

    //Mis métodos
    public String aCadena(){
        return String.format("%6s %10s %10s %s",this.DNI,this.nombre,this.apellidos,this.email);
    }
    
    public void imprimirDetalles(){
        System.out.println(this.nombre+" "+this.apellidos);
        System.out.println(this.DNI);
        System.out.println(this.email);
    }
    
    //Getter and Setter
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
    
    
    
    
    
    
    
    
}
