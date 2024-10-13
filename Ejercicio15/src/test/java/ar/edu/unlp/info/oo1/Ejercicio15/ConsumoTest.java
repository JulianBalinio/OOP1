package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsumoTest {
	
	private Consumo c1, c2, c3;
	
	@BeforeEach
	void setUp() {
		c1 = new Consumo(100, 60);
		c2 = new Consumo(100, 100);
		c3 = new Consumo(300, 71);
	}
	
	@Test
	void testFactorPotencia() {
		assertEquals(0.9, redondear(c1.factorPotencia(), 1));
		assertEquals(0.7, redondear(c2.factorPotencia(), 1));
		assertEquals(1.0, redondear(c3.factorPotencia(), 1));
	}
	
	 private double redondear(double valor, int decimales) {
        double escala = Math.pow(10, decimales);  // Escala para ajustar los decimales
        return Math.round(valor * escala) / escala;
    }
}
