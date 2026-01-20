
public class pruebaEstacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Estacionamiento estacionamiento = new Estacionamiento("El verde", 1011);
        Auto auto  = new Auto(677, "Julio");
        estacionamiento.registrarAuto(auto, 2,3);
        estacionamiento.buscarPatente(677);
        System.out.println(estacionamiento.toString());
        System.out.println("total " + estacionamiento.contarAutos(4)); // conta todos los autos que hay en las plazas 3 de todos los pisos.
    }
    
}
