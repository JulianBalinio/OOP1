package ar.edu.unlp.info.oo1.Ejercicio17;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
	
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedades;
	private List<Reserva> reservas;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.dni = dni;
		this.propiedades = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}
	
	public List<Propiedad> getPropiedades() {
		return this.propiedades;
	}

	
	public void agregarPropiedad(Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public void eliminarReserva(Reserva reserva) {
		this.reservas.remove(reserva);
	}
	
	public double calcularIngresos(DateLapse lapse) {
		return this.getPropiedades().stream()
				.flatMap(p -> p.getReservas().stream())
				.filter(r -> r.isOverlapsed(lapse))
				.mapToDouble(Reserva::calcularPrecio)
				.sum() * 0.75;
	}
}
