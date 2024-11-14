package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

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
		lapso = new DateLapse(LocalDate.now(), LocalDate.now().plusDays(5));
		lapso1 = new DateLapse(LocalDate.now().plusDays(3), LocalDate.now().plusDays(9));
		reserva = new Reserva(usuario, propiedad, lapso);
	}
	
	@Test
	void testCalcularPrecio() {
		
		assertEquals(500, reserva.calcularPrecio());
	}
	
	@Test
	void testIsOverlapsed() {
		assertTrue(reserva.isOverlapsed(lapso1));
	}
	
	@Test
	void testEnCurso() {
		reserva2 = new Reserva(usuario, propiedad, lapso1);
		//Actualizar las fechas para testear
		assertTrue(reserva.enCurso());
		assertFalse(reserva2.enCurso());
	}
	
	




}
