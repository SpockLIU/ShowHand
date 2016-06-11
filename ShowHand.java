import java.util.*;

public class ShowHand{
	private final int PLAY_NUM = 2;
	private List<String> cards = new LinkedList<String>();
	private String[] types = {"黑桃", "红桃", "草花", "方块"};
	private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	private String[] players = new String[PLAY_NUM];
	private List<String>[] playerCards = new List[PLAY_NUM];
	
	//初始化扑克牌
	public void initCards(){
		for(int i = 0; i < types.length; i++){
			for(int j = 0; j < values.length; j++){
				cards.add(types[i] + values[j]);
			}
		}
		Collections.shuffle(cards);
	}
	
	//初始化玩家
	public void initPlayers(String name){
		//2016-06-10，为了学习，现仅针对电脑及个人玩家重写这部分
		//先指定电脑玩家的名字
		players[0] = "computer";
		players[1] = name;	
		//以下code为针对多个玩家的。
		/*
		if(name.length > PLAY_NUM && name.length < 2){
			System.out.println("玩家数量需要大于2,并且小于" + PLAY_NUM);				return ;
		}else{
			for(int i = 0; i < name.length; i++){
				players[i] = name[i];
			}
		}
		*/
	}

	//初始化玩家手中的牌
	public void initPlayerCards(){
		for(int i = 0; i < PLAY_NUM; i++){
			if(players[i] != null && !players[i].equals("")){
				playerCards[i] = new LinkedList<String>();
			}
		}
	}

	//定义发牌动作
	public void deliverCards(String first){
		System.out.println("先给" + first + "发牌");
		int firstPos = ArrayUtils.search(players, first);
		for(int i = firstPos ; i < firstPos + PLAY_NUM; i++){
			if(players[i % PLAY_NUM] != null){	
				playerCards[i % PLAY_NUM].add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	
	//show玩家手中的牌,并隐藏电脑玩家的牌
	public void showPlayerCards(String name){
		for(int i = 0; i < PLAY_NUM; i++){
			if(players[i] != null && !players[i].equals("")){
				System.out.println(players[i] + ":");
				if(players[i].equals(name)){
					for(String card : playerCards[i]){
						System.out.print(card + "\t");
					}
				}else {
					System.out.print("底牌" + "\t");
					for(int j = 1; j < playerCards[i].size(); j++){
						System.out.print(playerCards[i].get(j) + "\t");
					}
				}
			}
			System.out.println();
		}	
	}

	public int nextFirst(int rount){
		int value = 0;
		int index = 0;
		for(int i = 0; i < PLAY_NUM; i++){
			if(playerCards[i].
		}
	}
	//主程序
	public static void main(String[] args){
		ShowHand sh = new ShowHand();
		sh.initCards();
		System.out.print("请输入玩家名字:");
		Scanner input = new Scanner(System.in);
		String name = input.next();
		sh.initPlayers(name);
		sh.initPlayerCards();
		sh.deliverCards("computer");
		sh.deliverCards("computer");
		for(int i = 2; i < 5; i++){
			int maxCard = sh.nextFirst(i);
		}
		sh.showPlayerCards(name);
		

	}
	
}
