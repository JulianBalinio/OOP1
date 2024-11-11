package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

public class Vacuna {
	
	private String nombre;
	private double costo;
	
	public Vacuna(String nombre, double costo) {
		this.nombre = nombre;
		this.costo = costo;
	}
	
	public double getCosto() {
		return this.costo;
	}
}
