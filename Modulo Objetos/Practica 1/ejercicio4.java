/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Micae
 */
public class ejercicio4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int [][] matriz = new int [8][4];
        // Pensar que estos son los numeros que voy a poner en la matriz, y si tiene: 
        // [8][4] en la matriz va de: 0..7  , 0..3 , por eso para mostrarlo hacemos i+1, j+1;
        int piso = GeneradorAleatorio.generarInt(10); // 0 al 7 (recordar que 8 no existe, 0..7)
        int oficina = GeneradorAleatorio.generarInt(4); // 0 al 3 (recordar que 4 no existe, 0..3)
        // Ponemos el piso en 10 pq sino se me genera un loop infinito, nunca se hace 9 si lo pongo en 8.
        while(piso != 9){
            // el indice para agregar a la matriz es entre 0..7 y 0..3; Porque: [8][4]
            // ¿La pos es válida?
        if(piso <= 7 & oficina <= 3){
             matriz[piso][oficina]++; 
        }
        // Vuelvo a generar el piso y oficina:
         piso = GeneradorAleatorio.generarInt(10);
         oficina = GeneradorAleatorio.generarInt(4);
        }
        
        // Informar: Piso y oficina:
        
        for(int i = 0; i < 8; i++){
            for(int j= 0; j < 4; j++){
                 System.out.println("Piso " + (i+1) + " Oficina " + (j+1) + ": " + matriz[i][j]);
            }
        }
        
        
    }
    
}
