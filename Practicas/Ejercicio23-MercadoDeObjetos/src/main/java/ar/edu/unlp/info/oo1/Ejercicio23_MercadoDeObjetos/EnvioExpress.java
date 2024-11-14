package ar.edu.unlp.info.oo1.Ejercicio23_MercadoDeObjetos;

public class EnvioExpress implements FormaEnvio {
	
	private CalculadorDeDistancia cd;
	
	public EnvioExpress() {
		this.cd = new CalculadorDeDistancia();
	}
	
	public double costoEnvio(String dir1, String dir2) {
		return 0.5 * cd.calcularDistancia(dir1, dir2);
	}
}
