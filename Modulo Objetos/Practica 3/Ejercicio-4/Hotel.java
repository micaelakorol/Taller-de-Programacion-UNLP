
public class Hotel {
    private int n;
    private Habitacion [] habitacion;
    
    // Pongo entre () lo que voy a enviar cuando instancie el objeto con new.
    public Hotel(int n){
        this.n = n;
        habitacion = new Habitacion [n]; // Creé el vector, puedo hacer new = null
        iniciarVector(); // Importnte pq si no da error "at tema3.Hotel.agregarHabitacion(Hotel.java:38)" "NullPointerException"

        // Inicializo cada una desocupada
        // Hacer un for de i hasta n - 1 y poner null en sus posiciones.
    }
    
 private void iniciarVector(){
    for(int i = 0; i < n; i++){
        habitacion[i] = new Habitacion(); // Cada posición del array es un nuevo objeto Habitacion
        // Creé las habitaciones.
        // si hago:  habitacion[i] = null; // Si solo hago esto no hay objeto aún, significa que la habitación está vacía
    }
}
 
 
 public void agregarHabitacion(Cliente cliente, int nroHab){
     //¿Donde agrego al vector? -> en donde esté declarado.
     // Accedo a la habitacion
     // Le agrego el cliente con setCliente
     // pongo a true ocupada.
    habitacion[nroHab].setCliente(cliente); // agrego el cliente.
    habitacion[nroHab].setOcupada(true);
 }
 
 public void aumentarCosto(double aumento){
     for(int i = 0; i < this.n; i++){
         double nuevoCosto = habitacion[i].getCosto() + aumento;
         habitacion[i].setCosto(nuevoCosto);
     }
 }
    
 public String toString(){
     String aux = "";
     // Return no puede ir dentro de for.
   for(int i = 0; i < this.n; i++){
        aux += "Habitación " + (i + 1)
         + " | Costo: " + habitacion[i].getCosto()
         + " | Ocupada: " + habitacion[i].estaOcupada()
         + " | Cliente: " + habitacion[i].getCliente(); // obtiene el toString del cliente.
   }
   return aux;
 }
 
 
}
