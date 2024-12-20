package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

import java.util.List;
import java.util.ArrayList;

public abstract class Cliente {
	
	private String nombre;
	private String direccion;
	private List<Envio> envios;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.envios = new ArrayList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
	
	public List<Envio> getEnvios(){
		return this.envios;
	}
	
	public void agregarEnvio(Envio envio) {
		this.envios.add(envio);
	}
	
	public double calcularMontoPeriodo(DateLapse lapso) {
		return this.envios.stream()
				.filter(envio -> lapso.includeDate(envio.getFechaDespacho()))
				.mapToDouble(envio -> envio.calcularCosto()).sum();
	}
}
