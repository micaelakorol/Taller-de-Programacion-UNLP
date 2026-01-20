
import PaqueteLectura.GeneradorAleatorio;

public class pruebaCoro {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
       // nombre = GeneradorAleatorio.generarString(10);
        // Generar un director: 
        Director director = new Director("Jose", 45675432, 55, 7);
        // Generamos un coro y le enviamos un director con set.
        CoroHileras coroH = new CoroHileras("Coroh",director, 2); // el nombre y su dimension
        Corista uncorista1 = new Corista("x1xx", 54646, 19, 4);
        Corista uncorista2 = new Corista("hhhhh", 6756, 34, 7);
        coroH.agregarCorista(uncorista1);
        coroH.agregarCorista(uncorista2);
       // coroH.setDirector(director); // le enviamos el director al coro
       System.out.println(coroH.toString());
        
        // Generamos el coro semi y agregamos corista:
        
        Director director2 = new Director("Pepe", 31067954, 44, 2);
        CoroSemi coroS = new CoroSemi("CoroS" , director2, 4);
        Corista uncorista = new Corista("xxx", 54646, 19, 4);
        Corista uncorista22 = new Corista("xxx", 54646, 19, 4);
        coroS.agregarCorista(uncorista);
         coroS.agregarCorista(uncorista22);
        System.out.println(coroS.estaLleno());
        System.out.println(coroS.toString());
        
    }
    
}
