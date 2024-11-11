package ar.edu.unlp.info.oo1.Ejercicio12;

public class PrismaRectangular extends Pieza{
	
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}
	
	public int getLadoMayor() {
		return this.ladoMayor;
	}
	
	public int getLadoMenor() {
		return this.ladoMenor;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public double getVolumen() {
		return (this.getLadoMayor() * this.getLadoMenor() * this.getAltura());
	}
	
	public double getSuperficie() {
		return 	2 * (this.getLadoMayor() * this.getLadoMenor()
				+ this.getLadoMayor() * this.getAltura()
				+ this.getLadoMenor() * this.getAltura());
	}
}
