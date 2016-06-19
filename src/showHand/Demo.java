package showHand;

public class Demo {
	public static void main(String[] args){
		ShowHandGame game = new ShowHandGame();
		String[] str = {"Tim", "Parker", "Kobe", "Jorden"};
		game.init(str);
		game.newRound();
		game.showResult();
		
		
		
	}
	
}
