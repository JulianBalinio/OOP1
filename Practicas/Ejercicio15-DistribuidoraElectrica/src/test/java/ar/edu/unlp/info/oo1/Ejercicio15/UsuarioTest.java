package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class UsuarioTest {

	private Usuario user;
	private CuadroTarifario ct;
	private Consumo c1, c2, c3;
	
	
	@BeforeEach
	void setUp() {
		ct = new CuadroTarifario(20);
		user = new Usuario("Julian", "Calle1", ct);
		
		c1 = new Consumo(100, 60, LocalDate.of(2024, 10, 25));
		c2 = new Consumo(100, 100, LocalDate.of(2024, 10, 28));
		c3 = new Consumo(300, 71,LocalDate.of(2024, 10, 30));
		
		user.agregarConsumo(c1);
		user.agregarConsumo(c2);
		user.agregarConsumo(c3);
	}
	
	@Test
	void testListaConsumos() {
		assertEquals(3, user.getConsumos().size());
		assertNotEquals(4, user.getConsumos().size());
		
		user.agregarConsumo(new Consumo(30, 30, LocalDate.now()));
		assertEquals(4, user.getConsumos().size());
	}
	
	@Test
	void testConsumo() {
		assertEquals(c3, user.ultimoConsumo());
		assertEquals(5400, user.getCostoConsumo());
		
		Consumo c4 = new Consumo(100, 50, LocalDate.now().minusDays(1));
		user.agregarConsumo(c4);
		assertEquals(c4, user.ultimoConsumo());
		assertEquals(1800, user.getCostoConsumo());
		
		Consumo c5 = new Consumo(200, 150, LocalDate.now());
		user.agregarConsumo(c5);
		assertEquals(c5, user.ultimoConsumo());
		assertEquals(4000, user.getCostoConsumo());
	}
	
	@Test
	void testEmitirFactura() {
		Factura fac = user.emitirFactura(user);
		assertEquals(5400, fac.getMontoFinal());
		assertTrue(fac.getBonificacion());
		assertEquals(LocalDate.now(), fac.getFecha());
	}
}
