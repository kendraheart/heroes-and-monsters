package handm;

import Miscellaneous.Misc;

public class Mystic extends Dungeon_Character {
	
	public Mystic(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_double_damage) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns,
				is_human);
		
	change_max_hp();
	
	}
	
	public Mystic(){
		super();
	}
	
	private void change_max_hp() {
		int roll = Misc.generate_random_int(20, 1);
		if(roll == 1) {
			super.set_max_hp((int)(get_max_hp() * .25));
			
		}else if(roll >= 3) {
			super.set_max_hp((int)(get_max_hp() * .35));
			
		}else if(roll >= 5) {
			super.set_max_hp((int)(get_max_hp() * .45));
			
		}else if(roll >= 13) {
			super.set_max_hp((int)(get_max_hp() * .55));
			
		}else if(roll >= 15) {
			super.set_max_hp((int)(get_max_hp() * .65));
			
		}else if(roll >= 17) {
			super.set_max_hp((int)(get_max_hp() * .75));
			
		}else if(roll >= 19) {
			super.set_max_hp((int)(get_max_hp() * .85));
			
		}else if(roll == 20) {
			super.set_max_hp((int)(get_max_hp() * 1.5));
		}
		
		
	}


}
