package basicTicTacToe;


import java.util.Scanner;

public class Player {
	private String name;
	private String playerID;
	private char symbol;
	private boolean isHuman;
	private boolean isWinner;
	

	public Player(String playerID, Scanner userInputScanner) {
		this.playerID = playerID;
		this.name = playerID;
		isWinner = false;
		
		// ask the user if the player should be human or AI
		System.out.println();
		System.out.println("is " + this.playerID + " human or not? n for no, any other character for yes ");		
		char isHuman = userInputScanner.nextLine().charAt(0);
		
		if (isHuman != 'n'){
			this.setToHuman();
		} else {
			// ToDo: create an AI player
			this.setToHuman();
			System.out.println("sorry, we do not hava an ai player yet, so " + this.playerID + " is set to human.");
		}
		
		// assign the symbol
		// this will break if we change the naming in TheGame, so never change the naming in TheGame
		if (this.playerID.equals("playerONE")) {
			this.setSymbol('x');
		} else {
			this.setSymbol('o');
		}
				
		// ask the user to provide a nickname
		System.out.println("please choose a stage name for " + this.playerID + ": ");
		String name = userInputScanner.nextLine();
		this.name = name;		
		System.out.println("hello " + this.name + " this is your symbol for this game: " + this.getSymbol());		
//		System.out.println("****************************");

	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public void setToWinner() {
		this.isWinner = true;
	}
	
	public boolean getIsWinner() {
		return this.isWinner;
	}
	
	public void setToHuman() {
		this.isHuman = true;
	}
	
	public boolean getIsHuman() {
		return this.isHuman;
	}

}
