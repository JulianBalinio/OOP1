package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Viaje {
	private String origen;
	private String destino;
	private double costoTotal;
	private Vehiculo vehiculo;
	private LocalDate fecha;
	private List<Usuario> pasajeros;

	public Viaje(String origen, String destino, double costoTotal, Vehiculo vehiculo, LocalDate fecha, Conductor conductor) {
		this.origen = origen;
		this.destino = destino;
		this.costoTotal = costoTotal;
		this.vehiculo = vehiculo;
		this.fecha = fecha;
		this.pasajeros = new ArrayList<>();
		this.pasajeros.add(conductor);
	}
	
	private void agregarPasajero(Pasajero pasajero) {
		this.pasajeros.add(pasajero);
	}
	
	private boolean aTiempo() {
		return LocalDate.now().plusDays(2).isBefore(this.fecha);
	}

	public int totalPasajeros() {
		return this.pasajeros.size();
	}
	
	public double calcularCuota(int pasajeros) {
		return this.costoTotal / pasajeros;
	}

	public boolean registrarPasajero(Pasajero pasajero) {
		if (!this.vehiculo.hayLugar(this.totalPasajeros()) || !this.aTiempo() || !pasajero.tieneFondos(this.calcularCuota(this.totalPasajeros() + 1))){
			return false;
		}
		this.agregarPasajero(pasajero);
		return true;
	}

	public void realizar() {
		for(Usuario pasajero: this.pasajeros) {
			pasajero.descontarSaldo(this.calcularCuota(this.totalPasajeros()));
		}
	} 
}
