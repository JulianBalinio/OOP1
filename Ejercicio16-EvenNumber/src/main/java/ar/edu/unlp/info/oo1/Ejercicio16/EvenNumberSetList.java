package ar.edu.unlp.info.oo1.Ejercicio16;

import java.util.ArrayList;
import java.util.List;

public class EvenNumberSetList {

	private List<Integer> numbers;

	public EvenNumberSetList() {
		this.numbers = new ArrayList<>();
	}
	
	public boolean addNumber(Integer number) {
		if (number % 2 == 0 && !this.numbers.contains(number)) {
			return this.numbers.add(number);
		}
		return false;
	}
	
	public int getSize() {
		return this.numbers.size();
	}
	
	public List<Integer> getNumbers(){
		return this.numbers;
	}
}
