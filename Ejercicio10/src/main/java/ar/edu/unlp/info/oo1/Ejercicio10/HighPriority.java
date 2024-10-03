package ar.edu.unlp.info.oo1.Ejercicio10;

import java.util.List;

public class HighPriority implements Strategy{

	public JobDescription next(List<JobDescription> jobs) {
		return jobs.stream()
				.max((job1, job2) -> Integer.compare(job1.priority(), job2.priority()))
				.orElse(null);
	}
		
}
