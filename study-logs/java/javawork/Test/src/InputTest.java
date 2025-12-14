import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("キーボードから文字を入力してください->");
		String inputStr = scan.nextLine();
		System.out.println(inputStr);
		
		System.out.print("キーボードから文字を入力してください->");
		int inputNum = scan.nextInt();
		System.out.println(inputNum);
		
		System.out.print("キーボードから文字を入力してください->");
		inputNum = inputNum += scan.nextInt();
		System.out.println(inputNum);

		int i = scan.nextInt(); //数字入力
		scan.nextLine(); //確定時の改行を受信
		String str = scan.nextLine(); //文字と改行を受け取る
		System.out.println(i);
		System.out.println(str);
	}

}
