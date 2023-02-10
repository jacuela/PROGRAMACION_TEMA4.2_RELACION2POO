/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;

/**
 *
 * @author juan.antonio
 */
public class Utilidades {
    
    //private static
    private static ArrayList<String> listaCodigos=new ArrayList();
    
    
    //=============================================================

    public static boolean checkEmail(String email){
        
        //Lo hago a lo fácil
        if (    email.contains("@") && 
                email.contains(".") &&
               (email.indexOf("@")<email.indexOf("."))
           ){
            return true;
        }
        else{
            return false;
        
        }
        
    }
    
    //=============================================================
    
    
    
    //Método que genera un codigo del tipo LLDDD
    //sinedo L una letra y D un dígito
    public static String generarCodigoLibro(){
        
        String codigo;
        
        char letra1,letra2;
        int digito1,digito2,digito3;
       
       do{ 
        
            //Genero letra entre A....Z 
            letra1=(char)((int)(Math.random()*26 +65));
            letra2=(char)((int)(Math.random()*26 +65));
            digito1=(int)(Math.random()*10);
            digito2=(int)(Math.random()*10);
            digito3=(int)(Math.random()*10);

            //Construyo la cadena de forma LLDDD
            // XD456 
            StringBuilder sb=new StringBuilder();
            sb.append(letra1);
            sb.append(letra2);
            sb.append(digito1);
            sb.append(digito2);
            sb.append(digito3);
            codigo=sb.toString();
       
       }while ( codigoUsado(codigo)==true);   
            
       //Si llego aquí, el codigo es bueno     
       listaCodigos.add(codigo);
       return codigo;
        
    }
    
    //=============================================================

    
    private static boolean codigoUsado(String codigo){
         
         for (int i = 0; i < listaCodigos.size(); i++) {
             if (listaCodigos.get(i).equals(codigo))
                 //codigo ya asignado a un libro
                 return true;
         }
         return false;
     }
    
    
    
}
