package game_refactoring;

public class TimeTunnel implements Grid{

	@Override
	public void print() {
		System.out.print("〓");
	}

	@Override
	public void fun(Player player1, Player player2) {
		player1.setPos(player1.getPos()+10);
	}
	
}
