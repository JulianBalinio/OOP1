package ar.edu.unlp.info.oo1.Ejercicio2;

public class Balanza {
	
	private double pesoTotal;
	private double precioTotal;
	private int cantidadDeProductos;
	
	public void ponerEnCero() {
		this.pesoTotal = 0;
		this.precioTotal = 0;
		this.cantidadDeProductos = 0;
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
	
	public void agregarProducto(Producto producto) {
		this.pesoTotal += producto.getPeso();
		this.precioTotal += producto.getPrecio();
		this.cantidadDeProductos++;
	}
	
	public Ticket emitirTicket() {
		return new Ticket(this.cantidadDeProductos, this.pesoTotal, this.precioTotal);
	}
}