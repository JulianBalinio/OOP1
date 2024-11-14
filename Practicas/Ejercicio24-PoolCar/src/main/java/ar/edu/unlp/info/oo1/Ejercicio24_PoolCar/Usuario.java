package ar.edu.unlp.info.oo1.Ejercicio24_PoolCar;

public abstract class Usuario {
	
	private String nombre;
	private double saldo;
	
	public Usuario(String nombre, double saldo) {
		this.nombre = nombre;
		this.saldo = saldo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void descontarSaldo(double monto) {
		this.saldo -= monto;
	}
}
