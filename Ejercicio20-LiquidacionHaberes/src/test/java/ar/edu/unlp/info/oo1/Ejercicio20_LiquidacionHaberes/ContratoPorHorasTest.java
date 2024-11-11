package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ContratoPorHorasTest {
	
	private ContratoPorHoras contrato;
	private LocalDate hoy, seisMesesAtras;
	
	@BeforeEach
	void setUp() throws Exception {
		hoy = LocalDate.now();
		seisMesesAtras = hoy.minusMonths(6);
		contrato = new ContratoPorHoras(seisMesesAtras, hoy, 10, 200);
	}
	
	@Test
	void testSueldo() {
		assertEquals(12000, contrato.sueldo(false, false));
		assertEquals(12000, contrato.sueldo(true, false));
		assertEquals(12000, contrato.sueldo(false, true));
		assertEquals(12000, contrato.sueldo(true, true));
	}
}
