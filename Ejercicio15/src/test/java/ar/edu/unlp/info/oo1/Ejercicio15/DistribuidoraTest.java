package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DistribuidoraTest {

    private Distribuidora distribuidora;
    private Usuario usuario1, usuario2, usuario3;
    private CuadroTarifario cuadroTarifario;

    @BeforeEach
    public void setup() {
        cuadroTarifario = new CuadroTarifario(10); // Precio del kWh = 10
        distribuidora = new Distribuidora(cuadroTarifario);

        usuario1 = new Usuario("Julian", "Calle Falsa 1");
        usuario2 = new Usuario("Juliana", "Calle Falsa 2");
        usuario3 = new Usuario("Nailuj", "Calle Falsa 3");

        distribuidora.agregarUsuario(usuario1);
        distribuidora.agregarUsuario(usuario2);
    }

    @Test
    public void testEmitirFacturaConBonificacion() {
        usuario1.agregarConsumo(new Consumo(100, 50)); // fp = 0.894
        Factura factura = distribuidora.emitirFactura(usuario1);

        assertNotNull(factura);
        assertEquals(usuario1, factura.getUsuario());
        double montoEsperado = (100 * 10) * 0.9;
        assertEquals(montoEsperado, factura.getMontoFinal(), 0.01); // Tolerancia 0.01
    }

    @Test
    public void testEmitirFacturaSinBonificacion() {
        usuario2.agregarConsumo(new Consumo(100, 100)); // fp = 0.707
        Factura factura = distribuidora.emitirFactura(usuario2);

        assertNotNull(factura);
        assertEquals(usuario2, factura.getUsuario());
        double montoEsperado = 100 * 10;
        assertEquals(montoEsperado, factura.getMontoFinal(), 0.01); // Tolerancia 0.01
    }
    
    @Test
    public void testFacturaNull() {
    	usuario3.agregarConsumo(new Consumo(100, 100));
    	Factura factura = distribuidora.emitirFactura(usuario3);
    	assertNull(factura);
  
    }

    @Test
    public void testActualizarTarifa() {
        distribuidora.actualizarTarifa(15);
        assertEquals(15, distribuidora.getCuadroTarifario().getPrecioKwh());

        usuario1.agregarConsumo(new Consumo(200, 50)); // fp > 0.8
        Factura factura3 = distribuidora.emitirFactura(usuario1);

        double montoEsperado = (200 * 15) * 0.9;
        assertEquals(montoEsperado, factura3.getMontoFinal(), 0.01);
    }
}
