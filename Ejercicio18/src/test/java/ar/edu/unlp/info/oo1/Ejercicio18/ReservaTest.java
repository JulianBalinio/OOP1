package ar.edu.unlp.info.oo1.Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class ReservaTest {

	protected Reserva reserva, reserva2;
	protected Usuario usuario;
	protected Propiedad propiedad;
	protected DateLapse lapso, lapso1;

	@BeforeEach
	void setUp() throws Exception {
		usuario = new Usuario("Usuario", "Calle", 12345);
		propiedad = new Propiedad("Casa", "Calle 1", 100);
		lapso = new DateLapse(LocalDate.of(2024, 10, 10), LocalDate.of(2024, 10, 20));
		lapso1 = new DateLapse(LocalDate.of(2024, 10, 18), LocalDate.of(2024, 10, 25));
		reserva = new Reserva(usuario, propiedad, lapso);
	}
	
	@Test
	void testCalcularPrecio() {
		
		assertEquals(1000, reserva.calcularPrecio());
	}
	
	@Test
	void testIsOverlapsed() {
		assertTrue(reserva.isOverlapsed(lapso1));
	}
	
	@Test
	void testEnCurso() {
		reserva2 = new Reserva(usuario, propiedad, lapso1);
		assertTrue(reserva.enCurso());
		assertFalse(reserva2.enCurso());
	}
	
	




}
