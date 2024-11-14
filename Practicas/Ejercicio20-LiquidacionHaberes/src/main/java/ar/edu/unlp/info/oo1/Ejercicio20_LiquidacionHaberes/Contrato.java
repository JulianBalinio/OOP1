package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Contrato {

	private LocalDate fechaInicio;
	
	public Contrato(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public LocalDate getFechaInicio() {
		return this.fechaInicio;
	}
	
	
	public int mesesTrabajados() {
		return (int) ChronoUnit.MONTHS.between(this.getFechaInicio(), LocalDate.now());

	}
	
	public abstract boolean estaVigente();
	public abstract double sueldo(boolean hijo, boolean conyuge);	
}