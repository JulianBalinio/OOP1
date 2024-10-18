package ar.edu.unlp.info.oo1.Ejercicio15;

import java.util.List;
import java.util.ArrayList;

import java.time.LocalDate;

public class Usuario {
	
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;
	private CuadroTarifario cuadroTarifario;
	
	public Usuario(String nombre, String domicilio, CuadroTarifario cuadroTarifario) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumos = new ArrayList<>();
		this.cuadroTarifario = cuadroTarifario;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDomicilio() {
		return this.domicilio;
	}
	
	public List<Consumo> getConsumos(){
		return this.consumos;
	}
	
	public Consumo ultimoConsumo() {
		if (this.consumos.isEmpty()) {
			return null;
		}
		return this.getConsumos().get(this.getConsumos().size()-1);
	}
	
	public double getCostoConsumo() {
		double costo = this.ultimoConsumo().getConsumoEnergiaActiva() * this.cuadroTarifario.getPrecioKwh();
		if(this.tieneBonificacion()) {
			return costo * 0.9;
		}
		return costo;
	}
	
	public void agregarConsumo(Consumo consumo) {
		this.consumos.add(consumo);
	}
	
	public boolean tieneBonificacion() {
		if (this.consumos.isEmpty()) {
			return false;
		}	
		return this.ultimoConsumo().factorPotencia() > 0.8;
	}
	
	public Factura emitirFactura(Usuario usuario) {
		boolean bonificacion = this.tieneBonificacion();
		Factura factura = new Factura(usuario, bonificacion, LocalDate.now(), this.getCostoConsumo());
		return factura;
	}
	
}
 