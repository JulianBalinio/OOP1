package ar.edu.unlp.info.oo1.Ejercicio22_EstadisticasClienteCorreo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {

	private ClienteDeCorreo cdc;
	
	private Carpeta spam;
	private Carpeta favorito;
	private Carpeta enviado;
	
	private Email eHolaMundo, eHelloWorld, eSpam, eDestacado;
	
	@BeforeEach
	void setUp() {
		this.cdc = new ClienteDeCorreo();
		
		this.spam = new Carpeta("spam");
		this.favorito = new Carpeta("favorito");
		this.enviado = new Carpeta("enviado");
		
		this.eHolaMundo = new Email("Hola", "Mundo");
		this.eHelloWorld = new Email("Hello", "World");
		this.eSpam = new Email("Correo", "Spam");
		this.eDestacado = new Email("Mensaje", "Destacado");
		
		this.cdc.getInbox().agregarEmail(eHolaMundo);
		this.cdc.getInbox().agregarEmail(eHelloWorld);
		this.cdc.getInbox().agregarEmail(eDestacado);
		this.cdc.getInbox().agregarEmail(eSpam);
		
		this.cdc.agregarCarpeta(spam);
		this.cdc.agregarCarpeta(favorito);
		this.cdc.agregarCarpeta(enviado);
	}
	
	@Test
	void testAgregarCarpeta() {
		assertEquals(3, this.cdc.getCarpetas().size());
		this.cdc.agregarCarpeta(new Carpeta("Folder"));
		assertEquals(4, this.cdc.getCarpetas().size());
	}
	
	@Test
	void testRecibir() {
		assertEquals(4, this.cdc.getInbox().getEmails().size());
		this.cdc.recibir(new Email("Nuevo", "Correo"));
		assertEquals(5, this.cdc.getInbox().getEmails().size());
	}
	
	@Test
	void testMover() {
		assertEquals(4, this.cdc.getInbox().getEmails().size());
		this.cdc.mover(eDestacado, this.cdc.getInbox(), favorito);
		assertEquals(3, this.cdc.getInbox().getEmails().size());
		assertEquals(1, favorito.getEmails().size());
		
		this.cdc.mover(eDestacado, this.cdc.getInbox(), enviado);
		assertEquals(3, this.cdc.getInbox().getEmails().size());
		assertEquals(0, enviado.getEmails().size());		
		
		this.cdc.mover(eSpam, this.cdc.getInbox(), spam);
		assertEquals(2, this.cdc.getInbox().getEmails().size());
		assertEquals(1, spam.getEmails().size());	
	}
	
	@Test
	void testTamano() {
		assertEquals(45, this.cdc.espacioOcupado());
		this.cdc.recibir(new Email("Nuevo", "Correo"));
		assertEquals(56, this.cdc.espacioOcupado());
		
		this.cdc.mover(eDestacado, this.cdc.getInbox(), favorito);
		assertEquals(56, this.cdc.espacioOcupado());
		
		this.eDestacado.agregarAdjunto(new Archivo("Nombre"));
		
		assertEquals(62, this.cdc.espacioOcupado());
		
	}
	
	@Test
	void testBuscar() {
		assertEquals(eSpam, this.cdc.buscar("Spam"));
		
		this.cdc.mover(eDestacado, this.cdc.getInbox(), favorito);
		assertEquals(eDestacado, this.cdc.buscar("Destacado"));
		
		this.cdc.mover(eHelloWorld, this.cdc.getInbox(), enviado);
		assertEquals(eHelloWorld, this.cdc.buscar("World"));
	}
	
	@Test
	void testCantidadTotalEmails() {
		assertEquals(4, this.cdc.cantidadTotalEmails());
		cdc.mover(eDestacado, cdc.getInbox(), favorito);
		assertEquals(4, this.cdc.cantidadTotalEmails());
	}
	
}
