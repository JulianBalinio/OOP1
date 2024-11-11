package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

import java.time.LocalDate;

public class DateLapse{
	
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public LocalDate getTo() {
		return this.to;
	}
	
	public int sizeInDays() {
		return this.from.until(this.to).getDays();
	}	
	
	public boolean includeDate(LocalDate date) {
	    return (date.isAfter(this.getFrom()) || date.equals(this.getFrom())) 
	        && (date.isBefore(this.getTo()) || date.equals(this.getTo()));
	}
	
	public boolean overlapse(DateLapse date) {
		return (date.includeDate(this.from) || date.includeDate(this.to));
	}
}
