package ar.edu.unlp.info.oo1.Ejercicio14;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class DateLapse implements Lapse{
	
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
		return (int)DAYS.between(this.getFrom(), this.getTo());
	}
	
	public boolean includeDate(LocalDate date) {
	    return (date.isAfter(this.getFrom()) || date.equals(this.getFrom())) 
	        && (date.isBefore(this.getTo()) || date.equals(this.getTo()));
	}
}
