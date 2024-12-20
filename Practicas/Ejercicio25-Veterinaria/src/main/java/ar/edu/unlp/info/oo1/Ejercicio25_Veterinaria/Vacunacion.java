package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;


public class Vacunacion extends ServicioMedico {

	private Vacuna vacuna;
	
	public Vacunacion(Veterinario vet, Mascota mascota, Vacuna vacuna) {
		super(vet, mascota);
		this.vacuna = vacuna;
	}
	
	public Vacuna getVacuna() {
		return this.vacuna;
	}
	
	public double getCosto() {
		return super.getCosto() +this.vacuna.getCosto();
	}
}
