package handm;

import java.util.Scanner;

import Miscellaneous.Misc;

public class Fairy extends Mystic {

	private Scanner scan;
	private int x_coord_choice;
	private double chance_to_move;


	public Fairy(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max,
			int do_damage_min, int direction, int rows, int columns, boolean is_human, double chance_to_double_damage, double chance_to_move, Scanner scan) {
		super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, rows, columns,
				is_human, chance_to_double_damage);
		this.scan = scan;
		this.chance_to_move = chance_to_move;
	}

	@Override
	public void move() {
		int choice = 0;
		if(super.get_is_human()) { //human
			choice = Misc.get_user_input_int("Do you want to use your wings? Select 1 for yes or 2 for no.", scan, 1, 2);
		}else {
			choice = Misc.generate_random_int(2, 1); //computer;

		}
		if(choice==1) {
			Fairy_turn(scan);
		}else {
			super.move();
		}
	}



	public void Fairy_turn(Scanner scan) {
		int[] board_size = super.rows_columns();
		this.scan = scan;
		if(super.get_is_human()) { //human
				x_coord_choice = Misc.get_user_input_int("Choose which column you would like to move to." , scan, 1, board_size[1]);
				if (super.successful_action(chance_to_move)) {
					super.set_x_coord(x_coord_choice-1);
				}
		//	}

		}else  {
			x_coord_choice = Misc.generate_random_int(2, 1); //computer;
				x_coord_choice = Misc.generate_random_int(board_size[1]-1, 0);
				if (super.successful_action(chance_to_move)) {
					super.set_x_coord(x_coord_choice);
				}
			//}
		}
	}

	public void x_coord_choice() {

	}



}
