package ar.edu.unlp.info.oo1.Ejercicio12;

import java.util.List;
import java.util.ArrayList;

public class ReporteDeConstruccion {

	private List<Pieza> piezas;
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<>();
	}
	
	public List<Pieza> getPiezas() {
		return this.piezas;
	}
	
	public double getVolumenMaterial(String material) {
		return this.piezas.stream()
				.filter(pieza -> pieza.getMaterial().equals(material))
				.mapToDouble(Pieza :: getVolumen).sum();
	}
	
	public double getSuperficieColor(String color) {
		return this.piezas.stream()
				.filter(pieza -> pieza.getColor().equals(color))
				.mapToDouble(Pieza :: getSuperficie).sum();
	}
}
