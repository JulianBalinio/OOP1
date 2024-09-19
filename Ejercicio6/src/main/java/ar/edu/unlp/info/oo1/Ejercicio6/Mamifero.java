package ar.edu.unlp.info.oo1.Ejercicio6;

import java.util.Date;

public class Mamifero {
	 
	private String identificador;
	private String especie;
	private Date fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero(String identificador) {
		this.identificador = identificador;
		this.padre = null;
		this.madre = null;
	}
	
	public Mamifero() {}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public String getEspecie() {
		return this.especie;
	}
	
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}
	
	public Mamifero getPadre() {
		return this.padre;
	}
	
	public Mamifero getMadre() {
		return this.madre;
	}
	
	public Mamifero getAbueloPaterno() {
		Mamifero mamifero = this.getPadre();
		if(mamifero != null) {
			return mamifero.getPadre();
		}
		return mamifero;
	}
	
	public Mamifero getAbueloMaterno() {
		Mamifero mamifero = this.getMadre();
		if(mamifero != null) {
			return mamifero.getPadre();
		}
		return mamifero;
	}
	
	
	public Mamifero getAbuelaPaterna() {
		Mamifero mamifero= this.getPadre();
		if(mamifero != null) {
			return mamifero.getMadre();
		}
		return mamifero;
	}
	public Mamifero getAbuelaMaterna() {
		Mamifero mamifero = this.getMadre();
		if(mamifero != null) {
			return mamifero.getMadre();
		}
		return mamifero;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;		
	}
	
	public boolean tieneComoAncestroA(Mamifero mamifero) {
		boolean ancestro = false;
		if ((this.madre == mamifero) || (this.padre == mamifero)) {
			ancestro = true;
		}
		else {
			if(this.padre != null) {
				ancestro = this.padre.tieneComoAncestroA(mamifero);
			}
			if((!ancestro) && (this.madre != null)) {
				ancestro = this.madre.tieneComoAncestroA(mamifero);
			}
			
		}
		return ancestro;
	}
	
}