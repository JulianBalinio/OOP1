package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class VacunacionTest {

	protected Veterinario vet1, vet2;
	protected ServicioMedico vac1, vac2;
	protected Vacuna vacuna1, vacuna2;
	protected Mascota mascota;
	
	@BeforeEach
	void setUp() throws Exception {
		vet1 = new Veterinario ("Veterinario 1", 3000);
		vet2 = new Veterinario ("Veterinario 2", 2000);
		
		mascota = new Mascota("Simon", LocalDate.now(), "callejero");
		
		vacuna1 = new Vacuna("Vacuna 1", 1000);
		vacuna2 = new Vacuna("Vacuna 2", 1500);
		
		vac1 = new Vacunacion(vet1, mascota, vacuna1);
		vac2 = new Vacunacion(vet2, mascota, vacuna2);
	}
	
	@Test
	void testConsulta() {
		assertEquals(4000, vac1.getCosto());
		assertEquals(3500, vac2.getCosto());
	}
}