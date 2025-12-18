package sec2ex;

public class Ex07 {

	public static void main(String[] args) {
		String str = "Java is a programming language.";
		int count = 0;
		String deleteStr = str.replaceAll("\\s", "");
		int all = str.length();
		int deAll = deleteStr.length();
		count = all - deAll;
		
		
		System.out.println("スペースは、"+count+"文字");
	}

}
