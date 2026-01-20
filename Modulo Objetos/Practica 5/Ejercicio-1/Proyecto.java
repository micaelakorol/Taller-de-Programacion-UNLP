
public class Proyecto {
    private String nombre;
    private int codigo;
    private String director;
   // private int max;
    private int contarInvestigadores; // dimL
    private Investigadores investigadores []; // Array de investigadores
    
    
    // Crear el array con new y poner la dimL en 0.
    // El vector solo va en parametros del constructor , solo cuando no se cuantos elementos tiene, digamos
    // solo va cuando el usuario define que el vector tiene "n" posiciones.
    public Proyecto(String nombre, int codigo, String director){
        this.nombre = nombre;
        this.codigo = codigo;
        this.director = director;
        this.contarInvestigadores = 0;
        this.investigadores = new Investigadores [50]; // En este punto creé el vector vacío. No puedo acceder a sus posiciones.
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDirector() {
        return director;
    }

    public int getContarInvestigadores() {
        return contarInvestigadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setContarInvestigadores(int contarInvestigadores) {
        this.contarInvestigadores = contarInvestigadores;
    }
    
    
    public void agregarInvestigador(Investigadores unInvestigador){
        // lo correcto es hacerlo directamente con la posición que manejás con la variable dimL
        // El for se usaría si tuvieras que recorrer el array buscando un lugar libre o haciendo un cálculo
        // Tambien puedo declarar una variable max = 50;
       if(this.contarInvestigadores < 50){
           investigadores[contarInvestigadores] = unInvestigador;
       }
    }
    
    // Comienzo recorriendo el array de investigadores:
    // Cada Investigador tiene un método que ya sabe calcular su total otorgado de subsidios dineroTotalOtorgado()
    // Proyecto no necesita recorrer los subsidios individuales, solo llama a ese método de cada investigador y suma los resultados.
    public double dineroTotalOtorgado() {
      double montoTotal = 0;
      for(int i = 0; i < contarInvestigadores; i++){
         montoTotal = montoTotal + investigadores[i].dineroTotalOtorgado();
      }
      return montoTotal;
    }
    
  
    
    public void OtorgarTodos(String nombreCompleto){
        // Aca solo invoco al metodo OtorgarTodos de investigadores y el hará lo que debe hacer.
        for(int i = 0; i < contarInvestigadores; i++){
          investigadores[i].otorgarTodos(nombreCompleto);
        }
    }
    
    public String toString(){
        String aux = "Nombre proyecto " + this.nombre + " codigo " + this.codigo + " director " + this.director + this.dineroTotalOtorgado();
        return aux;
    }
    
    
}
