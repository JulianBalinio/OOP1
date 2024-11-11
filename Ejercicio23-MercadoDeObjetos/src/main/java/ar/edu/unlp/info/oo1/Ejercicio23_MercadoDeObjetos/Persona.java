package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

public abstract class Persona {

	private String direccion;
	
	public Persona(String direccion) {
		this.direccion = direccion;
	}
	
	public String getDireccion() {
		return this.direccion;
	}
}
