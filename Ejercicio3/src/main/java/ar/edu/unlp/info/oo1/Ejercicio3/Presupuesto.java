package ar.edu.unlp.info.oo1.Ejercicio3;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Presupuesto {
	
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
		this.fecha = LocalDate.now();
		this.items = new ArrayList<Item>();
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal() {
		double total = 0;
		for(Item item : this.items) {
			total += item.costo();
		}
		return total;
	}
	
	
}