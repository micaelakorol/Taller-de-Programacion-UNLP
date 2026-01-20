
// Abstracción: la clase base (Coro) debe contener solo lo que es común a todos los coros
abstract public class Coro {
    private Director director;
    private String nombre;
    // El objeto DIRECTOR no lo enviamos por parametros en el constructor, agregamos mostramos con get  yset,
    public Coro(String nombre, Director director){
        this.director = director;
        this.nombre = nombre;
    }

    public Director getDirector() {
        return director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public abstract void agregarCorista(Corista corista);  // es abstracto pq tiene dif implementaciones.   
     public abstract boolean estaLleno();  // es abstracto pq tiene dif implementaciones.   
     

public String toString() {
    return "Coro: " + nombre + ", Director: " + director.toString();
}

   
}
