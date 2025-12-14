import java.util.Scanner;

public class IfTest3 {

	public static void main(String[] args) {
		System.out.println("---処理開始---");
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("数字を入力してください->");
		num = scan.nextInt();
		if (num == 1) {
			System.out.println("条件式1がtrueだった場合の処理が行われました");
		} else if (num == 0) {
			System.out.println("条件式2がtrueだった場合の処理が行われました");
		} else {
			System.out.println("全ての条件がfalseだった場合の処理が行われました");
		}
		System.out.println("---処理完了---");
	}

}