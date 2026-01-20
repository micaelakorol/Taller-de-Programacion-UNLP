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
public class ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              GeneradorAleatorio.iniciar();
      int [][] matriz = new int [5][4]; // clientes x aspecto
      int cliente;
      int puntaje;
      
      for(int i = 0; i < 5; i++){ // cliente
          for(int j = 0; j < 4; j++){ // puntaje
              cliente = GeneradorAleatorio.generarInt(5); // 0..4 incluido
              puntaje = GeneradorAleatorio.generarInt(10) + 1; // puede ser del 1 al 10.
              matriz[i][j] = puntaje;
          }
      }
      
   // Se muestra: Atención, comida , precio y ambiente.
    for(int i = 0; i < 5; i++){
        for(int j = 0; j < 4; j++){
            System.out.print(matriz[i][j] + "\t");
        }
        System.out.println();
    }
    }
    // imprima la calificación  promedio obtenida por cada aspecto.
    // sumar columna 0 y sacar promedio; sumar columna 1 y sacar promedio (asi sucesivamente)
    // para imprimir: i+1; j+1.
}
