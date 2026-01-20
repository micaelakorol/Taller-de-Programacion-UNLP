/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;

public class Partido {
    private String local;
    private String visitante;
    private int golesLocal; 
    private int golesVisitante;
    
    public Partido(){
    
    }

    public Partido(String unLocal, String unVisitante, int unGolLocal, int unGolVisitante){
        local = unLocal;
        visitante = unVisitante;
        golesLocal = unGolLocal;
        golesVisitante = unGolVisitante;
    }

    
    public String getLocal() {
        return local;
    }

    public String getVisitante() {
        return visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setLocal(String unEquipo) {
        local = unEquipo;
    }

    public void setVisitante(String unEquipo) {
        visitante = unEquipo;
    }

    public void setGolesLocal(int unosGoles) {
        golesLocal = unosGoles;
    }

    public void setGolesVisitante(int unosGoles) {
        golesVisitante = unosGoles;
    }
    
    public boolean hayGanador(){
         return (golesLocal!=golesVisitante); 
    }
    
    public boolean hayEmpate(){
         return ((golesLocal==golesVisitante));
    }
    
    public String getGanador(){
         String ganador=new String();
         if (golesLocal>golesVisitante){
             ganador = local;
         }
         else {
             if (golesLocal<golesVisitante){
                 ganador = visitante;
             }
         }
         return ganador;
    }	    
    
 @Override
public String toString() {
    return "Partido: " + local + " (" + golesLocal + ") vs " + visitante + " (" + golesVisitante + ")";
}

    
    
     public static void main(String[] args) {
       GeneradorAleatorio.iniciar();
       int dimL = 0;
       int dimF = 20;
       Partido [] vPartidos = new Partido[dimF];
       String nombreVisitante = GeneradorAleatorio.generarString(5);
       String nombreLocal;
       int golesLocal;
       int golesVisitante;
  
      while(!nombreVisitante.equals("ZZZ") && dimL < dimF){
       nombreLocal = GeneradorAleatorio.generarString(5);
       golesLocal = GeneradorAleatorio.generarInt(10);
       golesVisitante = GeneradorAleatorio.generarInt(10);
       // Genero el objeto:
       Partido p = new Partido(nombreVisitante,nombreLocal,golesLocal,golesVisitante);
       vPartidos[dimL] = p;
       dimL++; 
       nombreVisitante = GeneradorAleatorio.generarString(5);
      }
       
      for (int i = 0; i < dimL; i++) {
    System.out.println(vPartidos[i].toString()); 
    // Esto llama implícitamente a vPartidos[i].toString()
    // automáticamente se ejecuta tu toString() sobrescrito
}

       
     }
}
