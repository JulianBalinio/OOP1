package ar.edu.unlp.info.oo1.Ejercicio14plus;

import ar.edu.unlp.info.oo1.Ejercicio14.Lapse;
import java.time.LocalDate;

public class DateLapsePlus implements Lapse {
	
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapsePlus(LocalDate from, int sizeInDays) {
		this.from = from;
		this.sizeInDays = sizeInDays;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return (this.getFrom().plusDays(sizeInDays));
	}
	
	public int sizeInDays() {
		return this.sizeInDays;
	}
	
	public boolean includeDate(LocalDate date) {
		return (date.isAfter(this.getFrom()) || date.equals(this.getFrom()))
			&& (date.isBefore(this.getTo()) || date.equals(this.getTo()));
	}
}
