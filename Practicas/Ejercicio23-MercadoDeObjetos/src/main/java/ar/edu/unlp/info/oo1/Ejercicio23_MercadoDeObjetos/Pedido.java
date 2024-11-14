package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

public class Pedido {

	private Vendedor vendedor;
	private FormaEnvio envio;
	private FormaPago pago;
	private Producto producto;
	private int cantidad;
	private double total;
	
	public Pedido(Vendedor vendedor, FormaEnvio envio, FormaPago pago, Producto producto, int cantidad, double total) {
		this.vendedor = vendedor;
		this.envio = envio;
		this.pago = pago;
		this.producto = producto;
		this.cantidad = cantidad;
		this.total = total;
	}
	
	public Vendedor getVendedor() {
		return this.vendedor;
	}
	
	public Producto getProducto() {
		return this.producto;
	}
	
	public FormaEnvio getEnvio() {
		return this.envio;
	}
	
	public FormaPago getPago() {
		return this.pago;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	
}
