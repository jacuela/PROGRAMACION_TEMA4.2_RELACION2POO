/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5_enclase;

/**
 *
 * @author Juan Antonio Cuello Alarcon <juanantonio.cuello@murciaeduca.es>
 */
public class CuentaCorriente {
    private final int numero;
    
    private Cliente titular;
    private double saldo;
    
    private static int contadorNumero = 1001;
    
    public CuentaCorriente (Cliente titular, double saldoInicial){
        this.numero = CuentaCorriente.contadorNumero;
        CuentaCorriente.contadorNumero++;
        
        this.titular = titular;
        this.saldo = saldoInicial;
        
    }
    
    public void ingreso(double cantidad){
        this.saldo = this.saldo + cantidad;
    }
    
    public boolean reintegro(double cantidad){
        if (this.saldo < cantidad){
            System.out.println("ERROR, saldo insuficente");
            return false;
        }
        else{
            this.saldo = this.saldo - cantidad; 
            return true;
        }
    }
    
    public boolean transferencia (CuentaCorriente cuentaDestino, double cantidad){
       
        if (this.saldo < cantidad){
            System.out.println("ERROR, saldo insuficente. No puedo hacer la transferencia");
            return false;
        }
        else{
            //hay saldo
            this.saldo = this.saldo - cantidad;
            cuentaDestino.ingreso(cantidad);
            return true;
        }
    }
    
    public String aCadena(){
        return String.format("CC: %4d %10.2f   [%6s %s]",this.numero,this.saldo,
                                                this.titular.getDNI(),
                                                this.titular.getNombre());
        
    }
    
    
    //Getter and Setter

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
    
    
    
    
   
    
}
