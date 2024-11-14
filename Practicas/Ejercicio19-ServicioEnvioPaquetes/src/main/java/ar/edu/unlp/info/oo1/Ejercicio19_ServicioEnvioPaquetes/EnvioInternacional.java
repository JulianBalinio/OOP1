package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import java.time.LocalDate;

public class EnvioInternacional extends Envio {

	public EnvioInternacional(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double peso) {
		super(fechaDespacho, dirOrigen, dirDestino, peso);
	}
	
	private double costoBasico() {
		return 5000;
	}
	
	public double calcularCosto() {
		double costoBasico = this.costoBasico();
		if (this.getPeso() < 1000) {
			return costoBasico + this.getPeso() * 10;
		}
		return costoBasico + this.getPeso() * 12;
	}
}
