
import PaqueteLectura.GeneradorAleatorio;

public class Ejercicio4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       GeneradorAleatorio.iniciar();
       String nombre;
       int dni;
       int edad;
     //  int nroHab = 5;
       int n = 10;
       Hotel hotel = new Hotel(n); // le paso las habitaciones que tiene el hotel (n)}
       // Creo el cliente
      // Cliente cliente = new Cliente("Juan",410567903,28);
       Habitacion habitacion = new Habitacion();
       
       // Agregar clientes a las hab:
       for(int i = 0; i < n; i++){
           nombre = GeneradorAleatorio.generarString(10);
           dni = GeneradorAleatorio.generarInt(40324565);
           edad = GeneradorAleatorio.generarInt(100);
           Cliente cliente = new Cliente(nombre,dni,edad);
           hotel.agregarHabitacion(cliente, i);
       }
       
       System.out.println(hotel.toString());
       // Aumento el costo de las hab:
       hotel.aumentarCosto(100);
       // Vuelvo a mostrar el hotel:
       System.out.println(hotel.toString());
       
    }

    
}
