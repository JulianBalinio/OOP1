package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class EmpleadoTest {

	private Empleado emp;
	private Contrato c1, c2, c3;
	protected Recibo r;
	
	
	@BeforeEach
	void setUp() throws Exception {
		emp = new Empleado("Julian", "Ba", 12345, LocalDate.now(), true, true);
		c1 = new ContratoPorHoras(LocalDate.now().minusMonths(24), LocalDate.now(), 10, 200);
		c2 = new ContratoPorHoras(LocalDate.now().minusMonths(10), LocalDate.now(), 10, 200);
		c3 = new ContratoDePlanta(LocalDate.now(), 50000, 5000, 10000);
	}
	
	@Test
	void testRecibosEnOrden() {
		emp.agregarContrato(c1);
		r = emp.emitirRecibo();
		assertEquals(48000, r.getMonto());
		
		emp.agregarContrato(c2);		
		r = emp.emitirRecibo();
		assertEquals(20000, r.getMonto());
		
		emp.agregarContrato(c3);
		r = emp.emitirRecibo();
		assertEquals(65000, r.getMonto());
	}
	
	@Test
	void testUltimoRecibo() {
		emp.agregarContrato(c2);
		r = emp.emitirRecibo();
		assertEquals(20000, r.getMonto());
		
		emp.agregarContrato(c3);
		r = emp.emitirRecibo();
		assertEquals(65000, r.getMonto());
		
		emp.agregarContrato(c1);
		r = emp.emitirRecibo();		
		assertEquals(65000, r.getMonto());
	}
	
	@Test
	void testReciboConAntiguedad() {
		Contrato contratoConAntiguedad = new ContratoDePlanta(LocalDate.now().minusYears(5), 50000, 5000, 10000);
		emp.agregarContrato(contratoConAntiguedad);
		assertEquals(84500, emp.emitirRecibo().getMonto()); // 65000 * 1.3
		
		//Toma el valor del primer contrato con antiguedad (50000, 5000, 10000) por ser posterior al de abajo
		contratoConAntiguedad = new ContratoDePlanta(LocalDate.now().minusYears(15), 100000, 5000, 10000);
		emp.agregarContrato(contratoConAntiguedad);
		assertEquals(130000, emp.emitirRecibo().getMonto()); //15 años = 65000 * 2
	}
	
	@Test
	void testAgregarContrato() {
		emp.agregarContrato(c3);
		r = emp.emitirRecibo();		
		emp.agregarContrato(c2);
		r = emp.emitirRecibo();		
		emp.agregarContrato(c1);
		r = emp.emitirRecibo();		
		assertEquals(3, emp.getContratos().size());
	}
}
