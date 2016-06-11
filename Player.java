import java.util.*;

public class Player {
	private String name;
	private int account;
	private int winTimes;
	public boolean onBoard = true;
	public ShowHandCards playerCard = new ShowHandCards();
	
	public Player(String name){
		this.name = name;
		account = 1000;
		winTimes = 0;
	}
	
	public void initPlayer(){
		playerCard.initSHCards();
	}
	
	public void win(int bouns){
		account += bouns;
		winTimes++;
	}
	
	public int bet(){
		Scanner input = new Scanner(System.in);
		int bet = input.nextInt();
		account -= bet;
		return bet;
	}
	
	public int follow(int bet){
		account -= bet;
		return bet;
	}
	
	public void unFollow(){
		onBoard = false;
	}
	
	public int getAccount(){
		return account;
	}
	
	public int getWinTime(){
		return winTimes;
	}
	
	

}
