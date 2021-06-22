

import java.util.ArrayList;
import java.util.List;

public class Player
{
	// TODO:猪岡
	//      totalMyScoreは不要でmyHandsからスコアを計算するメソッドを用意すれば良いのでは？
	public int totalMyScore = 0;
	public List<Card> myHands = new ArrayList<>();

	// TODO:猪岡
	//      これは「ディーラーかどうか」のBooleanフィールドを追加するだけで不要になると思います。

	//クラスの名前を取得、最初の10文字(BlackJack.)を削っている。
	public String className = getClass().getName();

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

	// TODO:猪岡
	//      DeckをStatic化することで以下のメソッド定義で済むはず。
	//      public void draw(int drawCount)

	//カードを引く（どのデッキから,何枚引くか）
	public void draw(Deck deck,int drawCount)
	{
		for(int i = 0;i<drawCount;i++)
		{
			deck.cardCount -=1;
			myHands.add(deck.card.get(deck.cardCount));
			if(className.equals("Player"))
			{
				System.out.println("Playerの引いたカードは["+myHands.get(myHands.size()-1).suit+","+myHands.get(myHands.size()-1).number+"]");
			}
			totalMyScore += faceCardProcess(myHands.get(myHands.size()-1).number);
		}
	}

	// TODO:猪岡
	//      これはCardクラスのメソッドに持っていけば良い。(メソッド名はgetScore()等)

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
