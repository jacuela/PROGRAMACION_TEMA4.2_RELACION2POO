/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author juan.antonio
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion;
        Scanner teclado=new Scanner(System.in);
        
        BD_Producto mibd=new BD_Producto();
        mibd.add("Leche Puleva",1.2);
        mibd.add("Chocolate",2);
        mibd.add("Pan",0.75);
        mibd.add("Agua 1.5L",1.5);
        
        mibd.add("Cerveza 1L",1);

        
        //mibd.listarProductos();
        
        Factura factura1=new Factura("B111111","2022-1",LocalDate.now());
        
        do {
            System.out.println("");System.out.println("");    
            //System.out.println("\033[34m****************************");
            //System.out.printf("\033[34m%14s - FACTURA \n", mibd..getNombre());
            //System.out.println("\033[34m****************************");
           
            System.out.println("\033[34m1.  Añadir linea");
            System.out.println("\033[34m2.  Imprimir factura");
            System.out.println("\033[34m3.  Lista productos");
            System.out.println("\033[34m4.  Añadir producto");
            System.out.println("\033[34m5.  Salir");
          
            System.out.print("Elige una opción: \033[30m");
            opcion = Integer.parseInt(teclado.nextLine());
            System.out.println("");

            switch (opcion) {
                case 1:
                    
                    System.out.println("\nAñadiendo lineas...");
                    System.out.println("--- INTRO PARA FINALIZAR ---");
                    mibd.listarProductos();
                    do{
                    
                        System.out.print("Referencia: ");
                        String ref=teclado.nextLine();
                        if (ref.equals(""))
                            break;
                        System.out.print("Cantidad: ");
                        int cantidad=Integer.parseInt(teclado.nextLine());

                        //Buscando producto por referencia
                        Producto p=mibd.buscar(ref);

                        //Añado la linea a la factura
                        if (p!=null){
                            factura1.añadirLinea(p, cantidad);
                            System.out.println("       ...linea añadida");
                        }    
                        else
                            System.out.println("!!ERROR, referencia no exite");
                    
                    }while(true); 
                    break;

                case 2:
                    System.out.println("\nImprimiendo factura...");

                    //Imprimo la factura
                    factura1.imprimir();
                    break;

                case 3:
                    mibd.listarProductos();
                    break;
                    
                case 4:
                    System.out.println("\nAñadiendo productos...");
                    System.out.println("--- INTRO PARA FINALIZAR ---");
                    do{
                    
                        System.out.print("Descripcion: ");
                        String descripcion=teclado.nextLine();
                        if (descripcion.equals(""))
                            break;
                        System.out.print("Precio Unidad: ");
                        int precioUnidad=Integer.parseInt(teclado.nextLine());

                        //Añado el producto
                        mibd.add(descripcion,precioUnidad);
                        System.out.println("       ...producto añadido");

                    }while(true); 
                    
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no valida");
            }

        } while (opcion != 5);
        
        
        
        
        
        
    }
    
}
