package ar.edu.unlp.info.oo1.Ejercicio12;

public class Cilindro extends Pieza {
	
	private int radio;
	private int altura;
	
	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}
	
	public int getRadio() {
		return this.radio;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public double getVolumen() {
		return (Math.PI * Math.pow(this.getRadio(), 2) * this.getAltura());
	}
	
	public double getSuperficie() {
		return ((2 * Math.PI * Math.pow(this.getRadio(), 2)) + (2 * Math.PI * this.getRadio() * this.getAltura()));
	}
}
