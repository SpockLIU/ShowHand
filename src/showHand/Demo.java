package showHand;

public class Demo {
	public static void main(String[] args){
		ShowHandGame game = new ShowHandGame();
		/*
		for(int i = 0; i < 100; i++){
			game.newRound();
			System.out.println("round" + game.round);
		}
		game.showResult();
		*/
		Poker poker = new Poker();
		ShowHandCards shc = new ShowHandCards();
		for(int i = 0; i < 30; i++){
			poker.initPoker();
			shc.initSHCards();
			for(int j = 0; j < 5; j++){
				shc.getCards(poker.deliverCard());
			}
			System.out.println(shc);
			System.out.println(shc.getType());
			System.out.println();
		}
		shc.initSHCards();
		Card c1 = new Card(0,4);
		Card c2 = new Card(1, 6);
		Card c3 = new Card(3, 4);
		Card c4 = new Card(2, 6);
		Card c5 = new Card(2, 6);
		shc.getCards(c1);
		shc.getCards(c2);
		shc.getCards(c3);
		shc.getCards(c4);
		shc.getCards(c5);
		System.out.println(shc.getType());
	}
	
}
