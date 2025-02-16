/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author juanantoniocuelloalarcon
 */
public class InicioAlumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner teclado=new Scanner(System.in);
        int opcion;
        String matricula,fecha;
        
        Empresa miEmpresa=new Empresa("ALQUILA TU CARRO S.L.");
        
        //============ INICIALIZACION DE DATOS ===============================
        miEmpresa.addCliente("Mortadelo", "morta@kk.com", "Lorca");
        miEmpresa.addCliente("Filemon", "filemon@kk.com", "Aguilas");
       
        miEmpresa.addVehiculo("1111AAA", "Audi", "A4", Vehiculo.getPrecioDiaDefecto());
        miEmpresa.addVehiculo("2222AAA", "Volvo", "XC60", 40);
        miEmpresa.addVehiculo("3333AAA", "Seat", "Ibiza", 20);
        //============ FIN INICIALIZACION DE DATOS ===============================

        
        
        do{
            System.out.println("");System.out.println("");
            System.out.println("=============="+miEmpresa.getNombreEmpresa()+"================");
            
            System.out.println("==================================================");
            System.out.println("");
            System.out.println("1. Alta cliente");
            System.out.println("2. Alta vehiculo");
            System.out.println("3. Alquilar");
            System.out.println("4. Devolver");
            System.out.println("5. Histórico alquileres");
            System.out.println("6. Salir");
            
            System.out.print("Elige opción: ");
            opcion=Integer.parseInt(teclado.nextLine());
            System.out.println("");
            switch (opcion){
                case 1: System.out.println("--- Alta de cliente ---");
                        System.out.print("  >Nombre: ");
                        String nombre=teclado.nextLine();
                        System.out.print("  >Email: ");
                        String email=teclado.nextLine();
                        System.out.print("  >Localidad: ");
                        String localidad=teclado.nextLine();
                        miEmpresa.addCliente(nombre, email, localidad);
                        break;
                        
                case 2: System.out.println("--- Alta de vehiculo ---");
                        System.out.print("  >Matricula: ");
                        String matri=teclado.nextLine();
                        System.out.print("  >Marca y modelo: ");
                        String marca=teclado.next();
                        String modelo=teclado.nextLine();
                        System.out.printf("  >Precio/dia [INTRO para %.1f €/dia]: ",Vehiculo.getPrecioDiaDefecto());
                        String precio=teclado.nextLine(); //lo recojo como String para comprobar si es por defecto
                        
                        
                        
                        break;
                        
                case 3: System.out.println("--- Alquilando vehiculo ---");
                        miEmpresa.listarClientes();
                
                        System.out.print("  >ID Cliente: ");
                        int id=Integer.parseInt(teclado.nextLine());
                        
                        System.out.print("  >Matricula: ");
                        matricula=teclado.nextLine();
                        
                        System.out.print("  >Fecha de alquiler [intro para hoy]: ");
                        fecha=teclado.nextLine();
                        
                        
                        break;
                        
                case 4: System.out.println("--- Devolver vehiculo ---");
                        System.out.print("  >Matricula: ");
                        matricula=teclado.nextLine();
                        
                        System.out.print("  >Fecha de devolucion [intro para hoy]: ");
                        fecha=teclado.nextLine();
                        
                        
                      
                        break;
                        
                case 5: 
                    
                        break;
                        
                case 6: System.out.println("Bye bye");
                        break;
                
                default:System.out.println("ERROR: Opcion no válida");
            }
      
        }while (opcion!=6);
        
        
        
        
        
        
    }
    
}
