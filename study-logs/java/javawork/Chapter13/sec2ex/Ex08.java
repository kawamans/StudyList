package sec2ex;

public class Ex08 {
	public static void main(String[] args) {
		String str = "Japan,China,USA";
		String[] strings = str.split(",");
		
		for (String strs : strings) {
			System.out.println(strs);
		}
	}
}
