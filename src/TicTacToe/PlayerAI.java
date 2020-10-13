package TicTacToe;

import java.util.Random;

public class PlayerAI {
	

	public void makeADumbMove(Board theBoard, Player thePlayer) {
		int position;
		int min = 1;
		int max = 9;
		
		Random rand = new Random();
		position = rand.nextInt((max - min) + 1) + min;
		
		// 
		if (!theBoard.setToken(position, thePlayer.getSymbol())) {
			this.makeADumbMove(theBoard, thePlayer);			
		}
		System.out.println(thePlayer.getName() + " chose position " + position + ".");

	}
}
