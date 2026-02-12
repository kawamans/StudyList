import java.util.Scanner;

public class Practice08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("入力の回数を数値で指定してください-> ");
		int num = scan.nextInt();
		String[] inputArray = new String[num];
		
		System.out.println("---入力開始---");
		for (int i = 0; i < num; i++) {
			System.out.print(i+1+ "回目の入力-> ");
			inputArray[i] = scan.next();
		}
		
		System.out.println("---入力終了---");
		for (int i = 0; i < num; i++) {
			System.out.print(inputArray[i]);
			if (i < num) {
				System.out.print(" ");
			}
		}
	}

}
