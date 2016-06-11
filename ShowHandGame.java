public class ShowHandGame {
	
	public int round = 0;
	Poker poker = new Poker();
	int stake = 30;
	Player player1 = new Player("玩家一");
	Player player2 = new Player("玩家二");
	
	public void init(){
		poker.initPoker();
		
	}
	
	public void newRound(){
		poker.initPoker();
		player1.initPlayer();
		player2.initPlayer();
		for(int i = 0; i < 5; i++){
			player1.playerCard.getCards(poker.deliverCard());
			player2.playerCard.getCards(poker.deliverCard());
		}
		if(player1.playerCard.compareTo(player2.playerCard) > 0){
			player1.win(stake);
			player2.follow(stake);
			System.out.println("玩家一赢");
		}else if(player1.playerCard.compareTo(player2.playerCard) < 0){
			player2.win(stake);
			player1.follow(stake);
			System.out.println("玩家二赢");
		}
		System.out.println("玩家一的牌" + player1.playerCard.toString());
		System.out.println(player1.playerCard.getType() + "\t" + player1.playerCard.getMaxCard());
		System.out.println("玩家二的牌" + player2.playerCard.toString());
		System.out.println(player2.playerCard.getType() + "\t" + player2.playerCard.getMaxCard());
		System.out.println();
		round++;
	}
	
	public void showResult(){
		System.out.println("总共进行了" + round + "局");
		System.out.println("玩家一的余额" + player1.getAccount() + "胜利次数" + player1.getWinTime());
		System.out.println("玩家一的余额" + player2.getAccount() + "胜利次数" + player2.getWinTime());
	}

}
