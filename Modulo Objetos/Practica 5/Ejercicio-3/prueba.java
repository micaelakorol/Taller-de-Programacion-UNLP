
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        // TODO code application logic here
        // Datos del proyecto:
        Proyecto proyecto = new Proyecto("Investigacion" , 566, "Pedro Fuentes");
        // Agrego un investigador al array:
        Investigadores investigador1 = new Investigadores("Julio", 4 , "Medicina");
        Investigadores investigador2 = new Investigadores("Pedro", 1 , "Informática");
        Investigadores investigador3 = new Investigadores("Julio", 4 , "Perito");
        // Agrego los investigadores al proyecto:
        proyecto.agregarInvestigador(investigador1);
        proyecto.agregarInvestigador(investigador2);
        proyecto.agregarInvestigador(investigador3);
        // Creo 2 subsidios:
        Subsidio subsidio1 = new Subsidio(34564, "Investigacion");
        Subsidio subsidio2 = new Subsidio(56789, "Investigacion forense");
        // Agrego los subsidios:
        investigador1.agregarSubsidio(subsidio1);
        investigador2.agregarSubsidio(subsidio2);
        subsidio1.setOtorgado(true); // Le damos el ok a un subsidio
        subsidio2.setOtorgado(true); // Le damos el ok a un subsidio
        System.out.println(proyecto.toString());
        System.out.println(investigador1.toString());
        System.out.println(investigador2.toString());
        System.out.println(investigador3.toString());
     // Cada Investigador tiene su propio array de subsidios.   
     
     // Si quiero rellenar aleatoriamente: (Probar después)
  
    }
    
}
