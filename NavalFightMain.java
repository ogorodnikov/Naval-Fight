
public class NavalFightMain {

	public static void main(String[] args) {

		System.out.println("Starting..");
		
		Game myGame = new Game();
		Game.Player myPlayer = myGame.new Player();
		Game.Player.Ship myShip = myPlayer.new Ship();
		Game.Player.Field myField = myPlayer.new Field();
		
		//myShip.setLocation(3, 3);
		//myShip.showShip();
		
		myField.populateShipsRandomly();
		
		
		
		

	}

}
