package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ViajeTest {
	
	protected Pasajero p1, p2, p3, p4, p5;
	protected Conductor conductor;
	protected Viaje viajeBarato, viajeCaro;
	protected Vehiculo vehiculo;
	
	@BeforeEach
	void setUp() throws Exception {
		
		p1 = new Pasajero("Ju", 1750);
		p2 = new Pasajero("Li", 700);
		p3 = new Pasajero("An", 900);
		p4 = new Pasajero("Julian", 600);
		p5 = new Pasajero("Nailuj", 2500);
		
		vehiculo = new Vehiculo(conductor, "descripcion", 5, 1997, 40000.0);
		conductor = new Conductor("Chofer", 1200, vehiculo);

		viajeBarato = conductor.registrarViaje("Berisso", "Bs. As.", 1000, LocalDate.now().plusDays(5));
		viajeCaro = conductor.registrarViaje("Berisso", "Salta", 3500, LocalDate.now().plusDays(10));
	
		p1.inscribirse(viajeBarato);
		p2.inscribirse(viajeBarato);
		p3.inscribirse(viajeBarato);
	}
	
	
	
	
	@Test
	void testRegistroBarato() {
		assertEquals(4, viajeBarato.totalPasajeros());
		assertTrue(p4.inscribirse(viajeBarato));
		assertEquals(5, viajeBarato.totalPasajeros());
		assertFalse(p5.inscribirse(viajeBarato));
		assertEquals(5, viajeBarato.totalPasajeros());
	}
	
	@Test 
	void testRegistroCaro() {
		assertTrue(p1.inscribirse(viajeCaro)); //Cuota 1750 (p1 = 1750)
		assertFalse(p2.inscribirse(viajeCaro)); //Cuota 1166 (p2 = 700)
		assertFalse(p3.inscribirse(viajeCaro)); //Cuota  1166 (p3 = 900)
		assertFalse(p4.inscribirse(viajeCaro));//Cuota 1166 (p4 = 200)
		assertTrue(p5.inscribirse(viajeCaro)); //Cuota 1166 (p5 = 2500)
		assertEquals(3, viajeCaro.totalPasajeros());
		
		assertTrue(p3.inscribirse(viajeCaro)); //Ahora puede. Cuota actual 875 (p3 = 900)
		assertEquals(4, viajeCaro.totalPasajeros());
		assertTrue(p2.inscribirse(viajeCaro)); //Puede poqrue la cuota = 700. Capacidad max alcanzada
		assertEquals(5, viajeCaro.totalPasajeros());
		
		assertFalse(p4.inscribirse(viajeCaro)); //Podria porque si 3500/6 = 583,3. Pero capacidad max alcanzada
	}
	
}