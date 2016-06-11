public class Demo {
	public static void main(String[] args){
		ShowHandGame game = new ShowHandGame();
		game.init();
		for(int i = 0; i < 100; i++){
			game.newRound();
			System.out.println("round" + game.round);
		}
		game.showResult();
	}
	
}
