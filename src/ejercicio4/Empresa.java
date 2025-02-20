/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Empresa {
    
    
    private String nombreEmpresa;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Alquiler> listaAlquileres;

    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        listaClientes= new ArrayList();
        listaVehiculos= new ArrayList();
        listaAlquileres= new ArrayList();
    }
    
    //---------- getter and setter -----------

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
    
    //------------------------------------------
   
    //-------------Gestion de la lista de clientes --------
    public void addCliente(String nombre, String mail, String loca){
        listaClientes.add(new Cliente(nombre,mail,loca));
    }
    
    public Cliente getCliente(int id){
        for (Cliente c : listaClientes) {
            if (c.getId()==id){
                return c;
            }
            
        }
        return null;
    }
    
    public void listarClientes(){
        System.out.println("LISTADO DE CLIENES");
        System.out.println("=======================================");
        for (Cliente c : listaClientes) {
            System.out.println(c.aCadena());
        }
        System.out.println("=======================================");

    }
    
    //------------------------------------------

    //-------------Gestion de la lista de vehiculos --------
    public void addVehiculo(String matricula, String marca, String modelo, double precio_dia){
        if (precio_dia==0){
            //precio dia por defecto. llamo al constructor 1
            listaVehiculos.add(new Vehiculo(matricula, marca, modelo));
        }
        else{
            //precio dia definido. llamo al constructor 2
            listaVehiculos.add(new Vehiculo(matricula, marca, modelo, precio_dia));
        }
        
        
        
    }
    
   
    
    public Vehiculo getVehiculo(String matricula){
        for (Vehiculo v : listaVehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matricula)){
                return v;
            }
            
        }
        return null;
    }
    
     public void listarVehiculos(){
        //System.out.println("LISTADO DE VEHICULOS");
        //System.out.println("=======================================");
        for (Vehiculo v : listaVehiculos) {
            System.out.println(v.aCadena());
        }
        //System.out.println("=======================================");

    }
    //------------------------------------------
    //-------------Gestion de la lista de alquileres --------
    
    public Alquiler getAlquiler(String matricula){
        for (Alquiler a : listaAlquileres) {
            if (a.getMatricula().equalsIgnoreCase(matricula) && a.isFinalizado()==false){
                //He encontrado el alquiler. Ojo porque no solo vale con
                //buscar la matricula
                return a;
            }
        }
        return null;
    }
     
    public Alquiler getAlquiler(int idAlquiler){
        for (Alquiler a : listaAlquileres) {
            if (a.getId()==idAlquiler){
                return a;
            }
            
        }
        return null;
    }
     
     
    public void listarAlquileresTodos(){
        System.out.println("LISTADO DE ALQUILERES");
        System.out.println("=======================================");
        for (Alquiler a : listaAlquileres) {
            System.out.println(a.aCadena());
        }
        System.out.println("=======================================");

    }
     
     
     
    public boolean nuevoAlquiler(int idCliente, String matricula, LocalDate fecha_alquiler){
        
        //Buscamos el cliente
        Cliente cliente= this.getCliente(idCliente);
        if (cliente==null){
            System.out.println("  >ERROR: no existe dicho cliente");
            return false;
        }
        
        //Buscamos vehiculo y comprobamos que no esta alquilado
        Vehiculo vehiculo=this.getVehiculo(matricula);
        if (vehiculo==null){
            System.out.println("  >ERROR: no existe dicha matricula");
            return false;
        }else if (vehiculo.isAlquilado()){
            System.out.println("  >ERROR: el vehiculo ya esta alquilado");
            return false;
        }
        
        //Si llego aquí, alquilamos
        this.listaAlquileres.add(new Alquiler(cliente, vehiculo, fecha_alquiler));
        return true;
    } 
     
     
     
     
    public boolean devolverVehiculo(String matricula, LocalDate fecha_devolucion){
        
        
        //Primero buscamos el vehiculo
        Vehiculo vehiculo=this.getVehiculo(matricula);
        if (vehiculo==null){
            System.out.println("  >ERROR: no existe dicha matricula");
            return false;
        }else if (!vehiculo.isAlquilado()){
            System.out.println("  >ERROR: el vehiculo no esta alquilado");
            return false;
        }
        
        //Buscamos el alquiler del coche. Ojo, debe devolver
        //el último alquiler, donde el coche este aún alquilado
        Alquiler alquiler=this.getAlquiler(matricula);
        if (alquiler==null){
            System.out.println("  >ERROR: alquiler no encontrado");
            return false; 
        }
        
        //Si llego aquí, he encontrado el vehiculo y el alquiler
        alquiler.devolverVehiculo(fecha_devolucion);
        return true;        
        
    }
    
    
    
    
    
}
