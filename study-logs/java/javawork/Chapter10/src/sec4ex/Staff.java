package sec4ex;

public class Staff {
	String name;
	int birth;
	
	public Staff(String name, int birth) {
		this.name = name;
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		int yy = birth/10000;
		int mm = (birth/100)%100;
		int dd = birth%100;
		return "氏名："+ name+ " 生年月日:"+ yy+ "年"+ mm+ "月"+ dd+ "日";
	}
}
