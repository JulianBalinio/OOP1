package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class EnvioLocalTest {

	protected EnvioLocal el;
	protected LocalDate fecha;
	
	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.now();
		el = new EnvioLocal(fecha, "Origen", "Destino", 10, true);
	}
	
	@Test
	void testRapido() {
		assertEquals(1500, el.calcularCosto());
	}
	
	@Test
	void testNoRapido() {
		el.toggleRapido();
		assertEquals(1000, el.calcularCosto());
	}
}
