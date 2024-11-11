package ar.edu.unlp.info.oo1.Ejercicio18_PoliticasCancelacionExt17;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {

    protected Propiedad propiedad;
    protected Usuario inquilino;
    protected Reserva reserva;
    protected DateLapse lapso;

    @BeforeEach
    void setUp() {
        propiedad = new Propiedad("Prop", "Calle 1", 100);
        propiedad.setPolitica(new CancelacionFlexible());

        inquilino = new Usuario("Nailuj", "Calle", 54321);
        lapso = new DateLapse(LocalDate.now().plusDays(1), LocalDate.now().plusDays(5));

        reserva = new Reserva(inquilino, propiedad, lapso);
        propiedad.agregarReserva(reserva);
    }

    @Test
    void testCancelarReservaConPoliticaFlexible() {
        assertTrue(propiedad.cancelarReserva(reserva));
        assertEquals(400, inquilino.getReembolso());
    }

    @Test
    void testConsultarDisponibilidad() {
        DateLapse otroLapso = new DateLapse(LocalDate.now().plusDays(3), LocalDate.now().plusDays(6));
        assertFalse(propiedad.consultarDisponibilidad(otroLapso));
    }
}
