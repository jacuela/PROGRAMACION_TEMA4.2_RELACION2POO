/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String localidad;
    
    private static int contadorID=1001;

    public Cliente(String nombre, String email, String localidad) {
        this.nombre = nombre;
        this.email = email;
        this.localidad = localidad;
        this.id=Cliente.contadorID;
        Cliente.contadorID++;
    }
    
    //----------- getter and setter ----------------------------
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    //----------------------------------------------------------

    public String aCadena(){
            return String.format("%d %10s %10s %s",this.id, this.nombre, this.email, this.localidad);
        
    }
    
    
}
