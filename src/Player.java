

import java.util.ArrayList;
import java.util.List;

public class Player
{
	// TODO:猪岡
	//      totalMyScoreは不要でmyHandsからスコアを計算するメソッドを用意すれば良いのでは？
	public int totalMyScore = 0;
	public List<Card> myHands = new ArrayList<>();

	//クラスの名前を取得、最初の10文字(BlackJack.)を削っている。
	public String className = getClass().getName();

	//ヒットの場合（1枚）
	public void hit()
	{
		draw(1);
	}

	// TODO:猪岡
	//      DeckをStatic化することで以下のメソッド定義で済むはず。
	//      public void draw(int drawCount)
	//変更済み

	//カードを引く（どのデッキから,何枚引くか）
	public void draw(int drawCount)
	{
		for(int i = 0;i<drawCount;i++)
		{

			myHands.add(Deck.card.get(Deck.cardCount));
			Deck.cardCount -= 1;
			if(className.equals("Player"))
			{
				totalMyScore += faceCardProcess(myHands.get(myHands.size()-1).number);
				System.out.println("Playerの引いたカードは["+myHands.get(myHands.size()-1).suit+","+myHands.get(myHands.size()-1).number+"]");
			}else if(className.equals("Dealer"))
			{
				totalMyScore += faceCardProcess(myHands.get(i).number);
				System.out.println("Playerの引いたカードは["+myHands.get(myHands.size()-1).suit+","+myHands.get(myHands.size()-1).number+"]");
			}
		}
	}

	// TODO:猪岡
	//      これはCardクラスのメソッドに持っていけば良い。(メソッド名はgetScore()等)
	//
	//中内：Cardクラスはあくまで1枚のカード(スートと数)として認識していたのですが、
	//プログラム上だと実際の数字とは別に、スコアとしての数字を入れて置いておくといったイメージでいいですか？

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
