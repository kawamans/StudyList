package sec3ex;

public class Staff {
	private String name;
	private int birth;
	
	public Staff(String name, int birth) {
		super();
		this.name = name;
		this.birth = birth;
	}

	@Override
	public String toString() {
//		return "氏名:" + name + " 生年月日:" + birth;
		// Ex5
		int year = birth / 10000;
		int month = (birth / 100) % 1000;
		int day = birth % 100;
		return "氏名:" + name + " 生年月日:" + year + "年" + month + "月" + day + "日";
	}
	
}
