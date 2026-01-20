
public class pruebaRecital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // No instancias Recital, porque es abstracta
        //Pero sí cada objeto concreto (Evento o Gira) tendrá: String nombreBanda, int cantTemas.
        
        Evento evento  = new Evento ("Los charros", 4, "x", "Pablo", 15);
       
    System.out.println(evento.actuar());
        evento.agregarTema("La mordidita");
        evento.agregarTema("Bachata");
        evento.agregarTema("Bachata");
        evento.agregarTema("Bachata");
        evento.agregarTema("Te llamare");
        System.out.println(evento.imprimirTemas());
        
        
        Gira gira = new Gira("Nueva era", 2, "xx", 5, 8);
        Fecha fecha1 = new Fecha ("Ciudad", 4);
        Fecha fecha2 = new Fecha ("Ciudad", 0);
        gira.agregarFecha(fecha1);
        gira.agregarFecha(fecha2);
        // Si no le agrego temas, dará el error; ❌ NullPointerException, porque temas aún es null.
        gira.agregarTema("Llamame");
        gira.agregarTema("Te llamare");
        gira.agregarTema("Te llamare");
        gira.agregarTema("Te llamare");
        System.out.println(gira.imprimirTemas());
      System.out.println(gira.actuar());
    }
    
}
