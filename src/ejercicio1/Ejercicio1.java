/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.Scanner;

/**
 *
 * @author juan.antonio
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado=new Scanner(System.in);
        Biblioteca miBiblio=new Biblioteca("CuelloBiblio");
        int opcion;
        String ref;

        do {
            System.out.println("");System.out.println("");    
            //System.out.println("\033[34m****************************");
            System.out.printf("\033[34m%14s - LISTADO DE LIBROS\n", miBiblio.getNombre());
            //System.out.println("\033[34m****************************");
            miBiblio.listarLibros();
            System.out.println("\033[34m1.  Añadir autor");
            System.out.println("\033[34m2.  Añadir libro");
            System.out.println("\033[34m3.  Listar libros");
            System.out.println("\033[34m4.  Listar autores");
            System.out.println("\033[34m5.  Prestar libro");
            System.out.println("\033[34m6.  Devolver libro");
            System.out.println("\033[34m7.  Salir");

            System.out.print("Elige una opción: \033[30m");
            opcion = Integer.parseInt(teclado.nextLine());
            System.out.println("");

            switch (opcion) {
                case 1:
                    System.out.println("\nAñadiendo un autor...");
                    System.out.println("--- Pulsa INTRO si no tiene algun campo ---");
                    System.out.print("  Nombre1: ");
                    String nombre1=teclado.nextLine();
                    System.out.print("  Nombre2: ");
                    String nombre2=teclado.nextLine();
                    System.out.print("  Apellido1: ");
                    String apellido1=teclado.nextLine();
                    System.out.print("  Apellido2: ");
                    String apellido2=teclado.nextLine();
                    System.out.print("  email: ");
                    String email=teclado.nextLine();

                    miBiblio.addAutor(nombre1,nombre2,apellido1,apellido2,email);
                    
                    break;

                case 2:
                    System.out.println("");
                    miBiblio.listarAutores();
                    System.out.println("\nAñadiendo un libro...");
                    System.out.println("");
                    System.out.print("  Titulo: ");
                    String titulo=teclado.nextLine();
                    System.out.print("  Año: ");
                    int año=Integer.parseInt(teclado.nextLine());
                    System.out.print("  Autor (codigo): ");
                    int codAutor=Integer.parseInt(teclado.nextLine());    
                    
                    miBiblio.addLibro(titulo, año, codAutor);
                    
                    break;

                case 3:
                    miBiblio.listarLibros();
                    break;

                case 4:
                    miBiblio.listarAutores();
                    break;

                case 5:
                    System.out.print("Referencia a prestar: ");
                    ref=teclado.nextLine();
                    if (miBiblio.prestarLibro(ref)==false)
                        System.out.println("Error al prestar libro");
                    break;
                case 6:
                    System.out.println("");
                    miBiblio.listarLibros();
                    System.out.print("\nReferencia a devolver: ");
                    ref=teclado.nextLine();
                    
                    if (miBiblio.devolverLibro(ref)==false)
                           System.out.println("ERROR al devolver libro");
                    
                    break;
    
                case 7:
                    break;
                default:
                    System.out.println("Opción no valida");
            }

        } while (opcion != 7);
        
        
        
        
        
        
    
    }
    
    
    
}
