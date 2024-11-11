package ar.edu.unlp.info.oo1.Ejercicio5;

public class Cuadrado implements Figura{
	
	private double lado;
	
	public double getLado() {
		return this.lado;
	}
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getArea() {
		return (this.lado * this.lado);
	}
	
	public double getPerimetro() {
		return (this.lado * 4);
	}
}