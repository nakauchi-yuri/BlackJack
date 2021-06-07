package blackJack;

import java.io.IOException;

public class BlackJack
{

	//ゲーム全体の流れ
	public static void main(String[] args)throws IOException
	{
		GameManager game = new GameManager();
		game.readeyForGame();
		game.InGame();
	}
}
