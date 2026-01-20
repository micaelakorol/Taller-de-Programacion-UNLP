
public class Trabajador extends Persona{
    private String tarea;
    
    public Trabajador(String nombre, int dni, int edad, String tarea){
        super(nombre,dni,edad);
        this.tarea = tarea;
        // Si quiero acceder a nombre, desde esta clase, debo hacer getNombre() ya que pertenece a persona y son private.   
    }
    
     // Getter de tarea
    public String getTarea() {
        return tarea;
    }

    // Setter de tarea
    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    
    public String toString(){
        String aux = super.toString() + "Soy" + " "  + this.tarea + " . ";
        return aux;
    }
    
}
