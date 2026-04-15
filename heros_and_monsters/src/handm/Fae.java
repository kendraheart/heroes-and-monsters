/*package handm;

public class Fae extends Mystic {
	
	private int counter; //how many times attack can be used in 1 game
	private double chance_to_fae;

	public Fae(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_double_damage, int counter, double chance_to_fae) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns,
				is_human, chance_to_double_damage);
		this.counter = counter;
		this.chance_to_fae = chance_to_fae;
	}
	
	@Override
	public int[] attack() {
		int[] solution = super.attack();
		if(this.counter > 0 && super.successful_action(chance_to_fae)) {
			System.out.println("A giant ray of light appears");
			solution = calc_fae_solution(solution);
			this.counter --;
		}
		return solution;
	}

	public Fae() {
		super();
		this.counter = 3;
		this.chance_to_fae = .5;
	}
	
	private int[] calc_fae_solution(int[] solution) {
		int[] rows_columns = super.rows_columns();
		int sizeR = rows_columns[0] * 2;
		int sizeC = rows_columns[1] * 2;
		int row = solution[0];
		int column = solution[1];
		int facing = super.get_direction();
		int[] new_solution;
		
		if(facing == 1 || facing == 3) {
			new_solution = new int[sizeR+1];
			new_solution[sizeR] = solution[2];
 			return North_South_solution(sizeR, row, new_solution);
		}else {
			new_solution = new int[sizeC+1];
			new_solution[sizeC] = solution[2];
			return East_West_solution(sizeC, column, new_solution);
		}
	}
	
	private int[] North_South_solution(int size, int row, int[] solution) { //when facing north or south, attack will span across columns
		
		for(int i = 0, j = 1; i < size; i = i + 2, j++) {
			new_solution[i] = row;
			new_solution[i+1] = j;		
		}
		return new_solution;
	}
	
	private int[] East_West_solution(int size, int column, int damage) {
		
	}

}
*/