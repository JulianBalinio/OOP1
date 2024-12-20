package ar.edu.unlp.info.oo1.Ejercicio19_ServicioEnvioPaquetes;

public class PersonaFisica extends Cliente {

	private int dni;
	
	public PersonaFisica(String nombre, String direccion, int dni) {
		super(nombre, direccion);
		this.dni = dni;
	}
	
	//No se utiliza el dni en el enunciado, por lo que un getter es innecesario
	public double descuento() {
		return 0.9;
	}
	
	public double calcularMontoPeriodo(DateLapse lapso) {
		return super.calcularMontoPeriodo(lapso) * this.descuento();
	}

}
