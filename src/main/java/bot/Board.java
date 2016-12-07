package bot;

import java.util.Random;

public class Board {
	
	private final Api api;

	public int[][] matrix = new int[6][7];
	
	public Board(Api api){
		this.api = api;
	}
	
	public void addPiece(){
		
		//Generate random column to add piece
		Random random = new Random();
		int randomColumn = random.nextInt(7);
		
		//Check if column is full, if true generate another column to add
		if(matrix[0][randomColumn] == CellContent.Empty) {
//			api.`
		}
		
	}
}
