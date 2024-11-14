package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class EnvioInterurbanoTest {

	protected EnvioInterurbano ei;
	protected LocalDate fecha;
	@BeforeEach
	void setUp() throws Exception {
		fecha = LocalDate.now();
		ei = new EnvioInterurbano(fecha, "Origen", "Destino", 10, 100);
	}
	
	@Test
	void testTarifaBaja() {
		ei.setDistanciaKm(50);
		assertEquals(20, ei.tarifa());
		assertEquals(200, ei.calcularCosto());
	}
	
	@Test
	void testTarifaMedia() {
		ei.setDistanciaKm(250);
		assertEquals(25, ei.tarifa());
		assertEquals(250, ei.calcularCosto());
	}
	
	@Test
	void testTarifaAlta() {
		ei.setDistanciaKm(550);
		assertEquals(30, ei.tarifa());
		assertEquals(300, ei.calcularCosto());
	}
	
}
