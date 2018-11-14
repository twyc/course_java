package game_refactoring;

import java.util.Scanner;
/* 这个类弄巧成拙了 亲测如果关了就会出现nosuchelement这种别人在一个循环里面用两个next才会出现的异常
 * 并且如果在期望输入数字的地方输入string就凉了。。
 */
public class Input {
	public String input(String s) {
		Scanner in = new Scanner(System.in);
		String ret = new String(in.next());
//		in.close();
		return ret;
	}

	public int input(int s) {
		Scanner in = new Scanner(System.in);
		int ret = in.nextInt();
//		in.close();
		return ret;
	}
}
