	package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;
	
	import java.util.List;
	import java.util.ArrayList;
	
	public class Propiedad {
		
		private String nombre;
		private String direccion;
		private double precioNoche;
		private double saldoReembolso;
		private PoliticaCancelacion politica;
		private List<Reserva> reservas;
		
		public Propiedad(String nombre, String direccion, double precioNoche) {
			this.nombre = nombre;
			this.direccion = direccion;
			this.precioNoche = precioNoche;
			this.reservas = new ArrayList<>();
			this.politica = null;
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
			if(this.contieneReserva(reserva)) {
				this.reservas.remove(reserva);
			}
		}

		public boolean contieneReserva(Reserva reserva) {
			return this.reservas.contains(reserva);
		}
		
		public boolean consultarDisponibilidad(DateLapse lapse) {
			return this.getReservas().stream().noneMatch(reserva -> reserva.isOverlapsed(lapse));
		}
		
		public Reserva crearReserva(Usuario usuario, Propiedad propiedad, DateLapse lapse) {
			if(this.consultarDisponibilidad(lapse)) {
				Reserva reserva = new Reserva(usuario, propiedad, lapse);
				this.agregarReserva(reserva);
				return reserva;
			}
			return null;
		}
		
		public boolean cancelarReserva(Reserva reserva) {
			//Se corrobora que la fecha de solicitud de cancelacion sea anterior sal inicio de la reserva y que la propiedad contenga esa reserva.
			//Envidia de atributos?
			if (!reserva.enCurso() && this.contieneReserva(reserva)) {
				this.eliminarReserva(reserva);
				double reembolso = this.aplicarPolitica(reserva);
				reserva.getUsuario().ingresarSaldo(reembolso);
				return true;
			}
			return false;
		}
		
		public void setPolitica(PoliticaCancelacion politica) {
			this.politica = politica;
		}
		
		public double aplicarPolitica(Reserva reserva) {
			return this.politica.calcularReembolso(reserva);
		}
	}
