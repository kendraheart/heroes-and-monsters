package handm;

public class Board {
	//rows y first
	//columns x second
	private char [][] board;
	private int rows, columns;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.board = new char[this.rows][this.columns];
		initialize_board();
	}

	public void initialize_board() {
		for(int row = 0; row < this.rows; row++) {
			for(int column = 0; column < this.columns; column++) {
			board[row][column] = ' ';	
			}
			
		}
			
	}

	public void mark_board(int y, int x, char symbol) {
		this.board[y][x] = symbol;
	}
	
	public void display_board() {
		String horizontal_bar = "|";
		String main_line = "|";
		for(int i = 0; i < this.columns - 1; i++) {
			main_line += "===+";
		}
		main_line += "===|";
		System.out.println(main_line);
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.columns; j++) {
				System.out.print(horizontal_bar + " " + board[i][j] + " ");
			}
			System.out.print(horizontal_bar);
			System.out.println();
			System.out.println(main_line);
		}
		System.out.println();
	}



}
