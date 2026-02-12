import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("数字を入力してください->");
		int num = scan.nextInt();
		
		if (num == 0) {
			System.out.println("おはようございます");
			
		} else if (num == 1) {
			System.out.println("こんにちは");
			
		} else if (num == 2) {
			System.out.println("こんばんは");
			
		} else if (num == 3) {
			System.out.println("おやすみなさい");
			
		} else {
			System.out.println("0～3の数字を入力してください");
			
		}
	}

}
