package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import java.time.LocalDate;

public class EnvioLocal extends Envio{
	
	private boolean rapido;
	
	public EnvioLocal(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double peso, boolean rapido) {
		super(fechaDespacho, dirOrigen, dirDestino, peso);
		this.rapido = rapido;
	}
	
	public boolean getRapido() {
		return this.rapido;
	}
	
	public void toggleRapido() {
		this.rapido = !this.rapido;
	}
	
	public double costoBasico() {
		return 1000;
	}
	
	public double calcularCosto() {
		if (this.rapido) {
			return this.costoBasico() + 500;
		}
		return costoBasico();
	}
}
