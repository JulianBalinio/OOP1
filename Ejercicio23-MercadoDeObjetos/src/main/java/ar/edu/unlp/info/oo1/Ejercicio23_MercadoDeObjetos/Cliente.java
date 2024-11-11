package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

import java.util.Map;
import java.util.HashMap;

public class Cliente extends Persona {
	
	private Map<Categoria, Integer> mapaCompras;
	
	public Cliente(String direccion) {
		super(direccion);
		this.mapaCompras = new HashMap<>();
	}
	
	public Map<Categoria, Integer> getMapaCompras() {
		return this.mapaCompras;
	}
	
	public int comprasPorCategoria(Categoria categoria) {
		return this.mapaCompras.getOrDefault(categoria, 0);
	}
	
	private void actualizarCompras(Categoria categoria, int cantidad) {
		this.mapaCompras.put(categoria, cantidad);
	}
	
	//Este metodo es correcto que este en la clase Cliente? Envidia de clases?
	public Pedido crearPedido(Vendedor vendedor, FormaEnvio envio, FormaPago pago, Producto producto, int cantidad) {
		if (!vendedor.tomarPedido(producto, cantidad)) {
			return null;
		}
		double costoEnvio = envio.costoEnvio(this.getDireccion(), vendedor.getDireccion());
		double costoPago = pago.costoAdicional();
		double total = (producto.getPrecioUnit()	* cantidad) * costoPago + costoEnvio;
		this.actualizarCompras(producto.getCategoria(), cantidad);
		return new Pedido(vendedor, envio, pago, producto, cantidad, total);
	}
}
