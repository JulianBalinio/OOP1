package ar.edu.unlp.info.oo1.Ejercicio4;

import java.util.ArrayList;
import java.util.List;


public class Balanza {
	
	private List<Producto> productos;
	
	public Balanza() {
		this.productos = new ArrayList<Producto>();
	}
	
	public void ponerEnCero() {
		this.productos.clear();
	}
	
	public double getPesoTotal() {
		double pesoTotal = 0;
		for (Producto producto : this.productos) {
			pesoTotal += producto.getPeso();
		}
		return pesoTotal;
	}
	
	public double getPrecioTotal() {
		double precioTotal = 0;
		for (Producto producto : this.productos) {
			precioTotal += producto.getPrecio();
		}
		return precioTotal;
	}
	
	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public Ticket emitirTicket() {	
		
		return new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());
	}
}
