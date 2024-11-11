package ar.edu.unlp.info.oo1.Ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {

	private Esfera e1;
	private Esfera e2;
		
	@BeforeEach
	void setUp() {
		this.e1 = new Esfera("hierro", "rojo", 4);
		this.e2 = new Esfera("acero", "negro", 3);
	}
	
	@Test 
	void testVolumen(){
		assertEquals(268, Math.round(e1.getVolumen()));
		assertEquals(113, Math.round(e2.getVolumen()));
	}
	
	@Test
	void testSuperficie() {
		assertEquals(201, Math.round(e1.getSuperficie()));
		assertEquals(113, Math.round(e2.getSuperficie()));
	}
}
