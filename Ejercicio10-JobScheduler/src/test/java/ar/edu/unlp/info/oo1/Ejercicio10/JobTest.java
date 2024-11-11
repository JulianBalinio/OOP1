package ar.edu.unlp.info.oo1.Ejercicio10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class JobTest {
	
	private JobScheduler lifoScheduler;
	private JobScheduler fifoScheduler;
	private JobScheduler prioScheduler;
	private JobScheduler effortScheduler;
	
	private JobDescription job1, job2, job3, job4;
	
	
	
	@BeforeEach
	public void setUp() throws Exception {
		this.lifoScheduler = new JobScheduler();
		this.lifoScheduler.setStrategy(new Lifo());
		
		this.fifoScheduler = new JobScheduler();
		this.fifoScheduler.setStrategy(new Fifo());
		
		this.prioScheduler = new JobScheduler();
		this.prioScheduler.setStrategy(new HighPriority());
		
		this.effortScheduler = new JobScheduler();
		this.effortScheduler.setStrategy(new MostEffort());
		
		
		this.job1 = new JobDescription(1, 10, "Alta prioridad");
		this.job2 = new JobDescription(10, 1, "Mayor esfuerzo");
		this.job3 = new JobDescription(8, 5, "Intermedio");
		this.job4 = new JobDescription(5, 7, "Otro intermedio");
		
		
	}
	
	
	@Test
	void lifoTest() {
		this.lifoScheduler.schedule(job1);
		this.lifoScheduler.schedule(job2);
		this.lifoScheduler.schedule(job3);
		this.lifoScheduler.schedule(job4);
		
		assertEquals(4, this.lifoScheduler.getJobs().size());
		assertEquals(job4, this.lifoScheduler.next());
		assertEquals(3, this.lifoScheduler.getJobs().size());
		assertNotEquals(job1, this.lifoScheduler.next());
		assertEquals(2, this.lifoScheduler.getJobs().size());
		assertEquals(job2, this.lifoScheduler.next());
	}
	
	@Test
	void fifoTest() {
		this.fifoScheduler.schedule(job1);
		this.fifoScheduler.schedule(job2);
		this.fifoScheduler.schedule(job3);
		this.fifoScheduler.schedule(job4);
		
		assertEquals(4, this.fifoScheduler.getJobs().size());
		assertEquals(job1, this.fifoScheduler.next());
		assertEquals(3, this.fifoScheduler.getJobs().size());
		assertNotEquals(job3, this.fifoScheduler.next());
		assertEquals(2, this.fifoScheduler.getJobs().size());
		assertEquals(job3, this.fifoScheduler.next());
	}
	
	@Test
	void prioTest() {
		this.prioScheduler.schedule(job1);
		this.prioScheduler.schedule(job2);
		this.prioScheduler.schedule(job3);
		this.prioScheduler.schedule(job4);
		
		assertEquals(4, this.prioScheduler.getJobs().size());
		assertEquals(job1, this.prioScheduler.next());
		assertEquals(3, this.prioScheduler.getJobs().size());
		assertEquals(job4, this.prioScheduler.next());
		assertEquals(2, this.prioScheduler.getJobs().size());
		assertEquals(job3, this.prioScheduler.next());
	}
	
	
	
	@Test
	void effortTest() {
		this.effortScheduler.schedule(job1);
		this.effortScheduler.schedule(job2);
		this.effortScheduler.schedule(job3);
		this.effortScheduler.schedule(job4);
		
		assertEquals(4, this.effortScheduler.getJobs().size());
		assertEquals(job2, this.effortScheduler.next());
		assertEquals(job3, this.effortScheduler.next());
		assertEquals(job4, this.effortScheduler.next());
		assertEquals(1, this.effortScheduler.getJobs().size());
	}

}
