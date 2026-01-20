
public class Jugadores extends Empleado{
    private int partidosJugados;
    private int golesAnotados;
    
    public Jugadores(String nombre, int sueldoBasico, int antiguedad, int partidosJugados, int golesAnotados){
        super(nombre, sueldoBasico, antiguedad);
        this.golesAnotados = golesAnotados;
        this.partidosJugados = partidosJugados;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }
    
    public double calcularEfectividad(){
        return this.partidosJugados / this.golesAnotados ;
    }
    
    @Override 
    // Sobreescribimos el metodo heredado, pero antes , llamamos a calcularSueldoACobrar de la clase empleado para
    // guardar el cálculo base.
    public double calcularSueldoACobrar(){
       double sueldo = super.calcularSueldoACobrar(); // Ya tengo el base calculado en Empleado
       if(this.calcularEfectividad() > 0.5){ // Llamo a mi función calcularEfectividad (la de esta clase).
           sueldo = sueldo + getSueldoBasico(); // Si supera el promedio, le sumo otro sueldo basico.
       }
       return sueldo;
    }
   
    public String toString(){
        String aux = super.toString() + " " + this.calcularSueldoACobrar() + " " + this.calcularEfectividad();
        return aux;
    }
    
}
