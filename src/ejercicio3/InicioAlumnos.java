/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;

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
    
}
