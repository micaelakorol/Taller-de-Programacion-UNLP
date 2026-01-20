
public class CoroHileras extends Coro{
    private Corista[][] corista; // Declaramos la matriz cuadrada.
    private int dim;
    private int pos = 0;
    private int col = 0; 
    private int contador = 0;
    
    public CoroHileras(String nombre, Director director, int dim){
        super(nombre,director);
        this.dim = dim;
        this.corista = new Corista [dim][dim];
    }

    // Esto esta mal, rompe el encapsulamiento pq la persona puede acceder modificar al array completo.
    // En lugar de devolver toda la matriz, podrías dar acceso solo a un corista específico:
/*    public Corista[][] getCorista() {
        return corista;
    }*/
    
    // Esto estaría mejor:
    public Corista getCorista(int fila, int columna) {
    if (fila >= 0 && fila < dim && columna >= 0 && columna < dim) {
        // retorna de a un corista.
        // Así nadie puede reemplazar toda la matriz, solo acceder a elementos individuales.
        return corista[fila][columna];
    }
    return null;
}


    public int getDim() {
        return dim;
    }

    public void setCorista(Corista[][] corista) {
        this.corista = corista;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }
    // Agrego de izq a derecha [0][0] , [0] [1] ....
  public void agregarCorista(Corista uncorista){
    if (pos < dim && col < dim) {                   // si aún hay fila disponible
        corista[pos][col] = uncorista;
        col++;                         // pasamos a la siguiente columna
        contador++;
        if (col >= dim) {              // si se llenó la fila
            col = 0;                   // reiniciamos columna
            pos++;                       // pasamos a la siguiente fila
        }
    } else {
        System.out.println("El coro está lleno.");
    }
}

    
    public boolean estaLleno(){
       int aux = dim * dim;
       boolean ret = false;
       if(aux == contador){
           ret = true;
       }
       else {
           ret = false;
       }
       return ret;
    }
    /*public boolean estaLleno(){
    return contador == dim * dim;
} Otra forma.
*/
    // se supone que todas las posiciones estan ocupadas, no deberia preg por nul.
    public String toString(){
        String aux = super.toString() + " Corista " + " ";  // toString de director
           // Filas completas
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                aux += (corista[i][j] != null ? corista[i][j].toString() : "vacío") + " | ";
            }
            aux += "\n";
        }

        // Arreglar, no anda la representacion del corista.
     return aux;
    }
}

// Agregar un director con setDirector(...) no recibiendo el objeto por parametros en el constructor.
