
public class Gira extends Recital{
    private String nombre;
    private Fecha [] fecha;
    private int fechaProx;
    private int cantFechas;
    private int pos = 0;
    
    public Gira(String nombreBanda, int cantTemas, String nombre, int fechaProx, int cantFechas){
        super(nombreBanda, cantTemas);
        this.nombre = nombre; 
        this.fechaProx = fechaProx;
        this.cantFechas = cantFechas;
        this.fecha = new Fecha [cantFechas]; // tiene las pos null.
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaProx() {
        return fechaProx;
    }

    public int getCantFechas() {
        return cantFechas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaProx(int fechaProx) {
        this.fechaProx = fechaProx;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }
    
    
    public void agregarFecha(Fecha unaFecha){
        if(pos < this.cantFechas){
        fecha[pos] = unaFecha;
        pos++; 
        }
    }
    public String actuar(){
        String aux = "";
        // Hay que chequear el objeto entero fecha[fechaProx] , no hacer: fecha[fechaProx].getNombre, ya q solo chequeo 1 campo y dara exceptionpointernull.
        if(fecha[fechaProx] != null){
            aux = "Buenas noches " + fecha[fechaProx].getCiudad();
        }
        return aux;
    }
    
}
