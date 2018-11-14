package game_refactoring;

public class Map {
	int[] luckyTurn = { 6, 23, 40, 55, 69, 83 }; // 幸运轮盘
	int[] landMine = { 5, 13, 17, 33, 38, 50, 64, 80, 94 };// 地雷位置
	int[] pause = { 9, 27, 60, 93 }; // 暂停
	int[] timeTunnel = { 20, 25, 45, 63, 72, 88, 90 };// 时空隧道

	Grid grid[] = new Grid[100];

	public void createMap() {
		for (int i = 0; i < 100; i++) {
			grid[i] = new Normal();
		}
		for (int i = 0; i < luckyTurn.length; i++) {
			grid[luckyTurn[i]] = new LuckyTurn();
		}
		for (int i = 0; i < landMine.length; i++) {
			grid[landMine[i]] = new LandMine();
		}
		for (int i = 0; i < pause.length; i++) {
			grid[pause[i]] = new Pause();
		}
		for (int i = 0; i < luckyTurn.length; i++) {
			grid[luckyTurn[i]] = new LuckyTurn();
		}
	}

	public void getGraph(int pos, int playerPos1, int playerPos2) {
		if (playerPos1 == playerPos2 && playerPos1 == pos) {
			System.out.print("@@");
		} else if (playerPos1 == pos) {
			System.out.print("A");
		} else if (playerPos2 == pos) {
			System.out.print("B");
		}else {
			grid[pos].print();
		}
	}

	/**
	 * 输出地图的奇数行（第1、3行）
	 * 
	 * @param start
	 *            输出的起始点在地图上的位置
	 * @param end
	 *            输出的结束点在地图上的位置
	 * @param playerPos1
	 *            玩家1的当前位置
	 * @param playerPos2
	 *            玩家2的当前位置
	 */
	public void showLine1(int start, int end, int playerPos1, int playerPos2) {
		for (int i = start; i < end; i++) {
			getGraph(i, playerPos1, playerPos2);
		}
	}

	/**
	 * 输出地图的偶数行（第2行）
	 * 
	 * @param start
	 *            输出的起始点在地图上的位置
	 * @param end
	 *            输出的结束点在地图上的位置
	 * @param playerPos1
	 *            玩家1的当前位置
	 * @param playerPos2
	 *            玩家2的当前位置
	 */
	public void showLine2(int start, int end, int playerPos1, int playerPos2) {
		for (int i = end - 1; i >= start; i--) {
			getGraph(i, playerPos1, playerPos2);
		}
	}

	public void space30() {
		for (int i = 0; i < 30; i++) {
			System.out.print("  ");
		}
	}

	/**
	 * 输出地图的右竖列
	 * 
	 * @param start
	 *            输出的起始点在地图上的位置
	 * @param end
	 *            输出的结束点在地图上的位置
	 * @param playerPos1
	 *            玩家1的当前位置
	 * @param playerPos2
	 *            玩家2的当前位置
	 */
	public void showRLine(int start, int end, int playerPos1, int playerPos2) {
		for (int i = start; i < end; i++) {
			space30();
			getGraph(i, playerPos1, playerPos2);
			System.out.println();
		}
	}

	/**
	 * 输出地图的左竖列
	 * 
	 * @param start
	 *            输出的起始点在地图上的位置
	 * @param end
	 *            输出的结束点在地图上的位置
	 * @param playerPos1
	 *            玩家1的当前位置
	 * @param playerPos2
	 *            玩家2的当前位置
	 */
	public void showLLine(int start, int end, int playerPos1, int playerPos2) {
		for (int i = start; i < end; i++) {
			getGraph(i, playerPos1, playerPos2);
			System.out.println();
		}
	}

	/**
	 * 显示对战地图
	 * 
	 * @param playerPos1
	 *            玩家1的当前位置
	 * @param playerPos2
	 *            玩家2的当前位置
	 */
	public void showMap(int playerPos1, int playerPos2) {
		showLine1(0, 31, playerPos1, playerPos2); // 显示地图第一行
		System.out.println(); // 换行
		showRLine(31, 35, playerPos1, playerPos2);
		showLine2(35, 66, playerPos1, playerPos2);
		System.out.println(); // 换行
		showLLine(66, 69, playerPos1, playerPos2);
		showLine1(69, 100, playerPos1, playerPos2);
	}
	public static void main(String[] args) {//测试map打印情况
		Map map = new Map();
		map.createMap();
		map.showMap(0, 0);
	}
}