package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

import java.time.LocalDate;

public class Mascota {

	private String nombre;
	private LocalDate fechaNac;
	private String especie;
	
	public Mascota(String nombre, LocalDate fechaNac, String especie) {
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.especie = especie;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
}
