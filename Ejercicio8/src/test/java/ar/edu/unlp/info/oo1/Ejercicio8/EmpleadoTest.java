package ar.edu.unlp.info.oo1.Ejercicio8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class EmpleadoTest {
	
	private Empleado empleado;
	private EmpleadoJerarquico empleadoJ;
	private Gerente gerente;
	
	@BeforeEach
	void setUp() throws Exception {
		this.empleado = new Empleado("Juan");
		this.empleadoJ = new EmpleadoJerarquico("Nelsi");
		this.gerente = new Gerente("Pablo");
	}
	
	/*
	 * Analizar y pensar que imprime cada variable
	 * empleado.sueldoBasico();
	 * empleado.aporte();
	 * empleadoJ.sueldoBasico();
	 * emplaedoJ.aporte();
	 * gerente.sueldoBasico();
	 * gerente.aporte();
	 */
}
