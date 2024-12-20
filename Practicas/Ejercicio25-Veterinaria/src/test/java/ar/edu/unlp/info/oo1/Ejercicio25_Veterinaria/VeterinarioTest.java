package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class VeterinarioTest {

	protected Veterinario vet;
	protected ServicioMedico gua, cons, vac;
	protected Vacuna vacuna;
	protected Mascota mascota;
	
	@BeforeEach
	void setUp() throws Exception {
		vet = new Veterinario ("Veterinario 1", 3000);
		vacuna = new Vacuna("Vacuna", 1000);
		mascota = new Mascota("Simon", LocalDate.now(), "callejero");
	
		gua = new Guarderia(vet, mascota, 7);
		cons = new Consulta(vet, mascota, LocalDate.now());
		vac = new Vacunacion(vet, mascota, vacuna);
	}
	
	@Test
	void testServiciosLista() {
		assertEquals(0, vet.getServicios().size());
		vet.registrarServicio(gua);
		assertEquals(1, vet.getServicios().size());
		vet.registrarServicio(cons);
		assertEquals(2, vet.getServicios().size());
		vet.registrarServicio(vac);
		assertEquals(3, vet.getServicios().size());
		assertEquals(28000, vet.calcularMontoTotal());
	}
}