package TicTacToe;


import java.util.InputMismatchException;
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
				
		// ask the user to provide a name
		System.out.println("please choose a name for " + this.playerID + ": ");
		String name = userInputScanner.nextLine();
		if (!name.equals("")) {
			this.name = name;
		}else {
			this.name = this.playerID;
		}
				
		System.out.println("hello " + this.name + " this is your symbol for this game: " + this.getSymbol());		
	}
	
	public void makeAMove(Board theBoard, Scanner userInputScanner) throws Exception {
		try {
		System.out.println("\n" + this.getName() + " (" + this.getSymbol() + ") please enter a field number for your next move: ");
		int position = userInputScanner.nextInt();
		if (!theBoard.setToken(position, this.getSymbol())) {
			System.out.println("## sorry " + this.getName() + " that field does not exist or it was already taken! please try again ...");
			this.makeAMove(theBoard, userInputScanner);			
		}
		theBoard.checkForGameOver(this);
		}   
        catch (InputMismatchException  e) { 
            System.out.println("## Exception thrown: " + e);
            System.out.println("## you should type in a number between 1..9!");
            userInputScanner.nextLine();
            this.makeAMove(theBoard, userInputScanner);
        } 
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
