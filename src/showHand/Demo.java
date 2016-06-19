package showHand;

public class Demo {
	public static void main(String[] args){
		ShowHandGame game = new ShowHandGame();
		String[] str = {"Tim", "Parker", "Kobe"};
		game.init(str);
		for(int i = 0; i < 1; i++){
			game.newRound();
		}
		game.showResult();
		
		
		
	}
	
}
