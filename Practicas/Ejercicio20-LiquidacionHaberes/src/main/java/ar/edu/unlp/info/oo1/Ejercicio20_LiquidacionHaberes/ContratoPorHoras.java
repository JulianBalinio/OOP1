package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {

	
	private LocalDate fechaFin;
	private double valorHora;
	private int horasMensuales;
	
	public ContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horasMensuales) {
		super(fechaInicio);
		this.fechaFin = fechaFin;
		this.valorHora = valorHora;
		this.horasMensuales = horasMensuales;
	}
	
	public LocalDate getFechaFin() {
		return this.fechaFin;
	}
	
	public double getValorHora() {
		return this.valorHora;
	}
	
	public int getHorasMensuales() {
		return this.horasMensuales;
	}
	
	public boolean estaVigente() {
		return LocalDate.now().isBefore(this.fechaFin) || LocalDate.now().isEqual(this.fechaFin);
	}

	
	public double sueldo(boolean hijos, boolean conyuges) {
		return this.valorHora * this.horasMensuales * this.mesesTrabajados();
	}
	
}
