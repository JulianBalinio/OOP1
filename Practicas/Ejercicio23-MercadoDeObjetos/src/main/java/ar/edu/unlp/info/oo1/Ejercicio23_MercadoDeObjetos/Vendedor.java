package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

import java.util.HashMap;
import java.util.Map;

public class Vendedor extends Persona {
	
	private Map<Producto, Integer> productos;
	
	public Vendedor(String direccion) {
		super(direccion);
		this.productos = new HashMap<>();
	}
	
	public void agregarProducto(Producto producto, int cantidad) {
		this.productos.put(producto, cantidad);
	}
	
	private boolean hayDisponibilidad(Producto producto, int cantidad) {
		return this.consultarStock(producto) >= cantidad;
	}
	
	public int consultarStock(Producto producto) {
		return this.productos.getOrDefault(producto, 0);
	}
	
	private void reducirStock(Producto producto, int cantidad) {
		this.productos.put(producto, this.consultarStock(producto) - cantidad);
	}
	
	public boolean tomarPedido(Producto producto, int cantidad) {
		if (!this.hayDisponibilidad(producto, cantidad)) {
			return false;
		}
		this.reducirStock(producto, cantidad);
		return true;
	}
	
	
	
}
