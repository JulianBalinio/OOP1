package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ContratoDePlantaTest {

	private ContratoDePlanta contrato;
	private LocalDate fecha;
	
	@BeforeEach
	void setUp() {
		fecha = LocalDate.now();
		contrato = new ContratoDePlanta(fecha, 5000, 500, 1000);
	}
	
	@Test
	void testSueldoSinBono() {
		assertEquals(5000, contrato.sueldo(false, false));
	}

	@Test
	void testSueldoConConyuge() {
		assertEquals(5500, contrato.sueldo(true, false));
	}
	
	@Test
	void testSueldoConHijo() {
		assertEquals(6000, contrato.sueldo(false, true));
	}
	
	@Test
	void testSueldoConBono() {
		assertEquals(6500, contrato.sueldo(true, true));
	}

}
