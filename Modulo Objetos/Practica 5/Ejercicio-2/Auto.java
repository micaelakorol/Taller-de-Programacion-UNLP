
public class Auto {
    private int patente;
    private String nombre;
    
    
    // Constructor para cuando tienes los datos del auto real.
    public Auto(int patente, String nombre){
        this.patente = patente;
        this.nombre = nombre;
    }

    public int getPatente() {
        return patente;
    }

    public String getNombre() {
        return nombre;
    }
    
    // Constructor vacío, para inicializar la matriz con objetos VACÍOS y evitar null en las plazas.
    public Auto(){
        this.patente = -1;      // usamos -1 para chequear que esta vacío, ya que inicializamos el consteuctor con objetos vacios (y eso ya no es null.)
        this.nombre = "";       // cadena vacía
    }
    
      // Representación del auto
    public String toString() {
        return "Patente: " + patente + ", Dueño: " + nombre;
    }
}
