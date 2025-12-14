import java.util.Scanner;

public class Practice08_step_01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("入力の回数を数値で指定してください-> ");
		int num = scan.nextInt();
		
		if (num < 0 || num > 10) {
			while (num < 0 || num > 10) {
				System.out.print("0～10の回数で指定してください-> ");
				int reNum = scan.nextInt();
				num = reNum;
			}
		}
		
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