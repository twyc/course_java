package game_refactoring;

/*
 * 名字 状态是否走 位置 编号
 * 掷色子
 * ChangePos为往后退6个格子
 */
public class Player {
	private String name ,info;
	private boolean statu;
	private int pos;

	public Player(String name, int pos ,int no) {
		this.name = name;
		this.pos = pos;
		this.statu = true;
		info = "玩家" + no+": ";
		if(no == 0) {
			info = info +"A";
		}
		else {
			info = info +"B";
		}
	}
	public int throwShifter() {
		int step = 0;
		System.out.print("\n\n" + name + ", 请您按任意字母键后回车启动掷骰子： ");
		Input in = new Input();
		in.input("");
		// 产生一个1~6的数字,即掷的骰子数目
		step = (int) (Math.random() * 10) % 6 + 1;
		return step;
	}
	public String getInfo() {
		return info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getStatu() {
		return statu;
	}
	public void changeStatu() {
		statu = !statu;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public void ChangePos() {
		pos -= 6;
		if(pos < 0) {
			pos = 0;
		}
	}
}
