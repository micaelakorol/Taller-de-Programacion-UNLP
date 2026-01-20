
public class Investigadores {
    private String nombre;
    private int categoria;
    private Subsidio subsidio [];
    private String especialidad;
    private int cont;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    public Investigadores(String nombre, int categoria, String especialidad ){
        this.nombre = nombre;
        this.categoria = categoria;
        this.especialidad = especialidad;
        this.subsidio = new Subsidio [5]; // max 5 subsidios. -> creé el vector con sus pos en null.
        this.cont = 0; // dimL
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){
        if(cont < 5){
            subsidio[cont] = unSubsidio;
            cont++;
        }
    }
    
    // Acá recorro los subsidios y obtengo los montos:
    // Si siempre uso cont para recorrer el array, No hace falta chequear null, porque las posiciones de 0 a contarSubsidios-1 siempre contienen objetos válidos.
   // cont siemre hace que recorra las pos que tienen algo. No hace falta chequear null.
    // Recorres solo tus propios subsidios.
    public double dineroTotalOtorgado(){
     double total = 0;
     for(int i = 0; i < cont; i++){
         if(subsidio[i].isOtorgado()){
             total = total + subsidio[i].getMonto();
         }
     }
      return total;  
}
    //Cada objeto Investigadores sabe su nombre (this.nombre).
    // Si coincide, otorga todos sus subsidios; si no, no hace nada.
    public void otorgarTodos(String unNombre){
        if(this.nombre.equals(unNombre)){
            // Si el nombre coincide, recorro todos los subsidios:
            for(int i = 0; i < cont; i++){
                if(!subsidio[i].isOtorgado()){
                    subsidio[i].setOtorgado(true); // Si isOtorgado = false, lo cambia a true.
                }
            }
        }
    }
    
    public String toString(){
        String aux = " Nombre " + this.nombre + " categoria " + this.categoria + " especialidad " + this.especialidad + " dinero otorgado " + this.dineroTotalOtorgado();
        return aux;
    }
    
}
