
public class Triangulo extends Figura{
    private int l1;
    private int l2;
    private int l3;
    
    
    public Triangulo(String colorRelleno, String colorLinea, int l1, int l2, int l3){
     super(colorRelleno, colorLinea);
     this.l1 = l1;
     this.l2 = l2;
     this.l3 = l3;
    }

    public void setL1(int l1) {
        this.l1 = l1;
    }

    public void setL2(int l2) {
        this.l2 = l2;
    }

    public void setL3(int l3) {
        this.l3 = l3;
    }

    public int getL1() {
        return l1;
    }

    public int getL2() {
        return l2;
    }

    public int getL3() {
        return l3;
    }
     @Override
    public double calcularArea(){
        return 2.3;
    }
     @Override
    public double calcularPerimetro(){
         return 2.3;
    }
    
    @Override
    public String toString(){
   // toString.Super = Llama al método de la clase superior (Figura) e imprime su string 
    String aux = super.toString() + "Lados" + " " + this.l1 + " " + this.l2 + " " +  this.l3;
    return aux;
   }
    
}
