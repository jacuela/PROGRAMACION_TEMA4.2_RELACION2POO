/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author paula.tudela y Cuello
 */
public class Jugador {
    
    private String nombre;
    private int dorsal;
    private boolean fichado;

    public Jugador(String nombre, int dorsal) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.fichado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public boolean isFichado() {
        return fichado;
    }

    public void setFichado(boolean fichado) {
        this.fichado = fichado;
    }
    
    @Override
    public String toString(){
        if (fichado){
            return String.format("[%2d] %10s \033[31mFICHADO\033[30m",this.dorsal,this.nombre);
        }
        else{
            return String.format("[%2d] %10s \033[32mLIBRE\033[30m",this.dorsal,this.nombre);

        }
    }
    
}
