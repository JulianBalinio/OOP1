	package ar.edu.unlp.info.oo1.Ejercicio18;
	
	import java.util.List;
	import java.util.ArrayList;
	
	public class Propiedad {
		
		private String nombre;
		private String direccion;
		private double precioNoche;
		private PoliticaCancelacion politica;
		private List<Reserva> reservas;
		
		public Propiedad(String nombre, String direccion, double precioNoche) {
			this.nombre = nombre;
			this.direccion = direccion;
			this.precioNoche = precioNoche;
			this.reservas = new ArrayList<>();
		}
		
		public double getPrecioNoche() {
			return this.precioNoche;
		}
		
		public List<Reserva> getReservas(){
			return this.reservas;
		}
		
		public void agregarReserva(Reserva reserva) {
			this.reservas.add(reserva);
		}		
		
		public void eliminarReserva(Reserva reserva) {
			if (this.contieneReserva(reserva) ) {
				this.reservas.remove(reserva);
			}
		}
		
		

		public boolean contieneReserva(Reserva reserva) {
			return this.reservas.contains(reserva);
		}
	}
