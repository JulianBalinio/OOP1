package ar.edu.unlp.info.oo1.Ejercicio14;

import java.time.LocalDate;

public interface Lapse {
	public LocalDate getFrom();
	public LocalDate getTo();
	public int sizeInDays();
	public boolean includeDate(LocalDate date);
}
