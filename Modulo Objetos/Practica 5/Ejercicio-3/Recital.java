
abstract public class Recital {
    private String nombreBanda;
    private String temas [];
    private int cantTemas;
    private int pos = 0;
    
    public Recital(String nombreBanda, int cantTemas){
        this.nombreBanda = nombreBanda;
        this.cantTemas = cantTemas;
        this.temas = new String [cantTemas]; // temas
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public int getCantTemas() {
        return cantTemas;
    }
 // Retorna solo u ntema. // Evita que la otra clase acceda al arreglo completo.
    // Si no, rompe el encapsulamiento al mostrar el array completo.
   public String getTemas(int indice) {
       return this.temas[indice];
    }
   

   public void agregarTema(String tema){
       if(pos < this.cantTemas){
           temas[pos] = tema;
           pos++;
         //  aux = "Agregado";
       }
   };
  abstract public String actuar();
  
  public String imprimirTemas(){
      String aux = "";
      for(int i = 0; i < pos; i++){
            aux+=(" Tema: " + (i+1) + temas[i]);            
      }
      return aux;
  }
   
}
