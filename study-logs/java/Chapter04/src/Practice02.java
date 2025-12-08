import java.util.Scanner;

public class Practice02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("数字を入力してください->");
		int num = scan.nextInt();
		
		if (num >= 6 && num <=11) {
			System.out.println(num+"時 おはようございます");
			
		} else if (num >= 12 && num <=17) {
			System.out.println(num+"時 こんにちは");
			
		} else if (num >= 18 && num <=23) {
			System.out.println(num+"時 こんばんは");
			
		} else if (num <= 24) {
			System.out.println(num+"時 おやすみなさい");
			
		} else {
			System.out.println("0～24の数字を入力してください");
			
		}
	}

}
