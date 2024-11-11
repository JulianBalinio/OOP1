package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class PedidoTest {
	
	protected FormaEnvio correo, comercio, express;
	protected FormaPago contado, cuotas;
	protected Producto prod;
	protected Pedido pedido;
	protected Vendedor vendedor;
	protected Cliente cliente;

	@BeforeEach
	void setUp() throws Exception {
		vendedor = new Vendedor("Calle Comercio");
		cliente = new Cliente("Calle clientela");
		
		correo = new RetiroCorreo();
		comercio = new RetiroComercio();
		express = new EnvioExpress();
		
		contado = new PagoContado();
		cuotas = new Pago6Cuotas();
		prod = new Producto("prod", new Categoria("cat"), 200);
		
		vendedor.agregarProducto(prod, 10);
	}
	
	@Test
	void testContadoCorreo() {
		pedido = cliente.crearPedido(vendedor, correo, contado, prod, 5);
		assertEquals(4000, pedido.getTotal());
	}
	
	@Test
	void testContadoComercio() {
		pedido = cliente.crearPedido(vendedor, comercio, contado, prod, 5);
		assertEquals(1000, pedido.getTotal());
	}
	
	@Test
	void testContadoExpress() {
		pedido = cliente.crearPedido(vendedor, express, contado, prod, 5);
		assertEquals(1050, pedido.getTotal());
	}
	
	@Test
	void testCuotasCorreo() {
		pedido = cliente.crearPedido(vendedor, correo, cuotas, prod, 5);
		assertEquals(4200, pedido.getTotal());
	}
	
	@Test
	void testCuotasComercio() {
		pedido = cliente.crearPedido(vendedor, comercio, cuotas, prod, 5);
		assertEquals(1200, pedido.getTotal());
	}
	
	@Test
	void testCuotasExpress() {
		pedido = cliente.crearPedido(vendedor, express, cuotas, prod, 5);
		assertEquals(1250, pedido.getTotal());
	}
	
}

