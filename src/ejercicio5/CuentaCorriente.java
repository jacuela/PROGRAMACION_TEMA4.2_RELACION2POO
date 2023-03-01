/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author jacuela
 */
public class CuentaCorriente {
    
    private int numero;
    private Cliente titular;
    private double saldo;

    private static int contadorNumeroCuenta=1001;
    
    public CuentaCorriente(Cliente titular, double saldo_inicial) {
        this.titular = titular;
        this.saldo = saldo_inicial;
        this.numero=CuentaCorriente.contadorNumeroCuenta;
        CuentaCorriente.contadorNumeroCuenta++;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //*****************************************
    
    public void ingreso(double importe){
        this.saldo=this.saldo+importe;
    }
    
    public boolean reintegro(double importe){
        if (importe>this.saldo){
            System.out.println("  >ERROR, saldo insuficiente (SALDO ACTUAL:"+this.saldo+")");
            return false;
        }
        else{
            this.saldo=this.saldo-importe;
            return true;
        }
    }
    
    public boolean transferencia(CuentaCorriente cuentaDestino,double importe){
        
        if (this.reintegro(importe)==true){
            cuentaDestino.ingreso(importe);
            return true;
        }else{
            return false;
        }
        
    }
    
    public String aCadena(){
        return String.format("CC: %5s %10.2f€    [%9s %s]",numero,saldo, titular.getDNI(), titular.getNombre()+" "+titular.getApellidos());
    }
    
    
}
