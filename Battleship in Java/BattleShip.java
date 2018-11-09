import java.util.Scanner;

class BattleShip
{
	public static void main(String[] args){
		System.out.println("Human vs Human (1) or Human vs Computer (2):");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		if (choice == 1){
			HumanVSHuman();
		}else{
			HumanVSComputer();
		}
	}
	
	private static void HumanVSHuman(){
		HumanPlayer p1 = new HumanPlayer("Alice");
		HumanPlayer p2 = new HumanPlayer("Bob");
		do{
			System.out.println("\nPlayer "+p1+" turn");
			int[] pos =  p1.nextStrike();
			boolean success = p2.getStrike(pos);
			if (p2.allShipsSank()){
				System.out.println("Player "+p1+" won!");
				break;
			}
			p1.update(pos,success);
			if (p2.lastStrikeSankShip()){
				System.out.println("Last strike sank ship");
			}
			
			System.out.println("\nPlayer "+p2+" turn");
			pos =  p2.nextStrike();
			success = p1.getStrike(pos);
			if (p1.allShipsSank()){
				System.out.println("Player "+p2+" won!");
				break;
			}
			p2.update(pos,success);
			if (p1.lastStrikeSankShip()){
				System.out.println("Last strike sank ship");
			}
		}while(true);
	}
	
	private static void HumanVSComputer(){
		HumanPlayer p1 = new HumanPlayer("Alice");
		ComputerPlayer p2 = new ComputerPlayer();
		do{
			System.out.println("\nPlayer "+p1+" turn");
			int[] pos =  p1.nextStrike();
			boolean success = p2.getStrike(pos);
			if (p2.allShipsSank()){
				System.out.println("Player "+p1+" won!");
				break;
			}
			p1.update(pos,success);
			if (p2.lastStrikeSankShip()){
				System.out.println("Last strike sank ship");
			}
			
			System.out.println("\nPlayer "+p2+" turn");
			pos =  p2.nextStrike();
			success = p1.getStrike(pos);
			if (p1.allShipsSank()){
				System.out.println("Player "+p2+" won!");
				break;
			}
			p2.update(pos,success);
			if (p1.lastStrikeSankShip()){
				System.out.println("Last strike sank ship");
			}
		}while(true);
	}

	public void playGame(Player P1, Player P2){
		if (P1 instanceof HumanPlayer){
			if (P2 instanceof ComputerPlayer)
				HumanVSComputer();
		}
		else {
			HumanVSHuman();
		}
		
		
	}
}