package chessgame;

public class Display {
	
	public static void display(Board board){
		Boolean exists = false;
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				System.out.print("|");
				for (Pawn pawn : Board.pawns){
					if (pawn.getPos().equals(new Position(j,i))){
						System.out.print("P");
						exists = true;
					}
				}
				if (!exists){
					System.out.print(" ");
				}
				System.out.print("|");
				exists = false;
			}
			System.out.println();
		}
		
	}

	
	
	
	
	
	public static void main(String[] str){
		Board board = Board.getBoardInstance(true);
		
		
		
		display(board);
		
		
		
		
	}
}
