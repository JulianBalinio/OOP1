package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

import java.time.LocalDate;

public class Consulta extends ServicioMedico {
	private LocalDate fechaAtencion;

	public Consulta(Veterinario vet, Mascota mascota, LocalDate fechaAtencion) {
		super(vet, mascota);
		this.fechaAtencion = fechaAtencion;
	}
	
	public LocalDate getFechaAtencion() {
		return this.fechaAtencion;
	}
	
}
