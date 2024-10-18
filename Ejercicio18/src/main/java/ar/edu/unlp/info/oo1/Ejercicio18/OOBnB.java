package ar.edu.unlp.info.oo1.Ejercicio18;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class OOBnB {
	
	private List<Usuario> usuarios;
	private List<Reserva> reservas;
	
	public OOBnB() {
		this.usuarios = new ArrayList<>();
		this.reservas = new ArrayList<>();
	}

	
	
	
	
	
	public double calcularIngresosUsuario(Usuario usuario, DateLapse lapse) {
		return usuario.calcularIngresos(lapse) * 0.75;
	}
}
