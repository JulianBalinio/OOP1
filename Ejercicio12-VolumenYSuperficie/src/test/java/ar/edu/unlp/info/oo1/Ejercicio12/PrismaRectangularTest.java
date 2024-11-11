package ar.edu.unlp.info.oo1.Ejercicio12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {
	
	private PrismaRectangular pr1;
	private PrismaRectangular pr2;
	
	@BeforeEach
	void setUp() {
		this.pr1 = new PrismaRectangular("hierro", "rojo", 10, 5, 3);
		this.pr2 = new PrismaRectangular("hierro", "rojo", 9, 4, 6);
	}
	
	@Test
	void testVolumen() {
		assertEquals(150, Math.round(pr1.getVolumen()));
		assertEquals(216, Math.round(pr2.getVolumen()));
	}
	
	@Test
	void testSuperficie() {
		assertEquals(190, Math.round(pr1.getSuperficie()));
		assertEquals(228, Math.round(pr2.getSuperficie()));
	}
}
