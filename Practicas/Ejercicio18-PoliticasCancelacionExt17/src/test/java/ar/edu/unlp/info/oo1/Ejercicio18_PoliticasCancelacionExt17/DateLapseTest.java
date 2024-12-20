package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

class DateLapseTest {
	
	private DateLapse periodo;
	private DateLapse periodoPasado;
	private DateLapse periodoFuturo;
	private DateLapse periodo1;
	private DateLapse periodo2;
	
	@BeforeEach
	void setUp() throws Exception{
		periodo 		= new DateLapse(LocalDate.of(2024, 10, 15), LocalDate.of(2024, 10, 20)); // 15 al 20
		periodoPasado 	= new DateLapse(LocalDate.of(2024, 10, 1),  LocalDate.of(2024, 10, 9));  // 1  al 9  False
		periodoFuturo 	= new DateLapse(LocalDate.of(2024, 10, 21), LocalDate.of(2024, 10, 30)); // 21 al 30 False
		periodo1 		= new DateLapse(LocalDate.of(2024, 10, 10), LocalDate.of(2024, 10, 16)); // 10 al 16 True
		periodo2 		= new DateLapse(LocalDate.of(2024, 10, 18), LocalDate.of(2024, 10, 26)); // 18 al 26 True
	}
	
	@Test
	void testOverlapse() {
		assertTrue(periodo.overlapse(periodo1));
		assertTrue(periodo.overlapse(periodo2));
		assertFalse(periodo.overlapse(periodoFuturo));
		assertFalse(periodo.overlapse(periodoPasado));
	}
}
