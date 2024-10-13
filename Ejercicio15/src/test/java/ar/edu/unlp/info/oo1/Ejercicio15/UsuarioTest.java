package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.assertTrue;
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
		user = new Usuario("Julian", "Calle1");
		ct = new CuadroTarifario(20);
		
		c1 = new Consumo(100, 60);
		c2 = new Consumo(100, 100);
		c3 = new Consumo(300, 71);
		
		user.agregarConsumo(c1);
		user.agregarConsumo(c2);
		user.agregarConsumo(c3);
	}
	
	@Test
	void testListaConsumos() {
		assertEquals(3, user.getConsumos().size());
		assertNotEquals(4, user.getConsumos().size());
		
		user.agregarConsumo(new Consumo(30, 30));
		assertEquals(4, user.getConsumos().size());
	}
	
	@Test
	void testConsumo() {
		assertEquals(c3, user.ultimoConsumo());
		assertEquals(6000, user.getCostoConsumo(ct.getPrecioKwh()));
		
		Consumo c4 = new Consumo(100, 50);
		user.agregarConsumo(c4);
		assertEquals(c4, user.ultimoConsumo());
		assertEquals(2000, user.getCostoConsumo(ct.getPrecioKwh()));
		
		Consumo c5 = new Consumo(200, 150);
		user.agregarConsumo(c5);
		assertEquals(c5, user.ultimoConsumo());
		assertEquals(4000, user.getCostoConsumo(ct.getPrecioKwh()));
	}
	
	@Test
	void testBonificacion() {
		assertTrue(user.tieneBonificacion());
		
		Consumo c4 = new Consumo(100, 100);
		user.agregarConsumo(c4);
		assertFalse(user.tieneBonificacion());	
	}
}
