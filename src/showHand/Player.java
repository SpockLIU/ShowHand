package showHand;

import java.util.*;

public class Player {
	private String name;
	private int account;
	private int winTimes;
	int pBet = 0;
	private boolean onBoard = true;
	public ShowHandCards playerCard = new ShowHandCards();
	
	public Player(String name){
		this.name = name;
		account = 1000;
		winTimes = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public int getBet(){
		return pBet;
	}
	
	public void initPlayer(){
		playerCard.initSHCards();
	}
	
	public void win(int bouns){
		account += bouns;
		winTimes++;
	}
	
	public int bet(){
		System.out.print("Please input your bet: ");
		Scanner input = new Scanner(System.in);
		pBet = input.nextInt();
		account -= pBet;
		return pBet;
	}
	
	public boolean isFollow(int bet){
		System.out.print(name + ": 这一轮的赌注为" + bet + "请确定是否要跟 Y/N : ");
		Scanner input = new Scanner(System.in);
		if(input.next().equalsIgnoreCase("Y")){
			account -= bet;
			return true;
		}else{
			return false;
		}
	}
	
	
	public void unFollow(){
		onBoard = false;
	}
	
	public boolean isOn(){
		return onBoard;
	}
	
	
	public int getAccount(){
		return account;
	}
	
	public int getWinTime(){
		return winTimes;
	}
	
	public void showCards(String name){
		if(name.equals(this.name)){
			System.out.println(playerCard);
		}else {
			System.out.println(playerCard.toOther());
		}
	}
	
	public boolean goon(){
		System.out.println(name);
		return true;
		/*
		System.out.print("Follow: Y/N?");
		Scanner input = new Scanner(System.in);
		if(input.next().equalsIgnoreCase("Y")){
			//this.bet();
			return true;
		}else {
			return false;
		}
		*/
		
	}
	
	

}
