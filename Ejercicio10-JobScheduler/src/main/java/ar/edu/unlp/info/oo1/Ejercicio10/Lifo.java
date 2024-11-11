package ar.edu.unlp.info.oo1.Ejercicio10;

import java.util.List;

public class Lifo implements Strategy {

		public JobDescription next(List <JobDescription> jobs) {
			return jobs.get(jobs.size()-1);
		}
}
