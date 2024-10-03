package ar.edu.unlp.info.oo1.Ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CuentaTest {
	
	private CajaDeAhorro cda;
	private CuentaCorriente cc;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cda = new CajaDeAhorro();
		this.cc = new CuentaCorriente();
		
		cda.depositar(1000);
		
		cc.depositar(700);
		cc.setLimiteDescubierto(500);
	}

	@Test
	void testPuedeExtraerCajaDeAhorro() {
		assertFalse(cda.puedeExtraer(1000));
		assertTrue(cda.puedeExtraer(1000 - (1000*0.02)));
		assertTrue(cda.puedeExtraer(900));
		assertFalse(cda.puedeExtraer(990));
		assertTrue(cda.puedeExtraer(100));
	}
	
	@Test
	void testPuedeExtraerCuentaCorriente() {
		assertTrue(cc.puedeExtraer(1200));
		assertFalse(cc.puedeExtraer(1300));
		assertFalse(cc.puedeExtraer(2500));
		assertTrue(cc.puedeExtraer(1000));
		assertTrue(cc.puedeExtraer(500));
	}
	
	@Test
	void testTransferencias() {
		cc.transferirACuenta(500, cda);
		assertEquals(200, cc.getSaldo());
		assertEquals(1500, cda.getSaldo());
		
		cc.transferirACuenta(200, cda);
		assertEquals(0, cc.getSaldo());
		assertEquals(1700, cda.getSaldo());
		
		cda.transferirACuenta(1000, cc);
		assertEquals(700, cda.getSaldo());
		assertEquals(1000, cc.getSaldo());
		
		cc.transferirACuenta(1500, cda);
		assertEquals(-500, cc.getSaldo());	
		assertEquals(2200, cda.getSaldo());
		
		cda.transferirACuenta(1200, cc);
		assertEquals(1000, cda.getSaldo());
		assertEquals(700, cc.getSaldo());
	}
	
	@Test
	void testExtraccionCajaDeAhorro() {
		cda.extraer(500);
		assertEquals(490, cda.getSaldo());
		cda.extraer(400);
		assertEquals(82, cda.getSaldo());
		
		cc.extraer(1000);
		assertEquals(-300, cc.getSaldo());
		cc.extraer(200);
		assertEquals(-500, cc.getSaldo());
	}
	
	
}