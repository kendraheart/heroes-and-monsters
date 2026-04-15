package handm;

import java.util.Scanner;

import Miscellaneous.Misc;

public class Game {
	private Scanner scan;
	private boolean keep_playing = true;
	private boolean game_over = false;
	int turn;
	private Dungeon_Character dc1,dc2;
	private Board board;
	private int max_hp = 20;
	private int x_coord = 0;
	private int y_coord = 0;
	private double base_chance = .5; //to emulate rolling the dice
	private int do_damage_max = 7, do_damage_min = 2;
	private int direction = 3;
	private int rows;
	private int columns;




	public Game(Scanner scan, int rows, int columns) {
		this.scan = scan;	
		this.rows = rows;
		this.columns = columns;
	}  

	private void check_game_over() {
		if(!dc1.is_alive() || !dc2.is_alive()){
			this.game_over = true;
			if(dc1.is_alive()){
				System.out.println(dc1.get_name() + " wins!");
			}else if(dc2.is_alive()){
				System.out.println(dc2.get_name() + " wins!");
			}else{
				System.out.println(" No one wins!");
			}
		}
	}

	private void move(Dungeon_Character dc) {	
		int[] location = dc.get_location();
		this.board.mark_board(location[0], location[1], ' ');
		dc.move();
		location = dc.get_location();
		this.board.mark_board(location[0], location[1], dc.get_symbol());
	}

	private void display_info() {
		System.out.println(dc1.toString());
		System.out.println(dc2.toString());
	}


	private void human_change_direction(){		
		String message ="Which direction do you wish to face? 1 for north, 2 for east, 3 for south, 4 for west";
		int choice = Misc.get_user_input_int(message, scan, 1, 4);
		dc1.change_direction(choice);
	}

	private void computer_change_direction() {	
		int choice = Misc.generate_random_int(4, 1);
		if(choice == 1){
			System.out.println(dc2.get_name() + " faces north.");
		}else if(choice == 2){
			System.out.println(dc2.get_name() + " faces east.");
		}else if(choice == 3){
			System.out.println(dc2.get_name() + " faces south.");
		}else{
			System.out.println(dc2.get_name() + " faces west.");
		}
		dc2.change_direction(choice);
	}



	private void combat(Dungeon_Character attack,Dungeon_Character defense) {
		int[] solution = attack.attack();
		int solution_end = solution.length-1;
		if(solution[solution_end]> 0){
			int size = solution.length /2;
			boolean hit = false;
			int[] defense_location = defense.get_location();
			for(int i = 0; i<size; i=i+2){
				if(defense_location[0] == solution[i] && defense_location[1] == solution[i+1]){
					System.out.println(attack.get_name() + " hits and does " + solution[solution_end] + " damage");
					hit = true;
					break;
				}				
			}
			if(hit){
				defense.hit(solution[solution_end]);
			}else{
				System.out.println(attack.get_name() + " missed.");
			}
		}		
	}

	private void initialize_human_character() {	
		System.out.println("Hello human! Enter your name: ");
		String name = this.scan.nextLine();
		int choice = Misc.get_user_input_int("Select 1 for Warrior, 2 for Troll, 3 for Cleric, 4 for Princess, or 5 for Fairy", scan, 1, 5);
		this.dc1 = choose_character(choice, name, true);

		System.out.println("Welcome " + this.dc1.get_name());
		int[] location = this.dc1.get_location();
		this.board.mark_board(location[0], location[1], dc1.get_symbol());
	}

	private Dungeon_Character choose_character(int choice, String name, boolean is_human) {

		if(choice == 1) {
			return initialize_Warrior(name, is_human);
		}else if(choice == 2) {
			return initialize_Troll(name, is_human);	
		}else if(choice == 3) {
			return initialize_Cleric(name, is_human);
		}else if(choice == 4) {
			return initialize_Princess(name, is_human);
		}else if(choice == 5) {
			return initialize_Fairy(name, is_human);
		}else {
			System.out.println("Not valid, please choose again.");
			return null;
		}
	}

	private Dungeon_Character initialize_Fairy(String name, boolean is_human) {
		double chance_to_double_damage = .75;
		double chance_to_move = .5;

		Dungeon_Character dc = new Fairy(name, this.max_hp, this.y_coord, this.x_coord, this.base_chance, 
				this.do_damage_min, this.do_damage_max, this.direction, this.rows, this.columns, 
				is_human, chance_to_move, chance_to_double_damage, this.scan);

		return dc;
	}

	private Dungeon_Character initialize_Warrior(String name, boolean is_human) {
		double chance_to_block = .5;
		double chance_to_crush = .3;
		Dungeon_Character dc = new Warrior(name, this.max_hp, this.y_coord, this.x_coord, this.base_chance, 
				this.do_damage_min, this.do_damage_max, this.direction, this.rows, this.columns, 
				is_human, chance_to_block, chance_to_crush);
		return dc;

	}

	private Dungeon_Character initialize_Troll(String name, boolean is_human) {
		double chance_to_regen = .5;
		int min_regen = 2;
		int max_regen = 8;
		double chance_to_roll_boulder = .3;

		Dungeon_Character dc = new Troll(name, this.max_hp, this.y_coord, this.x_coord, this.base_chance, 
				this.do_damage_min, this.do_damage_max, this.direction, this.rows, this.columns, 
				is_human, chance_to_regen, min_regen, max_regen, chance_to_roll_boulder);
		return dc;
	}

	/*private Dungeon_Character initialize_Fae(String name, boolean is_human) {
		double chance_to_double_damage = .5;
		int counter = 3;
		double chance_to_fae = 0;

		Dungeon_Character dc = new Fae(name, this.max_hp, this.x_coord, this.y_coord, this.base_chance, 
					this.do_damage_min, this.do_damage_max, this.direction, this.rows, this.columns, 
					is_human, chance_to_double_damage, counter, chance_to_fae);
		return dc;
	}*/

	private Dungeon_Character initialize_Princess(String name, boolean is_human) {
		double chance_to_double_damage = .75;


		Dungeon_Character dc = new Princess(name, this.max_hp, this.y_coord, this.x_coord, this.base_chance, 
				this.do_damage_min, this.do_damage_max, this.direction, this.rows, this.columns, 
				is_human, chance_to_double_damage);
		return dc;
	}



	private Dungeon_Character initialize_Cleric(String name, boolean is_human) {
		double chance_to_block = .5;
		double chance_to_heal = .3;
		int min_heal = 2;
		int max_heal = 8;
		Dungeon_Character dc = new Cleric (name, this.max_hp, this.y_coord, this.x_coord, this.base_chance, 
				this.do_damage_min, this.do_damage_max, this.direction, this.rows, this.columns, 
				is_human, chance_to_block, chance_to_heal, min_heal, max_heal, this.scan);
		return dc;

	}




	private void initialize_computer_character() {		
		String name = "Computron";
		this.y_coord = this.rows -1;
		this.x_coord = this.columns -1;
		this.direction = 1;
		int choice = Misc.generate_random_int(5, 1);
		if(choice == 1) {
			System.out.println("Computer chose Warrior");
		}else if(choice == 2) {
			System.out.println("Computer chose Troll");
		}else if (choice == 3) {
			System.out.println("Computer chose Cleric");
		}else if (choice == 4) {
			System.out.println("Computer chose Princess");
		}else if (choice == 5) {
			System.out.println("Computer chose Fairy");
		}

		this.dc2 = choose_character(choice, name, false);
		System.out.println("Welcome " + this.dc2.get_name());
		int[] location = this.dc2.get_location();
		this.board.mark_board(location[0], location[1], dc2.get_symbol());
	}

	private void initialize_characters() {
		initialize_human_character();
		initialize_computer_character();

	}

	private void initialize_game() {
		board = new Board(this.rows, this.columns);
		board.initialize_board();
		initialize_characters();
		this.board.display_board();
		this.game_over = false;
		this.turn = 0;
	}

	private void take_computer_turn() {
		int choice = Misc.generate_random_int(3, 1);
		if(choice == 1) {
			System.out.println(dc2.get_name() + "moves");
			this.move(dc2);
		}else  if(choice == 2) {
			this.combat(dc2, dc1);
		}else {
			this.computer_change_direction();
		}
		board.display_board();
	}

	private void take_human_turn() {
		String message = "You have three options:  \n" +
				"Move (Enter 1)\n" +
				"Combat (Enter 2)\n" +
				"Change direction (Enter 3)";
		int choice = Misc.get_user_input_int(message, scan, 1, 3);

		if(choice == 1){
			this.move(dc1);
		}else if(choice == 2){
			this.combat(dc1, dc2);
		}else{
			this.human_change_direction();
		}				
		board.display_board();
	}

	private void take_turns() {
		if(!this.game_over) {
				this.display_info();
				if ((this.turn %2) == 0) {
					this.take_human_turn();	
				}else {
					this.take_computer_turn();				
				}
				this.turn ++;
				this.check_game_over();
		}	
	}				




	public void play_game() {
		int choice = 0;
		while(keep_playing){
			initialize_game();
			while(!game_over){
				take_turns();
			}
			choice = Misc.get_user_input_int("Do you wish to play again? 1 for yes 2  again" , scan, 1, 2);
			if(choice == 2){
				keep_playing = false;
			}			
		}
	} 




}
