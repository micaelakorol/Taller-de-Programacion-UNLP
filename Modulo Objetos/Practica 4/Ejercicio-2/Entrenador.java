
public class Entrenador extends Empleado{
    private int campGanados;
    
    public Entrenador(String nombre, int sueldoBasico, int antiguedad, int campGanados){
        super(nombre, sueldoBasico, antiguedad);
        this.campGanados = campGanados;
    }

    public int getCampGanados() {
        return campGanados;
    }

    public void setCampGanados(int campGanados) {
        this.campGanados = campGanados;
    }
    
    public double calcularEfectividad(){
        return getAntiguedad() + this.campGanados ;
    }
    
    
    public double calcularSueldoACobrar(){
        // Uso la implementación base y luego le agrego reglas adicionales en la subclase
        double sueldo = super.calcularSueldoACobrar();
        if(this.campGanados > 1 && this.campGanados < 4){
            sueldo = sueldo + 5000;
        }else 
            if(this.campGanados > 5 && this.campGanados < 10){
                sueldo = sueldo + 30000;
            }else
                if(this.campGanados > 10){
                    sueldo = sueldo + 50000;
                }
        return sueldo;
    }
    
        public String toString(){
        String aux = super.toString()+  " " + this.calcularSueldoACobrar() + " " + this.calcularEfectividad();
        return aux;
    }
    
}
