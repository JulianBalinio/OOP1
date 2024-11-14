package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PropiedadTest {
	
	protected Propiedad propiedad, propiedad2;
	protected Reserva r1, r2, r3;
	protected Usuario user;
	protected DateLapse lapso, lapso2, lapso3;
	
	@BeforeEach
	void setUp() throws Exception {
		propiedad = new Propiedad("Prop", "Calle 1", 100);
		propiedad2 = new Propiedad("Prop2", "Calle 2", 200);
		
		user = new Usuario("Julian", "Calle", 12345);
		
		lapso = new DateLapse(LocalDate.of(2024, 10, 17), LocalDate.of(2024, 10, 25));
		lapso2 = new DateLapse(LocalDate.of(2027, 10, 17), LocalDate.of(2024, 10, 25));
		r1 = new Reserva(user, propiedad, lapso);
		r2 = new Reserva(user, propiedad, lapso2);
		r3 = new Reserva(user, propiedad2, lapso);
		
		propiedad.agregarReserva(r1);
		propiedad.agregarReserva(r2);
		propiedad2.agregarReserva(r3);
	}
	
	@Test
	void testContiene() {
		assertTrue(propiedad.contieneReserva(r1));
		assertTrue(propiedad.contieneReserva(r2));
		assertFalse(propiedad.contieneReserva(r3));
		assertFalse(propiedad2.contieneReserva(r1));
	}
	
	@Test
	void testEliminar() {
		assertEquals(2, propiedad.getReservas().size());
		propiedad.eliminarReserva(r1);
		assertEquals(1, propiedad.getReservas().size());
		
		propiedad2.eliminarReserva(r3);
		assertEquals(0, propiedad2.getReservas().size());
	}
	
	@Test
	void testCancelarReserva() {
		assertFalse(propiedad.cancelarReserva(r1));
		assertTrue(propiedad.cancelarReserva(r2));
		assertEquals(1, propiedad.getReservas().size());
	}
	
}
