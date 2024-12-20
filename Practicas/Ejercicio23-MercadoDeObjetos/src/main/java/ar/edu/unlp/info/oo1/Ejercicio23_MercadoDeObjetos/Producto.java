package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

public class Producto {
	private String nombre;
	private Categoria categoria;
	private double precioUnit;
	
	public Producto(String nombre, Categoria categoria, double precioUnit) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precioUnit = precioUnit;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public double getPrecioUnit() {
		return this.precioUnit;
	}
}
