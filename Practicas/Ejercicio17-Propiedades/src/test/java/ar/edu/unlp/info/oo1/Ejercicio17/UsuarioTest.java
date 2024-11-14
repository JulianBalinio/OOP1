package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	
	protected Usuario user;
	protected Propiedad p1, p2;
	protected DateLapse lapso, lapso1, lapsoBuscado;
	
	@BeforeEach
	void setUp() throws Exception {
		user = new Usuario("Julian", "Mi direccion", 12345);
		
		p1 = new Propiedad("Casa 1", "Calle 1", 100);
		p2 = new Propiedad("Casa 2", "Calle 2", 200);
		user.agregarPropiedad(p1);
		user.agregarPropiedad(p2);
		
		lapso = new DateLapse(LocalDate.of(2024, 10, 10), LocalDate.of(2024, 10, 20)); //1000
		p1.agregarReserva(new Reserva(user, p1, lapso));
		lapso1 = new DateLapse(LocalDate.of(2024, 10, 17), LocalDate.of(2024, 10, 20)); //600
		p2.agregarReserva(new Reserva(user, p2, lapso1));
		
		lapsoBuscado = new DateLapse(LocalDate.of(2024, 10, 10), LocalDate.of(2024, 10, 20));
	}
	
	@Test
	void testPropiedades() {
		assertEquals(2, user.getPropiedades().size());		
		user.agregarPropiedad(new Propiedad("Casa 3", "Calle 3", 50));
		assertEquals(3, user.getPropiedades().size());
	}
	
	@Test
	void testCalcularIngreso() {
		assertEquals(1200, user.calcularIngresos(lapsoBuscado));
	}
	
}