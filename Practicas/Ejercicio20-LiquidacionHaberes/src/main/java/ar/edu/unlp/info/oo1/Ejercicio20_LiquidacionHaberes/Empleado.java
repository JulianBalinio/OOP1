package ar.edu.unlp.info.oo1.Ejercicio20_LiquidacionHaberes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado {
	
	private String nombre;
	private String apellido;
	private int cuil;
	private LocalDate fechaNac;
	private boolean conyugeACargo;
	private boolean hijosACargo;
	private List<Contrato> contratos;
	
	public Empleado(String nombre, String apellido, int cuil, LocalDate fechaNac, boolean conyugeACargo, boolean hijosACargo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuil = cuil;
		this.fechaNac = fechaNac;
		this.conyugeACargo = conyugeACargo;
		this.hijosACargo = hijosACargo;
		this.contratos = new ArrayList<>();
	}
	
	public boolean tieneConyuge() {
		return this.conyugeACargo;
	}
	
	public boolean tieneHijos() {
		return this.hijosACargo;
	}
	
	public List<Contrato> getContratos() {
		return this.contratos;
	}
	
	public void agregarContrato(Contrato contrato) {
		this.contratos.add(contrato);
	}
	
	public Contrato contratoVigente() {
	    return this.contratos.stream()
	            .filter(Contrato::estaVigente) // Filtra solo los contratos vigentes
	            .max((c1, c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio())) // Selecciona el contrato con la fecha de inicio más reciente
	            .orElse(null); // Devuelve null si no hay contratos vigentes
	}

	
	public int getAntiguedad() {
		return this.contratos.stream().mapToInt(c -> c.mesesTrabajados()).sum() / 12;
	}
	
	private double bonoAntiguedad(int antiguedad) {
		if (antiguedad >= 20) return  2;
		else if (antiguedad >= 15) return 1.5;
		else if (antiguedad >= 10) return 1.2;
		else if (antiguedad >= 5) return 1.3;
		return 1;
	}
	
	public Recibo emitirRecibo() {
		Contrato cVigente = this.contratoVigente();
		if (cVigente != null) {
			double monto= cVigente.sueldo(this.hijosACargo, this.conyugeACargo);
			monto *= this.bonoAntiguedad(this.getAntiguedad());
			return new Recibo(nombre, apellido, cuil, this.getAntiguedad(), LocalDate.now(), monto);
		}
		return null;
	}

}
