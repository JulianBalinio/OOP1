package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

import java.time.LocalDate;

public class Conductor extends Usuario {
	
	private Vehiculo vehiculo;
	
	public Conductor(String nombre, double saldo, Vehiculo vehiculo) {
		super(nombre, saldo);
		this.vehiculo = vehiculo;
	}
	
	public Viaje registrarViaje(String origen, String destino, double costoTotal, LocalDate fecha) {
		if (this.vehiculo != null) {
			Viaje viaje = new Viaje(origen, destino, costoTotal, this.vehiculo, fecha, this);
			this.agregarViaje(viaje);
			return viaje;
		}	
		return null;
	}	
}
