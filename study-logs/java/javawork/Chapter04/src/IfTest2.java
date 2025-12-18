import java.util.Scanner;

public class IfTest2 {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("数字を入力してください->");
		num = scan.nextInt();
		if (num == 1) {
			System.out.println("trueだった場合の処理がされました");
		} else {
			System.out.println("falseだった場合の処理がされました");
		}
		System.out.println("---処理完了---");
	}

}
