/*package handm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Monster_test {
	
	Monster M1 = new Monster();

	@Test
	void test_regen_dead() {
		M1.hit(20);
		assertFalse(M1.is_alive());
	}
	
	@Test
	void test_regen_times() {
		int count = 0;
		double runs = 100.0;
		for(int i = 0; i < runs; i++) {
			M1.hit(15);
			int hp = M1.get_current_hp();
			if(hp < 9) {
				count++;
			}
			M1.hit(-20);
		}
		double p = .5;
		double standard_deviation = Math.sqrt((p*(1-p)/runs));
		double failure_rate = count/runs;
		System.out.println("The failure rate is " + failure_rate + " standard deviation = " + standard_deviation);
		assertTrue(failure_rate > (.5-standard_deviation) && failure_rate < (.5 + standard_deviation));
	}

}
*/