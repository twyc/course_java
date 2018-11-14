package game_refactoring;

public class Pause implements Grid{

	@Override
	public void print() {
		System.out.print("■");
	}

	@Override
	public void fun(Player player1, Player player2) {
		player1.changeStatu();
	}

}
