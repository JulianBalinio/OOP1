package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

public class CancelacionFlexible implements PoliticaCancelacion{
	
	public double calcularReembolso(Reserva reserva) {
		return reserva.calcularPrecio();
	}
}
