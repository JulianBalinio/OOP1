package ar.edu.unlp.info.oo1.Ejercicio13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	
	private Archivo archL;
	private Archivo archM;
	
	@BeforeEach
	void setUp() {
		this.archL = new Archivo("Archivo Logico");
		this.archM = new Archivo("Archivo Maestro");
	}
	
	@Test
	void testNombre() {
		assertEquals("Archivo Logico", this.archL.getNombre());
		assertNotEquals("Archivo Maestro", this.archL.getNombre());
	
		assertEquals("Archivo Maestro", this.archM.getNombre());
		assertNotEquals("Archivo Logico", this.archM.getNombre());
	}
	
	@Test
	void testTamano() {
		assertEquals(14, this.archL.getTamano());
		assertNotEquals(15, this.archL.getTamano());
		assertNotEquals(13, this.archL.getTamano());
		
		assertEquals(15, this.archM.getTamano());
		assertNotEquals(14, this.archM.getTamano());
		assertNotEquals(13, this.archM.getTamano());
	}
}
