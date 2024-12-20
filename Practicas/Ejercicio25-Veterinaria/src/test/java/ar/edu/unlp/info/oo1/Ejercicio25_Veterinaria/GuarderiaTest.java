package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GuarderiaTest {

	protected Veterinario vet1, vet2;
	protected ServicioMedico gua1, gua2;
	protected Mascota mascota;
	
	@BeforeEach
	void setUp() throws Exception {
		vet1 = new Veterinario ("Veterinario 1", 3000);
		vet2 = new Veterinario ("Veterinario 2", 2000);
		
		mascota = new Mascota("Simon", LocalDate.now(), "callejero");
	
		gua1 = new Guarderia(vet1, mascota, 7);
		gua2 = new Guarderia(vet2, mascota, 10);
	}
	
	@Test
	void testConsulta() {
		assertEquals(21000, gua1.getCosto());
		assertEquals(20000, gua2.getCosto());
	}
}