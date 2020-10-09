package basicTicTacToe;


import java.util.Scanner;

public class Player {
	private String name;
	private char symbol;
	private boolean isHuman;
	private boolean isWinner;
	

	public Player(String playerName, Scanner userInputScanner) {
		this.name = playerName;
		// ask the user if the player should be human or AI
		System.out.println();
		System.out.println("****************************");
		System.out.println("Is " + this.name + " human or not? n for no, any other character for yes ");
		char isHuman = userInputScanner.next().charAt(0);		
		if (isHuman != 'n'){
			this.setToHuman();
		} else {
			// ToDo: create an AI player
			this.setToHuman();
			System.out.println("sorry, we do not hava an ai player yet, so " + this.name + " is set to human.");
		}
		// ask the user to provide a symbol for this user
		// this should be automatic, because I cannot check if that symbol was used already
		// use the player count!!! or can I check what symbol was already taken?
		System.out.println("choose a symbol for " + this.name + ": ");
		char playerSymbol = userInputScanner.next().charAt(0);

		
		this.setSymbol(playerSymbol);
		System.out.println("symbol for " + this.name + " is: " + this.getSymbol());		
		isWinner = false;
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
