package game_refactoring;

public class LuckyTurn implements Grid{

	@Override
	public void print() {
		System.out.print("¤");
	}
	
	@Override
	public void fun(Player player1,Player player2) {
		System.out.println(".....welcome to luckyTurn!.....");
        System.out.println("  please choose a choice:");
        System.out.println("  1.change the pos 2. attack");
        Input input = new Input();
        int op = input.input(0);
        if( op != 1 && op != 2) {
        	op = 1;
        }
        System.out.println("my option is " + op);
        
        if( op == 1) {
        	int a=player1.getPos();
        	int b=player2.getPos();
        	a = a ^ b;
        	b = a ^ b;
        	a = a ^ b;
        	player1.setPos(a);
        	player2.setPos(b);
        }
        else {
        	player2.ChangePos();
        }
	}
	
}
