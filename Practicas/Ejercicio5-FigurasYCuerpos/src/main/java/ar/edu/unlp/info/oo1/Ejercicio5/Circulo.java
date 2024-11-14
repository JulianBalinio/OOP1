package ar.edu.unlp.info.oo1.Ejercicio5;

public class Circulo implements Figura {
	
	private double radio;
	
	public double getRadio() {
		return this.radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return (this.radio * 2);
	}
	
	public double getArea() {
		return Math.PI * (this.radio * this.radio);
	}
	
	public double getPerimetro() {
		return (Math.PI * this.getDiametro());
	}
}