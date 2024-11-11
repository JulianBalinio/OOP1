package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

public abstract class ServicioMedico {

	private Veterinario vet;
	private Mascota mascota;
	
	public ServicioMedico(Veterinario vet, Mascota mascota) {
		this.vet = vet;
		this.mascota = mascota;
	}
	
	
	public Mascota getMascota() {
		return this.mascota;
	}
	
	public Veterinario getVeterinario() {
		return this.vet;
	}
	
	public double getCosto() {
		return this.vet.getHonorarios();
	}
}
