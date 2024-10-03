package ar.edu.unlp.info.oo1.Ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CilindroTest {
	
	private Cilindro c1;
	private Cilindro c2;
	
	@BeforeEach
	void setUp() {
		this.c1 = new Cilindro("hierro", "gris", 3, 5);
		this.c2 = new Cilindro("madera", "marron", 5, 7);
	}
	
	@Test
	void testVolumen() {
		assertEquals(141, Math.round(this.c1.getVolumen()));
		assertEquals(550, Math.round(this.c2.getVolumen()));
	}
	
	@Test
	void testSuperficie() {
		assertEquals(151, Math.round(this.c1.getSuperficie()));
		assertEquals(377, Math.round(this.c2.getSuperficie()));
	}
}
