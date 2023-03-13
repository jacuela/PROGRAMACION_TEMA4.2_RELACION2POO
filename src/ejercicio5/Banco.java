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
        
        CuentaCorriente cc;
        
        for (int i = 0; i < this.listaCuentas.size(); i++) {
            cc=this.listaCuentas.get(i);
            if (cc.getNumero()==numero)
                return cc;
        }
        return null;
    }
    
    

    public ArrayList<CuentaCorriente> getCuentas(Cliente c){
        ArrayList<CuentaCorriente> listaCoincidencias=new ArrayList();
      
        
        //*********** ¿Puedo comparar dos objetos??????
        //¿puedo comparar el objeto c con cada uno de los clientes 
        //de las cuentas de la lista?
        
        //En este caso, SÍ, porque es el mismo objeto CLIENTE que me lo he
        //ido llevando a diferentes sitios.
        
        for (CuentaCorriente cc : listaCuentas) {
            if (cc.getTitular()==c){   //Sí puedo comparar dos objetos
                listaCoincidencias.add(cc);
            }
        }
        
        return listaCoincidencias;
        
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
        for (int i = 0; i < this.listaClientes.size(); i++) {
            System.out.println(this.listaClientes.get(i).aCadena());
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
