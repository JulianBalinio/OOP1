package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

public class ClienteTest {

	protected Cliente pers, corp;
	protected Envio env1, env2, envFueraLapso, envLapso;
	protected LocalDate fecha, dosDias, ochoDias;
	protected DateLapse lapso;
	
	@BeforeEach
	void setUp() throws Exception {
		pers = new PersonaFisica("Julian", "Calle 1", 12345);
		corp = new ClienteCorporativo("JCorp", "Calle 2", 54321);
		
		dosDias = LocalDate.now().minusDays(2);
		ochoDias = LocalDate.now().plusDays(8);
		
		env1 = new EnvioLocal(LocalDate.now(), "origen", "destino", 500, false); //$1000
		env2 = new EnvioInternacional(LocalDate.now().plusDays(5), "origen", "destino", 900); //$14000
		
		//Se agregan en los test
		envFueraLapso = new EnvioLocal(LocalDate.now().plusDays(10), "origen", "destino", 500, false);
		envLapso = new EnvioLocal(LocalDate.now().plusDays(7), "origen", "destino", 500, false);
		
		pers.agregarEnvio(env1);
		pers.agregarEnvio(env2);
		corp.agregarEnvio(env1);
		corp.agregarEnvio(env2);
		//Lapso de 10 dias
		lapso = new DateLapse(dosDias, ochoDias);
	}
	
	@Test
	void testClienteCorporativo() {
		assertEquals(15000, corp.calcularMontoPeriodo(lapso));
		corp.agregarEnvio(envFueraLapso);
		assertEquals(15000, corp.calcularMontoPeriodo(lapso));
		corp.agregarEnvio(envLapso);
		assertEquals(16000, corp.calcularMontoPeriodo(lapso));
		
	}
	
	@Test
	void testPersonFisica() {
		assertEquals(13500, pers.calcularMontoPeriodo(lapso));
		pers.agregarEnvio(envFueraLapso);
		assertEquals(13500, pers.calcularMontoPeriodo(lapso));
		pers.agregarEnvio(envLapso);
		assertEquals(14400, pers.calcularMontoPeriodo(lapso));
	}
	
}
