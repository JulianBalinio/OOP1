package ar.edu.unlp.info.oo1.Ejercicio14;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import ar.edu.unlp.info.oo1.Ejercicio14plus.DateLapsePlus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {

	private DateLapse dl;
	private DateLapsePlus dlp;
	private LocalDate from;
	private LocalDate to;
	private LocalDate oor; //outOfRange
	private LocalDate ir; //inRange
	
	
	@BeforeEach
	void setUp() {
		this.from = LocalDate.of(2024, 10, 1);
		this.to = LocalDate.of(2024, 10, 23);
		
		this.oor = LocalDate.of(2023, 6, 18);
		this.ir = LocalDate.of(2024, 10, 8);
		
		this.dl = new DateLapse(from, to);
		this.dlp = new DateLapsePlus(from, 18);
	}
	
	@Test
	void testGetTo() {
		assertNotEquals(LocalDate.of(2024, 9, 30), this.dlp.getTo());
		assertEquals(LocalDate.of(2024, 10, 19), this.dlp.getTo());
		assertNotEquals(LocalDate.of(2024, 10, 20), this.dlp.getTo());
	}
	
	@Test
	void testSizeInDays() {
		assertNotEquals(23, this.dl.sizeInDays());
		assertEquals(22, this.dl.sizeInDays());
		assertNotEquals(5, this.dl.sizeInDays());
		
		assertEquals(18, this.dlp.sizeInDays());
		assertNotEquals(17, this.dlp.sizeInDays());			
	}
	
	@Test
	void testIncludeDate () {
		assertTrue(this.dl.includeDate(ir));
		assertFalse(this.dl.includeDate(oor));
		
		assertTrue(this.dlp.includeDate(from));
		assertTrue(this.dlp.includeDate(ir));
		assertFalse(this.dlp.includeDate(oor));
	}
}
