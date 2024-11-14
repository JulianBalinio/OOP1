package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

public class Vehiculo {

	private Conductor conductor;
	private String descripcion;
	private int capacidad;
	private int anoFabricacion;
	private double valor;

	public Vehiculo(Conductor conductor, String descripcion, int capacidad, int anoFabricacion, double valor) {
		this.conductor = conductor;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.anoFabricacion = anoFabricacion;
		this.valor = valor;
	}
	
	public Conductor getConductor() {
		return this.conductor;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}
	
	public boolean hayLugar(int pasajeros) {
		return pasajeros < this.capacidad;
	}
	//Considerar sacar conductor de constructor y asignarlo por setter
	//Considerar usar var booleana para chequear si el auto esta registrado o no para que no lo usen mas de 1 conductor
}
