package ar.edu.unlp.info.oo1.Ejercicio21_Bag;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;

public class JugadorTest {
	Map<Jugador, Integer> mapa;
	
	Jugador messi = new Jugador("Lionel", "Messi");
	Jugador batistuta = new Jugador("Gabriel", "Batistuta");
	Jugador aguero = new Jugador("Kun", "Aguero");
	
	@BeforeEach
	void setUp() throws Exception {
		mapa = new HashMap<>();
		mapa.put(messi, 111);
		mapa.put(batistuta, 56);
		mapa.put(aguero, 42);
	}
	
	@Test
	void testRemoveKun() {
		assertEquals(42, mapa.remove(aguero));
	}
	
	@Test
	void testReemplazarGoles() {
		assertEquals(111, mapa.replace(messi, 112));
		assertEquals(112, mapa.replace(messi, 115));
	}
	
	@Test
	void testGolesTotales() {
		assertEquals(209, mapa.values().stream().mapToInt(j -> j).sum());
	}
}
