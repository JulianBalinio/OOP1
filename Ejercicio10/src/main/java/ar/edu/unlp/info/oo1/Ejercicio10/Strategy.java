package ar.edu.unlp.info.oo1.Ejercicio10;

import java.util.List;

public interface Strategy {
	
	public JobDescription next(List<JobDescription> jobs);
	
}
