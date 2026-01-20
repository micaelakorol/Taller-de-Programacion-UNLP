/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4.ejercicio4;

/**
 *
 * @author Micae
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            Fecha unafecha = new Fecha (9);
            
    Persona p = new Persona ("Micaela", unafecha);
    p.getFecha().setDia(9);
    System.out.println(unafecha.setDia(5));
    }
    
}
