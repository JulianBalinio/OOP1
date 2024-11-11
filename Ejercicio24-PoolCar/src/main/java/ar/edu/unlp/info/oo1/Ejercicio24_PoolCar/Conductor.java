package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

import java.time.LocalDate;

public class Conductor extends Usuario {
	
	private Vehiculo vehiculo;
	
	public Conductor(String nombre, double saldo, Vehiculo vehiculo) {
		super(nombre, saldo);
		this.vehiculo = vehiculo;
	}
	
	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}
	
	public Viaje registrarViaje(String origen, String destino, double costoTotal, LocalDate fecha) {
		if (this.vehiculo != null) return new Viaje(origen, destino, costoTotal, this.vehiculo, fecha, this);
		return null;
	}
	
	//considerar usar metodo para agregar un auto en lugar de enviarlo por constructor
	
}
