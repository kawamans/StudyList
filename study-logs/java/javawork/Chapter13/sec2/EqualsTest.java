package sec2;

public class EqualsTest {
	public static void main(String[] args) {
		String str = "abcde";
		String str2 = "abc";
		System.out.println("(str)" + str);
		System.out.println("(str2 + \"de\")" + str2 + "de");
		//間違った比較
		if (str == str2 + "de") {
			System.out.println("(==比較)同じです");
		} else {
			System.out.println("(==比較)違います");
		}
		//正しい比較
		if (str.equals(str2 + "de")) {
			System.out.println("(equals比較)同じです");
		} else {
			System.out.println("(equals比較)違います");
		}
	}
}