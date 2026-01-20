
public class CoroSemi extends Coro{
    private Corista[] corista;
    private int dim;
    private int pos = 0;

        public CoroSemi(String nombre, Director director, int dim){
        super(nombre,director);
        this.dim = dim;
        this.corista = new Corista [dim];
    }
        // el nombre recibido por param debe ser != al del array.
    public void agregarCorista(Corista uncorista){
        // rellenar de izq a derecha
       // vamos agregando uno a uno.
       if(pos < dim){
         corista[pos] = uncorista;
        pos++;
       }
    }
    
  public boolean estaLleno() {
    return pos == dim;
}
  
  public String toString(){
      String aux = super.toString() + " Corista " + " ";  // toString de director
      for(int i = 0; i < pos; i++){
          aux += corista[i].toString();
      }
      return aux;
  }// no debemos chequear null porque como tenemos dim , el vector deberia estar lleno.

}
