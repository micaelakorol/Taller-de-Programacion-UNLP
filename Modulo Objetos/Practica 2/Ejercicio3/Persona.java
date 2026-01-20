import PaqueteLectura.GeneradorAleatorio;

public class Persona {
    private String nombre;
    private int DNI;
    private int edad; 
    
    public Persona(String unNombre, int unDNI, int unaEdad){
        nombre = unNombre;
        DNI = unDNI;
        edad = unaEdad; 
    }
    
    public Persona(){
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

    @Override
    public String toString(){
        return "Mi nombre es " + nombre + ", mi DNI es " + DNI + " y tengo " + edad + " años.";
    }

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        Persona[][] personas = new Persona[5][8];
        String nombre;
        int dni, edad;

        int i = 0;
        int j = 0;
        nombre = GeneradorAleatorio.generarString(10);

        while (!nombre.equals("ZZZ") && i < 5) {
            if (j < 8) {
                dni = GeneradorAleatorio.generarInt(41067900);
                edad = GeneradorAleatorio.generarInt(100);
                personas[i][j] = new Persona(nombre, dni, edad);
                j++;
                nombre = GeneradorAleatorio.generarString(10);
            } else {
                j = 0;
                i++;
            }
        }

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 8; j++) {
                if (personas[i][j] != null) {
                    System.out.println("Día " + (i+1) + " - Turno " + (j+1) + ": " + personas[i][j]);
                }
            }
        }
    }
}
