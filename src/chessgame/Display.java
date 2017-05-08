package chessgame;

public class Display {
	
	public static void display(Board board){
		Boolean exists = false;
		int file = 8;
		System.out.println("   a  b  c  d  e  f  g  h");
		for (int i = 0; i < 8; i++){
			System.out.print(file - i + " ");
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
			System.out.print(" ");
			System.out.println(file - i);
		}
		System.out.println("   a  b  c  d  e  f  g  h");
		
	}

	
	
	
	
	
	public static void main(String[] str){
		Board board = Board.getBoardInstance(true);
		
		
		
		display(board);
		
		
	}
}
