package ar.edu.unlp.info.oo1.Ejercicio16;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SetTest {

	private EvenNumberSet hashSet;
	private EvenNumberSetList listSet;
	
	@BeforeEach
	void setUp() throws Exception {
		hashSet = new EvenNumberSet();
		listSet = new EvenNumberSetList();
	}
	
	@Test
	void testHashSet() {
		assertFalse(hashSet.addNumber(1));
		assertFalse(hashSet.addNumber(3));
		assertTrue(hashSet.addNumber(4));
		assertFalse(hashSet.addNumber(4));
		assertTrue(hashSet.addNumber(20));
		assertFalse(hashSet.addNumber(21));
		assertTrue(hashSet.addNumber(8));
		assertFalse(hashSet.addNumber(8));
		assertEquals(3, hashSet.getSize());
	}
	
	@Test
	void testListSet() {
		assertFalse(listSet.addNumber(1));
		assertTrue(listSet.addNumber(2));
		assertFalse(listSet.addNumber(2));
		assertTrue(listSet.addNumber(6));
		assertFalse(listSet.addNumber(6));
		assertTrue(listSet.addNumber(10));
		assertFalse(listSet.addNumber(10));
		assertFalse(listSet.addNumber(11));
		assertEquals(3, listSet.getSize());
	}
}
