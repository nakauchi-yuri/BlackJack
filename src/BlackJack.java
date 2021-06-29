

import java.io.IOException;

public class BlackJack
{

	//ゲーム全体の流れ
	public static void main(String[] args)throws IOException
	{

		//String StringBirthday = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(DetaBirthday);
		GameManager game = new GameManager();
		game.readyForGame();
		game.InGame();
	}
}
