package ar.edu.unlp.info.oo1.Ejercicio12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {
	
	private ReporteDeConstruccion rep;
	private PrismaRectangular pr1;
	private PrismaRectangular pr2;
	private Cilindro c1;
	private Cilindro c2;
	private Esfera e1;
	private Esfera e2;
	
	@BeforeEach
	void setUp() {
		this.rep = new ReporteDeConstruccion();
		this.pr1 = new PrismaRectangular("hierro", "rojo", 10, 5, 3);
		this.pr2 = new PrismaRectangular("hierro", "rojo", 9, 4, 6);
		this.c1 = new Cilindro("hierro", "gris", 3, 5);
		this.c2 = new Cilindro("acero", "negro", 5, 7);
		this.e1 = new Esfera("madera", "rojo", 4);
		this.e2 = new Esfera("acero", "negro", 3);
		
		this.rep.getPiezas().add(pr1);
		this.rep.getPiezas().add(pr2);
		this.rep.getPiezas().add(c1);
		this.rep.getPiezas().add(c2);
		this.rep.getPiezas().add(e1);
		this.rep.getPiezas().add(e2);
	}
	
	@Test
	void testSize() {
		assertEquals(6, this.rep.getPiezas().size());
		this.rep.getPiezas().remove(0);
		assertEquals(5, this.rep.getPiezas().size());
	}
	
	@Test
	void testVolumenMaterial() {
		assertEquals(507, Math.round(this.rep.getVolumenMaterial("hierro")));
		assertEquals(663, Math.round(this.rep.getVolumenMaterial("acero")));
		assertEquals(268, Math.round(this.rep.getVolumenMaterial("madera")));
	}
	
	@Test
	void testSuperficieColor() {
		assertEquals(619, Math.round(this.rep.getSuperficieColor("rojo")));
		assertEquals(490, Math.round(this.rep.getSuperficieColor("negro")));
	}
}
