package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import java.time.LocalDate;

public abstract class Envio {
	
	private LocalDate fechaDespacho;
	private String dirOrigen;
	private String dirDestino;
	private double peso;
	
	public Envio(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double peso) {
		this.fechaDespacho = fechaDespacho;
		this.dirOrigen = dirOrigen;
		this.dirDestino = dirDestino;
		this.peso = peso;
	}
	
	public LocalDate getFechaDespacho() {
		return this.fechaDespacho;
	}
	
	public String getDirOrigen() {
		return this.dirOrigen;
	}
	
	public String getDirDestino() {
		return this.dirDestino;
	}
	
	public double getPeso() {
		return this.peso;
	}
	
	public abstract double calcularCosto();
	
}
