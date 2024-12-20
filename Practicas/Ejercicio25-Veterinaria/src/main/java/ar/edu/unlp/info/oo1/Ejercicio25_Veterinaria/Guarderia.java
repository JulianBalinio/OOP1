package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

public class Guarderia extends ServicioMedico {

	private int cantidadDias;
	
	public Guarderia(Veterinario vet, Mascota mascota, int cantidadDias) {
		super(vet, mascota);
		this.cantidadDias = cantidadDias;
	}
	
	public int getCantidadDias() {
		return this.cantidadDias;
	}
	
	public double getCosto() {
		return super.getCosto() * this.cantidadDias;
	}
}
