/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import PaqueteLectura.GeneradorAleatorio;

public class Persona {
    private String nombre;
    private int DNI;
    private int edad; 
    
    public Persona(String unNombre, int unDNI, int unaEdad){
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad; 
    }
    
    public Persona(){
     
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int unDNI) {
        DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    // Sobreescribo el metodo toString:
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años.";
        return aux;
    }
    
    
      // Método main para probar - La class va fuera del MAIN
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar(); // inicio el generador
        String nombre = GeneradorAleatorio.generarString(10); // guardo los valores q me genera en una var.
        int dni = GeneradorAleatorio.generarInt(41067901);
        int edad = GeneradorAleatorio.generarInt(100);
        
        // Creo el objeto con los valores aleatorios:
        Persona persona = new Persona(nombre,dni,edad);
        // Llamo al metodo toString() ya modificado;
       System.out.println(persona.toString());
       
       // Carga de Vector con dimL, guardar un objeto en vector, declarar v. de objetos.
       
       // Ejercicio 2. ---------------------------------------------------------------------
       int dimL = 0; 
       int dimF = 15;
       Persona [] personas; // declaro el vector de a lo sumo personas
       personas = new Persona[dimF];
       
       //Forma2. Declaro e inicializo al mismo tiempo: Persona[] personas = new Persona[15];  
      // Cargo los datos al vector con dimF: 
      
      while(edad != 0 && dimL < dimF){ // dimF 15 VA DE -> 0 - 14 pos 
           nombre = GeneradorAleatorio.generarString(10);
           dni = GeneradorAleatorio.generarInt(41067901);
          Persona persona2 = new Persona(nombre,dni,edad);
          personas[dimL] = persona2; // Guardo la persona en el vector.
          dimL = dimL + 1; // O DIML ++ 
          edad = GeneradorAleatorio.generarInt(100); // Genero la nueva edad    
      }
     // Imprimir todas las personas generadas
for (int i = 0; i < dimL; i++) {
    System.out.println(personas[i]);
}
    }
}
