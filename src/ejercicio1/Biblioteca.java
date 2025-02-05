/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juan.antonio
 */
public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Autor> listaAutores;
    
    public Biblioteca(String nombre){
        this.nombre=nombre;
        listaLibros=new ArrayList();
        listaAutores=new ArrayList();
        
        inicializar();
        
        
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    private void inicializar(){
        Autor a1,a2;
        Libro l1,l2;
        
        a1=new Autor("John","Ronald","Tolkien",null,"tolkien@mail.com");
        listaAutores.add(a1);
        
        a2=new Autor("Juan",null,"Gomez","Jurado","jurado@mail.com");
        listaAutores.add(a2);
        
        listaLibros.add(new Libro("El señor A",a1,1957));
        listaLibros.add(new Libro("Reina Roja",a2,2018));
        
        
    }
    
    
    public void addAutor(String nombre1, String nombre2, String apell1, String apell2, String email){
        
        Autor nuevoAutor;
        
        if (nombre2.equals("")) nombre2=null;
        if (apell2.equals("")) apell2=null;
        
        nuevoAutor=new Autor(nombre1,nombre2,apell1,apell2,email);
        listaAutores.add(nuevoAutor);
        
    }
    
    
    public void addLibro(String titulo, int año, int codAutor){
        
        Libro nuevoLibro;
        
        //Busco el autor con el codigo escrito por teclado
        Autor autor=buscarAutor(codAutor);
        if (autor!=null){
            nuevoLibro=new Libro(titulo, autor, año);
            listaLibros.add(nuevoLibro);
        }    
        else
            System.out.println("ERROR, el autor no existe.");
        
        
    }
    
    public void listarAutores(){
        
        
        System.out.println("LISTA DE AUTORES EN LA BIBLIOTECA");
        System.out.println("================================");
                
        for (int i = 0; i < listaAutores.size(); i++) {
            System.out.print(listaAutores.get(i).getId());
            System.out.print(" - ");
            System.out.println(listaAutores.get(i).getNombreCita());
        }
        
    }
    
    public void listarLibros(){
        
        //System.out.println("LISTA DE LIBROS EN LA BIBLIOTECA");
        System.out.println("====================================================");
        for (int i = 0; i < listaLibros.size(); i++) {
            listaLibros.get(i).imprimir();
        }
        System.out.println("====================================================");
       
    }
    
    
    private Autor buscarAutor(int codigo){
        Autor autor;
        
        for (int i = 0; i < listaAutores.size(); i++) {
            autor=listaAutores.get(i);
            if (autor.getId()==codigo)
                return autor;
        }
        
        return null;
        
    }
    
    public boolean prestarLibro(String ref){
        Libro unLibro;
        
        for (Libro libro : listaLibros) {
            if (libro.getCodigo().equalsIgnoreCase(ref)){
                //He encontrado el libro a prestar
                //Compruebo que no esta ya prestado
                
                if (!libro.isPrestado()){
                    libro.setPrestado(true);
                    return true;
                }
                else{
                    System.out.println("\033[31mERROR: el libro ya está prestado\033[30m");
                    return false;
                }
                
            }  
        }
        
        //Si llego aquí, es porque no he encontrado el libro
        System.out.println("\033[31mERROR: no existe dicha referencia de libro\033[30m");
        return false;
        
        
    }
    
     public boolean devolverLibro(String ref){
        Libro unLibro;
        
        for (int i = 0; i < listaLibros.size(); i++) {
            unLibro=listaLibros.get(i);
            if (unLibro.getCodigo().equals(ref)){
                unLibro.setPrestado(false);
                return true;
            }    
        }
        //System.out.println("ref no encontrada");
        return false;
        
        
    }
    
    
     
     
     
     
     
    
    
    
    
    
}
