

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * カードを用意してプレイヤーとディーラーに配るためのデッキを作成する。
 */

public class Deck
{
	// TODO:猪岡
    //      StaticフィールドにすることでPlayerにDeckクラスを渡さずにいけると思います。

	//カード型のリストを用意する
	public List<Card> card = new ArrayList<>();

	//次に引くカードの番号
	public int cardCount = 0;

	// TODO:猪岡
    //      デッキ作成というよりはデッキのリセット処理だと思います。

	//シャッフルされたデッキを作成する
	public void deckCreate()
	{
		cardGenerate();
		Collections.shuffle(card);
	}

	// TODO:猪岡
    //      以下のようなメソッドを定義するとPlayer側の処理を簡略できると思います。
    //      public static card draw()


	// TODO:猪岡
    //      メソッド名は generateCards() かな？
    //      最初にcardリストをクリアする処理を追加する方が良いでしょう。

	//カードを52枚作る
	private void cardGenerate()
	{
		for(int i = 1; i<=4;i++)
		{
			for(int j = 1;j<=13;j++)
			{
				// TODO:猪岡
			    //      Cardクラスにスートと数字を渡すコンストラクタを用意すれば良いと思います。
			    //      cardCountは不要で、単純にお尻にどんどん追加していけば良いのでは？

				card.add(cardCount, new Card());
				card.get(cardCount).suit = suitChoice(i);
				card.get(cardCount).number =j;
				cardCount ++;
			}
		}
	}

	// TODO:猪岡
    //      メソッド名は chooseSuit() かな？

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
