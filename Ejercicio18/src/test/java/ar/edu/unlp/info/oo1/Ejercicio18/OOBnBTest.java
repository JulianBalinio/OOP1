package ar.edu.unlp.info.oo1.Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class OOBnBTest {

	protected OOBnB sistema;
    protected Usuario usuario, usuario2;
    protected Propiedad p1, p2;
    protected DateLapse lapso1, lapso2, lapso3, lapsoBuscado;
    protected Reserva reserva1, reserva2, reserva3;

    @BeforeEach
    void setUp() {
        sistema = new OOBnB();
        
        usuario = sistema.registrarUsuario("Julian", "Mi direccion", 12345);
        usuario2 = sistema.registrarUsuario("Nailuj", "Otra direccion", 54321);

        p1 = sistema.registrarPropiedad("Casa 1", "Calle 1", 100, usuario);
        p2 = sistema.registrarPropiedad("Casa 2", "Calle 2", 200, usuario);
    
        lapso1 = new DateLapse(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 10)); //Reserva pasada
        lapso2 = new DateLapse(LocalDate.of(2024, 10, 11), LocalDate.of(2024, 10, 21)); //Reserva en curso
        lapso3 = new DateLapse(LocalDate.of(2024, 10, 20), LocalDate.of(2024, 10, 25)); //Reserva futura
        
        lapsoBuscado = new DateLapse(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 25));
        
        reserva1 = sistema.crearReserva(usuario, p1, lapso1);
        reserva2 = sistema.crearReserva(usuario, p1, lapso2);
        reserva3 = sistema.crearReserva(usuario, p2, lapso3);      
    }
    
    
    
    @Test
    void testCrearReserva() {
    	DateLapse lapso4 = new DateLapse(LocalDate.of(2024, 10, 26), LocalDate.of(2024, 10, 29));
    	assertEquals(3, sistema.getReservas().size());
    	sistema.crearReserva(usuario, p2, lapso4);
    	assertEquals(4, sistema.getReservas().size()); 	
    }
   
    @Test
    void testCancelarReserva() {      
    	assertFalse(sistema.cancelarReserva(reserva1));
    	assertFalse(sistema.cancelarReserva(reserva2));
    	assertTrue(sistema.cancelarReserva(reserva3));
    }
    
    @Test
    void testCalcularIngresoUsuario() {
    	assertEquals(2175, sistema.calcularIngresosUsuario(usuario, lapsoBuscado));
    	assertEquals(675, sistema.calcularIngresosUsuario(usuario, lapso1));
    	sistema.cancelarReserva(reserva3);
    	assertEquals(1425, sistema.calcularIngresosUsuario(usuario, lapsoBuscado));
    	
    	assertEquals(0, sistema.calcularIngresosUsuario(usuario2, lapsoBuscado));
    }
}