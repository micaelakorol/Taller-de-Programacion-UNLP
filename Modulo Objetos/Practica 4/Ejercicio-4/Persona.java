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
public class Persona {
    private String nombre;
    private Fecha fecha;
    
    public Persona(String nombre, Fecha fecha){
        this.nombre = nombre; 
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFecha() {
        return fecha;
    }
    
        public Persona(String nombre){
        this.nombre = nombre; 
        this.fecha = null;
    }
    
}
