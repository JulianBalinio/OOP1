package ar.edu.unlp.info.oo1.Ejercicio9;

public class CuentaCorriente extends Cuenta {
	
	private double limiteDescubierto;
	
	public CuentaCorriente () {
		super();
		this.limiteDescubierto = 0;
	}
	
	public double getLimiteDescubierto() {
		return this.limiteDescubierto;
	}
	
	public void setLimiteDescubierto(double limite) {
		this.limiteDescubierto = limite;
	}
	
	public boolean puedeExtraer(double monto) {
		return ((this.getSaldo() + this.limiteDescubierto) - monto >= 0);
	}
}