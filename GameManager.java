package blackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameManager {

	Deck deck = new Deck();
	Player player = new Player();
	Dealer dealer = new Dealer();

	public void readeyForGame()
	{
		deck.deckCreate();
		player.draw(deck,2);
		displayScore("player");
		dealer.draw(deck,2);
		System.out.println("Dealerの引いたカードは、["+dealer.myHands.get(1).suit+","+dealer.myHands.get(1).number+"]");
		System.out.println("Dealerの合計は、["+dealer.myHands.get(1).number+"]");
		System.out.println("もう1枚のカードは伏せてあります。");
	}

	//ゲームの流れ
	public void InGame()throws IOException
	{
		while(player.totalMyScore <= 21)
		{
			announce("カードを引きますか？（Y/N）");
			if(yesNoCheck())
			{
				player.hit(deck);
				judge("player",player.totalMyScore);
			}
			else
			{
				announce("スタンドを選択しました。Dealerに手番が移ります。");
				break;
			}
		}
		while(dealer.totalMyScore<=16&&player.totalMyScore<20)
		{
			dealer.hit(deck);
		}
		judge("dealer",dealer.totalMyScore);

		if(player.totalMyScore<22&& dealer.totalMyScore<22)
		{
			lastJudge();
		}
	}

	//キーボード入力をうながす
	private String keybordCheck()throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String getstr = reader.readLine();
		return getstr;
	}

	//入力された文字がYかyならtrue、それ以外ならfalseを返す
	private boolean yesNoCheck() throws IOException
	{
		String check = keybordCheck();
		if(check.equals("y")||check.equals("Y")) return true;
		else return false;
	}

	//入れた文字列を表示するだけ
	private void announce(String word)
	{
		System.out.println(word);
	}

	//勝ち負けの判定（プレイヤー）
	private void judge(String name ,int score) throws IOException
	{
		if(score>21)
		{
			announce("合計が21を超えたので、バストしました。");
			keybordCheck();
			if(name.equals("dealer"))
			{
				announce("dealerが負け、あなたが勝ちました。");
			}
			else
				announce("あなたは負けました。");
			keybordCheck();

		}
		else if(score == 21)
		{
			announce("合計が21になりました。ブラックジャックです。");
			keybordCheck();
			if(name.equals("dealer"))
			{
				announce("dealerが勝ち、あなたが負けました。");
			}
			announce("あなたは勝ちました。");
			keybordCheck();
		}
		//20以下であれば何も無し
	}

	//勝ち負けの判定(勝負)
	private void lastJudge() throws IOException
	{
		announce("あなたの合計は["+player.totalMyScore+"]");
		keybordCheck();
		announce("dealerの合計は["+dealer.totalMyScore+"]");
		keybordCheck();
		if(player.totalMyScore > dealer.totalMyScore)
		{
			announce("あなたの勝ちです");
		}
		else
		{
			announce("あなたの負けです");
		}
	}

	//現在の手札の合計値を表示する。
	public void displayScore(String who)
	{
		if(who.equals("player")) System.out.println("Playerの合計は["+player.totalMyScore+"]");
		else if (who.equals("dealer"))  System.out.println("Delaerの合計は["+dealer.totalMyScore+"]");
	}

}
