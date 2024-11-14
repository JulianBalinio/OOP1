package ar.edu.unlp.info.oo1.Ejercicio22_EstadisticasClienteCorreo;

import java.util.List;
import java.util.ArrayList;

public class Email {
	
	private String titulo;
	private String cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.adjuntos = new ArrayList<>();
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> getAdjuntos() {
		return this.adjuntos;
	}
	
	public int getTamano() {
		return ((this.adjuntos.stream().mapToInt(Archivo :: getTamano).sum()) + this.getCuerpo().length() + this.getTitulo().length());
	}
	
	public boolean contiene(String texto) {
		return (this.titulo.contains(texto) || this.cuerpo.contains(texto));
	}
	
	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);
	}
	
}
