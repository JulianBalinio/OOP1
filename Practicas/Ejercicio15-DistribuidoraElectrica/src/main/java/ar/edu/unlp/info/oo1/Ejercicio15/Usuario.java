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
		return this.consumos
			.stream()
			.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()))
			.orElse(null);
	}
	
	public double getCostoConsumo() {
		double costo = this.ultimoConsumo().getConsumoEnergiaActiva() * this.cuadroTarifario.getPrecioKwh();
		if(this.tieneBonificacion(this.ultimoConsumo())) {
			return costo * 0.9;
		}
		return costo;
	}
	
	public void agregarConsumo(Consumo consumo) {
		this.consumos.add(consumo);
	}
	
	 private boolean tieneBonificacion(Consumo consumo) {	
		return consumo.factorPotencia() > 0.8;
	}
	
	public Factura emitirFactura(Usuario usuario) {
		Consumo ultimo = this.ultimoConsumo();
		if (ultimo == null) {
			return new Factura(null, false, null, 0);
		}
		boolean bonificacion = this.tieneBonificacion(ultimo);
		Factura factura = new Factura(usuario, bonificacion, LocalDate.now(), this.getCostoConsumo());
		return factura;
	}
	
}
 