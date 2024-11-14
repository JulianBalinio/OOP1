package ar.edu.unlp.info.oo1.Ejercicio21_Bag;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class BagImpl<T> extends AbstractCollection<T> implements Bag<T> {
	
	Map<T, Integer> elementos;
	
	public BagImpl() {
		this.elementos = new HashMap<>();
	}
	
	public boolean add(T elemento) {
		if(!elementos.containsKey(elemento)) {
			elementos.put(elemento, 1);
		} else {
			int ocurrencias = occurrencesOf(elemento);
			elementos.put(elemento, ocurrencias++);
		}
		return true;			
	}
	
	public int occurrencesOf(T elemento) {
		return elementos.containsKey(elemento) ? elementos.get(elemento) : 0;
	}
	
	public void removeOccurrence(T elemento) {
		if (elementos.containsKey(elemento)) {
			int ocurrencias = elementos.get(elemento);
			if(ocurrencias > 0) {
				elementos.put(elemento, ocurrencias--);
			}
		}
	}
	
	public void removeAll(T elemento) {
		elementos.remove(elemento);
	}
	
	public int size() {
		return elementos.values().stream().mapToInt(e -> e).sum();
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Iterator<Map.Entry<T, Integer>> entryIterator = elementos.entrySet().iterator();
			private Map.Entry<T, Integer> currentEntry;
			private int rCount;
			
			public boolean hasNext() {
				return rCount > 0 || entryIterator.hasNext();
			}
			
			public T next() {
				if(rCount == 0) {
					currentEntry = entryIterator.next();
					rCount = currentEntry.getValue();
				}
				rCount--;
				return currentEntry.getKey();
			}
		
			public void remove() {
				removeOccurrence(currentEntry.getKey());
			}
		};
	}
	
}
