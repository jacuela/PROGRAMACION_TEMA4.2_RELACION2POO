/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import Utilidades.Utilidades;

/**
 *
 * @author juan.antonio
 */
public class Libro {
    
    private String codigo;
    private String titulo;
    private Autor autor;
    private int año;
    private boolean prestado;

    public Libro(String titulo, Autor autor, int año) {
        this.codigo = Utilidades.generarCodigoLibro();
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.prestado=false;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    
    
        
    public void imprimir(){
        
        if (this.prestado==true){
            //Imprimo el libro con la marca de prestadp
            System.out.printf("\033[31mP  %5s - %15s (%d) - %s\033[30m\n",this.codigo,
                                             this.titulo,
                                             this.año,
                                             this.autor.getNombreCita());
        }
        else{
            //Imprimo el libro sin la marca
            System.out.printf("\033[32m   %5s - %15s (%d) - %s\033[30m\n",this.codigo,
                                             this.titulo,
                                             this.año,
                                             this.autor.getNombreCita());
            
        }
        
    }
    
}
