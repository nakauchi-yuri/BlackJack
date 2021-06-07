package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * カードを用意してプレイヤーとディーラーに配るためのデッキを作成する。
 */

public class Deck
{
	//カード型のリストを用意する
	public List<Card> card = new ArrayList<>();

	//次に引くカードの番号
	public int cardCount = 0;

	//シャッフルされたデッキを作成する
	public void deckCreate()
	{
		cardGenerate();
		Collections.shuffle(card);
	}

	//カードを52枚作る
	private void cardGenerate()
	{
		for(int i = 1; i<=4;i++)
		{
			for(int j = 1;j<=13;j++)
			{
				card.add(cardCount, new Card());
				card.get(cardCount).suit = suitChoice(i);
				card.get(cardCount).number =j;
				cardCount ++;
			}
		}
	}

	//特定の数字に対してスートで返す
	private String suitChoice(int suitNum)
	{
		switch(suitNum)
		{
		case 1:return "spade";

		case 2:return "club";

		case 3:return "dia";

		case 4:return "heart";
		}
		return "out of range yade";
	}

}
