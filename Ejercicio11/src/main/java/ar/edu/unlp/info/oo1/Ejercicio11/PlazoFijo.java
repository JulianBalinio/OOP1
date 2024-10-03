package ar.edu.unlp.info.oo1.Ejercicio11;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class PlazoFijo implements Inversiones {
	
	private LocalDate fecha;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo(LocalDate fecha, double montoDepositado, double porcentajeDeInteresDiario) {
		
		this.fecha = fecha;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public double valorActual() {
		long dias= DAYS.between(this.fecha, LocalDate.now());
		double montoPorDia= (this.getPorcentajeDeInteresDiario() * this.getMontoDepositado())/100;
		return (this.getMontoDepositado() + (montoPorDia * dias));
	}
	

	public LocalDate getFecha() {
		return this.fecha;
	}

	public double getMontoDepositado() {
		return this.montoDepositado;
	}

	public double getPorcentajeDeInteresDiario() {
		return this.porcentajeDeInteresDiario;
	}
	
	
	
}
