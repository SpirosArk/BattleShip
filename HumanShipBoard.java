import java.util.Scanner;

public class HumanShipBoard extends ShipBoard{
	
	
	
	
	public void enterAllShips(){
		
		
		System.out.println("Enter 1 for manually putting ships or anything else for randomly ships arrangement ");
		Scanner scanner = new Scanner(System.in);
		int bn = scanner.nextInt();
				
		if (bn==1){
			
			enterAllShipsManually();
			}
		
		else{
			enterAllShipsRandomly();
			}
		
		
		
		
	}

}
