
public class Corista extends Persona{
    private int tono;
       
    public Corista(String nombre, int dni, int edad, int tono){
        super(nombre,dni,edad);
        this.tono = tono;
    }

    public int getTono() {
        return tono;
    }
    
    public String toString(){
        return super.toString() + "Tono " + getTono();
    }
   
}
