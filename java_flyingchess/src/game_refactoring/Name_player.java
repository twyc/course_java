package game_refactoring;

public enum Name_player {
	DGL("戴高乐"), ASH("艾森豪威尔"), MKA("麦克阿瑟"), BD("巴顿");
	private String name;

	private Name_player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
