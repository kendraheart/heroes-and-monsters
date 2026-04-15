package handm;

import Miscellaneous.Misc;

public class Princess extends Mystic {
	
	private double chance_to_double_damage;

	public Princess(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_double_damage) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns,
				is_human, chance_to_double_damage);
		
		this.chance_to_double_damage = chance_to_double_damage;
		
	}
	//deals double damage on critical rolls 1-10
	public Princess() {
		super();
		this.chance_to_double_damage = .75; //75% chance to roll double damage
		
	}
	
	@Override
	public int[] attack() {
		int[] solution = super.attack();
		int damage = solution[2];
		
		if(super.successful_action(chance_to_double_damage)) {
			int roll = Misc.generate_random_int(20, 1);
			if(roll >= 10) {
				damage *= 2;
				System.out.println("Critical roll, damage is doubled.");
				
				}else {
					damage *= 1.25;
				}
				}solution[2] = damage;
		return solution;
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


