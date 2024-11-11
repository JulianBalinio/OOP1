package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

public class ClienteCorporativo extends Cliente {

	private int cuit;
	
	public ClienteCorporativo(String nombre, String direccion, int cuit) {
		super(nombre, direccion);
		this.cuit = cuit;
	}
	//Tampoco se utiliza el cuit en el ejercicio, el getter esta demas
}
