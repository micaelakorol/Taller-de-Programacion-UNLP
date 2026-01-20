
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String toString(){
        // Se hce con get esto? o es valido usar this?
        String aux = " Mi nombre es " + this.nombre + " mi DNI es " + this.dni + " y tengo " + this.edad + "años. ";
        return aux;
    }
    
}
