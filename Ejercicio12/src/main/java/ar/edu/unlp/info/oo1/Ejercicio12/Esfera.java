package ar.edu.unlp.info.oo1.Ejercicio12;

public class Esfera extends Pieza{
	
	private int radio;
	
	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}
	
	public int getRadio() {
		return this.radio;
	}
	
	public double getVolumen() {
		return ((4.0/3.0) * Math.PI * Math.pow(this.getRadio(), 3));
	}
	
	public double getSuperficie() {
		return (4 * Math.PI * Math.pow(this.getRadio(), 2));
	}
}
