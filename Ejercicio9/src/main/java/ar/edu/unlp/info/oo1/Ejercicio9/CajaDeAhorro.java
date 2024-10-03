package ar.edu.unlp.info.oo1.Ejercicio9;

public class CajaDeAhorro extends Cuenta{
	
	private double comision = 1.02;
	
	public CajaDeAhorro() {
		super();
	}
	
	public boolean extraer(double monto) {
		return super.extraer(monto * comision);
	}
	
	public boolean puedeExtraer(double monto) {
		return (this.getSaldo() - (monto * comision) >= 0);
	}
}
