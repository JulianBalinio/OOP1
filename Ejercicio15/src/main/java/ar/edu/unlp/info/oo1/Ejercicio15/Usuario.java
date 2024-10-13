package ar.edu.unlp.info.oo1.Ejercicio15;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	private String domicilio;
	private List<Consumo> consumos;
	
	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.consumos = new ArrayList<>();
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
	
	public double getCostoConsumo(double precioKwh) {
		return this.ultimoConsumo().getConsumoEnergiaActiva() * precioKwh;
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
	
}
 