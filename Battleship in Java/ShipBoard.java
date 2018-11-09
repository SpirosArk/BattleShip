import java.util.Random;
import java.util.Scanner;

public abstract class ShipBoard
{
	private int boardSize = 10;
	private int[][] board = new int[boardSize][boardSize];
	private boolean[][] hits = new boolean[boardSize][boardSize];
	public int[] shipSizes = {5,4,3,3,2};
	private boolean sankShip = false;
	
	public void enterShipRandomly(int shipID)
	{
		int size = shipSizes[shipID-1];
		String[] directions = {"Vertical","Horizontal"};
		Random rnd = new Random();
		int choice = rnd.nextInt(2);
		String dir = directions[choice];
		int x = rnd.nextInt(boardSize);
		int y = rnd.nextInt(boardSize);
		if (dir.equals("Vertical")){
			boolean posNotFound = true;
			while (posNotFound){
				posNotFound = false;
				x = rnd.nextInt(boardSize-size+1);
				y = rnd.nextInt(boardSize);
				for (int i = 0; i < size; i ++){
					if (board[x+i][y] != 0){
						posNotFound = true;
						break;
					}
				}
			}
			for (int i = 0; i < size; i ++){
				board[x+i][y] = shipID;
			}
		}
		if (dir.equals("Horizontal")){
			boolean posNotFound = true;
			while (posNotFound){
				posNotFound = false;
				x = rnd.nextInt(boardSize);
				y = rnd.nextInt(boardSize-size+1);
				for (int i = 0; i < size; i ++){
					if (board[x][y+i] != 0){
						posNotFound = true;
						break;
					}
				}
			}
			for (int i = 0; i < size; i ++){
				board[x][y+i] = shipID;
			}
		}
		//System.out.println(x+" "+y+ " "+dir);
	}
	
	public void enterAllShipsRandomly(){
		for (int i = 0; i < shipSizes.length; i ++){
			enterShipRandomly(i+1);
		}
	}
	
	public boolean enterShipManually(int shipID)
	{
		int size = shipSizes[shipID-1];
		Scanner input = new Scanner(System.in);
		System.out.println("Give position and direction for ship "+shipID + " of size "+ shipSizes[shipID-1]);
		int x = input.nextInt();
		int y = input.nextInt();
		String dir = input.next(); 
		if (dir.equals("v")){
			if (x+size > boardSize || x < 0|| y <0 || y >= boardSize){
				return false;
			}
			for (int i = 0; i < size; i ++){
				if (board[x+i][y] != 0){
					return false;
				}
			}
			for (int i = 0; i < size; i ++){
				board[x+i][y] = shipID;
			}
			return true;
		}
		if (dir.equals("h")){
			if (x >= boardSize || x < 0|| y <0 || y+size > boardSize){
				return false;
			}
			for (int i = 0; i < size; i ++){
				if (board[x][y+i] != 0){
					return false;
				}
			}
			for (int i = 0; i < size; i ++){
				board[x][y+i] = shipID;
			}
			return true;
		}
		return false;
	}
	
	public void enterAllShipsManually(){
		for (int i = 0; i < shipSizes.length; i ++){
			while (!enterShipManually(i+1)){}
			printBoard();
		}
	}
	
	public boolean getStrike(int[] position){
		int x = position[0];
		int y = position[1];
		sankShip = false;
		if (!hits[x][y] && board[x][y] != 0){
			hits[x][y] = true;
			int ship = board[x][y];
			shipSizes[ship-1] --;
			if (shipSizes[ship-1] == 0){
				sankShip = true;
				System.out.println("Ship no "+ship+" sank");
			}
			return true;
		}else{
			return false;
		}
	}
	
	public boolean lastStrikeSankShip(){
		return sankShip;
	}
	
	
	public boolean allShipsSank(){
		for (int i = 0; i < shipSizes.length; i ++){
			if (shipSizes[i] != 0){
				return false;
			}
		}
		return true;
	}

	public void printBoard(){
		for (int i = 0; i < boardSize; i ++){
			for (int j = 0; j < boardSize; j ++){
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		ShipBoard board1 = new ComputerShipBoard();
		board1.enterAllShipsRandomly();
		board1.printBoard();
		ShipBoard board2 = new HumanShipBoard();
		board2.enterAllShipsManually();
		board2.printBoard();
	}

	public abstract void enterAllShips();

}