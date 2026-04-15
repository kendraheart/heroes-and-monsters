/*package handm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Hero_Test {
	
	Hero h1 = new Hero();
	

	@Test
	void test_chance_to_block() {
		double damage_done = 0;
		int counter = 0;
		for(int i = 0; i < 100; i++) {
			h1.hit(10);
			damage_done = h1.get_current_hp();
			if(damage_done == 20) {
				counter++;
			}
			h1.hit(-10);
		}
		System.out.println("blocks " + counter);
	}

}
*/