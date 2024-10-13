package ar.edu.unlp.info.oo1.Ejercicio15;

import java.time.LocalDate;

public class Factura {
	
	private Usuario usuario;
	private LocalDate fecha;
	private boolean bonificacion;
	private double montoFinal;
	
	//Pasar bonificacion(boolean) por parametro y al momento de instanciar evaluar el valor?
	//O llamar al metodo tieneBonificacion en this.usuario?
	public Factura(Usuario usuario, boolean bonificacion, CuadroTarifario cuadroTarifario) {
		this.usuario = usuario;
		this.bonificacion = bonificacion;
		//this.bonificacion = this.usuario.tieneBonificacion();
		this.fecha = LocalDate.now();
		this.montoFinal = this.calcularMontoFinal(cuadroTarifario);
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
	
	public double calcularMontoFinal(CuadroTarifario cuadroTarifario) {
		double costo = this.usuario.getCostoConsumo(cuadroTarifario.getPrecioKwh());
		if (this.bonificacion) {
			return costo * 0.9;
		}
		return costo;
	}
	
	
}
