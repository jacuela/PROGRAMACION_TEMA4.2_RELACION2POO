/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5_enclase;

import java.util.ArrayList;

/**
 *
 * @author Juan Antonio Cuello Alarcon <juanantonio.cuello@murciaeduca.es>
 */
public class Banco {
    private String nombre;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<CuentaCorriente> listaCuentas;
    
    public Banco(String nombre){
        this.nombre = nombre;
        this.listaClientes = new ArrayList();
        this.listaCuentas = new ArrayList();
    }
    
    
    public void listarCuentas(){
        
        System.out.println("=====================================================");
        System.out.println("\033[34m                  LISTADO DE CUENTAS          ");
        System.out.println("\033[34m  Numero      Saldo               Titular        ");
        
        for (CuentaCorriente cc : listaCuentas) {
            System.out.println(cc.aCadena());
        }
        
        System.out.println("=====================================================");
        System.out.println("");System.out.println("");
        
    }
    
    
    public void listarClientes(){
        System.out.println("=====================================================");
        System.out.println("\033[34m                  LISTADO DE CLIENTES          ");
        System.out.println("\033[34m     DNI          Nombre               e-mail         ");
        
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente.aCadena());
        }
        
        System.out.println("=====================================================");
        System.out.println("");System.out.println("");
        
    }
    
    public void nuevoCliente (String dni, String nombre, String ape, String email){
        Cliente c= new Cliente(dni,nombre,ape,email);
        listaClientes.add(c);
    }
    
    
    public void abrirCuenta(Cliente c, double saldoInicial){
         CuentaCorriente nuevacc=new CuentaCorriente(c, saldoInicial);
         this.listaCuentas.add(nuevacc);
        
    }
    
    public CuentaCorriente buscarCuenta(int numCuenta){
        
        for (CuentaCorriente cc : listaCuentas) {
            if (cc.getNumero()==numCuenta){
                return cc;
            }
        }
        
        return null;
    }
    
    public Cliente buscarCliente(String dni){
        for (Cliente cliente : listaClientes) {
            if (cliente.getDNI().equalsIgnoreCase(dni)){
                //he encontrado el cliente con dicho dni
                return cliente;
                
            }
       
        }
        return null;
   
   }
   
   public ArrayList<CuentaCorriente> getCuentas(Cliente cliente){
       
       ArrayList<CuentaCorriente> listaResultado=new ArrayList();  //lista de las cuentas del cliente
       
       for (CuentaCorriente cc : listaCuentas) {
           
           //Podria funcuionar, pero ojo al comparar objetos
           //if (cc.getTitular()==cliente){
           //    
           //}
           
            if (cc.getTitular().getDNI().equalsIgnoreCase(cliente.getDNI())){
               listaResultado.add(cc);
            }
       }
       
       return listaResultado;
       
   } 
    
    
    
    
    
    
}
