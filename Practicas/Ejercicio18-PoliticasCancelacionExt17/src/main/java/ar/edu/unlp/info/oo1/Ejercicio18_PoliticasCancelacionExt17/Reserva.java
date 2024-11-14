package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

import java.time.LocalDate;

public class Reserva {

	private Usuario usuario;
	private Propiedad propiedad;
	private DateLapse lapse;
	
	public Reserva(Usuario usuario, Propiedad propiedad, DateLapse lapse) {
		this.usuario = usuario;
		this.propiedad = propiedad;
		this.lapse = lapse;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	public double calcularPrecio() {
		return this.lapse.sizeInDays() * this.propiedad.getPrecioNoche();
	}
	
	public boolean isOverlapsed(DateLapse lapse) {
		return this.lapse.overlapse(lapse);
	}
	
	public DateLapse getLapse() {
		return this.lapse;
	}
	
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
	
	public boolean enCurso() {
		return !LocalDate.now().isBefore(this.lapse.getFrom());
	}
}
