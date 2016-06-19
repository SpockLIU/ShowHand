package showHand;

import java.util.*;

public class ShowHandGame {
	
	public int round = 0;
	Poker poker = new Poker();
	int bet = 0;
	int clip = 0;
	int lastMax = 0;
	ArrayList<Player> players = new ArrayList<>();
	
	public void init(String[] playerList){
		poker.initPoker();
		initPlayer(playerList);
	}
	
	public void initPlayer(String[] playerStr){
		if((playerStr.length > 0) && playerStr.length <= 5){
			for(String str :playerStr){
				Player player = new Player(str);
				players.add(player);
			}
		}
	}
	
	public void newRound(){
		System.out.println("Round" + (round + 1));
		round ++;
		bet = 0;
		clip =0;
		poker.initPoker();
		for(Player p : players){
			p.initPlayer();
		}
		for(int i = 0; i < 1; i++){
			for(Player p : players){
				p.playerCard.getCards(poker.deliverCard());
			}
		}
		for(int i = 1; i < 5; i++){
			int quiteNum = 0;
			lastMax = Deliver(players, lastMax);
			
			if(players.get(lastMax).goon()){
				System.out.println(players.get(lastMax).getName() + "所看见的牌");
				showCards(players.get(lastMax));
				bet = players.get(lastMax).bet();
				clip += bet;
				for(int j = 1; j < players.size(); j++){
					int follower = (j + lastMax) % players.size();
					System.out.println(players.get(follower).getName() + "所看见的牌");
					showCards(players.get(follower));
					if(players.get(follower).isOn() && players.get(follower).isFollow(bet)){
						clip += bet;
					}else {
						players.get(follower).unFollow();
						quiteNum ++;
					}
				}
			}
			
			if(quiteNum == players.size() - 1){
				break;
			}
			System.out.println();
		}
		Player winner = this.finndWinner(players);
		winner.win(clip);
		
		System.out.println("本轮的胜利者为" + winner.getName() + "， 他赢得的赌注为" + (clip - winner.getBet()));
		for(Player p : players){
			System.out.println(p.getName() + "余额： " + p.getAccount());
		}
		System.out.println();
	}
	
	public Player finndWinner(ArrayList<Player> players){
		ArrayList<Player> playerList = new ArrayList<>();
		for(Player p : players){
			if(p.isOn()){
				playerList.add(p);
			}
		}
		if(playerList.size() == 1){
			return playerList.get(0);
		}else {
			Player winner = playerList.get(0);
			for(Player p : playerList){
				//System.out.println(p.playerCard.shCards.size());
				if(winner.playerCard.compareTo(p.playerCard) < 0){
					winner = p;
				}
			}
			return winner;
		}
	}
			
	public void showCards(Player player){
		for(Player p : players){
			System.out.println(p.getName());
			p.showCards(player.getName());
		}
	}
	
	
	public void showResult(){
		System.out.println("总共进行了" + round + "局");
		for(Player p : players){
			System.out.println(p.getName() + "余额为： " + p.getAccount() + "; 胜利次数" + p.getWinTime());
		}
	}
	
	public int Deliver(List<Player> playerList, int index){
		int j = 0;
		int indexMax = 0;
		Card maxCard = new Card(0, 0);
		Card card;
		for(int i = index; i < index + playerList.size(); i++){
			j = i % playerList.size();
			if(playerList.get(j).isOn()){
				card = poker.deliverCard();
				playerList.get(i % playerList.size()).playerCard.getCards(card);
				if(card.compareTo(maxCard) > 0){
					maxCard = card;
					indexMax = j;
				}
			}
			
			//System.out.println(maxCard);
		}
		return indexMax;
	}


}
