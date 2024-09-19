package ar.edu.unlp.info.oo1.Ejercicio7;

import java.util.ArrayList;
import java.util.List;


public class Farola {
	
	private boolean encendida;
	private List<Farola> vecinos;
	
	public Farola() {
		this.encendida = false;
		this.vecinos = new ArrayList();
	}
	
	public void addNeighbor(Farola farola) {
		if (!vecinos.contains(farola)) {
			this.vecinos.add(farola);
		}
	}
	
	public List<Farola> getNeighbors() {
		return this.vecinos;
	}
	
	public void pairWithNeighbor(Farola farola) {
		this.addNeighbor(farola);
		farola.addNeighbor(this);
	}
	
	public void turnOff() {
		if(this.isOn()) {
			this.encendida = false;
			this.vecinos.stream().forEach(f -> f.turnOff());
		}
	}
	
	public void turnOn() {
		if(this.isOff()) {
			this.encendida = true;
			this.vecinos.stream().forEach(f -> f.turnOn());
		}
	}
	
	public boolean isOn() {
		return this.encendida == true;
	}
	
	public boolean isOff() {
		return this.encendida == false;
	}
}