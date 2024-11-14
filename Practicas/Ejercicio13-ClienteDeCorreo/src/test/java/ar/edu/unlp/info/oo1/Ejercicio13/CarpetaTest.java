package ar.edu.unlp.info.oo1.Ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CarpetaTest {
	
	private Carpeta inbox;
	private Email email1;
	private Email email2;
	
	@BeforeEach
	void setUp() {
		this.inbox = new Carpeta("inbox");
		this.email1 = new Email("Hola", "Mundo");
		this.email2 = new Email("Hello", "World");
		this.inbox.agregarEmail(email1);
		this.inbox.agregarEmail(email2);
	}
	
	@Test
	void testTamano() {
		assertNotEquals(9, this.inbox.getTamano());
		assertEquals(19, this.inbox.getTamano());
		assertNotEquals(20, this.inbox.getTamano());
	}
	
	@Test
	void testListEmails() {
		assertEquals(2, this.inbox.getEmails().size());
		assertNotEquals(1, this.inbox.getEmails().size());
		this.inbox.agregarEmail(new Email("Que", "Tal"));
		assertEquals(3, this.inbox.getEmails().size());
	}
	
	@Test
	void testContiene() {
		assertEquals(email1, this.inbox.contiene("Mundo"));
		assertNotEquals(email1, this.inbox.contiene("World"));
		
		assertEquals(email2, this.inbox.contiene("Hello"));
		assertNotEquals(email2, this.inbox.contiene("Hola"));
	}
	
	@Test
	void testEliminarMail() {
		assertTrue(this.inbox.eliminarEmail(email1));
		assertEquals(1, this.inbox.getEmails().size());
		assertEquals(10, this.inbox.getTamano());
		assertFalse(this.inbox.eliminarEmail(email1));
	}
	
	@Test
	void testAgregarMail() {
		this.inbox.agregarEmail(new Email("A", "B"));
		assertEquals(3, this.inbox.getEmails().size());
		assertEquals(21, this.inbox.getTamano());
		
		this.inbox.agregarEmail(new Email("ABC", "DEF"));
		assertEquals(4, this.inbox.getEmails().size());
		assertEquals(27, this.inbox.getTamano());
		
		
	}
	
	
}
