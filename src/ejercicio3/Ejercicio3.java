/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf_hora=DateTimeFormatter.ofPattern("HH:mm");
        Scanner teclado=new Scanner(System.in);
        
        
        Gestor migestor=new Gestor();
        int opcion=0;
        

        //******************  INICIALIZACIÓN ************************************
        
         //Primero creamos los puestos
        migestor.addPuesto(10, "PC sobremesa 10");
        migestor.addPuesto(11, "PC sobremesa 11");
        migestor.addPuesto(12, "PC portatil 12");
        migestor.addPuesto(40, "Pizarra digital sala reuniones");
        migestor.addPuesto(41, "PC sala de reuniones");
        

        //Luego las incidencias
        migestor.addIncidencia(migestor.buscarPuesto(10), "Sin acceso a Internet", LocalDate.parse("10/03/2022",dtf));
        migestor.addIncidencia(migestor.buscarPuesto(12), "No arranca", LocalDate.parse("12/03/2022",dtf));
        
       
        
        //***********************************************
        do{
            System.out.println("");System.out.println("");
            System.out.println("===========================================================");
            System.out.println("GESINTIC");
            System.out.println(LocalDate.now().format(dtf)+" - "+LocalTime.now().format(dtf_hora));
            System.out.println("===========================================================");
            migestor.listarIncidencias();
            System.out.println("===========================================================");
            System.out.println("");
            System.out.println("1. Nueva Incidencia");
            System.out.println("2. Resolver Incidencia");
            System.out.println("3. Detalles incidencia");
            System.out.println("4. Nuevo puesto");
            System.out.println("5. Salir");
            System.out.print("Elige opción: ");
            opcion=Integer.parseInt(teclado.nextLine());
            
            switch (opcion){
                case 1: menu1(migestor);
                        break;
                case 2: menu2(migestor);
                        break;
                case 3: System.out.print(">Codigo de la incidencia: ");
                        int codigo=Integer.parseInt(teclado.nextLine());
                        Incidencia i=migestor.buscarIncidencia(codigo);
                        if (i!=null) i.imprimirDetalles();
                        else System.out.println("ERROR: no existe la incidencia");
                        break;
                case 4: menu4(migestor);
                        break;
                case 5: break;
                default:System.out.println("ERROR: Opcion no válida");
            }
      
        }while (opcion!=5);
        
      
        
        
    }
    
    
    private static void menu1(Gestor gestor){
        Scanner teclado=new Scanner(System.in);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Puesto puesto;
        String descripcion;
        LocalDate fecha;
        
        System.out.println("\nCREANDO NUEVA INCIDENCIA");
        System.out.println("---------- PUESTOS ----------");
        gestor.listarPuestos();
        System.out.println("-----------------------------");
        
        do{
            System.out.print(">Puesto incidencia: ");
            int cod_puesto=Integer.parseInt(teclado.nextLine());
            puesto=gestor.buscarPuesto(cod_puesto);
            if (puesto!=null) break;
            else System.out.println("  ERROR: no existe dicho puesto");
        }while(true);
        
        System.out.print(">Descripcion: ");
        descripcion=teclado.nextLine();
        
        
        do{
            System.out.print(">Fecha incidencia (INTRO para hoy): ");
            String fechaString=teclado.nextLine();
            
            if (fechaString.equals("")){
                fecha=LocalDate.now();
                break;
            }
            else{    
                try {
                    fecha = LocalDate.parse(fechaString, dtf);
                    break;
                } catch (Exception ex) {
                    System.out.println("ERROR: fecha incorrecta");
                }
            }    
                
        }while(true);      
        
                        
        //Vamos a añadir la incidencia por medio del gestor.
        gestor.addIncidencia(puesto, descripcion, fecha);
   
    }
    
    //Opcion 2: resolver incidencia
    private static void menu2(Gestor gestor){
        Scanner teclado=new Scanner(System.in);
        
        System.out.print(">Incidencia a resolver: ");
        int codigo= Integer.parseInt(teclado.nextLine());
        
        Incidencia i=gestor.buscarIncidencia(codigo);
        if (i==null)
            System.out.println("ERRRO: no existe dicha incidencia");
        else{
           i.imprimirDetalles();
           System.out.println("");
           System.out.print(">>>Resolucion: ");
           String resolucion=teclado.nextLine(); 
           
           gestor.resolverIncidencia(i,resolucion, LocalDate.now());
        }
        
    }
    
    
    //Opcion 4: nuevo puesto
    private static void menu4(Gestor gestor){
        Scanner teclado=new Scanner(System.in);
        System.out.println("\nCREANDO NUEVA PUESTO");
        System.out.print(">Codigo del puesto: ");
        int codigo= Integer.parseInt(teclado.nextLine());
        System.out.print(">Descripcion del puesto: ");
        String descripcion=teclado.nextLine();
        
        gestor.addPuesto(codigo, descripcion);
    }
    
}
