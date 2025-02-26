/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jacuela
 */
public class Banco {
    private String nombre;
    private ArrayList<CuentaCorriente> listaCuentas;
    private ArrayList<Cliente> listaClientes;
    
    
    public Banco(String nombre){
       this.nombre=nombre;
       this.listaCuentas=new ArrayList();
       this.listaClientes=new ArrayList();
        
    }
    
    
    public void nuevoCliente(String dni, String nombre, String apellidos, String email){
      
        Cliente c=new Cliente(dni,nombre,apellidos,email);

        //Añado el cliente
        this.listaClientes.add(c);
    } 
    
    
    
    public void abrirCuenta(Cliente c, double saldoInicial){
        
        CuentaCorriente nuevacc=new CuentaCorriente(c, saldoInicial);
        this.listaCuentas.add(nuevacc);
        
    }
    
    
    public Cliente buscarCliente(String dni){
        Cliente c;
        for (int i = 0; i < this.listaClientes.size(); i++) {
            c=listaClientes.get(i);
            
            if (c.getDNI().equalsIgnoreCase(dni)){
                return c;
            }
        }
        return null;
    }
    
    
    public CuentaCorriente buscarCuenta(int numero){
        
        for (CuentaCorriente cc : listaCuentas) {
            if (cc.getNumero()==numero){
                return cc;
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
    
    
    public void listarCuentas(){
        
        System.out.println("=====================================================");
        System.out.println("\033[34m                  LISTADO DE CUENTAS          ");
        System.out.println("\033[34m  Numero      Saldo               Titular        ");
        for (int i = 0; i < this.listaCuentas.size(); i++) {
            System.out.println(this.listaCuentas.get(i).aCadena());
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
    
    
    public boolean tieneCuentas(Cliente c){
        CuentaCorriente cuentaActual;
        
        for (int i = 0; i < this.listaCuentas.size(); i++) {
            cuentaActual=listaCuentas.get(i);
            if (cuentaActual.getTitular().getDNI().equals(c.getDNI())){
                return true;
            }
        }
        return false;
    }
    
    
    
    
} //fin clase Banco
