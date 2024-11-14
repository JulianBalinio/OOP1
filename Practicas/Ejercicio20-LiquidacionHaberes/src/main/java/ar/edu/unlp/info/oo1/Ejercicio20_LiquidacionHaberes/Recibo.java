package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import java.time.LocalDate;

public class Recibo {

	private String nombre;
	private String apellido;
	private int cuil;
	private int antiguedad;
	private LocalDate fechaEmision;
	private double monto;
	
	public Recibo(String nombre, String apellido, int cuil, int antiguedad, LocalDate fechaEmision, double monto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.antiguedad = antiguedad;
		this.fechaEmision = fechaEmision;
		this.monto = monto;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	
	public int getCuil() {
		return this.cuil;
	}
	
	public int getAntiguedad() {
		return this.antiguedad;
	}
	
	public LocalDate getFecha() {
		return this.fechaEmision;
	}
	
	public double getMonto() {
		return this.monto;
	}
}
