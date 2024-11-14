package ar.edu.unlp.info.oo1.Ejercicio25_Veterinaria;

import java.util.List;
import java.util.ArrayList;

public class Veterinario {

	private String nombre;
	private double honorarios;
	private List<ServicioMedico> servicios;
	
	public Veterinario(String nombre, double honorarios) {
		this.nombre = nombre;
		this.honorarios = honorarios;
		this.servicios = new ArrayList<>();
	}
	
	public double getHonorarios() {
		return this.honorarios;
	}
	
	public List<ServicioMedico> getServicios() {
		return this.servicios;
	}
	
	public double calcularMontoTotal() {
		return this.servicios.stream().mapToDouble(s -> s.getCosto()).sum();
	}
	
	public void registrarServicio(ServicioMedico servicio) {
		this.servicios.add(servicio);
	}
}
