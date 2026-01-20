/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Micae
 */
public class Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String l1;
        String l2;
        
        l1 = "...";
        l2 = "...";
        
        System.out.print(l1.equals(l2) ); // indica si el contenido es igual 
        System.out.print(l1 == l2 ); // indica si se trata de la misma instancia de objeto, es dcir, si estan en la misma dir.
    }   //Como no le hice new, apuntan a la misma direccion de memoria.
    
    /*
 En Java, un String es un objeto, no un tipo primitivo. Por eso hay que diferenciar entre:

La instancia del objeto → dónde está guardado en memoria (su referencia).

El contenido del objeto → el texto que tiene dentro.

String saludo1 = "...";
String saludo2 = "...";
    
Ambos apuntan a la misma instancia en memoria.

Por eso saludo1 == saludo2 devuelve true. 
    
String saludo1 = new String("...");
String saludo2 = new String("...");
    
new crea objetos distintos en memoria, aunque tengan el mismo texto.

Ahora saludo1 == saludo2 devolvería false. ❌
    
    
    
    */
    
}
