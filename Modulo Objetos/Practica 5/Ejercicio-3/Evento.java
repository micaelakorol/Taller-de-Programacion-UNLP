
public class Evento extends Recital{
   private String motivo;
   private String contratante;
   private int dia;
   private int pos = 0;
   
   public Evento(String nombreBanda, int cantTemas, String motivo, String contratante, int dia){
       super(nombreBanda,cantTemas);
       this.motivo = motivo;
       this.contratante = contratante;
       this.dia = dia;
   }

    public String getMotivo() {
        return motivo;
    }

    public String getContratante() {
        return contratante;
    }

    public int getDia() {
        return dia;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
     
      public String actuar(){
        String aux = "";
        aux = "Recuerden colaborar con " + this.contratante + "Saludos amigos. ";
        return aux;
    }
}
