/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4;

import ejercicio3.Incidencia;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Inicio {

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
        
        miEmpresa.addCliente("Mortadelo", "morta@kk.com", "Lorca");
        miEmpresa.addCliente("Filemon", "filemon@kk.com", "Aguilas");
       
        miEmpresa.addVehiculo("1111AAA", "Audi", "A4", Vehiculo.getPrecioDiaDefecto());
        miEmpresa.addVehiculo("2222AAA", "Volvo", "XC60", 40);
        miEmpresa.addVehiculo("3333AAA", "Seat", "Ibiza", 20);
        
        
        
        do{
            System.out.println("");System.out.println("");
            System.out.println("=============="+miEmpresa.getNombreEmpresa()+"================");
            miEmpresa.listarVehiculos();
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
                        
                        double precio_dia;
                        if (precio.equals("")){
                            //precio por dia por defecto
                            miEmpresa.addVehiculo(matri, marca, modelo, 0); //0 indica precio por defecto
                            
                        }else{
                            precio_dia=Double.parseDouble(precio);
                            miEmpresa.addVehiculo(matri, marca, modelo, precio_dia);
                        }
                        break;
                        
                case 3: System.out.println("--- Alquilando vehiculo ---");
                        miEmpresa.listarClientes();
                
                        System.out.print("  >ID Cliente: ");
                        int id=Integer.parseInt(teclado.nextLine());
                        
                        System.out.print("  >Matricula: ");
                        matricula=teclado.nextLine();
                        
                        System.out.print("  >Fecha de alquiler [intro para hoy]: ");
                        fecha=teclado.nextLine();
                        LocalDate fecha_alquiler;
                        if (fecha.equals("")){
                           fecha_alquiler=LocalDate.now();
                        }else{
                           fecha_alquiler=LocalDate.parse(fecha,dtf); 
                        }
                        
                        if (miEmpresa.nuevoAlquiler(id, matricula, fecha_alquiler)==true){
                            System.out.println("Vehiculo alquilado correctamente");
                        }
                        else{
                            System.out.println("ERROR en el alquiler");
                        }
                        break;
                        
                case 4: System.out.println("--- Devolver vehiculo ---");
                        System.out.print("  >Matricula: ");
                        matricula=teclado.nextLine();
                        
                        System.out.print("  >Fecha de devolucion [intro para hoy]: ");
                        fecha=teclado.nextLine();
                        LocalDate fecha_devolucion;
                        if (fecha.equals("")){
                           fecha_devolucion=LocalDate.now();
                        }else{
                           fecha_devolucion=LocalDate.parse(fecha,dtf); 
                        }
                        
                        if (miEmpresa.devolverVehiculo(matricula, fecha_devolucion)==true){
                           //System.out.println("Vehiculo devuelto correctamente"); 
                        }else{
                           System.out.println("ERROR en la devolucion"); 
                        }
                      
                        break;
                        
                case 5: miEmpresa.listarAlquileresTodos();
                        System.out.print("ID alquiler para detalle [INTRO para salir]: ");
                        String idString=teclado.nextLine();
                        if (!idString.equals("")){
                            int idAlquiler=Integer.parseInt(idString);
                            Alquiler a=miEmpresa.getAlquiler(idAlquiler);
                            if (a!=null){
                                a.imprimirDetalles();
                            }
                            else{
                               System.out.println("ERROR. ID de alquiler no encontrado"); 
 
                            }
                        }
                        break;
                        
                case 6: System.out.println("Bye bye");
                        break;
                
                default:System.out.println("ERROR: Opcion no válida");
            }
      
        }while (opcion!=6);
        
        
        
        
        
    }
    
}
