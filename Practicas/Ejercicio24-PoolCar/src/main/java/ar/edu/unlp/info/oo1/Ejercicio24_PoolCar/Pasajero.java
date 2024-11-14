package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

public class Pasajero extends Usuario{

	public Pasajero(String nombre, double saldo) {
		super(nombre, saldo);
	}
	
	public boolean registrarViaje(Viaje viaje) {
		return viaje.registrarPasajero(this);
	}
	
	public boolean tieneFondos(double cuota) {
		return this.getSaldo() >= cuota;
	}
}