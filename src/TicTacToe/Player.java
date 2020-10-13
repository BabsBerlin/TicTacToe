package TicTacToe;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
	private String name;
	private String playerID;
	private char symbol;
	private boolean isHuman;
	private boolean isWinner;
	private PlayerAI playerAI;
	

	public Player(String playerID, Scanner userInputScanner) {
		this.playerID = playerID;
		this.name = playerID;
		isWinner = false;
		
		// ask the user if the player should be human or AI
		System.out.println();
		System.out.println("is " + this.playerID + " human or not? n for no, any other character for yes ");		
		char isHumanInput = userInputScanner.nextLine().charAt(0);
		
		if (isHumanInput != 'n'){
			this.setToHuman();
		} else {
			this.setToAI();
			playerAI = new PlayerAI();
			this.name = this.playerID+"roBOT";
		}
		
		// assign the symbol
		// never change the naming in TheGame
		if (this.playerID.equals("playerONE")) {
			this.setSymbol('x');
		} else {
			this.setSymbol('o');
		}
				
		// if player is Human, ask the user to provide a name
		if (this.isHuman) {
			System.out.println("please choose a name for " + this.playerID + ": ");
			String name = userInputScanner.nextLine();
			if (!name.equals("")) {
				this.name = name;
			}else {
				this.name = this.playerID;
			}
			System.out.println("hello " + this.name + " this is your symbol for this game: " + this.getSymbol());		
		} else {			
			System.out.println("the AI player " + this.name + " is your opponent, this is her symbol for the game: " + this.getSymbol());		
		}
				
	}
	
	public void makeAMove(Board theBoard, Scanner userInputScanner) throws Exception {
		try {
			if (this.getIsHuman() == true) {
				System.out.println("\n" + this.getName() + " (" + this.getSymbol() + ") please enter a field number for your next move: ");
				int position = userInputScanner.nextInt();
				if (!theBoard.setToken(position, this.getSymbol())) {
					System.out.println("## sorry " + this.getName() + " that field does not exist or it was already taken! please try again ...");
					this.makeAMove(theBoard, userInputScanner);			
				}
			} else {
				playerAI.makeADumbMove(theBoard, this);
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

	public void setToAI() {
		this.isHuman = false;
	}

	public boolean getIsHuman() {
		return this.isHuman;
	}

}
