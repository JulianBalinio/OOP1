package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class EnvioInternacionalTest {
	
	protected EnvioInternacional ei;
	protected LocalDate fecha;
	
	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.now();
	}
	
	@Test
	void testEnvioLigero() {
		ei = new EnvioInternacional(fecha, "origen", "destino", 900);
		assertEquals(14000, ei.calcularCosto());
	}
	
	@Test
	void testEnvioPesado() {
		ei = new EnvioInternacional(fecha, "origen", "destino", 1000);
		assertEquals(17000, ei.calcularCosto());
	}
}
