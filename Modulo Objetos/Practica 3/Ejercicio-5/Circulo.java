/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Micae
 */
public class Circulo {

    private double radio;
    private String colorRelleno;
    private String colorLinea;

    public Circulo(double radio, String colorRelleno, String colorLinea){
        this.radio = radio;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }

    // Getters
    public double getRadio() {
        return radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    // Setters
    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
  public double calcularPerimetro(){
    return 2 * 3.1416 * this.radio;
}

 public double calcularArea(){
      return 3.1416 * this.radio * this.radio;
 } 
  
}
