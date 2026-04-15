/*package handm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Dungeon_Character_Test {
	
	Dungeon_Character dcl = new Dungeon_Character();

	@Test
	void test_attack_location_y() {
		int[] fire_solution = dcl.attack();
		
		//standing at y = 2, x = 2
		//facing north (1)
		//attacking y = 1, x = 2
		assertTrue(fire_solution[0] == 1);
	
	}
	
	@Test
	void test_attack_location_x() {
		int[] fire_solution = dcl.attack();
		
		//standing at y = 2, x = 2
		//facing north (1)
		//attacking y = 1, x = 2
		assertTrue(fire_solution[1] == 1);
	
	}
	
	@Test
	void test_damage_done() { //we're counting how many times we get zero damage
		int[] solution;
		double runs = 100.0; //how many times is the test run
		int running_sum = 0; //how many times there is zero damage done
		for(int i = 0; i < runs; i++) {
			solution = dcl.attack();
			if(solution[2] == 0) {
				running_sum ++;
			}
		}
		double p = .5;
		double standard_deviation = Math.sqrt((p*(1-p)/runs));
		double failure_rate = running_sum/runs;
		System.out.println("The failure rate is " + failure_rate + ".");
		assertTrue(failure_rate > .35 && failure_rate < .65);
	}

}
*/