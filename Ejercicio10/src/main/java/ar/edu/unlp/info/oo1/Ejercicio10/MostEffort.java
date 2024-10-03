package ar.edu.unlp.info.oo1.Ejercicio10;

import java.util.List;

public class MostEffort implements Strategy{

	public JobDescription next(List<JobDescription> jobs) {
		return jobs.stream()
				.max((job1, job2) -> Double.compare(job1.effort(), job2.effort()))
				.orElse(null);
	}
	
}
