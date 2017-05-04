package chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton class containing an instance of the board that the game will be played on.
 */
public class Board {
	
	public static List<Pawn> pawns;
	private static Board board;
	private Position[][] game;

	private Board(boolean start){
		
		Board.pawns = new ArrayList<Pawn>();
		if (start == true){
			//Fill the board with units in its initial positions
			for (int i = 0; i < 8; i++){
				for (int j = 0; j < 8; j++){
					//Create black pawns
					if (j == 1){
						Pawn pawn = new Pawn(new Position(i ,j), 1);
						pawns.add(pawn);
					}
					//Create white pawns
					else if (j == 6){
						Pawn pawn = new Pawn(new Position(i ,j), 0);
						pawns.add(pawn);
					}
				}
			}
		}
	}
	
	public static Board getBoardInstance(boolean game){
		if (board == null){
			Board board = new Board(game);
			
		}
		return board;
	}


	public static Boolean isOccupied(Position pos){
		for (Pawn pawn : pawns){
			if (pawn.getPos() == pos){
				return true;
			}
		}
		return false;
	}
	
	public void move(){
		
	}
	
	public void kill(){
		
	}
	
	public void display(){
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				for (Pawn pawn : pawns){
					if (pawn.getPos().equals(new Position(i,j))){
						System.out.println("P");
					}
				}
			}
		}
		System.out.println();
	}
	
}
