

/**
 *
 * @author Alumno
 */
public class Habitacion {
    private double costo;
    private boolean ocupada;
    private Cliente cliente;

    // Constructor
    public Habitacion(){
        this.ocupada = false;
        this.costo = 2000 + Math.random() * 6000;
        this.cliente = null;
    }

    // Getter y setter para costo
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo; // lo uso para aumentar el costo
    }

    // Getter y setter para ocupada
    public boolean estaOcupada() {
        return this.ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    // getCliente() devuelve el objeto Cliente
 // concatenarlo con un String o pasarlo a println() invoca automáticamente toString() del cliente.
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
