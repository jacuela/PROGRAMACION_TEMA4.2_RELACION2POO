/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6;

import java.util.Scanner;

/**
 *
 * @author Juan Antonio Cuello Alarcon
 */
public class MenuInicio {

      
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
          Scanner teclado = new Scanner(System.in);
        int opcion;
        String ref;
        String tecla;
        int cantidad;
        Producto p;
        
        
        
        Ferreteria ferreteria = new Ferreteria("Ferreteria LORCA");

        //   *******  DATOS PARA INICIALIZAR EL PROGAMA  ****************
        ferreteria.nuevoProducto("Pilas alcalina", 2, 20);
        ferreteria.nuevoProducto("Destornillador", 5, 20);
        ferreteria.nuevoProducto("Sarten", 35, 20);
        ferreteria.nuevoProducto("Bombilla", 5, 5);
        //   ***********************************************************
        
        

        
        do {
            System.out.println("");
            System.out.printf("=== %s  - TPV ===\n",ferreteria.getNombre());
            System.out.println("1. Nueva venta");
            System.out.println("2. Listado de ventas");
            System.out.println("3. Gestion almacen");
            System.out.println("4. Salir");
            System.out.println("===============================");
            System.out.print("Dime tu opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch (opcion) {
                case 1:
                    System.out.println("\n\nCreando una nueva venta...");
                    Venta venta=ferreteria.nuevaVenta();
                    
                    ferreteria.listadoReferencias();

                    do{

                        //Pido los datos del cliente
                        System.out.print(">Referencia del producto [INTRO para fin]: "); 
                        ref=teclado.nextLine();

                        if (!ref.equals("")){
                            do{
                                ref="REF"+ref;
                                p=ferreteria.buscarProducto(ref);
                                if (p==null) {
                                    System.out.println("  -ERROR: no existe dicha referencia");
                                    System.out.print(">Nº Referencia del producto [INTRO para fin]: "); ref=teclado.nextLine();
                                }

                            }while (p==null);

                            do{
                                System.out.print("Cantidad:"); 
                                cantidad=Integer.parseInt(teclado.nextLine());
                                if (p.getUnidades()<cantidad){
                                   System.out.println("  -ERROR: disponible: "+p.getUnidades()+"unidades");
                                }                               
                            }while(p.getUnidades()<cantidad);
                            
                            venta.añadirLinea(p, cantidad);
                        }
                    
                    }while(!ref.equals(""));
                    
                    venta.imprimirVenta();
                    System.out.println("- Pulse INTRO para continuar -");tecla=teclado.nextLine();
                    break;
                
                case 2:
                    ferreteria.mostrarVentas();
                    break;
                
                case 3:
                    
                    submenuAlmacen(ferreteria);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("ERROR. Opcion no valida");
                    break;
            }
        } while (opcion != 4);
    }
    
    
    private static void submenuAlmacen(Ferreteria f) {
    
        Scanner teclado = new Scanner(System.in);
        int opcion, num,num_destino;
        System.out.println("");System.out.println("");
        String tecla;
        String descripcion,ref;
        double precioUnidad;
        int cantidad;
        Producto p;
        
        do {
            f.mostrarAlmacen();
            System.out.println("1. Nuevo producto");
            System.out.println("2. Añadir stock");
            System.out.println("3. Volver");
            System.out.println("========================");
            System.out.print("Dime tu opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch (opcion) {
                case 1:
                    //******** Creando un nuevo producto
                    System.out.print(">Descripcino: ");
                    descripcion=teclado.nextLine();
                    System.out.print(">Precio de cada unidad €: ");
                    precioUnidad=Double.parseDouble(teclado.nextLine());
                    System.out.print(">Stock inicial: ");
                    cantidad=Integer.parseInt(teclado.nextLine());
                    f.nuevoProducto(descripcion, precioUnidad, cantidad);
                    System.out.println("");
                    break;
                
                case 2:
                    boolean operacionOK;
                    do{
                        System.out.print(">Num Referencia del producto: ");
                        ref = teclado.nextLine();
                        ref = "REF" + ref;
                        
                        System.out.print(">Cantidad:");
                        cantidad = Integer.parseInt(teclado.nextLine());
                        
                        operacionOK=f.añadirStock(ref, cantidad);
                        
                    } while (operacionOK==false);
                    
                    break;
     
                case 3:
                    //System.out.println("VOLVIENDO...");
                    break;
                default:
                    System.out.println("ERROR. Opcion no valida");
                    break;
            }

        } while (opcion != 3);
        
    
    
    
    }
    
    
}
