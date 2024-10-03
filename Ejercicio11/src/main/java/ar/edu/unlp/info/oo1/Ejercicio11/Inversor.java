package ar.edu.unlp.info.oo1.Ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<Inversiones> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<>();
	}
	
	public double valorActual() {
		return (this.inversiones.stream().mapToDouble(Inversiones :: valorActual).sum());
	}

	public String getNombre() {
		return nombre;
	}
	
	public void agregarInversion(Inversiones inversion) {
		this.inversiones.add(inversion);
	}
	
}
