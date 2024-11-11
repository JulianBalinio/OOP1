package ar.edu.unlp.info.oo1.Ejercicio15;

import java.time.LocalDate;

public class Consumo {
	
	private double consumoEnergiaActiva;	
	private double consumoEnergiaReactiva;
	private LocalDate fecha;
	
	public Consumo(double consumoEnergiaActiva, double consumoEnergiaReactiva, LocalDate fecha) {
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
		this.fecha = fecha;
	}
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	public double getConsumoEnergiaReactiva() {
		return this.consumoEnergiaReactiva;
	}
	
	public double factorPotencia() {
		return this.getConsumoEnergiaActiva() / 
				Math.sqrt(Math.pow(this.getConsumoEnergiaActiva(), 2) +	
						  Math.pow(this.getConsumoEnergiaReactiva(), 2));
	}
	
	public double costoEnBase(CuadroTarifario cuadroTarifario) {
		return this.consumoEnergiaActiva * cuadroTarifario.getPrecioKwh();
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
}
