package ar.edu.unlp.info.oo1.Ejercicio15;

import java.time.LocalDate;

public class Factura {
	
	private Usuario usuario;
	private LocalDate fecha;
	private boolean bonificacion;
	private double montoFinal;
	
	public Factura(Usuario usuario, boolean bonificacion, LocalDate fecha, double montoFinal) {
		this.usuario = usuario;
		this.bonificacion = bonificacion;
		this.fecha = fecha;
		this.montoFinal = montoFinal;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public double getMontoFinal() {
		return this.montoFinal;
	}
	
	public boolean getBonificacion() {
		return this.bonificacion;
	}
	
}
