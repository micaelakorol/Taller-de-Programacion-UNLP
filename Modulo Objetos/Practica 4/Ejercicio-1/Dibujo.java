
public class Dibujo {
  private String titulo; 
  private Figura [] vector; // Inicializar la variable vector 
  private int guardadas; 
  private int capacidadMaxima=10; 
 
  //inicia el dibujo, sin figuras    
  public Dibujo (String titulo){ 
    this.titulo = titulo;
    vector = new Figura[capacidadMaxima];  // Creo el vector vacío
    guardadas = 0;
  } 
     
  //agrega la figura al dibujo 
  public void agregar(Figura f){ 
      //completar 
    if(guardadas < capacidadMaxima){
        vector[guardadas] = f; 
        guardadas++;
      System.out.println("la figura"+ 
                        f.toString() +  "se ha guardado"); 
    }
  } 
     
  //calcula el área del dibujo: 
  //suma de las áreas de sus figuras 
  //public double calcularArea(){ 
      //completar 
      // Recorro el vector y sumo todas sus áreas llamando a calcularArea?
  //} 
 
  //sigue a la derecha ->
    //imprime el título, representación 
  //de cada figura, y área del dibujo 
  public void mostrar(){ 
      //completar 
  } 
 
  //retorna está lleno el dibujo           
  public boolean estaLleno() { 
    return (guardadas == capacidadMaxima); 
  }   
} 
