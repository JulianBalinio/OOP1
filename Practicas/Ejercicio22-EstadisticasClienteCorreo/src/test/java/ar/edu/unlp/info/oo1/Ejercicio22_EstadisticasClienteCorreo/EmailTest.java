package ar.edu.unlp.info.oo1.Ejercicio22_EstadisticasClienteCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {
	
	private Email email1;
	private Email email2;
	
	@BeforeEach
	void setUp() {
		this.email1 = new Email("Baja", "Eliminar usuario"); // len = 20
		this.email2 = new Email("Creacion", "Activar usuario"); // len = 23;
	}
	
	@Test
	void testTamano() {
		assertEquals(20, this.email1.getTamano());
		assertNotEquals(21, this.email1.getTamano());
		
		assertEquals(23, this.email2.getTamano());
		assertNotEquals(22, this.email2.getTamano());
	}
	
	@Test
	void testContiene() {
		assertTrue(this.email1.contiene("Baja"));
		assertTrue(this.email1.contiene("Eliminar"));
		assertFalse(this.email1.contiene("Activar"));
		
		assertTrue(this.email2.contiene("Creacion"));
		assertTrue(this.email2.contiene("Activar"));
		assertFalse(this.email2.contiene("Eliminar"));
	}
	
	@Test
	void testAdjuntos() {
		this.email1.agregarAdjunto(new Archivo("arch"));
		assertEquals(24, this.email1.getTamano());
		assertEquals(1, this.email1.getAdjuntos().size());
		
		this.email1.agregarAdjunto(new Archivo("archLogico")); 
		assertEquals(34, this.email1.getTamano());
		assertEquals(2, this.email1.getAdjuntos().size());

		assertEquals(0, this.email2.getAdjuntos().size());
	}
	
	
}
