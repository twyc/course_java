package game_refactoring;


public class GameDisplay {

	public static void splashScreen() {
		System.out.println("**************************************************************");
		System.out.println("*                                                            *");
		System.out.println("*                                                            *");
		System.out.println("*                         骑士飞行棋                         					 *");
		System.out.println("*                                                            *");
		System.out.println("*                                                            *");
		System.out.println("**************************************************************\n");
	}

	public static void startGame() {
		System.out.println("\n");
		System.out.print("**************************************************************\n");
		System.out.print("*                        Game Start                          *\n");
		System.out.print("**************************************************************\n");
	}

	public static void gameOver() {
		System.out.println("\n\n\n\n");
		System.out.print("****************************************************\n");
		System.out.print("                      Game  Over                    \n");
		System.out.print("****************************************************\n\n");
	}
	
	public static void selectRole() {
	  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~两  人  对  战~~~~~~~~~~~~~~~~~~~~~~~~\n");
	  String roles=" ";
	  for(int i=0;i<Name_player.values().length;i++)
		  roles=roles+(i+1)+". "+Name_player.values()[i].getName()+" ";
	  
	  System.out.println("请选择角色: "+roles);
	}
	
	public static void winner(Player player1, Player player2) {
  	  if(player1.getPos() > player2.getPos()){
		  System.out.println("\n恭喜" + player1.getName() + "将军! 您获胜了！");
	  }else{
		  System.out.println("\n恭喜" + player2.getName() + "将军! 您获胜了！");
	  }
	}
	
	public static void twoPlayers(Player player1, Player player2) {
	  System.out.println("^_^" + player1.getName() + "的士兵：　Ａ");
	  System.out.println("^_^" + player2.getName() + "的士兵：  Ｂ\n");
	}
	
	public static void allSymbol() {
	System.out.println("图例说明：\n" + "@@ 起点; ■ 暂停; ¤ 幸运轮盘; ★ 地雷; 〓 时空隧道; － 普通\n\n地图如下：");
	}
	
	public static void currentPositionOfPlayers(Player player1, Player player2) {
	  System.out.println("\n您("+player1.getInfo()+")当前位置：  "+ player1.getPos());
	  System.out.println("对方("+player2.getInfo()+")当前位置："+ player2.getPos());
	  System.out.println("-----------------\n");
	} 
	
	public static void  pause(Player player) {
		System.out.println("\n" + player.getName() +"停掷一次！\n"); 
		System.out.println("\n\n\n");
	}
	
	public static void showShifterNum(int step) {
		System.out.println("\n-----------------"); // 显示结果信息
		System.out.println("骰子数： " + step);
	}
}
