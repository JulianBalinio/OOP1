package ar.edu.unlp.info.oo1.Ejercicio15;

import java.util.List;
import java.util.ArrayList;

public class Distribuidora {

	private CuadroTarifario cuadroTarifario;
	private List<Usuario> usuarios;
	private List<Factura> facturas;
	
	public Distribuidora(CuadroTarifario cuadroTarifario) {
		this.cuadroTarifario = cuadroTarifario;
		this.usuarios = new ArrayList<>();
		this.facturas = new ArrayList<>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
	
	public void agregarFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	public CuadroTarifario getCuadroTarifario() {
		return this.cuadroTarifario;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public Factura emitirFactura(Usuario usuario) {
		if (!this.getUsuarios().contains(usuario)) {
			return null;
		}
		boolean bonificacion = usuario.tieneBonificacion();
		Factura factura = new Factura(usuario, bonificacion, cuadroTarifario);
		this.agregarFactura(factura);
		return factura;
	}
	
	public void actualizarTarifa(double precio) {
		this.cuadroTarifario.actualizarPrecioKwh(precio);
	}	

}
