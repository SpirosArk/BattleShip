import java.util.Scanner;

class HumanPlayer extends Player
{
	private ShipBoard ships;
	private StrikeBoard strikes = new StrikeBoard();
	private String name;
	
	public HumanPlayer(String name){
		createBoard();
		this.name = name;
		ships.enterAllShipsManually();
		ships.printBoard();
	}
	
	public boolean allShipsSank(){
		return ships.allShipsSank();
	}
	
	public int[] nextStrike(){
		System.out.println("\n"+name);
		strikes.printBoard();
		Scanner input = new Scanner(System.in);
		System.out.println("Give x and y:");
		int pos[] = new int[2];
		pos[0] = input.nextInt();
		pos[1] = input.nextInt();
		return pos;
	}
	
	public void update(int[] pos, boolean success){
		strikes.addStrike(pos,success);
		if (success){
			System.out.println("\nSuccessful hit!");
		}
		strikes.printBoard();
	}
	
	public boolean getStrike(int[] pos){
		return ships.getStrike(pos);
	}
	
	public boolean lastStrikeSankShip(){
		return ships.lastStrikeSankShip();
	}
	
	public String toString(){
		return name;
	}

	public void createBoard(){
		ships = new HumanShipBoard();
	}

}