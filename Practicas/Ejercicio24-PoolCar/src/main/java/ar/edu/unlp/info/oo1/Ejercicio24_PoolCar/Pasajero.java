package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

public class Pasajero extends Usuario{

	public Pasajero(String nombre, double saldo) {
		super(nombre, saldo);
	}
	
	public boolean inscribirse(Viaje viaje) {
		if(viaje.registrarPasajero(this)){
			this.agregarViaje(viaje);
			return true;
		}
		return false;
	}
	
	public boolean tieneFondos(double cuota) {
		return this.getSaldo() >= cuota;
	}
}
