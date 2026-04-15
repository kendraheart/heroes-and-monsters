package handm;

import java.util.Scanner;

import Miscellaneous.Misc;

public class Cleric extends Hero {
	
	private double chance_to_heal;
	private int min_heal;
	private int max_heal;
	private Scanner scan;

	public Cleric(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_block,
			double chance_to_heal, int min_heal, int max_heal, Scanner scan) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns,
				is_human, chance_to_block);
	}

	public Cleric(Scanner scan) {
		this.chance_to_heal = .3;
		this.min_heal = 2;
		this.max_heal = 8;
		this.scan = scan;
		
	}
	
	@Override
	public int[] attack() {
		int[] solution = super.attack();
		int size = solution.length;
		solution[size-1] = cleric_turn(solution[size-1]);
		
		return solution;
		
	}
	
	private int cleric_turn(int damage) {
		int choice = 0;
		if(super.get_is_human()) { //human
			choice = Misc.get_user_input_int("Do you want to heal or attack? Select 1 for heal or 2 for attack.", scan, 1, 2);
		}else {
			choice = Misc.generate_random_int(2, 1); //computer
		}
		damage = heal_helper(damage, choice);
		
		return damage;
		
	}
	
	
	
	private int heal_helper(int damage, int choice) {
				if(choice == 1) {
			damage = 0;
			if(super.successful_action(chance_to_heal)) {
				int heal = Misc.generate_random_int(max_heal, min_heal);
				System.out.println(super.get_name() + " heals for " + heal);
				super.hit(-heal);
			}else {
				System.out.println(super.get_name() + " tried to heal and failed.");
			}
		}
				return damage;
	}
	
	
	
	
	
	
	
	
	
	

}
