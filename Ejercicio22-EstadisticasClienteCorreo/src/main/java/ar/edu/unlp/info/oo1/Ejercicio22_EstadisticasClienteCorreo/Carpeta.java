package ar.edu.unlp.info.oo1.Ejercicio22_EstadisticasClienteCorreo;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Carpeta {
	
	private String nombre;
	private List<Email> emails;
	
	public Carpeta(String nombre) {
		this.nombre = nombre;
		this.emails = new ArrayList<>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getTamano() {
		return this.emails.stream().mapToInt(Email :: getTamano).sum();
	}
	
	public List<Email> getEmails() {
		return this.emails; 
	}
	
	public void agregarEmail(Email email) {
		this.emails.add(email);
	}
	
	public boolean eliminarEmail(Email email) {
		return this.emails.remove(email);
	}
	
	public Email contiene(String texto) {
		boolean encontre = false;
		int i = 0;
		while ((!encontre) && (i < this.getEmails().size())) {
			if (this.getEmails().get(i).contiene(texto)) {
				return this.getEmails().get(i);
			}
			i++;
		}
		return null;
	}
	
	public int cantidadEmails() {
		return this.emails.size();	
	}
	
	public Map<String, Integer> cantidadEmailsCategorizados() {
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("Pequeño", 0);
		mapa.put("Mediano", 0);
		mapa.put("Grande", 0);
		mapa.replace("Pequeño", (int) this.emails.stream().filter(e -> e.getTamano() <= 300).count());
		mapa.replace("Mediano", (int) this.emails.stream().filter(e -> (e.getTamano() >= 301) && (e.getTamano() <= 500)).count());
		mapa.replace("Grande", (int) this.emails.stream().filter(e -> e.getTamano() >= 501).count());
		return mapa;
	}
	
	
	 	
}
