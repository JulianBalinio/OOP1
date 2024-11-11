package ar.edu.unlp.info.oo1.Ejercicio22_EstadisticasClienteCorreo;

public class Archivo {
	
	private String nombre;
	
	public Archivo (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTamano() {
		return this.getNombre().length();
	}
}
