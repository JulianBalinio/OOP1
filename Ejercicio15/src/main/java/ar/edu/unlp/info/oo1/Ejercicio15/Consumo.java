package ar.edu.unlp.info.oo1.Ejercicio15;

public class Consumo {
	
	private double consumoEnergiaActiva;	
	private double consumoEnergiaReactiva;
	
	public Consumo(double consumoEnergiaActiva, double consumoEnergiaReactiva) {
		this.consumoEnergiaActiva = consumoEnergiaActiva;
		this.consumoEnergiaReactiva = consumoEnergiaReactiva;
	}
	
	public double getConsumoEnergiaActiva() {
		return this.consumoEnergiaActiva;
	}
	
	public double getConsumoEnergiaReactiva() {
		return this.consumoEnergiaReactiva;
	}
	
	public double factorPotencia() {
		return this.getConsumoEnergiaActiva() / 
				Math.sqrt(Math.pow(this.getConsumoEnergiaActiva(), 2) +	
						  Math.pow(this.getConsumoEnergiaReactiva(), 2));
	}		
}
