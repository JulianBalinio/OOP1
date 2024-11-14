package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class ConsultaTest {

	protected Veterinario vet1, vet2;
	protected Consulta consulta1, consulta2;
	protected Mascota mascota;
	
	@BeforeEach
	void setUp() throws Exception {
		vet1 = new Veterinario ("Veterinario 1", 3000);
		vet2 = new Veterinario ("Veterinario 2", 2000);
		
		mascota = new Mascota("Simon", LocalDate.now(), "callejero");
	
		consulta1 = new Consulta(vet1, mascota, LocalDate.now());
		consulta2 = new Consulta(vet2, mascota, LocalDate.now());
	}
	
	@Test
	void testConsulta() {
		assertEquals(3000, consulta1.getCosto());
		assertEquals(2000, consulta2.getCosto());
	}
}
