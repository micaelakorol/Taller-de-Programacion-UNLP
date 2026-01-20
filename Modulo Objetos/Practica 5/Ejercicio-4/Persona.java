
public class Persona {
    private String nombre;
    private int dni;
    private int edad;
    
    public Persona(String nombre, int dni, int edad){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }
    
    public String toString(){
        return "Nombre " + getNombre() + "DNI " + getDni();
    }
    
}

