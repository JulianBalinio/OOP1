package ar.edu.unlp.info.oo1.Ejercicio16;

import java.util.Set;
import java.util.HashSet;

public class EvenNumberSet {
	
	private Set<Integer>numbers;
	
	public EvenNumberSet() {
		this.numbers = new HashSet<>();
	}
	
	public boolean addNumber(Integer number) {
		if(number % 2 == 0) {
			return this.numbers.add(number);
		}
		return false;
	}
	
	public int getSize() {
		return this.numbers.size();
	}
	
	public Set<Integer> getNumbers() {
		return this.numbers;
	}
}
