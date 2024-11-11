	package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;
	
	import java.time.LocalDate;
	
	public class EnvioInterurbano extends Envio{
		
		private int distanciaKm;
		
		public EnvioInterurbano(LocalDate fechaDespacho, String dirOrigen, String dirDestino, double peso, int distanciaKm) {
			super(fechaDespacho, dirOrigen, dirDestino, peso);
			this.distanciaKm = distanciaKm;
		}
		
		public int getDistanciaKm() {
			return this.distanciaKm;	}
		
		protected double tarifa() {
			if (this.distanciaKm < 100) return 20;
			if (this.distanciaKm <= 500) return 25;
			return 30;
		}
		
		public void setDistanciaKm(int distanciaKm) {
			this.distanciaKm = distanciaKm;
		}
		
		public double calcularCosto() {
			return this.getPeso() * this.tarifa();
		}
	}
