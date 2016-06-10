import java.util.*;

public class ShowHand{
	private final int PLAY_NUM = 5;
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
	public void initPlayers(String... name){
		if(name.length > PLAY_NUM && name.length < 2){
			System.out.println("玩家数量需要大于2,并且小于" + PLAY_NUM);				return ;
		}else{
			for(int i = 0; i < name.length; i++){
				players[i] = name[i];
			}
		}
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
		int firstPos = ArrayUtils.search(players, first);
		for(int i = firstPos ; i < firstPos + PLAY_NUM; i++){
			if(players[i % PLAY_NUM] != null){	
				playerCards[i % PLAY_NUM].add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	
	//show玩家手中的牌
	public void showPlayerCards(){
		for(int i = 0; i < PLAY_NUM; i++){
			if(players[i] != null && !players[i].equals("")){
				System.out.println(players[i] + ":");
				for(String card : playerCards[i]){
					System.out.print(card + "\t");
				}
			}
			System.out.println();
		}	
	}

	//主程序
	public static void main(String[] args){
		ShowHand sh = new ShowHand();
		sh.initCards();
		sh.initPlayers("唐僧", "孙悟空", "猪八戒", "沙僧");
		sh.initPlayerCards();
		sh.deliverCards("唐僧");
		sh.showPlayerCards();
		sh.deliverCards("孙悟空");	
		sh.showPlayerCards();
		sh.deliverCards("猪八戒");
		sh.showPlayerCards();
		sh.deliverCards("沙僧");
		sh.showPlayerCards();
		sh.deliverCards("猪八戒");
		sh.showPlayerCards();

	}
	
}
