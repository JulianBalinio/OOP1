package ar.edu.unlp.info.oo1.Ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InversionesTest {

	private InversionEnAcciones iea1, iea2, iea3;
	private PlazoFijo pf, pf1, pf2;
	private Inversor inversor;
	
	@BeforeEach
	void setUp() throws Exception {
		this.inversor = new Inversor("Julian");
		
		this.iea1 = new InversionEnAcciones("S", 5, 1000);
		this.iea2 = new InversionEnAcciones("Apple", 10, 500);
		this.iea3 = new InversionEnAcciones("AMD", 2, 2000);
		
		this.pf = new PlazoFijo(LocalDate.of(2024, 9, 23), 450, 10);
		this.pf1 = new PlazoFijo(LocalDate.of(2024, 9, 2),3000, 1);
	}
	
	@Test
	void testInversor() {
		assertEquals(0, this.inversor.valorActual());
		this.inversor.agregarInversion(iea1);
		assertEquals(5000, this.inversor.valorActual());
		this.inversor.agregarInversion(iea3);
		assertEquals(9000, this.inversor.valorActual());
	}
	
	@Test
	void testInversionEnAcciones() {
		assertEquals(1000, this.iea1.getValorUnitario());
		assertEquals(500, this.iea2.getValorUnitario());
		assertEquals(2000, this.iea3.getValorUnitario());
		
		assertEquals(5000, this.iea1.valorActual());
		assertEquals(5000, this.iea2.valorActual());
		assertEquals(4000, this.iea3.valorActual());
		
		assertEquals(5, this.iea1.getCantidad());
		assertEquals(10, this.iea2.getCantidad());
		assertEquals(2, this.iea3.getCantidad());
	}
	
	@Test
	void testPlazoFijo() {
		//Estos valores van a variar dado que se comparan con la fecha del plazo fijo y la fecha ACTUAL
		assertEquals(3930, pf1.valorActual());
		assertEquals(900, pf.valorActual());
	}
	
}
