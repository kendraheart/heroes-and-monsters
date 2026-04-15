package handm;

import java.util.*;

public class Heros_Monsters_Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Game game1 = new Game(scan, 6, 6);
		game1.play_game();
		
		
		scan.close();
		

	}

}
