package handm;

import Miscellaneous.Misc;

public class Warrior extends Hero {
	
	private double chance_to_crush;

	public Warrior(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_block, double chance_to_crush) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns,
				is_human, chance_to_block);
		this.chance_to_crush = chance_to_crush;
		
	}
//warrior deals different damage on critical roll of 1 or 20
	public Warrior() {
		super();
		this.chance_to_crush = .30;
		
	}
	
	@Override
	public int[] attack() {
		int[] solution = super.attack();
		int damage = solution[2];
		
		if(super.successful_action(chance_to_crush)) {
			int roll = Misc.generate_random_int(20, 1);
			if(roll == 20) {
				damage *= 2;
				System.out.println("Critical roll of 20, damage is doubled.");
				}else if(roll == 1) {
					super.hit(damage);
					damage = 0;
					System.out.println("Critical roll of 1, you damaged yourself.");
				}else {
					damage += damage * this.chance_to_crush;
				}
		}
		solution[2] = damage;
		return solution;
		
	}
	

}
