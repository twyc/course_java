package game_refactoring;


public class Game {
	Map map; // 地图
	Player player[] = new Player[2];

	/*
	 * 初始化游戏的一局
	 */
	public void init() {
		player[0] = new Player(null, 0, 0);
		player[1] = new Player(null, 0, 1);
		map = new Map();
		map.createMap(); // 生成地图
	}

	/**
	 * 开始游戏
	 */
	public void start() {
		init();
		GameDisplay.splashScreen();
		GameDisplay.selectRole();

		Input in = new Input();
		System.out.print("请玩家1选择角色:  ");
		int role1 = in.input(0);
		while (role1 < 1 || role1 > 4) {
			System.out.print("请玩家1重新选择角色:  ");
		}

		System.out.print("请玩家2选择角色:  ");
		int role2 = in.input(0);
		while (role1 == role2 || role2 < 1 || role2 > 4) {
			System.out.print("请玩家2重新选择角色:  ");
			role2 = in.input(0);
		}
		// 设置对战角色
		player[0].setName(Name_player.values()[role1 - 1].getName());
		player[1].setName(Name_player.values()[role2 - 1].getName());
		play(); // 开始两人对战
	}

	/**
	 * 两人对战玩法
	 */
	public void play() {
		GameDisplay.startGame();
		GameDisplay.twoPlayers(player[0], player[1]);// 显示对战双方士兵样式
		GameDisplay.allSymbol();// 显示对战地图

		map.showMap(player[0].getPos(), player[1].getPos());

		// 游戏开始

		while (player[0].getPos() < 99 && player[1].getPos() < 99) { // 有任何一方走到终点，跳出循环

			// 2个玩家轮流掷骰子
			int over = playerGoOn(0);
			if (over == 1) {
				break;
			}

			over = playerGoOn(1);
			if (over == 1) {
				break;
			}
		}

		// 游戏结束
		GameDisplay.gameOver();
		GameDisplay.winner(player[0], player[1]);
	}

	/*
	 * 只要一个参数就可以表示现在是谁 以及获取这个玩家的信息
	 */
	public int playerGoOn(int no) {
		if (player[no].getStatu()) {
			int step = player[no].throwShifter(); // 掷骰子
			GameDisplay.showShifterNum(step);
			getCurPos(no, step); // 计算这一次移动后的当前位置

			GameDisplay.currentPositionOfPlayers(player[no], player[1 - no]);
			map.showMap(player[0].getPos(), player[1].getPos()); // 显示当前地图
			if (player[0].getPos() >= 99) { // 如果走到终点
				return 1; // 退出
			}
		} else {
			GameDisplay.pause(player[no]);// 显示此次暂停信息
			player[no].changeStatu();// 设置下次可掷状态
		}
		System.out.println("\n\n\n\n");
		return 0;
	}

	/**
	 * 计算玩家此次移动后的当前位置
	 * 
	 * @param no
	 *            玩家次序
	 * @param step
	 *            掷的骰子数目
	 * @return position 移动后的位置
	 */
	public int getCurPos(int no, int step) {
		player[no].setPos(player[no].getPos()+step); // 第一次移动后的位置
		if (player[no].getPos() >= 99) {
			return 99;
		}
		//相遇的情况
		if(player[no].getPos() == player[1-no].getPos()) {
			player[1-no].setPos(0);
		}
		// 这里删了一大段的switch case 终于找到了实现这个接口的意义。。
		map.grid[player[no].getPos()].fun(player[no], player[1 - no]);
		// 返回此次掷骰子后玩家的位置坐标
		if (player[no].getPos() < 0) {
			return 0;
		} else if (player[no].getPos() > 99) {
			return 99;
		} else {
			return player[no].getPos();
		}
	}
}
