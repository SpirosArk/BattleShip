import java.util.Random;

class ComputerPlayer extends Player
{
	
	private ShipBoard ships;
	private StrikeBoard strikes = new StrikeBoard();
	private RandomStrategy strategy = new RandomStrategy();
	private String name = "Hal";
	
	public ComputerPlayer(){
		createBoard();
		ships.enterAllShipsRandomly();
		//ships.printBoard();
	}
	
	public boolean allShipsSank(){
		return ships.allShipsSank();
	}

	public int[] nextStrike(){
		return strategy.nextStrike();
	}
	
	
	public void update(int[] pos, boolean success){
		strikes.addStrike(pos,success);
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
		ships = new ComputerShipBoard();
	}
}