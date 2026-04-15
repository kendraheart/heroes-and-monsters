package handm;

public class Troll extends Monster {
	
	private double chance_to_roll_boulder;
	

	public Troll(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_regen, int min_regen,
			int max_regen, double chance_to_roll_boulder) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns,
				is_human, chance_to_regen, min_regen, max_regen);
		
		this.chance_to_roll_boulder = chance_to_roll_boulder;
	}
//Troll occasionally attacks with a boulder which increases the attack radius
	public Troll() {
		super();
		this.chance_to_roll_boulder = .3;  //30% chance to roll a boulder
	}
	
	@Override
	public int[] attack() {
		int[] solution = super.attack();
		
		if(solution[2] != 0) {
			if(super.successful_action(chance_to_roll_boulder)) {
				System.out.println(super.get_name() + " rolls a boulder!");
				solution = get_new_solution();
			}
		}
		
		
		return solution;
		
	}
	
	private int[] get_new_solution() {
		int facing = super.get_direction();
		int[] new_solution = new int[5];
		int[] old_solution = super.attack();
		new_solution[0] = old_solution[0];
		new_solution[1] = old_solution[1];
		new_solution[4] = old_solution[2];
		switch(facing) {
		case 1: //north
			new_solution[2] = old_solution[0]-1;
			new_solution[3] = old_solution[1];
			break;
		case 2: //east
			new_solution[2] = old_solution[0];
			new_solution[3] = old_solution[1]+1;
			break;
		case 3: //south
			new_solution[2] = old_solution[0]+1;
			new_solution[3] = old_solution[1];
			break;
		case 4: //west
			new_solution[2] = old_solution[0];
			new_solution[3] = old_solution[1]-1;
			break;
		}
		
		return new_solution;
		
	}
	
	public String toString() {
		String info= "Troll " + super.toString();
		return info;
	}

}
