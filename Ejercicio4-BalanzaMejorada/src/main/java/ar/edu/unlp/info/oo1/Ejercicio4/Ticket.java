package ar.edu.unlp.info.oo1.Ejercicio4;

import java.time.LocalDate;


public class Ticket{
	
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	
	public Ticket(int cantProd, double pesoTotal, double precioTotal) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantProd;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal + impuesto();
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	
	public double impuesto() {
		return (this.precioTotal * 0.21);
	}
}