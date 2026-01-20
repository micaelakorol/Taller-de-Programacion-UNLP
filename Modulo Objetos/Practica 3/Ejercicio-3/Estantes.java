import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Micae
 */
public class Estantes {
    private Libro [] libros;
    private int cant;
    public Estantes(){
        libros = new Libro [20]; // Creo el vector
        cant = 0; // sin libros, equivale a la dimL. - corregido
       
    }
    
    // Métodos get y set.
    
    public int getCantidadLibros(){
        return cant; /// esto sería la dimL pero con diferente nombre.
    }
    
  public boolean estaLleno() {
    if (cant == 20) { // el vector va de 0 a 19.
        return true;
    } else {
        return false;
    }
}
// System.out.println() no devuelve un valor, su tipo es void.
  public boolean agregarLibro(Libro libro){
      if(cant < 20){
          libros[cant] = libro; // agrego el libro e incremento la posicion
          cant++;
          System.out.println("Agregado");
         return true;
      }else{
       System.out.println("No hay lugar");
       return false;
      }
  }
  // Cuando tengo que buscar, se refiere a recorrer el vector. 
  public String buscarPorTitulo(String titulo){
      boolean encontrado = false;
      int cont = 0;
      while(!encontrado && cont < this.cant){
          if(libros[cont].getTitulo().equals(titulo)){ 
              encontrado = true;
          }else{
              cont++;
          }
      }
      if(encontrado){
       return libros[cont].getPrimerAutor(); // retorno el autor
      }else{
          return "";
      }
  }
  
  // Voy creando libros y los pongo en los estantes.
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        String titulo;
        String editorial;
        int anio;
        String autor;
        String ISBN;
        int precio;
        Estantes estante = new Estantes(); // Debemos hacerlo antes de crear un objeto, si no estante no existe.
   
        int generar = 0;
        
        Libro libroMujercitas = new Libro(
    "Mujercitas",        // título
    "Roberto Arlt",      // editorial (podés cambiarlo si querés otra)
    1868,                // año de edición
    "Louisa May Alcott", // primer autor
    "1112223334",        // ISBN
    1200.0               // precio
);
  estante.agregarLibro(libroMujercitas);
        
        while(generar < 19){ // 20 lugares: 0 - 19; 
        titulo = GeneradorAleatorio.generarString(15);
        editorial = GeneradorAleatorio.generarString(10); 
        autor = GeneradorAleatorio.generarString(15);
        ISBN = GeneradorAleatorio.generarString(15);
        anio = GeneradorAleatorio.generarInt(2000);
        precio = GeneradorAleatorio.generarInt(9000);
        
        // Deben estar en orden, igual que en el constructor.
        // Podemos ponerlo dentro de un while.
        Libro libro3 = new Libro(titulo,editorial,anio,autor,ISBN,precio);
        estante.agregarLibro(libro3);   
        generar++;
        }  
     System.out.println(estante.buscarPorTitulo("Mujercitas"));
    } 
}


/**
 * C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que 
almacenen como máximo N libros? ¿Cómo instanciaría el estante?
 * El constructor recibiria "n" y el vector quedaria:
 * libros = new Libro [n]; 
 */