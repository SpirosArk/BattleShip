import java.util.Random;

class StrikeBoard
{
	private int boardSize = 10;
	private int[][] hits = new int[boardSize][boardSize];

	
	public boolean addStrike(int[] pos, boolean success){
		//scores[x][y] = 0;
		int x = pos[0];
		int y = pos[1];
		//boolean success = board.getHit(x,y);
		if (success){
			hits[x][y] = 1;
		}else{
			hits[x][y] = -1;
		}
		return success;
	}
	

	public boolean isCandidate(int[] pos){
		int x = pos[0];
		int y = pos[1];
		if (x < 0 || x >= boardSize || y < 0 || y >= boardSize){
			return false;
		}	
		return hits[x][y] == 0;
	}
	
	public void printBoard(){
		for (int i = 0; i < boardSize; i ++){
			for (int j = 0; j < boardSize; j ++){
				System.out.printf("%3d ",hits[i][j]);
			}
			System.out.println();
		}
	}
}