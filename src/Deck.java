

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
	//変更済み

	//カード型のリストを用意する
	static public List<Card> card = new ArrayList<>();

	//次に引くカードの番号
	public int cardCount = 0;

	// TODO:猪岡
    //      デッキ作成というよりはデッキのリセット処理だと思います。
	//変更済み

	//デッキを作り直してシャッフルする
	public void deckCreate()
	{
		generateCards();
		Collections.shuffle(card);
	}

	// TODO:猪岡
    //      以下のようなメソッドを定義するとPlayer側の処理を簡略できると思います。
    //      public static card draw()


	// TODO:猪岡
    //      メソッド名は generateCards() かな？
    //      最初にcardリストをクリアする処理を追加する方が良いでしょう。

	//カードを52枚作る
	private void generateCards()
	{
		for(int i = 1; i<=4;i++)
		{
			for(int j = 1;j<=13;j++)
			{
				// TODO:猪岡
			    //      Cardクラスにスートと数字を渡すコンストラクタを用意すれば良いと思います。
			    //      cardCountは不要で、単純にお尻にどんどん追加していけば良いのでは？
				//変更済み

				card.add(new Card(chooseSuit(i),j));
			}
		}
	}

	// TODO:猪岡
    //      メソッド名は chooseSuit() かな？
	//変更済み

	//特定の数字に対してスートで返す
	private String chooseSuit(int suitNum)
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
