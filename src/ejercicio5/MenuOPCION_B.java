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
public class MenuOPCION_B {

    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner teclado = new Scanner(System.in);
        int opcion;
        String nombre,apellidos, dni, email;
        String tecla;
        
        Banco banco = new Banco("Lorbank S.A");

        //   *******  DATOS PARA INICIALIZAR EL PROGAMA  ****************
        banco.nuevoCliente("0000A","Mortadelo","Sanchez","mortadelo@mail.com");
        banco.nuevoCliente("0000B","Filemon","Sanchez","filemon@mail.com");
        
        Cliente c_0000A=banco.buscarCliente("0000A");
        banco.abrirCuenta(c_0000A, 1000);
        banco.abrirCuenta(c_0000A, 5000);
        //   ***********************************************************
        
        
        
        do {
            System.out.println("");
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Nuevo Cliente");
            System.out.println("2. Selecionar Cliente");
            System.out.println("3. Listar Todas Cuentas");
            System.out.println("4. Listar Todos Clientes");
            System.out.println("5. Salir");
            System.out.println("========================");
            System.out.print("Dime tu opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch (opcion) {
                case 1:
                    System.out.println("\n\nCreando un nuevo cliente...");
       
                    //Pido los datos del cliente
                    System.out.print("DNI:"); dni=teclado.nextLine();
                    System.out.print("Nombre:"); nombre=teclado.nextLine();
                    System.out.print("Apellidos:"); apellidos=teclado.nextLine();
                    System.out.print("email:"); email=teclado.nextLine();
                    
                    banco.nuevoCliente(dni, nombre, apellidos, email);
                    break;
                
                case 2:
                    System.out.print("DNI del cliente: ");
                    dni = teclado.nextLine();
                    Cliente cliente = banco.buscarCliente(dni);
                    if (cliente!=null){
                       submenuCliente(cliente,banco);
                    }
                    else{
                        System.out.println("ERROR: no existe dicho cliente");
                    }
                    break;
                
                case 3:
                    banco.listarCuentas();
                    break;
                case 4:
                    banco.listarClientes();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("ERROR. Opcion no valida");
                    break;
            }
        } while (opcion != 5);
    }


    private static void submenuCliente(Cliente cliente, Banco banco) {
    
        Scanner entrada = new Scanner(System.in);
        int opcion, num,num_destino;
        double saldo, importe;
        CuentaCorriente cuentaDestino,cuentaOrigen;
        System.out.println("");System.out.println("");
        String tecla;
        boolean ok_reintegro, ok_transfer;
        ArrayList<CuentaCorriente> lista;
        
        do {
            System.out.println("");
            System.out.println("=== Menu Cliente ===");
            cliente.imprimirDetalles();
            System.out.println("");
            System.out.println("cuenta          saldo");
            System.out.println("---------------------");
            //banco.listarCuentas(cliente);
            
            lista=banco.getCuentas(cliente);
            if (lista!=null){
                for (CuentaCorriente cc : lista) {
                    System.out.println(cc.aCadena());
                }    
            }
            else{
                System.out.println("El cliente no tiene cuentas");
                System.out.println("");
            }
            

            System.out.println("");
            System.out.println("1. Abrir Cuenta");
            System.out.println("2. Ingreso");
            System.out.println("3. Reintegro");
            System.out.println("4. Transferencia");
            System.out.println("5. Volver");
            System.out.println("====================");
            System.out.print("Elige opción: ");
            opcion = Integer.parseInt(entrada.nextLine());
            
            switch (opcion) {
                case 1:
                    //******** Abriendo nueva cuenta *********
                    System.out.print("Indica el SALDO inicial: ");
                    saldo = Double.parseDouble(entrada.nextLine());
                    banco.abrirCuenta(cliente, saldo);
                    break;
                case 2:
                    if (banco.tieneCuentas(cliente)){
                        //******* Haciendo in ingreso *********
                        System.out.print("Numero de cuenta para el ingreso: ");
                        num = Integer.parseInt(entrada.nextLine());
                        System.out.print("Importe a ingresar: ");
                        importe = Double.parseDouble(entrada.nextLine());
                        
                        CuentaCorriente cc=banco.buscarCuenta(num);
                        if(cc!=null) cc.ingreso(importe);
                        else System.out.println("  >ERROR: cuenta no encontrada");
                    }
                    else{
                        System.out.println("Operación no disponible");
                        
                    }
                    System.out.println("- Pulse INTRO para continuar -");
                    tecla=entrada.nextLine();
                    break;
                    
                case 3:
                    if (banco.tieneCuentas(cliente)){
                        //********* Haciendo un reintegro ***********
                        System.out.print("Numero de cuenta para el reintegro: ");
                        num = Integer.parseInt(entrada.nextLine());
                        
                        CuentaCorriente cc=banco.buscarCuenta(num);
                        if(cc!=null){
                            do{
                             System.out.print("Importe del reintegro: ");
                             importe = Double.parseDouble(entrada.nextLine());   
                             ok_reintegro=cc.reintegro(importe);
                            }while(ok_reintegro==false); 
                        
                        }
                        else System.out.println("  >ERROR: cuenta no encontrada");
                       
                    }else{
                        System.out.println("Operación no disponible");
                        
                    }    
                    System.out.println("- Pulse INTRO para continuar -");
                    tecla=entrada.nextLine();
                    break;
                  
                case 4:
                     if (banco.tieneCuentas(cliente)){
                        //******** Haciendo una transferencia ***********
                        System.out.print("Cuenta de origen: ");
                        num = Integer.parseInt(entrada.nextLine());
                        System.out.print("Cuenta de destino: ");
                        num_destino = Integer.parseInt(entrada.nextLine());
                        
                        cuentaOrigen=banco.buscarCuenta(num);
                        cuentaDestino=banco.buscarCuenta(num_destino);
                        
                        if (cuentaOrigen!=null && cuentaDestino!=null){
                            do{
                                //Existen ambas cuentas
                                System.out.println("Importe de la transferencia: ");
                                importe = Double.parseDouble(entrada.nextLine());
                                ok_transfer=cuentaOrigen.transferencia(cuentaDestino, importe);
                            }while(ok_transfer==false);
                        }
                        else{
                            System.out.println("  >ERROR: cuenta no encontrada");
                        }
                        
                     }else{
                        System.out.println("Operación no disponible");
                     }
                     System.out.println("- Pulse INTRO para continuar -");
                     tecla=entrada.nextLine();
                     break;
                    
                case 5:
                    //System.out.println("VOLVIENDO...");
                    break;
                default:
                    System.out.println("ERROR. Opcion no valida");
                    break;
            }

        } while (opcion != 5);
        
    
    
    
    }
 
    
}
