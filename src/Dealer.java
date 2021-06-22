

// TODO:猪岡
//      これは継承しなくてDealerクラスを作らなくても、
//      Playerクラスに「ディーラーかどうか」のBoolean値があればいける気がします。
public class Dealer extends Player
{
	@Override
	public void draw(Deck deck,int drawCount)
	{
		for(int i = 0;i<drawCount;i++)
		{
			deck.cardCount -=1;
			myHands.add(deck.card.get(deck.cardCount));
			totalMyScore += faceCardProcess(myHands.get(i).number);
		}
	}
}
