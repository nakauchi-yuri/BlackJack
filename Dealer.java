package blackJack;

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
