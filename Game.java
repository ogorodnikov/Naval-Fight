import java.util.ArrayList;




public class Game {
	
	final int FIELD_WIDTH = 300;
	final int FIELD_HEIGHT = 300;
	final int SHIP_COUNT = 89999;
	
	static int maxRandomRegenerationCount = 0; 
		
	class Player {
		
		ArrayList<Ship> shipArray = new ArrayList<Ship>();
		
		public void Player () {};
		
		public void placeShip (int X, int Y, Ship myShip) {
			if ((X <= FIELD_WIDTH)&&(Y <= FIELD_HEIGHT)) {
				myShip.setLocation (X, Y);
			}
			//check if other ship is already there
		}	
		
		class Field {
			
			public void populateShipsRandomly() {
				
				for (int i=0; i<SHIP_COUNT; i++) {
					int randomRegenerationCount = 0;
					Game.Player.Ship myShip = new Ship();
					
					int currentX = (int)(Math.random()*FIELD_WIDTH);
					int currentY = (int)(Math.random()*FIELD_HEIGHT);
					
					System.out.println("\nGenerated X:" + currentX + " Y:" + currentY);
					
					while (isShipLocatedAt(currentX, currentY)) {
						currentX = (int)(Math.random()*FIELD_WIDTH);
						currentY = (int)(Math.random()*FIELD_HEIGHT);
						randomRegenerationCount++;
						if (randomRegenerationCount > maxRandomRegenerationCount) {
							maxRandomRegenerationCount = randomRegenerationCount;
						}
						
						System.out.println("New coordinates generated: X:" + currentX + " Y:" + currentY);
					}
					//check random redo when field is overpopulated 
					
					placeShip (currentX, currentY, myShip);
					System.out.println("Added Ship (" + i + "): X: " + currentX + ", Y: " + currentY);
					myShip.showShip();
					
					shipArray.add(myShip);
	
				}
				
				System.out.println("\nMaximum random regeneration count: " + maxRandomRegenerationCount);
				
			}
			
			//proposed by Z
			public boolean isShipLocatedAt (int X, int Y) {
				for (int i=0; i < shipArray.size(); i++) {
					if ((shipArray.get(i).locationX == X)&&(shipArray.get(i).locationY == Y)) {
						System.out.println("Ship is already loacted at " + X + ", " + Y + "!");
						return true;
					}
				}
				return false;
			}
		
			class Cell {
				
				
				
			}
		
		}
		
		class Ship {
			
			int locationX, locationY;
			
			
			public Ship() {
				locationX = 0;
				locationY = 0;
				
			}
			
			public void setLocation (int X, int Y) {
				this.locationX = X;
				this.locationY = Y;
			}
			
			public void showShip () {
				System.out.println("Ship location: " + locationX + ", " + locationY);
			}
			
		}
		
	}
	
}
