package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PasajeroTest {
	
	protected Pasajero p1, p2;
	protected Conductor conductor;
	protected Viaje viaje;
	protected Vehiculo vehiculo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		p1 = new Pasajero("Julian", 1500);
		p2 = new Pasajero("Nailuj", 500);
		
		vehiculo = new Vehiculo(conductor, "descripcion", 5, 1997, 40000.0);
		conductor = new Conductor("Chofer", 1200, vehiculo);

		viaje = conductor.registrarViaje("Berisso", "Bs. As.", 1400, LocalDate.now().plusDays(5));
	}
	
	@Test
	void testRegistroConSaldo() {
		assertTrue(p1.inscribirse(viaje));
	}
	
	@Test
	void testRegistroSinSaldo() {
		assertFalse(p2.inscribirse(viaje));
	}
}
