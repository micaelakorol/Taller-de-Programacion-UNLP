
import PaqueteLectura.GeneradorAleatorio;

public class Persona_4a {
      private String nombre;
    private int DNI;
    private int edad; 
    
    public Persona_4a(String unNombre, int unDNI, int unaEdad){
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad; 
    }
    
    public Persona_4a(){
     
    }

    public int getDNI() {
        return DNI;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDNI(int unDNI) {
        DNI = unDNI;
    }

    public void setEdad(int unaEdad) {
        edad = unaEdad;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }
    // Sobreescribo el metodo toString:
    public String toString(){
        String aux; 
        aux = "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años.";
        return aux;
    }
    
     public static void main(String[] args) {
         Persona [][] matriz = new Persona[5][8];
         String nombre;
         int dni;
         int edad;
         int dia;
         int cupos = 0;
         int j = 0;
         boolean inscripto = false;
         GeneradorAleatorio.iniciar();
         // inicializar la matriz en null.
         nombre = GeneradorAleatorio.generarString(10);
         
      while(cupos < 40 && !nombre.equals("ZZZ")) {
    dni = GeneradorAleatorio.generarInt(41056901);
    edad = GeneradorAleatorio.generarInt(100);
    dia = GeneradorAleatorio.generarInt(5);
    j = 0;            // reiniciar turno para la persona actual
    inscripto = false; // reiniciar estado

    while (j < 8 && !inscripto) { // recorro turnos hasta encontrar uno que sea null.
        if (matriz[dia][j] == null) {
            matriz[dia][j] = new Persona(nombre, dni, edad);
            cupos++;
            inscripto = true; // cortamos el while interno
            System.out.println("Inscripción de " + nombre + " en día " + dia + ", turno " + (j+1));
        }
        j++; // avanzamos al siguiente turno
    }

    if (!inscripto) {
        System.out.println("No hay lugar para " + nombre + " en el día " + dia);
    }

    nombre = GeneradorAleatorio.generarString(10); // generamos próxima persona
}
     }
    
}
