package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ClienteVendedorTest {
	
	protected Cliente cliente;
	protected Vendedor vendedor;
	protected Producto p1, p2, p3;
	protected Categoria elec, mueble;
	
	@BeforeEach
	void setUp() throws Exception {
		cliente = new Cliente("Calle falsa");
		vendedor = new Vendedor("Calle comercio");
		
		elec = new Categoria("Electrodomestico");
		mueble = new Categoria("Mueble");
		
		p1 = new Producto("Prod1", elec, 500);
		p2 = new Producto("Prod2", elec, 1000);
		p3 = new Producto("Prod3", mueble, 200);
		
		vendedor.agregarProducto(p1, 10);
		vendedor.agregarProducto(p2, 5);
		vendedor.agregarProducto(p3, 20);
	}
	
	@Test
	void testMapCompras() {
		assertEquals(0, cliente.comprasPorCategoria(elec));
		cliente.crearPedido(vendedor, new RetiroComercio(), new PagoContado(), p1, 11); //No se crea el pedido porque la cantidad supera el stock
		assertEquals(0, cliente.comprasPorCategoria(elec));
		cliente.crearPedido(vendedor, new RetiroComercio(), new PagoContado(), p1, 6);
		assertEquals(6, cliente.comprasPorCategoria(elec));
		assertEquals(0, cliente.comprasPorCategoria(mueble));
		cliente.crearPedido(vendedor, new RetiroComercio(), new PagoContado(), p3, 15);
		assertEquals(15, cliente.comprasPorCategoria(mueble));
	}
	
	@Test
	void testInventario() {
		assertEquals(10, vendedor.consultarStock(p1));
		cliente.crearPedido(vendedor, new RetiroComercio(), new PagoContado(), p1, 6);
		assertEquals(4, vendedor.consultarStock(p1));
		assertEquals(5, vendedor.consultarStock(p2));
		assertEquals(20, vendedor.consultarStock(p3));
		cliente.crearPedido(vendedor, new RetiroComercio(), new PagoContado(), p3, 12);
		assertEquals(8, vendedor.consultarStock(p3));
	}
	
	
}
