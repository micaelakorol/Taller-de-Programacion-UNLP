public class Cliente {
    private String nombre;
    private int dni;
    private int edad;
    
    public Cliente(String nombre, int dni, int edad){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }
   @Override 
    public String toString(){
        return "Nombre " + this.nombre + " "+ "DNI " + " " + this.dni + " ";
    }
    
}
// Podes no crear esta clase y reusar persona del ejercicio anterior como indica el ejercicio.