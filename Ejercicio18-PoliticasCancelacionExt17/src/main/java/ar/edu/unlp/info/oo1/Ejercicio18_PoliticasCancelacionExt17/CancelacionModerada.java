package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

import java.time.LocalDate;

public class CancelacionModerada implements PoliticaCancelacion {
	
	public double calcularReembolso(Reserva reserva) {
		LocalDate hoy = LocalDate.now();
		LocalDate inicioReserva = reserva.getLapse().getFrom();
		
		int diasAntes = hoy.until(inicioReserva).getDays();
		
		if(diasAntes >= 7) {
			return reserva.calcularPrecio();
		} else if(diasAntes >= 2) {
			return reserva.calcularPrecio()/2;
		}
		return 0;
	}
}
