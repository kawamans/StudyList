import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		int num = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("キーボードから数字を入力してください->");
		num = scan.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println(i);
		}
		for (int i = num; i >= 0; i--) {
			System.out.println(i);
		}
		System.out.println("---処理終了---");
	}

}
