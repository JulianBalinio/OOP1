package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {
	
	private double sueldo;
	private double montoPorConyuge;
	private double montoPorHijos;
	
	public ContratoDePlanta(LocalDate fechaInicio, double sueldo
							, double montoPorConyuge, double montoPorHijos) {
		super(fechaInicio);
		this.sueldo = sueldo;
		this.montoPorConyuge = montoPorConyuge;
		this.montoPorHijos = montoPorHijos;
	}
	
	public double getMontoPorConyuge() {
		return this.montoPorConyuge;
	}
	
	public double getMontoPorHijos() {
		return this.montoPorHijos;
	}
	
	public boolean estaVigente() {
		return !super.getFechaInicio().isAfter(LocalDate.now());
	}
	
	public double sueldo(boolean conyuge, boolean hijos) {
		double sueldoBase = sueldo;
		if (conyuge) sueldoBase += this.getMontoPorConyuge();
		if (hijos) sueldoBase += this.getMontoPorHijos();
		return sueldoBase;
	}
}
