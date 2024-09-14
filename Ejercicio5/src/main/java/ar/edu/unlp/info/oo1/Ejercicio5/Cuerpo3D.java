package ar.edu.unlp.info.oo1.Ejercicio5;

public class Cuerpo3D {
	
	private Figura caraBasal;
	private double altura;
	
	public void setCaraBasal(Figura caraBasal) {
		this.caraBasal = caraBasal;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public double getVolumen() {
		return (this.caraBasal.getArea() * this.altura);
	}
	
	public double getSuperficieExterior() {
	    return (this.caraBasal.getArea() * 2) + (this.caraBasal.getPerimetro() * this.altura);
	}
}