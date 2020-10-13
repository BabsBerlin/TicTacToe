package TicTacToe;



public class Board {
	private char[][] gameBoard;
	private static int ROWS = 3;
	private static int COLS = 3;
	private int rowEntry;
	private int colEntry;
	private boolean gameOver = false;

	
	public Board() {
		gameBoard = new char[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				this.gameBoard[i][j] = '*';
			}
		}	
	}
	
	
	// print out the content of the board
	public void printBoard() {
		System.out.println();
		int positionOnBoard = 1;
		for (int m = 0; m < ROWS; m++) {
			for (int n = 0; n < COLS; n++) {
				if (this.getBoardToken(m, n) == '*') {
					System.out.print(positionOnBoard);
				} else {
					System.out.print(this.getBoardToken(m, n));
				}
				if (positionOnBoard%3 != 0) {
					System.out.print(" | ");
				}
				positionOnBoard++;
			}
			if (m < ROWS-1) {
				System.out.println("\n---------");
			}			
		}
		System.out.println();
	}
	
	
	
	public boolean setToken(int position, char symbol) {
		this.convertPositionEntry(position);
		if (this.getBoardToken(rowEntry, colEntry) == '*') {
			this.gameBoard[rowEntry][colEntry] = symbol;
			return true;
		} else {
			return false;
		}		
	}
	
	
	public boolean checkForGameOver(Player currentPlayer) {
		// check for a complete column
		for (int m=0; m < COLS; m++) {
			if (this.getBoardToken(0, m) == currentPlayer.getSymbol() && this.getBoardToken(0, m) == this.getBoardToken(1, m) && this.getBoardToken(1, m) == this.getBoardToken(2, m) ) {				
				this.gameOver = true;
				currentPlayer.setToWinner();
			}			
		}
		// check for a complete row
		for (int n=0; n<ROWS; n++) {
			if (this.getBoardToken(n, 0) == currentPlayer.getSymbol() && this.getBoardToken(n, 0) == this.getBoardToken(n, 1) && this.getBoardToken(n, 1) == this.getBoardToken(n, 2) ) {				
				this.gameOver = true;
				currentPlayer.setToWinner();
			}			
		}
		// check for complete diagonals
		if (this.getBoardToken(1, 1) == currentPlayer.getSymbol() && this.getBoardToken(1, 1) == this.getBoardToken(0, 0) && this.getBoardToken(0, 0) == this.getBoardToken(2, 2) ) {				
			this.gameOver = true;
			currentPlayer.setToWinner();
		}			
		if (this.getBoardToken(1, 1) == currentPlayer.getSymbol() && this.getBoardToken(1, 1) == this.getBoardToken(2, 0) && this.getBoardToken(2, 0) == this.getBoardToken(0, 2) ) {				
			this.gameOver = true;
			currentPlayer.setToWinner();
		}
		// check for a draw
		int maxNumberOfSquares = ROWS * COLS;
		int occupiedSquares = 0;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j<COLS; j++) {
				if (this.getBoardToken(i, j) != '*') {
					occupiedSquares++;
				}
			}
		}
		if (occupiedSquares == maxNumberOfSquares) {
			this.gameOver = true;
		}
		return true;
	}
	
	
	public char getBoardToken(int row, int col) {
		return this.gameBoard[row][col];
	}
	

	
	public boolean getGameOver() {
		return this.gameOver;
	}
	
	public void convertPositionEntry(int positionEntry) {
		switch (positionEntry) {
			case 1:
				rowEntry = 0;
				colEntry = 0;
				break;
			case 2:
				rowEntry = 0;
				colEntry = 1;
				break;
			case 3:
				rowEntry = 0;
				colEntry = 2;
				break;
			case 4:
				rowEntry = 1;
				colEntry = 0;
				break;
			case 5:
				rowEntry = 1;
				colEntry = 1;
				break;
			case 6:
				rowEntry = 1;
				colEntry = 2;
				break;
			case 7:
				rowEntry = 2;
				colEntry = 0;
				break;
			case 8:
				rowEntry = 2;
				colEntry = 1;
				break;
			case 9:
				rowEntry = 2;
				colEntry = 2;
				break;
		}
	}


}
