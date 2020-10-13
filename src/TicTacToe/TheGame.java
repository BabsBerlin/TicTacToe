package TicTacToe;


import java.util.Scanner;

public class TheGame {
	
	private Player playerONE;
	private Player playerTWO;
	private Player currentPlayer;
	private Scanner userInputScanner; 
	private Board theBoard;
	
	
	public static void main(String[] args) throws Exception {

		TheGame theGame = new TheGame();
		theGame.initialize();		
		theGame.play();		
		
	}
	
	
	
	// initialize the game by creating two players and a board
	private void initialize() {
		System.out.println("*********************");		
		System.out.println("welcome to TicTacToe!");
		System.out.println("*********************");		
		
		userInputScanner = new Scanner(System.in);
		playerONE = new Player("playerONE", userInputScanner);
		playerTWO = new Player("playerTWO", userInputScanner);
		currentPlayer = playerONE;
		
		// initialize the gameBoard
		theBoard = new Board();
		theBoard.printBoard();			
	}
	
	
	private void play() throws Exception {
		// players take turns to set their tokens until GameOver is reached
		while (!theBoard.getGameOver()) {
			currentPlayer.makeAMove(theBoard, userInputScanner);
			theBoard.printBoard();
			switchCurrentPlayer();
		}
		// when GameOver is reached, close up and give out the result
		closeTheGame();
	}
	
	
	// print out the result and close the scanner
	private void closeTheGame() {
		System.out.println();
		System.out.println("****************************************");
		System.out.println("************** GAME OVER! **************");
		System.out.println("****************************************");
		if (playerONE.getIsWinner()) {
			System.out.println("*** we have a winner: congratulations " + playerONE.getName() + " ***");
		} else if (playerTWO.getIsWinner()) {
			System.out.println("we have a winner: congratulations " + playerTWO.getName());
		} else {
			System.out.println("************* it's a tie!" + " *************");
		}
		System.out.println("****************************************");
		
		userInputScanner.close();
	}

	
	// switch the player who can make his move
	private void switchCurrentPlayer() {
		if (currentPlayer == playerONE) {
			currentPlayer = playerTWO;
		} else {
			currentPlayer = playerONE;
		}		
	}
	
}
