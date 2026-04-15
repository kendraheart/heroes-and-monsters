package handm;

import java.util.Random;

import Miscellaneous.Misc;

public abstract class Dungeon_Character implements iDC {
	private String name;
	private char symbol;
	private int max_hp;
	private int current_hp;
	private int x_coord;
	private int y_coord;
	private double base_chance; //to emulate rolling the dice
	private int do_damage_max, do_damage_min;
	private int direction;
	private int rows;
	private int columns;
	private boolean is_human;
	
	public Dungeon_Character(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max, 
			int do_damage_min, int direction, int rows, int columns, boolean is_human) {
		this.name = name; //this. refers to the class level variable
		this.symbol = name.charAt(0);
		this.max_hp = max_hp;
		this.current_hp = this.max_hp;
		this.x_coord = x_coord;
		this.y_coord = y_coord;
		//this.base_chance = base_chance;
		this.do_damage_max = do_damage_max;
		this.do_damage_min = do_damage_min;
		this.direction = direction;
		this.rows = rows;
		this.columns = columns;
		this.is_human = is_human;
	}
	
	//overloading the constructor is having more than 1 method with the same name, but different parameters
	//this is strictly for testing purposes so we can assign specific variables 
	public Dungeon_Character() {
		this.name = "Bob";
		this.symbol = name.charAt(0);
		this.max_hp = 20;
		this.current_hp = this.max_hp;
		this.x_coord = 2;
		this.y_coord = 2;
		this.base_chance = .5;
		this.do_damage_max = 20;
		this.do_damage_min = 5;
		this.direction = 1;
		this.rows = 10;
		this.columns = 10;
	}
	
	
	
	
	@Override
	//override because we are inheriting this from the interface
	public boolean successful_action(double chance) {
		Random rand = new Random();
		Boolean succeed = rand.nextDouble() <= chance;
		return succeed;
		
	}
	//method to ensure values are within the min/max range
	public int set_vars(int min, int max,int var) {
		if(var < min) {
			var = min;
		}else if (var > max) {
			var = max;
		}
		return var;
	}  
	
	@Override
	public void hit(int damage) {
		
		this.current_hp = set_vars(0,this.max_hp, this.current_hp - damage);
	}
	
	@Override
	public void change_direction(int direction) {
		this.direction = set_vars(1, 4, direction);
	}
	
		@Override
	public String toString() {
		String read_out = this.name + "\n";
		read_out += "Facing " + facing() + "\n";
		read_out += "Has " + this.current_hp + "hp\n";
		return read_out;
	}
	
	
	private String facing() {
		switch(this.direction) {
		case 1:
			return "North";
		case 2:
			return "East";
		case 3:
			return "South";
		case 4:
			return "West";
		default:
			return "Error";
		}
	}
	
	public int[] rows_columns() {
		int[] rows_columns = new int[2];
		rows_columns[0] = this.rows;
		rows_columns[1] = this.columns;
		return rows_columns;
	}

	public String get_name() {
		return this.name; //this is a getter - the game will need to get the name but not change it
	}
	
	public char get_symbol() {
		return this.symbol;
	}
	
	public int get_direction() {
		return this.direction;
	}
	
	@Override
	public int [] get_location() {
		int[] location = {this.y_coord, this.x_coord};
		return location;
	}
	
	public void set_max_hp(int less_hp) {
		this.max_hp -= less_hp;
	}
	
	public void set_x_coord(int new_x_coord) {
		this.x_coord = new_x_coord;
		
	}
	
	public void set_y_coord(int new_y_coord) {
		this.y_coord = new_y_coord;
		
	}
	
	public boolean is_alive() {
		return this.current_hp > 0;
	}
	
	private int[] increment_north(){
		int y = set_vars(0, this.rows - 1, this.y_coord - 1);//subtract from y to go up
		int[] new_increment = {y,this.x_coord};
		return new_increment;
	}

	private int[] increment_south(){
		int y = set_vars(0, this.rows, this.y_coord + 1);// add to y to go down
		int[] new_increment = {y,this.x_coord};
		return new_increment;
	}
	
	private int[] increment_east(){
		int x = set_vars(0, this.columns, this.x_coord + 1);//add to x to go right
				int[] new_increment = {this.y_coord,x};
				return new_increment;
			}

	private int[] increment_west(){
		int x = set_vars(0, this.columns, this.x_coord - 1);//subtract from x to go left.
		int[] new_increment = {this.y_coord,x}; 
		return new_increment;
	}

	private int[] new_increment(){
		int[] increment_array = new int[2]; 
		switch(this.direction){		
		case 1:
			increment_array = this.increment_north();		
			break;
		case 2:
			increment_array = this.increment_east();		
			break;
		case 3:
			increment_array = this.increment_south();		
			break;
		case 4:
			increment_array = this.increment_west();		
			break;
		}
		return increment_array;
	}	
	
	
	@Override
	public void move() {
		int[] new_increments = new_increment();
		this.y_coord = new_increments[0];
		this.x_coord = new_increments[1];	
	}
	
	public int[] attack() {
		int[] fire_solution = new int[3];
		int[] solution = new_increment();
		fire_solution[0] = solution[0];
		fire_solution[1] = solution[1];
		
		if(this.successful_action(base_chance)) {
			fire_solution[2] = Misc.generate_random_int(do_damage_max, do_damage_min);
			System.out.println(this.name + " attacked for " + fire_solution[2] + " damage.");
			
		}else {
			System.out.println(this.name + " misses wildly!");
			fire_solution[2] = 0;
		}
		
		return fire_solution;
	}

	public int get_current_hp() {
		
		return this.current_hp;
	}
	
	public int get_max_hp() {
		return this.max_hp;
	
	}
	
	public boolean get_is_human() {
		return this.is_human;
		
	}

}
