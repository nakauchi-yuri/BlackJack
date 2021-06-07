package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Player
{
	public int totalMyScore = 0;
	public List<Card> myHands = new ArrayList<>();

	//クラスの名前を取得、最初の10文字(BlackJack.)を削っている。
	public String className = getClass().getName().substring(10);

	//最初のドロー（2枚）
	public void firstDraw(Deck deck)
	{
		draw(deck,2);
	}

	//ヒットの場合（1枚）
	public void hit(Deck deck)
	{
		draw(deck,1);
	}

	//カードを引く（どのデッキから,何枚引くか）
	public void draw(Deck deck,int drawCount)
	{
		for(int i = 0;i<drawCount;i++)
		{
			deck.cardCount -=1;
			myHands.add(deck.card.get(deck.cardCount));
			if(className.equals("Player"))
			{
				System.out.println("Playerの引いたカードは["+myHands.get(i).suit+","+myHands.get(i).number+"]");
			}
			totalMyScore += faceCardProcess(myHands.get(i).number);
		}
	}

	//faceCard(絵札)を10として処理する
	protected int faceCardProcess(int getCard)
	{
		if(getCard >= 10)
		{
			return 10;
		}
		return getCard;
	}
}
