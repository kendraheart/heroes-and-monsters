package handm;

public abstract class Hero extends Dungeon_Character {
	private double chance_to_block;
	private double current_chance_to_block;
	

	public Hero(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_block) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns, is_human);
		this.chance_to_block = chance_to_block;
		this.current_chance_to_block = chance_to_block;
	
	}

	public Hero() {
		super();
		this.chance_to_block = .5;
		this.current_chance_to_block = .5;
		
	}
	
	@Override
	public void hit(int damage) {
		if(damage > 0) {
			if(super.successful_action(this.current_chance_to_block)) {
				System.out.println(super.get_name() + "blocks damage!");
				damage = 0;
				this.current_chance_to_block = this.chance_to_block;
			}else {
				this.current_chance_to_block *= 1.25;
				System.out.println("Chance to block increased to " + this.current_chance_to_block);
			}
		}
		super.hit(damage);
		
	}

}

