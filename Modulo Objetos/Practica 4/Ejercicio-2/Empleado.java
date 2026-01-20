
abstract public class Empleado {
    private String nombre;
    private int sueldoBasico;
    private int antiguedad;
    
    public Empleado(String nombre, int sueldoBasico, int antiguedad){
    this.nombre = nombre;
    this.sueldoBasico = sueldoBasico;
    this.antiguedad = antiguedad;
}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBasico(int sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSueldoBasico() {
        return sueldoBasico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
   
   public String toString(){
       String aux = "Nombre" + " " + this.nombre + "";
       return aux;
       // Llamarla en las clases hijas como: super.toString();
   }
    
    // super lo uso cuando quiero esquivar la instancia actual (ej ir una jerarquía más arriba);
    
  public abstract double calcularEfectividad();
  // No es abstracto porque tiene un codigo base en común: (PREGUNTAR)
  public double calcularSueldoACobrar(){
      // S hago getAntiguedad() * 100 / 10; es valido?
      int adic = (this.sueldoBasico * this.antiguedad * 10) / 100;
      return adic + this.sueldoBasico;
  } 
}
