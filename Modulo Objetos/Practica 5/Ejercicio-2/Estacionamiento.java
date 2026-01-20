
public class Estacionamiento {
    private String nombre;
    private int direccion;
    private double horaApertura;
    private double horaCierre;
    private int pisos;
    private int plazas;
    private Auto[][] matriz ; // declaro la matriz. Luego debo crearla en el constructor con n y m como parámetros.
    
    // El estacionamiento inicialmente no tiene autos. -> DEBO CREAR LOS AUTOS COMO OBJETOS VACÍOS (ARRAY != NULL)
    public Estacionamiento(String nombre, int direccion){
         this.horaApertura = 8.00;
         this.horaCierre = 21.00;
         this.nombre = nombre;
         this.direccion = direccion;
         this.pisos = 5;
         this.plazas = 10;
         matriz = new Auto [pisos][plazas]; // Creo la matriz, ya existe con todos null, debemos crear los objetos vacíos.
         inicializarMatriz();
         
    }
    
    // Constructor 2:
    // “Estacionamiento con los datos recibidos y sin autos” = Poner las pos en null.
    public Estacionamiento(String nombre, int direccion, double horaApertura, double horaCierre, int pisos, int plazas){
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.pisos = pisos;
        this.plazas = plazas;
        this.matriz = new Auto[pisos][plazas]; // Creo el array -> poner sus posiciones en null
        inicializarNull();
    }
    
    // Pongo sus pos en null pq debo insertar en una pos N M y debo chequear si esta es null.
    private void inicializarNull(){
        for(int i = 0; i < pisos; i++){
            for(int j = 0; j < plazas; j++){
                matriz[i][j] = null;
            }
        }
    }
    
    //  // Inicializa todas las posiciones con objetos Auto vacíos
    private void inicializarMatriz(){
        for(int i = 0; i < pisos; i++){
            for(int j = 0; j < plazas ; j++ ){
                //matriz[i][j] = new Auto(); // cada plaza tiene un Auto vacío, aca estoy usando el constructor vacío.
                matriz[i][j] = new Auto();
            }
        }
    }
    
    // Voy a registrar los autos, donde esté declarado el array/matriz:
    
    public void registrarAuto(Auto auto, int x, int y){
        // Suponga que x y estan en rango y que el lugar esta vacío.
        matriz[x][y] = auto; // Agrego el auto.
    }
    
    // Como debo BUSCAR en la matriz, voy a tener que usar FOR.
    // Pisos y plazas pueden no estar completos, asi que uso != null
    public void buscarPatente(int patente){
     //   boolean encontro = false;
        for(int i = 0; i < pisos; i++ ){
            for(int j = 0; j < plazas; j++){
                if(matriz[i][j] != null && matriz[i][j].getPatente() == patente){
                    System.out.println("Piso: " + (i+1) + ", Plaza: " + (j+1));
                  //  encontro = true;
                    return; // corta la ejecución del programa cuando encuentra la patente.
                }
            }
        }
        ///if(!encontro){ -> funciona de ambas formas.
                  System.out.println("Auto inexistente");   
        //}
    }
    
    public String toString(){
        String aux = "";
        for(int i = 0; i < pisos; i++){
            for(int j = 0; j < plazas; j++){
                aux = "Piso " + (i+1) + "Plaza " + (j+1); // mensaje que seguro imprime
                if(matriz[i][j] != null){
                    aux += "Ocupada" + " " +  matriz[i][j].toString(); // le concateno ocupada si es != null.
                }
                else{
                    aux += "Libre" + " " + matriz[i][j].toString();;   // Si no es null, libre.
                }
            }
        }
        return aux;
    }
    
    
    public int contarAutos(int y){
        int cont =0;
        int columna = y - 1;
        for(int i = 0; i < pisos; i++){
            // como tengo un constructor donde inicializo null la matriz y otro como objeto vacío, debo hacer
            // que este metodo sirva para ambos casos, por eso chequeo -1 , ya que significa q no hay auto.
            if(matriz[i][columna] != null && matriz[i][columna].getPatente() != -1){
                cont++; // Si hay un auto en esa plaza, sumo 1.
            }
        }
        return cont;
    }
  
    
}
/*
Si solo tuvieras un constructor con parámetros (Auto(int patente, String nombre)),
sí deberías pasarle siempre los datos al crear un auto, incluso para inicializar la matriz.

Pero si querés llenar la matriz de objetos vacíos al inicio, entonces necesitas un segundo constructor sin parámetros,
para poder crear Auto() sin pasar datos.

// Casos de inicializacion:

dimL -> No pongo las posiciones en null, voy insertando directamente vector[dimL] = xxx; 
inicializar objetos vacíos -> creo la matriz/vector hago new NOMBRECLASE y ya tengo objetos vacios. (Ver constructor)
si debo INSERTAR en x posicion -> Inicializar la matriz/vector en null , pq necesito chequear si la pos != null.
*/