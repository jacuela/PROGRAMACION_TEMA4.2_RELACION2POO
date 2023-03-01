/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

import java.util.Scanner;

/**
 *
 * @author jacuela
 */
public class MenuOPCION_A {
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        Banco mibanco=new Banco("LorbankSA");
//        Scanner entrada=new Scanner(System.in); 
//        String dni, nombre, apellidos, email;
//        Persona cliente;
//        double importe;
//        int numcuenta, numcuenta2;
//        CuentaCorriente unacuenta, cuentadestino;
//        boolean salir = false;
//        int opcion; //Guardaremos la opcion del usuario
//        
//        
//        
//        //Metemos a mano un par de clientes
//        mibanco.nuevoCliente("1111A", "Mustafa", "Lopez", "musta@kk.com");
//        mibanco.nuevoCliente("2222A", "Kiko", "Kikaes", "kiko@kk.com");
//                                
//        
//        
//        
//        
//        //Menu principal
//        while(!salir){
//           
//           System.out.println("\n\n\n\n***** LORBANK S.A. *****");
//           System.out.println("***************************");
//           
//           System.out.println("1. Nuevo Cliente");
//           System.out.println("2. Abrir Cuenta");
//           System.out.println("3. Ingreso");
//           System.out.println("4. Reintegro");
//           System.out.println("5. Transferencia");
//           System.out.println("6. Listar Cuentas Cliente");
//           System.out.println("7. Listar Todas Cuentas");
//           System.out.println("8. Listar Todos Clientes");
//           System.out.println("9. Salir");
//            
//           System.out.print("Elige una opcion >");
//           opcion = Integer.parseInt(entrada.nextLine());
//            
//           switch(opcion){
//               case 1:
//                    System.out.println("\n\nCreando un nuevo cliente...");
//                    
//                    //Pido los datos del cliente
//                    System.out.print("DNI:"); dni=entrada.nextLine();
//                    System.out.print("Nombre:"); nombre=entrada.nextLine();
//                    System.out.print("Apellidos:"); apellidos=entrada.nextLine();
//                    System.out.print("email:"); email=entrada.nextLine();
//                  
//                    //Añado el cliente
//                    mibanco.nuevoCliente(dni, nombre, apellidos, email);
//                    System.out.println("\n");
//                    break;
//               
//               case 2:
//                   
//                    System.out.println("\n\nAbriendo una cuenta...");
//                    
//                    System.out.print("DNI del cliente:"); dni=entrada.nextLine();
//                    System.out.print("Importe inicial:"); importe=Double.parseDouble(entrada.nextLine());
//                    cliente=mibanco.buscarCliente(dni);
//                    mibanco.abrirCuenta(cliente,importe);
//                    System.out.println("\n");
//                    break;
//               
//               case 3:
//                    System.out.println("\n\nIngresando dinero...");
//                    System.out.print("Numero de cuenta:"); numcuenta=Integer.parseInt(entrada.nextLine());
//                    System.out.print("Importe:"); importe=Double.parseDouble(entrada.nextLine());
//                    unacuenta = mibanco.buscarCuenta(numcuenta);
//                    unacuenta.ingreso(importe);
//                    System.out.println("\n");
//                    break;
//
//               
//               case 4:
//                    System.out.println("\n\nSacando dinero...");
//                    System.out.print("Numero de cuenta:"); numcuenta=Integer.parseInt(entrada.nextLine());
//                    System.out.print("Importe:"); importe=Double.parseDouble(entrada.nextLine());
//                    unacuenta = mibanco.buscarCuenta(numcuenta);
//                    unacuenta.reintegro(importe);
//                    System.out.println("\n");
//                    break;
//               
//               case 5:
//                    System.out.println("\n\nHaciendo transferencia...");
//                    System.out.print("Cuenta origen:"); numcuenta=Integer.parseInt(entrada.nextLine());
//                    System.out.print("Cuenta destino:"); numcuenta2=Integer.parseInt(entrada.nextLine());
//                    System.out.print("Importe:"); importe=Double.parseDouble(entrada.nextLine());
//                    unacuenta = mibanco.buscarCuenta(numcuenta);
//                    cuentadestino = mibanco.buscarCuenta(numcuenta2);
//                    unacuenta.transferencia(cuentadestino, importe);
//                    System.out.println("\n");
//                    break;
//               
//               case 6:
//                    System.out.println("\n\nListar cuentas de un cliente...");
//                    System.out.print("DNI del cliente:"); dni=entrada.nextLine();
//                    mibanco.listarCuentasCliente(dni);
//                    System.out.println("\n");
//                    break;
//               case 7:
//                    System.out.println("\n\nListar todas las cuentas...");
//                    mibanco.listarTodasCuentas();
//                    System.out.println("\n");
//                    break;
//               case 8:
//                    System.out.println("\n\nListar todos los clientes...");
//                    mibanco.listarTodosClientes();
//                    System.out.println("\n");
//                    break;
//                    
//                    
//                case 9:
//                   salir=true;
//                   break;
//              
//                default:
//                   System.out.println("Solo números entre 1 y 9");
//           }
//            
//       } //fin menu
//        
//        
//        
//    }
//    
}
