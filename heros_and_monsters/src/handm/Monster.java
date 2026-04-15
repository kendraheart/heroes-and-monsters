package handm;

import Miscellaneous.Misc;

public abstract class Monster extends Dungeon_Character {
	private double chance_regen;
	private int min_regen;
	private int max_regen;
	private int max_hp_local;

	public Monster(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_regen, int min_regen, int max_regen) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns, is_human);
		this.max_hp_local = max_hp;
		this.chance_regen = chance_to_regen;
		this.min_regen = min_regen;
		this.max_regen = max_regen;
		
	
	}

	public Monster() {
		this.max_hp_local = 20;
		this.chance_regen = .50;
		this.min_regen = 2;
		this.max_regen = 8;
		
	}
	
	@Override
	public void hit(int damage) {
		super.hit(damage);
		if(super.is_alive()) {
			int regen_amount = 0;
			if(super.successful_action(chance_regen)) {
				if(super.get_current_hp() < (this.max_hp_local * .3)) {
					regen_amount = Misc.generate_random_int(max_regen + 1, min_regen + 4);
					
				}else {
					regen_amount = Misc.generate_random_int(max_regen, min_regen);
				}		
				System.out.println(super.get_name() + " regenerates " + regen_amount + " health.");
				super.hit(regen_amount * -1);
			}
		}
	}
	

}
