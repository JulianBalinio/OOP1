package ar.edu.unlp.info.oo1.Ejercicio13;

import java.util.List;
import java.util.ArrayList;

public class ClienteDeCorreo {
	
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo() {
		this.inbox = new Carpeta("inbox");
		this.carpetas = new ArrayList<>();
	}
	
	public Carpeta getInbox() {
		return this.inbox;
	}
	
	public List<Carpeta> getCarpetas() {
		return this.carpetas;
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	
	public void mover(Email email, Carpeta origen, Carpeta destino) {
		boolean ok = origen.eliminarEmail(email);
		if (ok)
			destino.agregarEmail(email);
	}
	
	public Email buscar(String texto) {
		for (Carpeta car: carpetas) {
			if(car.contiene(texto) != null)
				return car.contiene(texto);
		}
		if (this.getInbox().contiene(texto) != null) 
			return this.getInbox().contiene(texto);
		return null;
	}
	
	public int espacioOcupado() {
		int espacio = 0;
		for (Carpeta car: carpetas) {
			espacio += car.getTamano();
		}
		espacio += this.getInbox().getTamano();
		return espacio;
	}
	
	public void agregarCarpeta(Carpeta car) {
		this.getCarpetas().add(car);
	}
	
}
