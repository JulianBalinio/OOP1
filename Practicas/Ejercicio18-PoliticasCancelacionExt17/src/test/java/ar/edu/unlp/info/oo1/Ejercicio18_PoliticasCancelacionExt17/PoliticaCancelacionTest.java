package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PoliticaCancelacionTest {

    protected Reserva reserva;
    protected DateLapse lapso;

    @BeforeEach
    void setUp() {
        Propiedad propiedad = new Propiedad("Prop", "Calle 1", 100);
        Usuario usuario = new Usuario("Julian", "Calle", 12345);
        lapso = new DateLapse(LocalDate.now().plusDays(5), LocalDate.now().plusDays(10));
        reserva = new Reserva(usuario, propiedad, lapso);
    }

    @Test
    void testPoliticaFlexible() {
        PoliticaCancelacion politica = new CancelacionFlexible();
        assertEquals(500, politica.calcularReembolso(reserva));
    }

    @Test
    void testPoliticaEstricta() {
        PoliticaCancelacion politica = new CancelacionEstricta();
        assertEquals(0, politica.calcularReembolso(reserva));
    }

    @Test
    void testPoliticaModerada() {
        PoliticaCancelacion politica = new CancelacionModerada();

        // Caso 1: Cancelación con más de 7 dias
        LocalDate hoy = LocalDate.now();
        lapso = new DateLapse(hoy.plusDays(10), hoy.plusDays(15));
        reserva = new Reserva(reserva.getUsuario(), reserva.getPropiedad(), lapso);
        assertEquals(500, politica.calcularReembolso(reserva));

        // Caso 2: Cancelacion entre 2 y 7 dias
        lapso = new DateLapse(hoy.plusDays(4), hoy.plusDays(9));
        reserva = new Reserva(reserva.getUsuario(), reserva.getPropiedad(), lapso);
        assertEquals(250, politica.calcularReembolso(reserva));

        // Caso 3: Cancelacion con menos de 2 dias
        lapso = new DateLapse(hoy.plusDays(1), hoy.plusDays(6));
        reserva = new Reserva(reserva.getUsuario(), reserva.getPropiedad(), lapso);
        assertEquals(0, politica.calcularReembolso(reserva));
    }
}
