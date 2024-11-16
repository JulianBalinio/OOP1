package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

import java.util.List;
import java.util.ArrayList;

public abstract class Usuario {
	
	private String nombre;
	private double saldo;
	private List<Viaje> viajes;

	public Usuario(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
		this.viajes = new ArrayList<>();
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void descontarSaldo(double monto) {
		this.saldo -= monto;
	}

	protected void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}
}
