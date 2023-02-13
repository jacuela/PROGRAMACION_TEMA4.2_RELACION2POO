/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author juan.antonio
 */
public class Autor {
    private int id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String email;

    public Autor(String nombre1, String nombre2, String apellido1,
            String apellido2,String email) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email=email;
        this.id=(int)(Math.random()*1000);
        //this.id=Utilidades.generarIdAutor();  OPCIONAL
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public String getNombreCita(){
        
       StringBuilder sb=new StringBuilder();
       sb.append(apellido1);
       sb.append(", ");
       sb.append(nombre1.charAt(0));
       sb.append(".");
       if (nombre2!=null){
            sb.append(nombre2.charAt(0));
            sb.append(". ");
       }
       return sb.toString();
        
    }
    
    
    
}
