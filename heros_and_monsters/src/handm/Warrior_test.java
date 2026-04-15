package handm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Warrior_test {
	
	Warrior w1 = new Warrior();

	@Test
	void test_crush() {
		int[] solution;
		double runs = 100.0;
		int running_sum = 0;
		for(int i = 0; i < runs; i++) {
			solution = w1.attack();
			if(solution[2] == 40) {
				running_sum++;
			}
			
		}
		double p = .015;
		double standard_deviation = Math.sqrt((p*(1-p)/runs));
		double failure_rate = running_sum/runs;
		System.out.println("The failure rate is " + failure_rate + " standard deviation = " + standard_deviation);
		assertTrue(failure_rate > (.05 - standard_deviation) && failure_rate < (.05 + standard_deviation));
	
		
	}

}
